package com.anurag.BinaryTree;


public class ValidBST 
{ 
	Node root; 
	boolean isBST() { 
		return function(root, Integer.MIN_VALUE, 
							Integer.MAX_VALUE); 
	} 

	boolean function(Node node, int min, int max) 
	{ 
		if (node == null) {
            return true;
        }

        // Check if the current node's value is within the valid range
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively check the left and right subtrees
        return function(node.left, min, node.data) && function(node.right, node.data, max);
	} 

	public static void main(String args[]) 
	{ 
		ValidBST tree = new ValidBST(); 
		tree.root = new Node(12); 
		tree.root.left = new Node(4); 
		tree.root.right = new Node(25); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(9); 
		tree.root.right.left = new Node(16); 
		tree.root.right.right = new Node(32); 

		if (tree.isBST()) 
			System.out.println("IS BST"); 
		else
			System.out.println("Not a BST"); 
	} 
} 

/* Try more Inputs
case1:
 root = Node(12); 
root.left = Node(4); 
root.right = Node(25); 
root.left.left = Node(2); 
root.left.right = Node(9); 
root.right.left = Node(16); 
root.right.right = Node(32); 
actual = isBST(root)
expected = True

case2:
root = Node(2); 
root.left = Node(1); 
root.right = Node(3); 
actual = isBST(root)
expected = True

*/
