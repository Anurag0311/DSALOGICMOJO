package com.anurag.BinaryTree;


import java.util.Stack; 

class NodeIIT 
{ 
	int data; 
	NodeIIT left, right; 

	public NodeIIT(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class IterativeInorderTraversal 
{ 
	NodeIIT root; 
	void inorder() 
	{ 
		if(root == null) {
			return;
		}
		Stack<NodeIIT> stack = new Stack<NodeIIT>();
		NodeIIT curr = root;
		while(curr != null || stack.size() > 0) {	
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	} 

	public static void main(String args[]) 
	{ 

		IterativeInorderTraversal tree = new IterativeInorderTraversal(); 
		tree.root = new NodeIIT(6); 
		tree.root.left = new NodeIIT(4); 
		tree.root.right = new NodeIIT(10); 
		tree.root.left.right = new NodeIIT(5); 
		tree.root.right.right = new NodeIIT(12); 
		tree.root.right.left = new NodeIIT(8);
		tree.inorder(); 
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
expected = {1,2,3}

*/