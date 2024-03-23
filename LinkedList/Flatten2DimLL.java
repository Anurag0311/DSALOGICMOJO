package com.anurag.LinkedList;

import java.util.*;
//A linked list node
class NodeDimLL {
	int data;
	NodeDimLL next;
	NodeDimLL down;
};

public class Flatten2DimLL
{
	// Helper function to insert new node in the beginning of the vertical linked list
	public static NodeDimLL push(NodeDimLL head, int data)
	{
		NodeDimLL newNode = new NodeDimLL();

		newNode.data = data;
		newNode.next = null;
		newNode.down = head;

		return newNode;
	}

	// Takes two lists sorted in increasing order, and merge their nodes
	// together to make one big sorted list which is returned
	public static NodeDimLL SortedMerge(NodeDimLL a, NodeDimLL b)
	{
		if (a == null) {
			return b;
		}
		else if (b == null) {
			return a;
		}

		NodeDimLL result;

		// Pick either a or b, and recur
		if (a.data <= b.data)
		{
			result = a;
			result.down = SortedMerge(a.down, b);
		}
		else
		{
			result = b;
			result.down = SortedMerge(a, b.down);
		}

		return result;
	}

	/*
		Split the nodes of the given list into front and back halves.
		If the length is odd, the extra node should go in the front list.
		It uses the fast/slow reference strategy
	*/

	public static NodeDimLL[] FrontBackSplit(NodeDimLL source)
	{
		// if length is less than 2, handle separately
		if (source == null || source.down == null) {
			return new NodeDimLL[]{ source, null } ;
		}

		NodeDimLL slow = source;
		NodeDimLL fast = source.down;

		// Advance 'fast' two nodes, and advance 'slow' one node
		while (fast != null)
		{
			fast = fast.down;
			if (fast != null)
			{
				slow = slow.down;
				fast = fast.down;
			}
		}

		// 'slow' is before the midpoint in the list, so split it in two
		// at that point.
		NodeDimLL[] array = new NodeDimLL[]{ source, slow.down };
		slow.down = null;

		return array;
	}

	// Sort given linked list using Merge sort algorithm
	public static NodeDimLL MergeSort(NodeDimLL head)
	{
		// Base case -- length 0 or 1
		if (head == null || head.down == null) {
			return head;
		}

		// Split head into 'front' and 'back' sublists
		NodeDimLL[] array = FrontBackSplit(head);
		NodeDimLL front = array[0];
		NodeDimLL back = array[1];

		// Recursively sort the sublists
		front = MergeSort(front);
		back = MergeSort(back);

		// answer = merge the two sorted lists together
		return SortedMerge(front, back);
	}

	// Helper function to print given linked list
	public static void printList(NodeDimLL head,ArrayList<Integer> result)
	{
		NodeDimLL ptr = head;
		while (ptr != null)
		{
			result.add(ptr.data);
			ptr = ptr.down;
		}
	}

	// Iterative function to flatten and sort a given list
	public static void flatten (NodeDimLL head)
	{
		NodeDimLL curr = head;

		while (curr != null)
		{
			NodeDimLL temp = curr;
			while (temp.down != null) {
				temp = temp.down;
			}
			temp.down = curr.next;
			curr = curr.next;
		}
	}

	// Helper function to create a linked list with elements of given vector
	public static NodeDimLL createVerticalList(NodeDimLL head, int[] array)
	{
		for (int key: array) {
			head = push(head, key);
		}
		return head;
	}

	public static void main(String[] args)
	{
		NodeDimLL head = null;
     ArrayList<Integer> result = new ArrayList<Integer>();
		int[] array1 = { 8, 6, 4, 1 };
		int[] array2 = { 7, 3, 2 };
		int[] array3 = { 9, 5 };
		int[] array4 = { 12, 11, 10 };

		head = createVerticalList(head, array1);
		head.next = createVerticalList(head.next, array2);
		head.next.next = createVerticalList(head.next.next, array3);
		head.next.next.next = createVerticalList(head.next.next.next, array4);

		// flatten the list
		flatten(head);

		//sort the list
		MergeSort(head);

		// print the flattened & sorted linked list
		printList(head,result);
		System.out.print(result);
	}
}

/* Try more Inputs
Case 1:
Node head = null;
ArrayList<Integer> result = new ArrayList<Integer>();
int[] array1 = { 1 };
int[] array2 = { 2 };
int[] array3 = { 3 };
int[] array4 = { 4 };
head = createVerticalList(head, array1);
head.next = createVerticalList(head.next, array2);
head.next.next = createVerticalList(head.next.next, array3);
head.next.next.next = createVerticalList(head.next.next.next, array4);
flatten(head);
MergeSort(head);
printList(head,result);
expected = [1,2,3,4]

Case2: 
Node head = null;
ArrayList<Integer> result = new ArrayList<Integer>();
int[] array1 = { 1 };
int[] array2 = { 2,3 };
int[] array3 = { 4 };
int[] array4 = { 5 };
head = createVerticalList(head, array1);
head.next = createVerticalList(head.next, array2);
head.next.next = createVerticalList(head.next.next, array3);
head.next.next.next = createVerticalList(head.next.next.next, array4);
flatten(head);
MergeSort(head);
printList(head,result);
expected = [1,2,3,4,5]
*/
