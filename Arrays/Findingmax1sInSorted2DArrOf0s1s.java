package com.anurag.Arrays;

//import java.io.*;
//import java.lang.reflect.Array; 

public class Findingmax1sInSorted2DArrOf0s1s { 
	static int m = 4, n = 4; 
	
	static int binarySearch(int array[], int low, int high) 
	{ 
		int mid =low+(high - low)/2;
	    if(high >= low) {
	    	if((mid == 0 || (array[mid-1] == 0)) && array[mid] == 1) {
	    		return mid;
	    	}
	    }
	    else if(array[mid] == 0) {
	    	return binarySearch(array,(mid + 1),high);
	    }else {
	    	return binarySearch(array,low,(mid + 1));
	    }
		return -1; 
	} 

	static int findRow(int matrix[][]) 
	{ 
	    int max_row_index = 0,max = -1;
	    int i,index;
	    for(i=0 ; i < matrix.length ; i++) {
	    	index = binarySearch(matrix[i],0,matrix[0].length-1);
	    	if(index != 1 && matrix[0].length-1-index > max) {
	    		max = matrix[0].length-1-index;
	    		max_row_index = i;
	    	}
	    }
		return max_row_index; 
	} 
	public static void main(String[] args) 
	{ 
		int matrix[][] = { { 0, 1, 1, 1 }, 
						{ 0, 0, 1, 1 }, 
						{ 0, 0, 0, 1 }, 
						{ 1, 1, 1, 1 } }; 
		System.out.println("Index of row with maximum 1s is "
											+ findRow(matrix)); 
											
	} 
} 

/* Try more Inputs
case1:
 actual = findRow([[0, 1, 1, 1], 
       [0, 0, 1, 1], 
       [1, 1, 1, 1], 
       [0, 0, 0, 0]])
expected = 2

case2:
actual = findRow([[1, 1, 1], 
       [0, 0, 0], 
       [1, 1, 0], 
       [1, 0, 0]])
expected = 0

case3:
actual = findRow([[0, 0, 0, 1, 1], 
       [0, 0, 1, 1, 1], 
       [0, 0, 0, 0, 0], 
       [0, 1, 1, 1, 1],
       [0, 0, 0, 0, 1]])
expected = 4

*/


