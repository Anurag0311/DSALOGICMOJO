package com.anurag.Arrays;


public class MaxOfjsubiwithAofiSmallerEqualAofj 
{ 
	int findDiff(int arr[], int n) 
	{ 
	    int maxDiff;
	    int i,j;
	    int right[] = new int[n];
	    int left[] = new int[n];
	    right[n-1] = n-1;
	    for(j = n-2; j >= 0 ; j--) {
	    	right[j] = arr[j] < arr[right[j+1]] ? right[j+1] : j;
	    }
	    left[0] = 0;
	    for(i = 1; i < n ; i++) {
	    	left[i] = arr[i] > arr[left[i-1]] ? right[i-1] : i;
	    }
	    i=0;
	    j=0;
	    maxDiff=1;
	    while(j < n && i< n) {
	    	if(arr[left[i]] < arr[right[j]]) {
	    		maxDiff = Math.max(maxDiff, right[j] - left[i]);
	    		j+=1;
	    	}
	    	else {
	    		i+=1;
	    	}
	    }
	    return maxDiff; 
	} 

	
	public static void main(String[] args) 
	{ 
		MaxOfjsubiwithAofiSmallerEqualAofj assign = new MaxOfjsubiwithAofiSmallerEqualAofj(); 
		int arr[] = {35, 9, 12, 3, 2, 70, 31, 33, 1}; 
		int n = arr.length; 
		int maxDiff = assign.findDiff(arr, n); 
		System.out.println(maxDiff); 
	} 
} 

/* Try more Inputs
case1:
actual = findDiff([35, 9, 12, 3, 2, 70, 31, 33, 1])
expected = 6

case2:
actual = findDiff([1, 2, 3, 4, 5, 6])
expected = 5

case3:
actual = findDiff([9, 2, 3, 4, 5, 6, 7, 8, 18, 0])
expected = 8

case4:
actual = findDiff([6, 5, 4, 3, 2, 1])
expected = -1

*/
