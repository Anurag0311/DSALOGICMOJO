package com.anurag.BinaryTree;



  
public class PrintAllBoundaryNodes { 
    Node root; 
    //function to print leaf nodes of a Binary Tree
    void leavesNodes(Node node) 
    { 
      if(node==null)
			return;
 
      if(node.left==null && node.right==null)
      {
        System.out.print(node.data+" ");
        return;
      }
      leavesNodes(node.left);
      leavesNodes(node.right);
    } 
  //function to print all left boundary nodes, except a leaf node. Print the nodes in top down manner
    void leftInternalNodes(Node node) 
    { 
          if(node==null)
          return;
    
        // if leaf node, ignore while printing edges
        if(node.left==null && node.right==null)
          return;
    
        System.out.print(node.data+" ");
    
        // If left is null, right will be the boundary edge.
        if(node.left==null)
        {
          leftInternalNodes(node.right);
        }
        else
        {//to ensure top down order, print the node before calling itself for left subtree
          leftInternalNodes(node.left);
        }
        
    }
    //function to print all right boundary nodes, except a leaf node. Print the nodes in bottam up manner  
    void rightInternalNodes(Node node) 
    { 
        if(node==null)
        return;
  
      if(node.left==null && node.right==null)
      {
        return;
      }
  
      if(node.right!=null)
      {//to ensure bottom up order, first call for right subtree, then print this node
        rightInternalNodes(node.right);
      }
      else if(node.left!=null)
      {
        rightInternalNodes(node.left);
      }
  
        System.out.print(node.data+" ");
    } 
    //Function to do boundary traversal of a given binary tree
    void printBoundary(Node node) 
    { 
        System.out.print(node.data+" ");
        //Print the left boundary in top-down manner
        leftInternalNodes(node.left);
        //Print all leaf nodes
        leavesNodes(node);
        //Print the right boundary in bottom-up manner
        rightInternalNodes(node.right);
    } 
  
    
    public static void main(String args[]) 
    { 
    	PrintAllBoundaryNodes tree = new PrintAllBoundaryNodes();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.left.right.left.left = new Node(17);
        tree.printBoundary(tree.root);
    } 
} 

/* Try more Inputs
Case 1:
Main tree = new Main();
tree.root = new Node(20);
tree.root.left = new Node(8);
tree.root.right = new Node(22);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(12);
tree.root.right.left = new Node(10);
tree.root.right.right = new Node(25);
tree.printLeftView(root)
expected = [20,8,4,12,10,25,22]

Case2: 
Main tree = new Main();
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);
tree.root.right.left = new Node(6);
tree.root.right.right = new Node(7);
tree.root.left.left.left = new Node(8);
tree.root.left.left.right = new Node(9);
tree.root.left.right.right = new Node(10);
tree.root.right.right.left = new Node(11);
tree.root.left.left.right.left = new Node(12);
tree.root.left.left.right.right = new Node(13);
tree.root.right.right.left.left = new Node(14);
tree.printLeftView(root)
expected = [1,2,4,8,12,13,10,6,14,11,7,3]
*/