package com.anurag.LinkedList;

import java.util.*;

public class ReverseLLInKGroup 
{ 
    Node head;  
   
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    } 
  
    Node reverseKList(Node head, int k) 
    { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
       //Reverse first k nodes of the linked list
       while (count < k && current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
       //next is now a pointer to (k+1)th node recursively call for the list starting from current. And make rest of the list as next of first node 
       if (next != null)  
          head.next = reverseKList(next, k); 
      //prev is new head of the input list
       return prev; 
    }  
    //Function to insert a new node at the beginning                      
    public void insert(int new_data) 
    { 
        Node new_node = new Node(new_data); 
   
        new_node.next = head; 
   
        head = new_node; 
    } 
  
    void printList(ArrayList<Integer> result) 
    { 
        Node temp = head; 
        while (temp != null) 
        { 
           result.add(temp.data); 
           temp = temp.next; 
        }   
    } 
  
    public static void main(String args[]) 
    { 
    	ReverseLLInKGroup list= new ReverseLLInKGroup(); 
          
        list.insert(4); 
        list.insert(2); 
        list.insert(8); 
        list.insert(5); 
        list.insert(1); 
        list.insert(6); 
        list.insert(3); 
        list.insert(7); 
          
        list.head = list.reverseKList(list.head, 3); 
        ArrayList<Integer> result = new ArrayList<Integer>();
        System.out.println("Reverse  list"); 
        list.printList(result);
        System.out.println(result); 
    } 
} 


           
 /* Try more Inputs
Case 1:
        Main list= new Main(); 
        list.insert(1); 
        list.insert(2); 
        list.insert(3); 
        list.insert(4); 
        list.insert(5); 
        list.insert(6); 
        list.insert(7); 
        list.insert(8); 
        list.head = list.reverseKList(list.head, 3); 
        expected = [3,2,1,6,5,4,9,8,7]

    Case 2:
    LinkedList llist = new LinkedList();
    llist.push(1);
    llist.push(2);
    llist.push(3);
    llist.push(4);
    llist.push(5);
    list.head = list.reverseKList(list.head, 3); 
    expected = [3, 4, 5, 1, 2

*/

