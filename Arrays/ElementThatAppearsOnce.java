package com.anurag.Arrays;


public class ElementThatAppearsOnce 
{ 
    static int findSingle(int array[], int array_size) 
    { 
        int res = array[0]; 
        for (int i = 1; i < array_size; i++) 
            res = res ^ array[i]; 
      
        return res; 
    } 
  
    public static void main (String[] args) 
    { 
        int array[] = {6,2,4,3,4,2,3}; 
        int n = array.length; 
        System.out.println("Element is " + 
                            findSingle(array, n) + " "); 
    } 
} 

/* Try more Inputs
case 1: 
actual = findSingle([-1,2,-1,3,2],5)
expected = 3

case2: 
 actual = findSingle([9,4,9,6,4],5)
 expected = 6
 
case3: 
actual = findSingle([1,1,2,2,3,3,4],7)
expected = 4
*/
