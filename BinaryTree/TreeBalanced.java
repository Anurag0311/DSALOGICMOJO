package com.anurag.BinaryTree;

public class TreeBalanced {
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

    Node root;

    boolean isTreeBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        if (Math.abs(left - right) <= 1 && isTreeBalanced(node.left) && isTreeBalanced(node.right)) {
            return true;
        }

        return false;
    }

    int findHeight(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    public static void main(String args[]) {
        TreeBalanced tree = new TreeBalanced();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        boolean actual = tree.isTreeBalanced(tree.root);
        boolean expected = true;

        System.out.println("Actual result: " + actual);
        System.out.println("Expected result: " + expected);
    }
}

/* Try more Inputs
case1:
root = Node(2) 
root.left = Node(3) 
root.right = Node(4) 
root.left.left = Node(5) 
root.left.right = Node(6) 
root.left.left.left = Node(9)
actual = isTreeBalanced(root)
expected = True

case2:
root = Node(2) 
root.left = Node(3) 
root.right = Node(4) 
root.left.left = Node(5) 
root.left.left.left = Node(6) 
root.left.left.left.left = Node(9)
actual = isTreeBalanced(root)
expected = False

*/