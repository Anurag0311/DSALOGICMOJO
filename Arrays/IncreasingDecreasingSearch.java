package com.anurag.Arrays;

public class IncreasingDecreasingSearch {

	static int findNumber(int array[],int start,int end,int value) {
		if (start > end) {
			return -1;
		}
		int mid=(start+end)/2;
		if(array[mid] == value) {
			return mid;
		}
		
		if(array[start] <= array[mid]) {
			if(value >= array[start] && array[mid] >= value) {
				return findNumber(array,start,mid-1,value);
			}
			return findNumber(array,mid+1,end,value);
		}
		if(array[mid] <= value && array[end] >= value) {
			return findNumber(array,mid+1,end,value);
		}
		return findNumber(array,start,mid-1,value);
	}
	
	public static void main(String args[]) 
    { 
        int array[] = { 3,4, 5, 6, 7, 8, 9, 1, 2}; 
        int n = array.length; 
        int value = 1; 
        int i = findNumber(array, 0, n - 1, value); 
        if (i != -1) 
            System.out.println("Index: " + i); 
        else
            System.out.println("Value not found"); 
    } 

}
