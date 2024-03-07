package com.anurag.BinaryTree;



public class PrintkDistNodeFromLeaf { 
	Node root; 

	void printKDistance(Node node, int k,int arr[], boolean visited[], 
							int count) 
	{ 
	    if(node == null) {
	    	return;
	    }
	    arr[count] = node.data;
	    visited[count] = false;
	    if(node.left == null && node.right == null && count - k >= 0 && visited[count - k] == false) {
	    	System.out.println(arr[count -k]);
	    	visited[count - k] = true;
	    	return;
	    }
	    printKDistance(node.left, k, arr, visited, count+1);
	    printKDistance(node.right, k, arr, visited, count+1);
	} 

	void printKDistantfromLeaf(Node node, int k) 
	{ 
		int path[] = new int[1000]; 
		boolean visited[] = new boolean[1000]; 
		printKDistance(node, k,path, visited, 0); 
	} 

	public static void main(String args[]) 
	{ 
		PrintkDistNodeFromLeaf tree = new PrintkDistNodeFromLeaf(); 

		tree.root = new Node(3); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(9); 
		tree.root.left.left = new Node(11); 
		tree.root.left.right = new Node(7); 
		tree.root.left.right.left = new Node(6); 
		tree.root.left.right.right = new Node(12); 
		tree.root.right.left= new Node(8); 
		tree.root.right.right = new Node(3); 

		System.out.println(" Nodes at distance 2 are :"); 
		tree.printKDistantfromLeaf(tree.root, 2); 
	} 
} 

/* Try more Inputs
case1:
root = Node(3); 
root.left = Node(8); 
root.right = Node(9); 
root.left.left = Node(11); 
root.left.right = Node(7); 
root.left.right.left = Node(6); 
root.left.right.right = Node(12); 
root.right.left = Node(8); 
root.right.right = Node(3); 
actual = printKDistantfromLeaf(root,3)
expected = 3

case2:
root = Node(3); 
root.left = Node(8); 
root.right = Node(9); 
root.left.left = Node(11); 
root.left.right = Node(7); 
root.left.right.left = Node(6); 
root.left.right.right = Node(12); 
root.right.left = Node(8); 
root.right.right = Node(3); 
actual = printKDistantfromLeaf(root,3)
expected = {3,8}


*/
