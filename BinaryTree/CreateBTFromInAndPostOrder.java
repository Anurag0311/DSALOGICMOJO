package com.anurag.BinaryTree;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


class NodeInPo
{
	int key;
	NodeInPo left, right;

	NodeInPo(int key) {
		this.key = key;
	}
}

public class CreateBTFromInAndPostOrder
{
  //Recursive function to perform inorder traversal of a binary tree
	public static void inorderTraversal(NodeInPo root,ArrayList<Integer> result)
	{
		if (root == null) {
			return;
		}

		inorderTraversal(root.left,result);
		result.add(root.key);
		inorderTraversal(root.right,result);
	}
  //Recursive function to perform postorder traversal of a binary tree
	public static void postorderTraversal(NodeInPo root)
	{
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.key + " ");
	}
  //Recursive function to construct a binary tree from inorder and postorder traversals
	public static NodeInPo construct(int start, int end, int[] postorder, AtomicInteger pIndex, Map<Integer,Integer> map)
	{
		//base case
		if (start > end) {
			return null;
		}
    //Consider the next item from the end of given postorder sequence.This value would be the root node of subtree formed by inorder[start, end]
		NodeInPo root = new NodeInPo(postorder[pIndex.getAndDecrement()]);
		int index = map.get(root.key); //search in Inorder Array using HashMap
    //recursively construct the right subtree
		root.right = construct(index + 1, end, postorder, pIndex, map);
    //recursively construct the left subtree
		root.left = construct(start, index - 1, postorder, pIndex, map);
    //return root node
		return root;
	}
  //Construct a binary tree from inorder and postorder traversals. This function assumes that the input is valid i.e. given inorder and postorder sequence forms a binary tree
	public static NodeInPo construct(int[] inorder, int[] postorder)
	{
		
		int n = inorder.length;
		
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		AtomicInteger pIndex = new AtomicInteger(n - 1);
		return construct(0, n - 1, postorder, pIndex, map);
	}
  

	public static void main(String[] args)
	{
	     /* Consider below tree
			  1
			/   \
		   /	 \
		  2		  3
		 /		 / \
		/		/   \
	   4	   5	 6
			  / \
			 /	 \
			7	  8
	*/

		int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
		int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1};

		NodeInPo root = construct(inorder, postorder);

		ArrayList<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root,result);
		System.out.print("Inorder	  : " +result); 
		System.out.print("\nPostorder : "); postorderTraversal(root);
	}
}


/* Try more Inputs
Case 1:
int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1};
ArrayList<Integer> result = new ArrayList<Integer>();
Node root = construct(inorder, postorder);
inorderTraversal(root,result);
expected = [4, 2, 1, 7, 5, 8, 3, 6]

Case2: 
int[] inorder = { 9,3,15,20,7 };
int[] postorder = { 9,15,7,20,3};
ArrayList<Integer> result = new ArrayList<Integer>();
Node root = construct(inorder, postorder);
inorderTraversal(root,result);
expected = [9,3,15,20,7]
*/

