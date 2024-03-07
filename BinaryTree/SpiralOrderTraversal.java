package com.anurag.BinaryTree;


import java.util.*; 
  
class NodeSPT { 
    int data; 
    NodeSPT left, right; 
  
    public NodeSPT(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 


class SpiralOrderTraversal { 
  
    static NodeSPT root; 
  
    void printSpiralOrder(NodeSPT node) 
    { 
        if (node == null) 
            return; 
  
        
        
        Stack<NodeSPT> s1 = new Stack<NodeSPT>();  
        
        Stack<NodeSPT> s2 = new Stack<NodeSPT>();  
  
        
        s1.push(node); 
  
        
        while (!s1.empty() || !s2.empty()) { 
            
            
            while (!s1.empty()) 
            { 
            	NodeSPT n1 = s1.peek(); 
                s1.pop(); 
                System.out.print(n1.data + " "); 
  
                
                if (n1.right != null) 
                    s2.push(n1.right); 
  
                if (n1.left != null) 
                    s2.push(n1.left); 
            } 
  
            
            
            while (!s2.empty()) { 
            	NodeSPT n2 = s2.peek(); 
                s2.pop(); 
                System.out.print(n2.data + " "); 
  
                
                if (n2.left != null) 
                    s1.push(n2.left); 
                if (n2.right != null) 
                    s1.push(n2.right); 
            } 
        } 
    } 
  
    public static void main(String[] args) 
    { 
    	SpiralOrderTraversal tree = new SpiralOrderTraversal(); 
        root = new NodeSPT(1); 
        root.left = new NodeSPT(2); 
        root.right = new NodeSPT(3); 
        root.left.left = new NodeSPT(7); 
        root.left.right = new NodeSPT(6); 
        root.right.left = new NodeSPT(5); 
        root.right.right = new NodeSPT(4); 
        System.out.println("Spiral Order traversal of Binary Tree is "); 
        tree.printSpiralOrder(root); 
    } 
} 

/* Try more Inputs
root = None
root = Node(1)  
root.left = Node(2)  
root.right = Node(3)  
actual = printSpiralOrder(root)
expected = [1, 2, 3]

root = Node(1);
root.left = Node(2);
root.right = Node(10);
root.left.left = Node(-1);
root.left.right = Node(-4);
root.right.left = Node(-5);
root.right.right = Node(-6);
actual = printSpiralOrder(root)
expected = [1, 2, 10, -6, -5, -4, -1]
*/


