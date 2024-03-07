package com.anurag.BinaryTree;



import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 
   

   
public class ReverseLevelOrder  
{ 
    Node root; 
   // Function to print reverse level order traversal of given binary tree
    void reverseLevelOrder(Node node)  
    { 
        // create a stack to reverse level order nodes
        Stack<Node> stack = new Stack(); 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new LinkedList(); 
        queue.add(node); 
        // loop till queue is empty
        while (queue.isEmpty() == false)  
        {   // process each node in queue and enqueue their children
            node = queue.peek(); 
            queue.remove(); 
            // push current node to stack
            stack.push(node); 
            // important - process right node before left node
            if (node.right != null) 
                queue.add(node.right);  
                  
            if (node.left != null) 
                queue.add(node.left); 
        } 
        // pop all nodes from the stack and print them
        while (stack.empty() == false)  
        { 
            node = stack.peek(); 
            System.out.print(node.data + " "); 
            stack.pop(); 
        } 
    } 
   
    public static void main(String args[])  
    { 
    	ReverseLevelOrder tree = new ReverseLevelOrder(); 
   
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
   
        System.out.println("Revrese Level Order traversal :"); 
        tree.reverseLevelOrder(tree.root); 
   
    } 
} 

/* Try more Inputs
case1:
Main tree = new Main(); 
tree.root = new Node(1); 
tree.root.left = new Node(2); 
tree.root.right = new Node(3); 
actual = reverseLevelOrder(tree)
expect = 2 3 1

case2: 
Main tree = new Main(); 
tree.root = new Node(1); 
tree.root.left = new Node(2); 
tree.root.right = new Node(3); 
tree.root.right.left = new Node(-4); 
tree.root.right.right = new Node(-5); 
expect = -4 -5 2 3 1
*/
