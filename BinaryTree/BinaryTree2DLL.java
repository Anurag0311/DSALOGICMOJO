package com.anurag.BinaryTree;

import java.util.*;
public class BinaryTree2DLL {  
       //Represent a node of the binary tree  
    public static class Node{  
        int data;  
        Node left;  
        Node right;  
          
        public Node(int data) {  
            this.data = data;  
            this.left = null;  
            this.right = null;  
        }  
    }  
      
    //Represent the root of the binary tree  
  
    public Node root;  
        
    //Represent the head and tail of the doubly linked list  
    Node head, tail = null;  
      
    //convertbtToDLL() will convert the given binary tree to corresponding doubly linked list  
    public void convertbtToDLL(Node node) {  
        //Checks whether node is null  
        if(node == null)  
            return;  
          
        //Convert left subtree to doubly linked list  
        convertbtToDLL(node.left);  
          
        //If list is empty, add node as head of the list  
        if(head == null) {  
            //Both head and tail will point to node  
            head = tail = node;  
        }  
        //Otherwise, add node to the end of the list  
        else {  
            //node will be added after tail such that tail's right will point to node  
            tail.right = node;  
            //node's left will point to tail  
            node.left = tail;  
            //node will become new tail  
            tail = node;  
        }  
          
        //Convert right subtree to doubly linked list  
        convertbtToDLL(node.right);  
    }  
      
    //display() will print out the nodes of the list  
    public void display(ArrayList<Integer> result) {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of generated doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
            result.add(current.data);  
            current = current.right;  
        }  
    }  
      
    public static void main(String[] args) {  
          
    	BinaryTree2DLL bt = new BinaryTree2DLL();  
        //Add nodes to the binary tree  
        bt.root = new Node(1);  
        bt.root.left = new Node(2);  
        bt.root.right = new Node(3);  
        bt.root.left.left = new Node(4);  
        bt.root.left.right = new Node(5);  
        bt.root.right.left = new Node(6);  
        bt.root.right.right = new Node(7);  
          
        //Converts the given binary tree to doubly linked list  
        bt.convertbtToDLL(bt.root);  
          
        //Displays the nodes present in the list  
        ArrayList<Integer> result = new  ArrayList<Integer>();
        bt.display(result);
        System.out.print(result);
    }  
}  

/* Try more Inputs
Case 1:
BinaryTree tree = new BinaryTree();
BinaryTree tree = new BinaryTree();
tree.root = new Node(10);
tree.root.left = new Node(12);
tree.root.right = new Node(15);
tree.root.left.left = new Node(25);
tree.root.left.right = new Node(30);
tree.root.right.left = new Node(36);
display(root)
expected = [25 ,12 ,30 ,10 ,36 ,15]

Case 1:
BinaryTree tree = new BinaryTree();
BinaryTree tree = new BinaryTree();
tree.root = new Node(10);
tree.root.left = new Node(12);
display(root)
expected = [12,10]

*/
