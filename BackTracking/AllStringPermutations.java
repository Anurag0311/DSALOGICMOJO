package com.anurag.BackTracking;


public class AllStringPermutations 
{ 
    public static void main(String[] args) 
    { 
        String word = "ABC"; 
        int n = word.length(); 
        AllStringPermutations permutation = new AllStringPermutations(); 
        permutation.permutation(word, 0, n-1); 
    } 
  //1. word  = String 
  //  2. start = Starting index of the string 
  //3. end = Ending index of the string. 
    private void permutation(String word, int start, int end) 
    { 
        if (start == end) 
            System.out.println(word); 
        else
        { 
            for (int i = start; i <= end; i++) 
            { 
                //swap 
                word = swap(word,start,i); 
                permutation(word, start+1, end); 
                word = swap(word,start,i);  //backtrack
            } 
        } 
    } 
  
    public String swap(String str, int i, int j) 
    { 
        char temp; 
        char[] array = str.toCharArray(); 
        temp = array[i] ; 
        array[i] = array[j]; 
        array[j] = temp; 
        return String.valueOf(array); 
    } 
  
}
