package com.anurag.BinaryTree;


class TreeNodeVS {
	int data;
	TreeNodeVS left, right;
	
	TreeNodeVS(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}

class ListNode {
	int data;
	ListNode prev, next;

	ListNode(int data, ListNode prev, ListNode next)
	{
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}

public class VerticalSumOfBT
{
	// Function to print the vertical sum stored in given doubly linked list
	public static void print(ListNode mid)
	{
		// find the head mode
		while (mid != null && mid.prev != null) {
			mid = mid.prev;
		}

		// start with the head node
		ListNode head = mid;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
  // Recursive function to do a pre-order traversal of the tree and calculate the
  // vertical sum of given binary tree.
  // Each node of doubly linked list will store the sum of tree nodes at
  // corresponding vertical line in a binary tree
	public static void VirticalSum(TreeNodeVS root, ListNode curr)
	{
		
		if (root == null) {
			return;
		}

    // update the data of linked list node corresponding to the vertical line
    // passing through current tree node
		curr.data += root.data;
    // create a new linked list node corresponding to the vertical line passing
    // through root's left child, if not already.
    // This node would be the prev pointer of current linked list node
		if (root.left != null && curr.prev == null) {
			curr.prev = new ListNode(0, null, curr);
		}
    // create a new linked list node corresponding to the vertical line through
    // through root's right child, if not already.
    // This node would be the next pointer of current linked list node
		if (root.right != null && curr.next == null) {
			curr.next = new ListNode(0, curr, null);
		}
    // recur for left and right subtree
		VirticalSum(root.left, curr.prev);
		VirticalSum(root.right, curr.next);
	}
  // Function to find and print the vertical sum of given binary tree
	public static void verticalSum(TreeNodeVS root)
	{
    // create a linked list node corresponding to the vertical line through
    // root node
		ListNode curr = new ListNode(0, null, null);
    // calculate vertical sum and store it in doubly linked list
		VirticalSum(root, curr);
    // print the linked list
		print(curr);
	}

	public static void main(String[] args)
	{
    /* Construct below tree
                  1
                /   \
               /     \
              2       3
                    /   \
                   /     \
                  5       6
                /   \
               /     \
              7       8
        */
 
		TreeNodeVS root = new TreeNodeVS(1);
        root.left = new TreeNodeVS(2);
        root.right = new TreeNodeVS(3);
        root.right.left = new TreeNodeVS(5);
        root.right.right = new TreeNodeVS(6);
        root.right.left.left = new TreeNodeVS(7);
        root.right.left.right = new TreeNodeVS(8);

		verticalSum(root);
	}
}

/* Try more Inputs
TreeNode root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(7);
verticalSum(root)
expected = [4, 2, 12, 3, 7]
*/
