package com.anurag.Arrays;



public class RainTrappingProblem { 
    static int array[] = new int[] {5,3,4,6,3,6}; 
  
    static int findWater(int n) 
    { 
        //Store the left max and right max of each point in the map
        int maxLeft[] = new int[n]; 
  
        int maxRight[] = new int[n]; 
       //keeps track of the total water as we traverse the elevation map
        int water = 0; 
        //default values
        maxLeft[0] = array[0]; 
        //filling the left max list
        for (int i = 1; i < n; i++) 
            maxLeft[i] = Math.max(maxLeft[i - 1], array[i]); 
  
        maxRight[n - 1] = array[n - 1]; 
        //filling the right max list 
        for (int i = n - 2; i >= 0; i--) 
            maxRight[i] = Math.max(maxRight[i + 1], array[i]); 
        //calculating the amount of water
        for (int i = 0; i < n; i++) 
            water += Math.min(maxLeft[i], maxRight[i]) - array[i]; 
  
        return water; 
    } 
  
    public static void main(String[] args) 
    { 
  
        System.out.println("Maximum water " + findWater(array.length)); 
    } 
} 

/* Try more Inputs
case 1: 
actual = findWater([2, 0, 2],3)
expected = 2

case2: 
 actual = findWater([3, 0, 2, 0, 4],5)
 expected = 7
 
case3: 
actual = findWater([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1],12)
expected = 6
*/


/* Try more Inputs
case 1: 
actual = findWater([2, 0, 2],3)
expected = 2

case2: 
 actual = findWater([3, 0, 2, 0, 4],5)
 expected = 7
 
case3: 
actual = findWater([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1],12)
expected = 6
*/

