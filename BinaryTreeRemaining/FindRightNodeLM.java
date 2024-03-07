package com.anurag.BinaryTreeRemaining;


class RightNode
{
	int key;
	RightNode left = null, right = null;

	RightNode(int key) {
		this.key = key;
	}
}

public class FindRightNodeLM
{	static int desiredLevel = 0;
	public static RightNode findRightNode(RightNode root, int value, int level)	
	{
		if(root == null) {
			return null;
		}
		if(root.key == value) {
			desiredLevel = level;
			return null;
		}
		if(desiredLevel != 0) {
			if(level == desiredLevel) {
				return root;
			}
		}
		RightNode left = findRightNode(root.left, value,level+1);
		if(left != null) {
			return left;
		}
		return findRightNode(root.right, value, level+1);
	}

	public static void main(String[] args)
	{

		RightNode root = new RightNode(1);
		root.left = new RightNode(2);
		root.right = new RightNode(3);
		root.left.left = new RightNode(4);
		root.left.right = new RightNode(5);
		root.right.left = new RightNode(6);
		root.right.left.left = new RightNode(7);
		root.right.left.right = new RightNode(8);

		RightNode right = findRightNode(root, 5,0);
		if (right != null) {
			System.out.print("Right Node is " + right.key);
		} else {
			System.out.print("Right Node doesn't exists");
		}

	}
}

/* Try more Inputs
case1:
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.left.left = Node(7)
root.right.left.right = Node(8)
actual = findRightNode(root, 5,0)
expected = 6

case2:
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.left.left = Node(7)
root.right.left.right = Node(8)
actual = findRightNode(root, 2,0)
expected = 3

case3:
root = Node(1)
root.left = Node(2)
root.right = Node(3)
actual = findRightNode(root, 2,0)
expected = 3

*/