package com.anurag.BinaryTreeRemaining;


class NodeBT  
{ 
    int data; 
    NodeBT left, right; 
   
    NodeBT(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
public class PrintkDistNodeFromRoot  
{ 
	NodeBT root; 
   
    void findNode_DistanceDown(NodeBT node, int k)  
    { 
        if (node == null) 
            return; 
        if (k == 0)  
        { 
            System.out.print(node.data + " "); 
            return; 
        }  
        else 
        { 
            findNode_DistanceDown(node.left, k - 1); 
            findNode_DistanceDown(node.right, k - 1); 
        } 
    } 
      
    public static void main(String args[]) { 
    	PrintkDistNodeFromRoot tree = new PrintkDistNodeFromRoot(); 
        
        tree.root = new NodeBT(1); 
        tree.root.left = new NodeBT(2); 
        tree.root.right = new NodeBT(3); 
        tree.root.left.left = new NodeBT(4); 
        tree.root.left.right = new NodeBT(5); 
        tree.root.right.left = new NodeBT(8); 
   
        tree.findNode_DistanceDown(tree.root, 2); 
    } 
} 


/* Try more Inputs

/* Constructed binary tree is           
             1  
            / \  
           2   3  
          / \ /  
         4  5 8  
    */
/*Case 1:
Main tree = new Main(); 
tree.root = new Node(1);  
tree.root.left = new Node(2);  
tree.root.right = new Node(3);  
tree.root.left.left = new Node(4);  
tree.root.left.right = new Node(5);  
tree.root.right.left = new Node(8); 
tree.printLeftView(tree.root,2)
expected = [4,5,8]*/

//Case2: 
/* Constructed binary tree is           
             10  
            / \  
           12  3  
           \  /  
            4 5  
                \
                 6
*/
/*BinaryTree root = newNode(10);
root.left = newNode(12);
root.right = newNode(3);
root.left.right = newNode(4);
root.right.left = newNode(5);
root.right.left.right = newNode(6);
tree.printLeftView(root,2)
expected = [4,5]
*/

