package com.anurag.Arrays;


import java.io.*; 
import java.util.*; 
  
class SubArray  
{ 
    int first, second; 
    SubArray(int a, int b)  
    { 
        first = a; 
        second = b; 
    } 
} 
  
public class SubArrSumZero 
{ 
    static ArrayList<SubArray> findSubArrays(int[] array, int n) 
    { 
           HashMap<Integer,Integer> hm=new HashMap<>();
           ArrayList<SubArray> containsZeroSumIndex=new ArrayList<>();
           int sum=0;
           for(int i=0;i<array.length;i++) {
        	   sum+=array[i];
        	   if(sum==0) {
        		   containsZeroSumIndex.add(new SubArray(0,i));
        	   }
        	   if(hm.containsKey(sum)) {
        		SubArray zeroSum=new SubArray(hm.get(sum)+1,i);
        		containsZeroSumIndex.add(zeroSum);
        	   }
        	   else {
        		   hm.put(sum, i);
        	   }   
           }
           
            return containsZeroSumIndex; 
    }  
  
  
    public static void main(String args[]) 
    { 
            int[] array = {0,2,0,1,6}; 
            int n = array.length; 
              
            ArrayList<SubArray> out = findSubArrays(array, n); 
            for(SubArray element : out) {
            	System.out.println(element.first+" "+element.second);
            }
    } 
}  

/* Try more Inputs
case1:
actual = findSubArrays([4, 2, -3, 1, 6],5)
expected = True

case2:
actual = findSubArrays([4,2,0,1,6],5)
expected = True

actual = findSubArrays([-3,2,3,1,6],5)
expected = False

actual = findSubArrays([1,2],2)
 expected = False

*/