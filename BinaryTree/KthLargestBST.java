package com.anurag.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

import com.anurag.BinaryTree.BinaryTree2DLL.Node;


public class KthLargestBST
{
	public static class Node{  
        int data;  
        Node left;  
        Node right;  
          
        public Node(int data) {  
            this.data = data;  
            this.left = null;  
            this.right = null;  
        }  
    }  
	
	
	public static Node insert(Node root, int key)
	{
		if (root == null) {
			return new Node(key);
		}

		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static int kthLargestBST(Node root, AtomicInteger i, int k) {
	    if (root == null) {
	        return -1;
	    }

	    // Traverse the right subtree
	    int rightResult = kthLargestBST(root.right, i, k);

	    // If kth largest is found in the right subtree, return it
	    if (rightResult != -1) {
	        return rightResult;
	    }

	    // Increment the count
	    i.set(i.get() + 1);

	    // If the current node is the kth largest, return its value
	    if (i.get() == k) {
	        return root.data;
	    }

	    // Traverse the left subtree
	    return kthLargestBST(root.left, i, k);
	}

	public static int kthLargestBST(Node root, int k) {
	    AtomicInteger i = new AtomicInteger(0);
	    return kthLargestBST(root, i, k);
	}

	public static void main(String[] args)
	{
		Node root = null;
		int[] keys = { 13, 14, 22, 25, 23, 32, 26,28,40};

		for (int key : keys) {
			root = insert(root, key);
		}

		int k = 3;
		int res = kthLargestBST(root, k);

		if (res != Integer.MAX_VALUE) {
			System.out.print(res);
		}
		else {
			System.out.print("Invalid Input");
		}
	}
}

/* Try more Inputs

case1:
keys = [13, 14, 22, 25, 23, 32, 26,28,40]
root = insert(root, key)
actual = findKthLargest(root,3)
expected = 22

case2:
keys = [5,3,6,2,4,1]
root = insert(root, key)
actual = findKthLargest(root,3)
expected = 3

*/