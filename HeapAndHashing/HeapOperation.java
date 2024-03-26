package com.anurag.HeapAndHashing;

public class HeapOperation { 
	  
    static void heapify(int array[], int n, int i) 
    { 
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        
        if (l < n && array[l] > array[largest]) 
            largest = l; 
        
        if (r < n && array[r] > array[largest]) 
            largest = r; 
        
        if (largest != i) { 
            int swap = array[i]; 
            array[i] = array[largest]; 
            array[largest] = swap; 
            heapify(array, n, largest); 
        } 
    } 
  
    static void buildHeap(int array[], int n) 
    { 
        int startIdx = (n / 2) - 1; 
        for (int i = startIdx; i >= 0; i--) { 
            heapify(array, n, i); 
        } 
    }
    
    static void printHeap(int array[], int n) 
    { 
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(array[i] + " "); 
  
        System.out.println(); 
    } 
  
    
    public static void main(String args[]) 
    { 
        
        int array[] = {3,5,9,6,8,20,10,12, 19,18,2 }; 
  
        int n = array.length; 
  
        buildHeap(array, n); 
  
        printHeap(array, n); 
    } 
} 
