package com.anurag.BinaryTreeRemaining;

class NodeMPS { 
    int data; 
    NodeMPS left, right; 
  
    public NodeMPS(int item) { 
        data = item; 
        left = right = null; 
    } 
} 
  
  
public class MaxPathSum { 
  
	NodeMPS root; 
    static int result = 0;
    
    int maxPathUtility(NodeMPS node) 
    { 
        if (node == null) 
            return 0; 
        //left and right store maximum path sum going through left and right child of root respetively
        int left = maxPathUtility(node.left); 
        int right = maxPathUtility(node.right); 
        //Max path for parent call of root. This path must include at most one child of root
        int max_value = Math.max(Math.max(left, right) + node.data, 
                                  node.data);
        //Max top represents the sum when the node under consideration is the root of the maxSum path and no ancestor of root are there in max sum path                           
        int max_top = Math.max(max_value, left + right + node.data); 
        //Global variable to store the changes Store the maximum result
        result = Math.max(result, max_top); 
  
        return max_value; 
    } 
  
    public static void main(String args[]) { 
    	MaxPathSum tree = new MaxPathSum(); 
        tree.root = new NodeMPS(10); 
        tree.root.left = new NodeMPS(2); 
        tree.root.right = new NodeMPS(15); 
        tree.root.left.left = new NodeMPS(-4); 
        tree.root.left.right = new NodeMPS(-6); 
        tree.root.left.left.left = new NodeMPS(28);
        tree.root.left.left.right = new NodeMPS(-22);
        tree.root.right.right = new NodeMPS(-25); 
        tree.root.right.right.left = new NodeMPS(3); 
        tree.root.right.right.right = new NodeMPS(4); 
        tree.maxPathUtility(tree.root);
        System.out.println("maximum path sum : " + result); 
    } 
} 


/* Try more Inputs
case1:
root = None
root = newNode(1)  
root.left = newNode(2)  
root.right = newNode(3)  
resultRoot = maxPathUtility(root)
expected = 6

case2:
Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(10);
root.left.left = new Node(-1);
root.left.right = new Node(-4);
root.right.left = new Node(-5);
root.right.right = new Node(-6);
root.left.right.left = new Node(4);
root.right.left.left = new Node(7);
root.right.left.right = new Node(4);
root.right.left.left.right = new Node(-2);
actual = maxPathUtility(root)
expected = 19
*/
