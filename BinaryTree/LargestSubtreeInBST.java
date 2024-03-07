package com.anurag.BinaryTree;

public class LargestSubtreeInBST {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class List {
        int sz;
        int max;
        int min;
        boolean isBST;

        List(int sz, int max, int min, boolean isBST) {
            this.sz = sz;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    List largestBST(Node root) {
        if (root == null) {
            return new List(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        if (root.left == null && root.right == null) {
            return new List(1, root.data, root.data, true);
        }

        List left = largestBST(root.left);
        List right = largestBST(root.right);

        List ret = new List(0, 0, 0, false);
        ret.sz = (1 + left.sz + right.sz);
        if (left.isBST && right.isBST && left.max < root.data && right.min > root.data) {
            ret.min = Math.min(left.min, Math.min(right.min, root.data));
            ret.max = Math.max(left.max, Math.max(right.max, root.data));
            ret.isBST = true;

            return ret;
        }
        ret.isBST = false;

        return ret;
    }
    
    public static void main(String args[]) 
    { 
    	LargestSubtreeInBST tree = new LargestSubtreeInBST();
    	Node root = new Node(65); 
    	root.left = new Node(70); 
    	root.right = new Node(75); 
    	root.left.left = new Node(55); 
    	System.out.print(" Size of the largest BST is:"+tree.largestBST(root).sz); 
    } 
}
/* Try more Inputs
case1:
root = newNode(60)  
root.left = newNode(65)  
root.right = newNode(70)  
root.left.left = newNode(50) 
actual = largestBSTBT(root)
expected = 2

case2:
root = newNode(5)  
root.left = newNode(2)  
root.right = newNode(4)  
root.left.left = newNode(1)
root.left.right = newNode(3)  
actual = largestBSTBT(root)
expected = 3

*/
