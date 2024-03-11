package com.anurag.LinkedList;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean; 

class CheckPalindrome { 
    public static void main(String args[]) 
    { 
    	NodeCP one = new NodeCP(2); 
        NodeCP two = new NodeCP(3); 
        NodeCP three = new NodeCP(4); 
        NodeCP four = new NodeCP(5); 
        NodeCP five = new NodeCP(4); 
        NodeCP six = new NodeCP(3); 
        NodeCP seven = new NodeCP(2); 
        one.ptr = two; 
        two.ptr = three; 
        three.ptr = four; 
        four.ptr = five; 
        five.ptr = six; 
        six.ptr = seven; 
        boolean condition = isPalindrome(one); 
        System.out.println("Check Palindrome :" + condition); 
    } 
    static boolean isPalindrome(NodeCP head) 
    { 
        if (head == null) {
            return true;
        }
        AtomicBoolean odd = new AtomicBoolean(false);
        NodeCP mid = findMiddle(head, odd);
        if (odd.get()) {
            mid = mid.ptr;
        }
        mid = reverse(mid);
        return compare(head, mid);
    }

    // Method to compare two linked lists for palindrome check
    private static boolean compare(NodeCP a, NodeCP b) {
        if (a == null && b == null) {
            return true;
        }

        return a != null && b != null && (a.data == b.data) && compare(a.ptr, b.ptr);
    }

    // Method to reverse a linked list
    private static NodeCP reverse(NodeCP mid) {
        NodeCP prev = null;
        NodeCP current = mid;
        NodeCP next = null;

        // Traverse the linked list and reverse the direction of pointers
        while (current != null) {
            next = current.ptr;
            current.ptr = prev;
            prev = current;
            current = next;
        }

        // 'prev' now points to the new head of the reversed linked list
        return prev;
    }

    // Method to find the middle of a linked list and update the 'odd' flag
    private static NodeCP findMiddle(NodeCP head, AtomicBoolean odd) {
        NodeCP prev = null;
        NodeCP slow = head, fast = head;

        while (fast != null && fast.ptr != null) {
            prev = slow;
            slow = slow.ptr;
            fast = fast.ptr.ptr;
        }

        // If 'fast' is not null, the linked list has odd length
        if (fast != null) {
            odd.set(true);
        }

        // Split the linked list into two halves
        prev.ptr = null;
        return slow;
    }

} 
  
class NodeCP { 
    int data; 
    NodeCP ptr; 
    NodeCP(int d) 
    { 
        ptr = null; 
        data = d; 
    } 
} 
