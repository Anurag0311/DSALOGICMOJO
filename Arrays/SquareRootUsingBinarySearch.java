package com.anurag.Arrays;


public class SquareRootUsingBinarySearch 
{ 
    public static int Sqrt(int Num) 
    {   //Base cases
        if (Num == 0 || Num == 1) 
            return Num; 
        //Do Binary Search for(sqrt(Num))
        int start = 1, end = Num, result=0; 
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
            //If Num is a perfect square 
            if (mid*mid == Num) 
                return mid; 
            //when mid*mid is smaller than x , move closer to sqrt(x)
            if (mid*mid < Num) 
            { 
                start = mid + 1; 
                result = mid; 
            } 
            else  //If mid*mid is greater than Num  
                end = mid-1; 
        } 
        return result; 
    } 
    public static void main(String args[])
    { 
        int Num = 11; 
        System.out.println(Sqrt(Num)); 
    } 
} 

/* Try more Inputs
case 1: 
actual = Sqrt(4)
expected = 2

case2: 
 actual = Sqrt(8)
 expected = 2
*/

