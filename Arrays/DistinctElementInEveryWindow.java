package com.anurag.Arrays;

import java.util.HashMap;
//iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiincorrect
public class DistinctElementInEveryWindow 
{ 
    // Counts distinct elements in arraydow of size k 
    static void distinctElement(int array[], int k) 
    { 
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<k;i++) {
        	if(map.get(array[i])==null) {
        		map.put(array[i], 1);
        		count++;
        	}
        	else {
        		count=map.get(array[i]);
        		map.put(array[i], count+1);
        	}
        }
        System.out.println(count);
        for(int i=k;i<array.length;i++) {
        	if(map.get(array[i-k])==1) {
        		map.remove(array[i-k]);
        		count--;
        	}
        	else {
        		count=map.get(array[i-k]);
        		map.put(array[i-k], count-1);
        	}
	        if(map.get(array[i])==null) {
	        	map.put(array[i], 1);
	        	count++;
	        }
	        else {
	        	count=map.get(array[i]);
	        	map.put(array[i], count+1);
	        }
	        System.out.println(count);
        }
        return ;
    } 
      
    public static void main(String args[]) 
    { 
         int array[] = {1,2,1,3,4,2,3},  k = 4; 
            
         distinctElement(array, k); 
    } 
}
/* Try more Inputs
case1:
actual = distinctElement([1,2,1,3,4,2,3],4)
expected = 3,4,4,3

case2:
actual = distinctElement([4,1,1],2)
expected = 2,1

case3:
actual = distinctElement([1,2,1,3,4,3],3)
expected = 2,3,3,2

case4:
actual = distinctElement([1,1,2,2],1)
expected = 1,1,2,2

*/
