package com.anurag.Arrays;

import java.util.Arrays;

public class Sort012 {
	
	static void swap(int [] array,int index1,int index2) {
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public static void Sort012(int [] array,int n) {
		int low=0,mid =0;
		int high=array.length-1;
		while(mid <= high) {
			if(array[mid] == 0) {
				swap(array,low,mid);
				low++;
				mid++;
			}
			else if(array[mid]==2) {
				swap(array,mid,high);//here we did not decrease mid because the swaped value would be ignored if we increase mid
				high--;
			}
			else {
			mid++;
			}
		}
	}
	
	public static void main(String[] args) {
	    int[] array = { 2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

	    Sort012(array, array.length - 1);
	    System.out.println(Arrays.toString(array));
	  }

}
