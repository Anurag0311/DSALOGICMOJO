package com.anurag.BinaryTreeRemaining;

//Data structure to store a Binary Tree node
class NodeConnect
{
 int data;
 NodeConnect left = null, right = null, next = null;

 NodeConnect(int data) {
     this.data = data;
 }
}

class ConnectAllNodesSameLevel
{
 // Function to print a given linked list
 public static void printList(NodeConnect head)
 {
     while (head != null) {
         System.out.print(head.data + " -> ");
         head = head.next;
     }

     System.out.println("null");
 }

 // Function to perform inorder traversal of a binary tree where nodes
 // at the same level are linked together in the form of a linked list
 public static void inorder(NodeConnect root)
 {
     if (root == null) {
         return;
     }

     inorder(root.left);

     // print current node and its next node
     System.out.print(root.data + "->");
     if (root.next != null) {
         System.out.println(root.next.data);
     } else {
         System.out.println("null");
     }

     inorder(root.right);
 }

 // Recursive function to find the first node in next level of the root node
 public static NodeConnect findNextNode(NodeConnect root)
 {
     // base case
     if (root == null || root.next == null) {
         return null;
     }

     // if left child of root's next node exists, return it
     if (root.next.left != null) {
         return root.next.left;
     }

     // if right child of root's next node exists, return it
     if (root.next.right != null) {
         return root.next.right;
     }

     // if root's next node is a leaf node, recur for root's next node
     return findNextNode(root.next);
 }

 // Recursive function to link nodes present in each level of a binary tree
 // in the form of a linked list
 public static void linkNodes(NodeConnect root)
 {
     // base case
     if (root == null) {
         return;
     }

     // ensure that the nodes of the current level is linked before the nodes
     // of the next level
     linkNodes(root.next);

     // update the next pointer of root's left child to root's right child
     // if right child doesn't exist, link it to first node in the next level
     if (root.left != null) {
         root.left.next = (root.right != null)? root.right: findNextNode(root);
     }

     // update the next pointer of root's right child to first node
     // in the next level
     if (root.right != null) {
         root.right.next = findNextNode(root);
     }

     // recur for left and right subtree
     linkNodes(root.left);
     linkNodes(root.right);
 }

 public static void main(String[] args)
 {
     /* Construct below Tree
            1
          /   \
         2     3
        / \     \
       4   5     6
        \       /
         7     8
     */

	 NodeConnect root = new NodeConnect(1);
     root.left = new NodeConnect(2);
     root.right = new NodeConnect(3);
     root.left.left = new NodeConnect(4);
     root.left.right = new NodeConnect(5);
     root.right.right = new NodeConnect(6);
     root.left.left.right = new NodeConnect(7);
     root.right.right.left = new NodeConnect(8);

     // link nodes at the same level
     linkNodes(root);

     // print the nodes
     NodeConnect node = root;
     while (node != null)
     {
         // print current level
         printList(node);

         // find leftmost node of the next level
         if (node.left != null)
             node = node.left;
         else if (node.right != null)
             node = node.right;
         else
             node = findNextNode(node);
     }

     // inorder(root);
 }
}




