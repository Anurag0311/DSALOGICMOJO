package com.anurag.Arrays;

  
public class KadaneAlgo 
{ 
    public static void main (String[] args) 
    { 
        int [] a = {-5, 6, -7, 1, 4, -8, 16};                 
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a)); 
    } 
  
    static int maxSubArraySum(int array[]) 
    { 
    	int currentSum=0;
    	int globalSum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
        	currentSum+=array[i];
        	if(currentSum<0) {
        		currentSum=0;
        	}
        	if(currentSum < array[i]) {
        		currentSum=array[i];
        	}
        	if(currentSum>globalSum) {
        		globalSum=currentSum;
        	}
        }
        return globalSum;
    } 
} 
/* Try more Inputs

case1:
actual = maxSubArraySum([-2,1,-3,4,-1,2,1,-5,4],9)
expected = 6

case2:
actual = maxSubArraySum([1],1)
expected = 1

case3:
actual = maxSubArraySum([-4, 2, -5, 1, 2, 3, 6, -5, 1],9)
expected = 12

case4:
actual = maxSubArraySum([-5, 6, -7, 1, 4, -8, 16],7)
expected = 16

*/
