package com.anurag.Arrays;

import java.util.Arrays;

public class NextGreaterUsingSameSet {
/*
 * Write an algorithm to find out next greater number to given number with the same set of digits 
 * ex)218765--->251678
 * 12345---->12354
 */
	//218765
	//258761
	//251876
	//251687
	//251678
	public static int[] arrangment(int[] array) {
		int index=0;
		for(int i=array.length-2;i>=0;i--) {
//			System.out.println("hello"+i);
			if(!(array[array.length-1]<array[i])) {
				System.out.println("hello"+i);
				int temp=array[array.length-1];
				array[array.length-1]=array[i];
				array[i]=temp;
				index=i;
				break;
			}
			else {
				if(i==0) {
					return array;
				}
			}
//			System.out.println(index);
//			for(int l=0;l<array.length;l++) {
//				System.out.print(array[l]);
//			}
//			int [] dumArray=new int[array.length-index];
//			int copy=index;
//			for(int j=0;j<array.length;j++) {
//				dumArray[j]=array[copy];
//				copy++;
//			}
//			System.out.println(index);
			Arrays.sort(array,index,array.length);
//			copy=index;
//			for(int k=0;k<array.length;k++) {
//				array[copy]=dumArray[k];
//				copy++;
//			}
		}
		System.out.println(index);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		return array; 
	}
	
	public static int[] arrangmentLogicMojo(int[] array) {
		int i=0;
		for(i=array.length-1;i<0;i--) {
			if(array[i]>array[i-1]) {
				break;
			}
		}
		int element=array[i-1];
		int min=i;
		for(int j=i+1;j<array.length-1;j++) {
			if(array[j]>element && array[j]<array[min]) {
				min=j;
			}
		}
		swap(array,i-1,min);
		Arrays.sort(array,i,array.length);
		
		for(int k=0;k<array.length;k++) {
			System.out.println(array[k]);
		}
		
		return array;
	}
	
	public static void swap(int[] array,int index1,int index2) {
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public static void main(String[] args) {
		int array[]= {2,1,8,7,6,5};
		arrangmentLogicMojo(array);

	}

}
