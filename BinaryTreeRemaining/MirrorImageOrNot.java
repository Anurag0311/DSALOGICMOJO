package com.anurag.BinaryTreeRemaining;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MirrorImageOrNot {
	static class Node {
		int data;

		Node children[];

		Node(int n, int data) {
			children = new Node[n];
			this.data = data;
		}
	}

	public static void main(String[] args) {

		int n = 3;
		Node root = new Node(n, 1);
		root.children[0] = new Node(n, 2);
		root.children[1] = new Node(n, 3);

		Node root1 = new Node(n, 1);
		root1.children[0] = new Node(n, 3);
		root1.children[1] = new Node(n, 2);

		System.out.println(checkMirror(root, root1));
	}

	private static boolean checkMirror(Node a, Node b) {
		if (a.data != b.data) {
			return false;
		}
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(a);
		stack.push(b);
		while (queue.isEmpty() == false && stack.isEmpty() == false) {
			Node poll = queue.poll();
			Node pop = stack.pop();
			if (poll.data != pop.data && !check(a, b, stack, queue)) {
				return false;
			}
			Arrays.stream(poll.children).filter(e -> e != null).forEach(e -> queue.add(e));
			Arrays.stream(pop.children).filter(e -> e != null).forEach(e -> stack.push(e));
		}
		return true;
	}

	private static boolean check(Node a, Node b, Stack<Node> stack, Queue<Node> queue) {
		if (a.children.length != b.children.length || (stack.size() != queue.size())) {
			return false;
		}
		Iterator<Node> it1 = stack.iterator();
		Iterator<Node> it2 = queue.iterator();
		while (it1.hasNext() && it2.hasNext()) {
			if (it1.next().data != it2.next().data) {
				return false;
			}
		}
		if (it1.hasNext() == false || it2.hasNext() == false) {
			return false;
		}
		return true;
	}

}

