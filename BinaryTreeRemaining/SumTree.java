package com.anurag.BinaryTreeRemaining;

import org.w3c.dom.Node;

class NodeST
{
	int data;
	NodeST left = null, right = null;

	NodeST(int data) {
		this.data = data;
	}
}

public class SumTree
{
	public static void Inorder(NodeST root)
	{
	    if(root == null) {
	    	return;
	    }
	    Inorder(root.left);
	    System.out.print(root.data + " ");
	    Inorder(root.right);
	    
	}

	public static int convertToSumTree(NodeST root)
	{
		if (root == null) {
			return 0;
		}
		int oldValue = root.data;
		int left = convertToSumTree(root.left);
		int right = convertToSumTree(root.right);
		root.data = left + right;
		
		return root.data + oldValue;
	}

	public static void main(String[] args)
	{
		NodeST root = null;
		root = new NodeST(10);
		root.left = new NodeST(-3);
		root.right = new NodeST(4);
		root.left.left = new NodeST(9);
		root.left.right = new NodeST(-4);
		root.right.left = new NodeST(6);
		root.right.right = new NodeST(5);

		convertToSumTree(root);
		Inorder(root);
	}
}

/* Try more Inputs
case1:
root = None
root = newNode(10)  
root.left = newNode(-3)  
root.right = newNode(4)  
root.left.left = newNode(9)  
root.left.right = newNode(-4)  
root.right.left = newNode(6)  
root.right.right = newNode(5)  
resultRoot = convertSumTree(root)
actual = Inorder(resultRoot)
expected = {0,5,0,17,0,11,0}

case2:
root = None
root = newNode(10)  
root.left = newNode(-2)  
root.right = newNode(6)  
root.left.left = newNode(8)  
root.left.right = newNode(-4)  
root.right.left = newNode(7)  
root.right.right = newNode(5)  
resultRoot = convertSumTree(root)
actual = Inorder(resultRoot)
expected = {0,4,0,20,0,12,0}
*/
