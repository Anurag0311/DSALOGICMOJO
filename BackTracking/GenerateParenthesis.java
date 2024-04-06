package com.anurag.BackTracking;

import java.io.*; 

class GenerateParenthesis  
{ 
    
    static void generateParenthesis(char str[], int pos, int n, int open, int close) 
    { 
       if (close == n) {
    	   for(int i = 0;i < str.length; i++) {
    		   System.out.print(str[i]);
    	   }
    	   System.out.println();
    	   return;
       }
       else {
    	   if(open > close) {
    		   str[pos] = '}';
    		   generateParenthesis(str, pos+1, n, open, close+1);
    	   }
    	   if(open < n) {
    		   str[pos] = '{';
    		   generateParenthesis(str, pos+1, n, open+1, close);
    	   }
       }
    } 
      
   
    static void printParenthesis(char str[], int n) 
    { 
        if(n > 0) 
        generateParenthesis(str, 0, n, 0, 0); 
        return; 
    } 
      
  
    public static void main (String[] args)  
    { 
        int n = 2; 
        char[] str = new char[2 * n]; 
        printParenthesis(str, n); 
    } 
} 

/*
  test_validParenthesis_1():
        n = 3;
        str = [""] * 2 * n;
        actual = printParenthesis(str,n)
        expected = ["((()))","(()())", "(())()", "()(())", "()()()"]
        self.assertEqual(actual, expected) 

     test_validParenthesis_2():
        n = 2;
        str = [""] * 2 * n;
        actual = printParenthesis(str,n)
        expected = ["(())","()()"]
        self.assertEqual(actual, expected) 
*/
