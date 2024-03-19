package com.anurag.LinkedList;

class NthNodeFromLast {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printNthFromLast(int n) {
        if (head == null) {
            System.out.print("List is empty");
            return;
        }
        Node second = head;
        Node first = head;
        int count = 0;
        while (count < n) {
            if (first == null) {
                System.out.print("n is greater than the number of nodes");
                return;
            }
            first = first.next;
            count++;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        System.out.print(second.data);
    }

    public void insert(int new_data) {

        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
    }

    public static void main(String[] args) {
        NthNodeFromLast llist = new NthNodeFromLast();
        llist.insert(20);
        llist.insert(4);
        llist.insert(15);
        llist.insert(35);

        llist.printNthFromLast(4);
    }
}