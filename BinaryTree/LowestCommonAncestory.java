package com.anurag.BinaryTree;

class NodeLCA 
{ 
    int data; 
    NodeLCA left, right; 
  
    public NodeLCA(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
public class LowestCommonAncestory 
{ 
	NodeLCA root; 
    static boolean v1 = false, v2 = false; 
  
    NodeLCA function(NodeLCA node, int data1, int data2) 
    { 
        if (node == null) {
            return null;
        }

        // Check if the current node is one of the target nodes
        if (node.data == data1) {
            v1 = true;
            return node;
        }

        if (node.data == data2) {
            v2 = true;
            return node;
        }

        // Recursively find LCA in the left and right subtrees
        NodeLCA leftLCA = function(node.left, data1, data2);
        NodeLCA rightLCA = function(node.right, data1, data2);

        // If both nodes are found in different subtrees, the current node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        // If one of the nodes is found, return that as the LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    } 
  
    NodeLCA findLCA(int n1, int n2) 
    { 
        v1 = false; 
        v2 = false; 
  
        NodeLCA lca = function(root, n1, n2); 
  
        if (v1 && v2) 
            return lca; 
  
        return null; 
    } 
  
    public static void main(String args[]) 
    { 
        LowestCommonAncestory tree = new LowestCommonAncestory(); 
        tree.root = new NodeLCA(3); 
        tree.root.left = new NodeLCA(4); 
        tree.root.right = new NodeLCA(5); 
        tree.root.left.left = new NodeLCA(6); 
        tree.root.left.right = new NodeLCA(7); 
        tree.root.right.left = new NodeLCA(8); 
        tree.root.right.right = new NodeLCA(9); 
  
        NodeLCA lca = tree.findLCA(6,7); 
        if (lca != null) 
            System.out.println("LCA(6,7) = " + lca.data); 
        else
            System.out.println("Keys are not present"); 
  
    } 
} 

/* Try more Inputs
case1:
root = Node(3) 
root.left = Node(4) 
root.right = Node(5) 
root.left.left = Node(6) 
root.left.right = Node(7) 
root.right.left = Node(8) 
root.right.right = Node(9) 
actual = findLCA(root,4,9)
expected = 3

case2:
root = Node(3) 
root.left = Node(4) 
root.right = Node(5) 
root.left.left = Node(6) 
root.left.right = Node(7) 
root.right.left = Node(8) 
root.right.right = Node(9) 
actual = findLCA(root,6,7)
expected = 4

*/

