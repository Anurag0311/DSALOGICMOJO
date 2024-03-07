package com.anurag.BinaryTree;

  
public class PrintkDistNodeFromRandomNode  
{ 
    Node root; 
   
    void printNodesDown(Node node, int k)  
    {  //Base Case 1 : IF tree is empty return -1 
        if (node == null || k < 0) 
            return; 
        if (k == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
        printNodesDown(node.left, k - 1); 
        printNodesDown(node.right, k - 1); 
    } 
    
    int printNodes(Node node, Node target, int k)  
    { 
        
        if (node == null) 
            return -1; 
        //If target is same as root. Use the downward function to print all nodes at distance k in subtree rooted with target or root 
        if (node == target)  
        { 
            printNodesDown(node, k); 
            return 0; 
        } 
        //Recur for left subtree
        int dLeft = printNodes(node.left, target, k); 
        //Check if target node was found in left subtree
        if (dLeft != -1)  
        { 
            //If root is at distance k from target, print root Note: dLeft is distance of root's left child from target 
            if (dLeft + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            } 
            else
                printNodesDown(node.right, k - dLeft - 2); 
            return 1 + dLeft; 
        }
        
        int dRight = printNodes(node.right, target, k); 
        if (dRight != -1)  
        { 
            if (dRight + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                printNodesDown(node.left, k - dRight - 2); 
            return 1 + dRight; 
        } 
        return -1; 
    } 
   
    
    public static void main(String args[])  
    { 
    	PrintkDistNodeFromRandomNode tree = new PrintkDistNodeFromRandomNode(); 
   
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        Node target = tree.root.left.right; 
        tree.printNodes(tree.root, target, 2); 
    } 
} 




