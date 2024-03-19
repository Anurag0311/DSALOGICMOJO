package com.anurag.LinkedList;

public class CloneLinkedList {
    
    static class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
            this.next = this.random = null;
        }

        @Override
        public String toString() {

            Integer nextdata = this.next != null ? this.next.data : null;
            Integer randomData = this.random != null ? this.random.data : null;
            return "[" + "data=" + data + ", next=" + nextdata +
                    ", random=" + randomData +
                    "]";
        }
    }
    
    public static void main(String[] args) {
     

        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);

        // 3 random points to 5
        head.random = head.next.next;

        // 5 random points to 3
        head.next.random = head;

        // 5 and 6 random points to 7
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;

        // 7 random points to 4
        head.next.next.next.next.random = head.next;

        createCloneLinkedList(head);
        
    }
        

    private static void createCloneLinkedList(Node first) {
        if (first == null) {
            return;
        }

        System.out.println("Original list : ");
        printNextRandomList(first);

        Node str = first;
        Node clone = new Node(-1);
        Node dummy = clone;

        while (str != null) {
            //store next node.
            Node next = str.next;

            //create new Node
            Node newNode = new Node(str.data);

            //point random of newNode to original list node.
            newNode.random = str;

            //making cloned list chain.
            dummy.next = newNode;
            dummy = dummy.next;

            //point original list node to cloned list node.
            str.next = newNode;

            //traverse to next.
            str = next;
        }

        clone = clone.next;
        Node temp = clone;
        
        while (temp != null) {
            //point random in cloned list nodes to original list.
            temp.random = temp.random.random.next;
            temp = temp.next;
        }

        System.out.println("\nCloned list : ");
        printNextRandomList(clone);

    }
    
    private static void printNextRandomList(Node clone) {
        if (clone == null) {
            return;
        }
        Node Node = clone;

        while (Node != null) {
            System.out.println(Node);
            Node = Node.next;
        }
    }

}