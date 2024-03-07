package com.anurag.Arrays;


public class MajorityElement
{
    // Function to return majority element present in given array
    public static int majorityElement(int[] array)
    {
        int majority=array[0];
        int count=1;
        for(int i=1;i<array.length;i++) {
        	if(majority==array[i]) {
        		count++;
        	}
        	else {
        		count--;
        		if(count==0) {
        			majority=array[i];
        			count=1;
        		}
        	}
        }
    	return majority;
    }
 
        public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] array = { 3, 8, 3, 4, 3, 2, 2, 2, 2, 2, 2 };
 
        System.out.println("Majority element is " + majorityElement(array));
    }
}
