package com.anurag.Arrays;

public class RemoveDupFromSorted {
	/*Given a sorted array, remove the duplicates in place 
	 * such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, Time complexity O(n) and Space complexity O(1)
	 */
	
	public static int removeDuplicatesFromSortedArr(int array[]) {
		int index=1;
		int unique=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] != unique) {
				array[index] = array[i];
				unique=array[i];
				index++;
			}
			else {
				continue;
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		return index;
	}
	
	public static void main(String[] args) {
		int [] array= {2,3,4,5,6};
		System.out.print("loda"+removeDuplicatesFromSortedArr(array));
	}

}
