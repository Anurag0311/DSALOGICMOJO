package com.anurag.Arrays;


public class NextSmallestPalindrome  
{ 
    static void utilityFunction(int array[], int n)  
    { 
        
    } 
     //The function that prints next palindrome of a given number array[] with n digits.
    static void nextPalindromeProblem(int array[], int n)  
    { 
    	
        if(array.length%2==0) {
        	if(array[(array.length-1)/2]>array[array.length/2]) {
        		int left=(array.length-1)/2;
        		int right=array.length/2;
        		while(left!=-1) {
        			array[right]=array[left];
        			right++;
        			left--;
        		}
        	}
        	else {
        		int left=(array.length-1)/2;
        		int right=array.length/2;
        		while(left!=-1) {
        			array[left]=array[right];
        			right++;
        			left--;
        		}
        	}
        }
        else {
      
        		int left=((array.length-1)/2)-1;
        		int right=((array.length-1)/2)+1;
        		if(array[array.length/2] == 9) {
        			array[(array.length/2)-1]++;
        			array[array.length/2]=0;
        			array[(array.length/2)+1]++;
        		}
        		else {
        			array[array.length/2]++;
        		}
        		while(left!=-1) {
        			System.out.println(left);
        			array[right]=array[left];
        			right++;
        			left--;
        		}
        	 }
     
        
    } 
    
    
    static void utilityFunctionLogicMojo(int array[], int n)  
    { 
        // find the index of mid digit 
        int mid = n / 2;
        //end of left side is always 'mid -1' 
        int i = mid - 1;
        //Beginning of right side depends if n is odd or even  
        int j = (n % 2 == 0) ? mid : mid + 1; 
       //  A bool variable to check if copy of left side to right is sufficient or not
        boolean leftsmaller = false; 
  
        while (i >= 0 && array[i] == array[j])  
        { 
            i--; 
            j++; 
        } 
         //Find if the middle array(s) need to be incremented or not (or copying left side is not sufficient) 
        if (i < 0 || array[i] < array[j])  
        { 
            leftsmaller = true; 
        } 
        //Copy the mirror of left to right  
        while (i >= 0)  
        { 
            array[j++] = array[i--]; 
        } 
        //Handle the case where middle digit(s) must be incremented.   
        if (leftsmaller)  
        { 
            int carry = 1; 
            //If there are odd digits, then increment the middle digit and store the carry
            if (n % 2 == 1) { 
                array[mid] += 1; 
                carry = array[mid] / 10; 
                array[mid] %= 10; 
            } 
            i = mid - 1; 
            j = (n % 2 == 0 ? mid : mid + 1); 
            //Add 1 to the rightmost digit of the left side, propagate the carry towards MSB digit and simultaneously copying mirror of the left side to the right side 
            while (i >= 0 && carry>0)   
            { 
                array[i] = array[i] + carry; 
                carry = array[i] / 10; 
                array[i] %= 10; 
                array[j] = array[i];
                i--; 
                j++; 
            } 
  
        } 
    } 
     //The function that prints next palindrome of a given number array[] with n digits.
    static void nextPalindromeProblemLogicMojo(int array[], int n)  
    { 
        System.out.println("Next Palindrome is:"); 
          
        if (isAll9(array, n)) { 
            System.out.print("1"); 
            for (int i = 0; i < n - 1; i++) 
                System.out.print("0"); 
            System.out.println("1"); 
  
        } 
      
        else { 
            utilityFunction(array, n); 
            printarray(array); 
        } 
    } 
  //function to check if num has all 9s 
    static boolean isAll9(int array[], int n) { 
        for (int i = 0; i < n; i++) 
            if (array[i] != 9) 
                return false; 
        return true; 
    } 
  
  
  
    static void printarray(int array[]) { 
        for (int i = 0; i < array.length; i++) 
            System.out.print(array[i]); 
        System.out.println(); 
    } 
  
    public static void main(String[] args)  
    { 
        int array[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}; //83177977138
        nextPalindromeProblem(array, array.length); 
        printarray(array);
    } 
} 


/* Try more Inputs
case 1: 
actual = nextPalindromeProblem([9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2],11)
expected = 94188088149

case2: 
 actual = nextPalindromeProblem([1,2,1],3)
 expected = 131
 
case3: 
actual = nextPalindromeProblem([2,3,5,4,5],5)
expected = 23632
*/
