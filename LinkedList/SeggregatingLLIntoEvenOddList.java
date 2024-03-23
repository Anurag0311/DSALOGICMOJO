package com.anurag.LinkedList;


class NodeEvenOdd
{
	int data;
	NodeEvenOdd next;

	NodeEvenOdd(int data, NodeEvenOdd next) {
		this.data = data;
		this.next = next;
	}
}

class SeggregatingLLIntoEvenOddList
{

	public static NodeEvenOdd rearrangeEvenOdd(NodeEvenOdd head) {
        // Initialize separate even and odd lists
        NodeEvenOdd oddList = null;
        NodeEvenOdd evenList = null;
        
        // Initialize pointers for traversal
        NodeEvenOdd odd = oddList;
        NodeEvenOdd even = evenList;
        NodeEvenOdd curr = head;
        
        // Traverse the original list and segregate even and odd nodes
        while (curr != null) {
            if ((curr.data % 2) != 0) {
                if (oddList == null) {
                    oddList = curr;
                    odd = oddList;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
            } else {
                if (evenList == null) {
                    evenList = curr;
                    even = evenList;
                } else {
                    even.next = curr;
                    even = even.next;
                }
            }
            curr = curr.next;
        }
        
        // Connect even list to the end of odd list and set null at the end of odd list
        if (evenList != null) {
            even.next = oddList;
        }
        if (odd != null) {
            odd.next = null;
        }
        
        // Return the head of the rearranged list
        return evenList;
    }
	
	static void printNodes(NodeEvenOdd head) {
		NodeEvenOdd current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Print a newline after printing all nodes
    }
	
	public static void main(String[] args)
	{
		// input keys
		int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		NodeEvenOdd head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new NodeEvenOdd(keys[i], head);
		}

		head = rearrangeEvenOdd(head);
		printNodes(head);
	}
}
