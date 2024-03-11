package com.anurag.LinkedList;

import java.util.*;
class Node  
{ 
    int data; 
    Node next; 
    Node(int d) {data = d; 
                 next = null;} 
} 

public class MergeSortedLL  
{ 
    Node head;  
      
    public void addToTheLast(Node node)  
    { 
        if (head == null) 
        { 
            head = node; 
        } 
        else 
        { 
            Node temp = head; 
            while (temp.next != null) 
                temp = temp.next; 
            temp.next = node; 
        } 
    }
    
    
    // Method to merge two sorted linked lists
    static Node merge_sort(Node first, Node second) {

        // Check if the first linked list is empty
        if (first == null)
            return second;

        // Check if the second linked list is empty
        if (second == null)
            return first;

        Node temp = null;

        // Determine the smaller head between the first and second linked lists
        if (first.data < second.data) {
            temp = first;
            first = first.next;
        } else {
            temp = second;
            second = second.next;
        }

        Node curr = temp;

        // Merge the remaining nodes while maintaining the sorted order
        while (first != null && second != null) {
            if (first.data > second.data) {
                curr.next = second;
                second = second.next;
            } else {
                curr.next = first;
                first = first.next;
            }
            curr = curr.next;
        }

        // Attach the remaining nodes from the first linked list, if any
        if (first == null)
            curr.next = first;

        // Attach the remaining nodes from the second linked list, if any
        if (second == null)
            curr.next = second;

        // Return the head of the merged linked list
        return temp;
    }
    
    
    public static void printList(Node head,ArrayList<Integer> result)
    {
        Node ptr = head;
        while (ptr != null)
        {
            result.add(ptr.data);
            ptr = ptr.next;
        }
    }
    public static void main(String args[]) 
    { 
    	MergeSortedLL list1 = new MergeSortedLL(); 
    	MergeSortedLL list2 = new MergeSortedLL(); 
        ArrayList<Integer> result = new ArrayList<Integer>();
        list1.addToTheLast(new Node(2)); 
        list1.addToTheLast(new Node(4)); 
        list1.addToTheLast(new Node(5)); 
        list1.addToTheLast(new Node(8)); 
          
        list2.addToTheLast(new Node(1)); 
        list2.addToTheLast(new Node(3)); 
        list2.addToTheLast(new Node(6)); 
        list2.addToTheLast(new Node(7)); 
          
          
        list1.head = merge_sort(list1.head, list2.head);
        list1.printList(list1.head,result);
        System.out.println(result);
          
    } 
}


/* Try more Inputs
Case 1:
 Main list1 = new Main(); 
 Main list2 = new Main();
 ArrayList<Integer> result = new ArrayList<Integer>();
 list1.addToTheLast(new Node(1)); 
 list1.addToTheLast(new Node(4)); 
 list1.addToTheLast(new Node(5));
 
 list2.addToTheLast(new Node(2)); 
 list2.addToTheLast(new Node(3)); 
 list2.addToTheLast(new Node(6));
 list1.head = merge_sort(list1.head, list2.head);
 list1.printList(list1.head,result);
 expected = [1,2,3,4,5,6]
 
 Case 2:
 Main list1 = new Main(); 
 Main list2 = new Main();
 ArrayList<Integer> result = new ArrayList<Integer>();
 list1.addToTheLast(new Node(1)); 
 list1.addToTheLast(new Node(3)); 
 
 list2.addToTheLast(new Node(2)); 
 list1.head = merge_sort(list1.head, list2.head);
 list1.printList(list1.head,result);
 expected = [1,2,3]
*/
