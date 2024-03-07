package com.anurag.Arrays;

import java.util.Arrays;

public class SmallerAndGreater {

	public static int smallerAndGreater(int [] array) {
		int left[]=new int[array.length];
		left[0]=Integer.MIN_VALUE;
		for(int i=1;i<array.length;i++) {
			left[i]=Math.max(left[i-1], array[i-1]);
		}
		int right=Integer.MAX_VALUE;
		for(int i=array.length-1;i>=0;i--) {
			if(left[i]<array[i] && right>array[i]) {
				return i;
			}
			right=Math.min(right, array[i]);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int array[]= {6,2,5,4,7,9,11,8,10};
		System.out.print(smallerAndGreater(array));
	}

}
