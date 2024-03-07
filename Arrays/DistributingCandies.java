package com.anurag.Arrays;

import java.util.Arrays;
/*
There are N children standing in a line with some rating value. You want to distribute a minimum number of candies to these children such that:

Each child must have at least one candy.
The children with higher ratings will have more candies than their neighbors.
You need to write a program to calculate the minimum candies you must give.
*/
public class DistributingCandies
{
    public static int candyLogicMojo(int[] ratings) 
    {   
    	int sum=0;
    	int [] left = new int[ratings.length];
    	int [] right = new int[ratings.length];
    	Arrays.fill(left, 1);
    	Arrays.fill(right, 1);
    	for(int i=1;i<ratings.length;i++) {
    		if(ratings[i-1]<ratings[i]) {
    			left[i]=left[i-1]+1;
    		}
    	}
    	for(int i=ratings.length-2;i>=0;i--) {
    		if(ratings[i]>ratings[i+1]) {
    			right[i]=right[i+1]+1;
    		}
    	}
    	for(int i=0;i<ratings.length;i++) {
    		sum+=Math.max(left[i], right[i]);
    	}
    	
    	
    	return sum;
    }
	public static void main(String[] args) {
	  int ratings[] = {1,5,2,1};
	  int result = candyLogicMojo(ratings);
	  System.out.println(result);
	}
}