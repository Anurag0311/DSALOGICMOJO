package com.anurag.BinaryTreeRemaining;

import java.util. * ;
import java.lang. * ;
//binary tree class
class Node {
  int key;
  Node left;
  Node right;
  public Node(int k) {
    key = k;
  }
  public void setLeft(int x) {
    left = new Node(x);
  }
  public void setRight(int x) {
    right = new Node(x);
  }

}

class binaryTree {
	Node root;
  int ind;

  public int[] treeToArray() {
    //we'll create an array list and then convert it to array
    //as we don't know in advance how many keys have to be stored
    ArrayList < Integer > arrList = new ArrayList < Integer > ();
    //call helper that recursively adds to array
    treeToArray(root, arrList);
    //fill in our return value
    int[] arr = new int[arrList.size()];
    for (int i = 0; i < arr.length; ++i)
    arr[i] = arrList.get(i).intValue();

    return arr;
  }
  //helper function
  void treeToArray(Node n, ArrayList < Integer > arrList) {
    if (n != null) {
      //add the key using preorder traversal
      arrList.add(n.key);
      treeToArray(n.left, arrList);
      treeToArray(n.right, arrList);
    }
    else
    //add the null
    arrList.add( - 1);
  }
  public void arrayToTree(int[] arrKeys) {
    ind = 0;
    root = seralized(arrKeys);
  }

  Node seralized(int[] arrKeys) {
    if (ind >= arrKeys.length) return null;
    if (arrKeys[ind] == -1) return null;
    Node n = new Node(arrKeys[ind]);
    ind = ind + 1;
    n.left = seralized(arrKeys);
    ind = ind + 1;
    n.right = seralized(arrKeys);
    return n;
  }

  public void printPreorder() {
    System.out.println("In order traversal:");
    printPreorder(root);
  }

  void printPreorder(Node n) {
    if (n != null) {
      System.out.print(n.key + " ");
      printPreorder(n.left);
      printPreorder(n.right);
    }

  }
}
public class SerialAndDeserial {

  public static void main(String args[]) {
    int myArr[] = {5,9,2,8,-1,-1,-1, 4,-1,7,-1,-1, 1,-1,3,-1,-1};
    binaryTree bt = new binaryTree();
    bt.arrayToTree(myArr);
    bt.printPreorder();
    int arr[] = bt.treeToArray();

    System.out.println("\nArray created: ");
    for (int i = 0; i < arr.length; ++i)
    System.out.print(arr[i] + " ");
  }

}

