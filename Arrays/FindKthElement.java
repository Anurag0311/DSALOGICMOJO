package com.anurag.Arrays;


public class FindKthElement 
{ 
    //finds the kth position in a given unsorted array i.e this function can be used to find both kth largest and kth smallest element in the array. 
    int findKthElement(int array[], int low, int high, int k) 
    { 
         //Practise Yourself : Write your code Here 
         return 0;
    } 
  
    public static void main(String args[]) 
    { 
    	FindKthElement ob = new FindKthElement(); 
        int array[] = {54, 26, 93, 17, 77, 31, 44,20,55}; 
        int n = array.length,k = 3; 
        System.out.println("K'th smallest element is "+ 
                           ob.findKthElement(array, 0, n-1, k)); 
    } 
} 


/* Try more Inputs
case 1: 
actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,3)
expected = 7

case2: 
 actual = findKthElement([7, 10, 4, 3, 20, 15],0,5,4)
 expected = 10
 
case3: 
actual = findKthElement([12, 3, 5, 7, 19],0,4,2)
expected = 5
*/