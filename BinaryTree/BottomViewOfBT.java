package com.anurag.BinaryTree;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


class NodeBT
{
	int key;
	NodeBT left = null, right = null;

	NodeBT(int key) {
		this.key = key;
	}
}

class NodeLevel<U, V>
{
	public final U first;   	
	public final V second;  	
	
	private NodeLevel(U first, V second)
	{
		this.first = first;
		this.second = second;
	}

	public static <U, V> NodeLevel <U, V> of(U a, V b)
	{
		
		return new NodeLevel<>(a, b);
	}
}

public class BottomViewOfBT
{
  
	public static void bottamView(NodeBT root, int d, int level,
								   Map<Integer, NodeLevel<Integer, Integer>> map)
	{
    //base case: empty tree
		if (root == null) {
			return;
		}
    //if current level is more than or equal to maximum level seen so far for the same horizontal distance or horizontal distance is seen for the first time, update the map

		if (!map.containsKey(d) || level >= map.get(d).second)
		{
      //update value and level for current distance
			map.put(d, NodeLevel.of(root.key, level));
		}
    //recur for left subtree by decreasing horizontal distance and increasing level by 1
		bottamView(root.left, d - 1, level + 1, map);
    //recur for right subtree by increasing both level and horizontal distance by 1
		bottamView(root.right, d + 1, level + 1, map);
	}
	//Function to print the bottom view of given binary tree
	public static ArrayList<Integer> bottamView(NodeBT root)
	{
	 ArrayList<Integer> mlist = new ArrayList<Integer>();
    //create a HashMap where key -> relative horizontal distance of the node from root node and value -> pair containing node's value and its level
	 Map<Integer, NodeLevel<Integer, Integer>> map = new TreeMap<>();
   //do pre-order traversal of the tree and fill the dictionary
		bottamView(root, 0, 0, map);
    //traverse the dictionary in sorted order of their keys and print the bottom view
		for (NodeLevel<Integer, Integer> it: map.values()) {
		    mlist.add(it.first);
		}
	  return mlist;
	}

	public static void main(String[] args)
	{
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.left.right = new NodeBT(4);
		root.right.left = new NodeBT(5);
		root.right.right = new NodeBT(6);
		root.right.left.left = new NodeBT(7);
		root.right.left.right = new NodeBT(8);

		System.out.print(bottamView(root));
	}
}


/* Try more Inputs
Case 1:
result = []
Node root = new Node(20);
root.left = new Node(8);
root.right = new Node(22);
root.left.left = new Node(5);
root.left.right = new Node(3);
root.right.left = new Node(4);
root.right.right = new Node(25);
root.left.right.left = new Node(10);
root.left.right.right = new Node(14);
result = bottamView(root)
expected = [5,10,4,14,25]

Case2: 
Node root = new Node(20);
root.left = new Node(8);
root.right = new Node(22);
root.left.left = new Node(5);
root.left.right = new Node(3);
printLeftView(root)
expected = [5,3,22]
*/
