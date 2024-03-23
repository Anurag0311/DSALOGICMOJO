package com.anurag.LinkedList;

import java.util.ArrayList;
//A linked list node
class NodeRLL
{
 int data;
 NodeRLL next;

 NodeRLL(int data, NodeRLL next) {
     this.data = data;
     this.next = next;
 }
}

class RearrangeLL
{

 // Helper function to print given linked list
 public static ArrayList<Integer> printList(NodeRLL head,ArrayList<Integer> result)
 {
	 NodeRLL ptr = head;
     while (ptr != null)
     {
         result.add(ptr.data);
         ptr = ptr.next;
     }

     return result;
 }

 // Iterative function to reverse nodes of linked list
 public static NodeRLL reverse(NodeRLL head)
 {
	 NodeRLL result = null;
	 NodeRLL current = head;

     // Iterate through the list and move/insert each node to the
     // front of the result list (like a push of the node)
     while (current != null)
     {
         // tricky: note the next node
    	 NodeRLL next = current.next;

         // move the current node onto the result
         current.next = result;
         result = current;

         // process next node
         current = next;
     }

     // fix head pointer
     return result;
 }

 // Recursive function to construct a linked list by merging
 // alternate nodes of two given linked lists
 //Note : In video lecture we used iterative approch to merge LinkedList here we show another way of recursive approch to merge LinkedList 
 public static NodeRLL mergeList(NodeRLL a, NodeRLL b)
 {
     // see if either list is empty
     if (a == null) {
         return b;
     }

     if (b == null) {
         return a;
     }

     // it turns out to be convenient to do the recursive call first --
     // otherwise a.next and b.next need temporary storage

     NodeRLL recur = mergeList(a.next, b.next);

     NodeRLL result = a;        // one node from a
     a.next = b;             // one from b
     b.next = recur;         // then the rest

     return result;
 }

 // Function to split the linked list into two equal parts and return
 // pointer to the second half
 public static NodeRLL findMiddle(NodeRLL head)
 {
	 NodeRLL prev = null;
	 NodeRLL slow = head, fast = head;

     // find middle pointer
     while (fast != null && fast.next != null)
     {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
     }

     // for odd nodes, fix middle
     if (fast != null && fast.next == null)
     {
         prev = slow;
         slow = slow.next;
     }

     // make next of prev node null
     prev.next = null;

     // return mid node
     return slow;
 }

 // Function to rearrange given linked list in specific way
 public static void rearrange(NodeRLL head)
 {
     // base case
     if (head == null) {
         return;
     }

     // find second half of linked list
     NodeRLL mid = findMiddle(head);

     // reverse the second half
     mid = reverse(mid);

     // merge first and second half
     mergeList(head, mid);
 }

 public static void main(String[] args)
 {
     // input keys
     int[] keys = { 1, 2, 3, 4, 5, 6 };
     ArrayList<Integer> mlist = new ArrayList<Integer>();
     NodeRLL head = null;
     for (int i = keys.length - 1; i >= 0; i--) {
         head = new NodeRLL(keys[i], head);
     }

     rearrange(head);
     printList(head,mlist);
     System.out.print(mlist);
 }
}

/* Try more Inputs
Case 1:
     int[] keys = { 1,2,3 };
     ArrayList<Integer> mlist = new ArrayList<Integer>();
     Node head = null;
     for (int i = keys.length - 1; i >= 0; i--) {
         head = new Node(keys[i], head);
     }

     rearrange(head);
     printList(head,mlist);
     System.out.print(mlist);
     expected = [3,1,2]

Case 1:
     int[] keys = { 1,2,3,4,5 };
     ArrayList<Integer> mlist = new ArrayList<Integer>();
     Node head = null;
     for (int i = keys.length - 1; i >= 0; i--) {
         head = new Node(keys[i], head);
     }

     rearrange(head);
     printList(head,mlist);
     System.out.print(mlist);
     expected = [1,5,2,4,3]
*/

