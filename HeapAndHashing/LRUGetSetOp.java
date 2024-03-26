package com.anurag.HeapAndHashing;

import java.util.*;
public class LRUGetSetOp {

    // Definition of a doubly linked list node
    class DLL {
        int key;
        int value;
        DLL prev;
        DLL next;
    }

    private Map<Integer, DLL> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLL head, tail;

    // Constructor to initialize the LRU cache
    public LRUGetSetOp(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // Dummy head and tail nodes to simplify boundary cases
        head = new DLL();
        tail = new DLL();
        head.next = tail;
        tail.prev = head;
    }

    // Method to retrieve the value corresponding to a key from the cache
    public int get(int key) {
        DLL node = cache.get(key);
        if (node == null) return -1; // Key not found in cache

        // Move the accessed node to the head of the list (indicating recent use)
        moveToHead(node);

        return node.value;
    }

    // Method to insert or update a key-value pair in the cache
    public void put(int key, int value) {
        DLL node = cache.get(key);

        if (node == null) {
            // If the key is not already present in the cache, insert a new node
            DLL newNode = new DLL();
            newNode.key = key;
            newNode.value = value;

            // Add the new node to the cache and the head of the list
            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            // Check if the cache exceeds its capacity and evict the least recently used node if necessary
            if (size > capacity) {
                DLL tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // If the key is already present, update the value and move the node to the head of the list
            node.value = value;
            moveToHead(node);
        }
    }

    // Helper method to add a node to the head of the list
    private void addNode(DLL node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node from the list
    private void removeNode(DLL node) {
        DLL prev = node.prev;
        DLL next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Helper method to move a node to the head of the list
    private void moveToHead(DLL node) {
        removeNode(node);
        addNode(node);
    }

    // Helper method to remove and return the tail node of the list
    private DLL popTail() {
        DLL res = tail.prev;
        removeNode(res);
        return res;
    }

    // Main method for testing the LRU cache
    public static void main(String[] args) {
        // Create an instance of the LRU cache with capacity 4
        LRUGetSetOp lrucache = new LRUGetSetOp(4);
        
        // Perform some put operations on the cache
        lrucache.put(1, 100);
        lrucache.put(10, 99);
        lrucache.put(15, 98);
        lrucache.put(10, 97);
        lrucache.put(12, 96);
        lrucache.put(18, 95);
        lrucache.put(1, 94);
 
        // Perform some get operations on the cache and print the results
        System.out.println(lrucache.get(1)); // Expected output: 94
        System.out.println(lrucache.get(10)); // Expected output: 97
        System.out.println(lrucache.get(15)); // Expected output: 98
    }
}

