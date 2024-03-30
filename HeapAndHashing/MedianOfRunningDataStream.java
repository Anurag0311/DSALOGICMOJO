package com.anurag.HeapAndHashing;




import java.util.Scanner;

public class MedianOfRunningDataStream {

    public static void main(String[] args) {
        int n = 6;
        int[] a = {12,4,5,3,8,7};
        int[] minHeap = new int[n];
        int[] maxHeap = new int[n];
        int minHeapSize = 0;
        int maxHeapSize = 0;

        float currentMedian = 0;

        for (int a_i = 0; a_i < n; a_i++) {
            // Decide whether to add the current element to the minHeap or maxHeap
            if (a[a_i] < currentMedian) {
                maxHeap[maxHeapSize++] = a[a_i];
                if (maxHeap[maxHeapSize - 1] > maxHeap[0]) {
                    swap(maxHeap, maxHeapSize - 1, 0);
                }
            } else {
                minHeap[minHeapSize++] = a[a_i];
                if (minHeap[minHeapSize - 1] < minHeap[0]) {
                    swap(minHeap, minHeapSize - 1, 0);
                }
            }

            // Rebalance the heaps if the difference in their sizes is more than 1
            if (Math.abs(maxHeapSize - minHeapSize) > 1) {
                if (maxHeapSize > minHeapSize) {
                    swap(maxHeap, maxHeapSize - 1, 0);
                    minHeap[minHeapSize++] = maxHeap[--maxHeapSize];
                    swap(minHeap, 0, minHeapSize - 1);
                    buildMaxHeap(maxHeap, maxHeapSize);
                } else {
                    swap(minHeap, minHeapSize - 1, 0);
                    maxHeap[maxHeapSize++] = minHeap[--minHeapSize];
                    swap(maxHeap, 0, maxHeapSize - 1);
                    buildMinHeap(minHeap, minHeapSize);
                }
            }

            // Calculate the current median based on the sizes of the heaps
            if (maxHeapSize == minHeapSize) {
                currentMedian = (minHeap[0] + maxHeap[0]);
                currentMedian = currentMedian / 2;
            } else if (maxHeapSize > minHeapSize) {
                currentMedian = maxHeap[0];
            } else {
                currentMedian = minHeap[0];
            }

            System.out.println(currentMedian);
        }
    }

    // Method to build a max heap from an input array
    static void buildMaxHeap(int[] input, int heapSize) {
        int depth = (heapSize - 1) / 2;
        for (int i = depth; i >= 0; i--) {
            maxHeapify(input, i, heapSize);
        }
    }

    // Method to perform max heapify operation on a heap
    static void maxHeapify(int[] input, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;

        if (left < heapSize && input[left] > input[largest]) {
            largest = left;
        }

        if (right < heapSize && input[right] > input[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(input, i, largest);
            maxHeapify(input, largest, heapSize);
        }
    }

    // Method to build a min heap from an input array
    static void buildMinHeap(int[] input, int heapSize) {
        int depth = (heapSize - 1) / 2;
        for (int i = depth; i >= 0; i--) {
            minHeapify(input, i, heapSize);
        }
    }

    // Method to perform min heapify operation on a heap
    static void minHeapify(int[] input, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int smallest = i;

        if (left < heapSize && input[left] < input[smallest]) {
            smallest = left;
        }

        if (right < heapSize && input[right] < input[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(input, i, smallest);
            minHeapify(input, smallest, heapSize);
        }
    }

    // Method to swap two elements in an array
    static void swap(int[] input, int i, int j) {
        if (i == j)
            return;
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
