package com.anurag.BinaryTree;


import java.util.Stack; 


public class PreOrderIterative 
{ 
	Node root; 
	void preorder() 
	{ 
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(stack.empty() == false) {
			Node myNode = stack.pop();
			System.out.print(myNode.data + " ");
			if(myNode.right != null) {
				stack.push(myNode.right);
			}
			if(myNode.left != null) {
				stack.push(myNode.left);
			}		
		}
	} 

	public static void main(String args[]) 
	{ 

		PreOrderIterative tree = new PreOrderIterative(); 
		tree.root = new Node(6); 
		tree.root.left = new Node(4); 
		tree.root.right = new Node(10); 
		tree.root.left.right = new Node(5); 
		tree.root.right.right = new Node(12); 
		tree.root.right.left = new Node(8);
		tree.preorder(); 
	} 
} 

/* Try more Inputs
case1:
root = Node(6); 
root.left = Node(4); 
root.right = Node(10); 
root.left.right = Node(5); 
root.right.right = Node(12); 
root.right.left = Node(8);
actual = preOrder(root)
expected = {6,4,5,10,8,12}

case2:
root = Node(1);  
root.right = Node(2); 
root.right.left = Node(3); 
actual = preOrder(root)
expected = [1,2,3]

*/