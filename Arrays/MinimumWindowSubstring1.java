package com.anurag.Arrays;


public class MinimumWindowSubstring1  
{ 
    static final int no_of_chars = 256; 
      
    static String findMinWindow(String str, String pat) 
    { 
        int str_len = str.length(); 
        int ptr_len = pat.length(); 
      
        if (str_len < ptr_len) 
        { 
            System.out.println("window doesn't exists"); 
            return ""; 
        } 
      
        int ascii_ptr[] = new int[no_of_chars]; 
        int ascii_str[] = new int[no_of_chars]; 
      
        for (int i = 0; i < ptr_len; i++) 
            ascii_ptr[pat.charAt(i)]++; 
      
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE; 
      
        int count = 0;  
        for (int j = 0; j < str_len ; j++) 
        { 
            ascii_str[str.charAt(j)]++; 
      
            if (ascii_ptr[str.charAt(j)] != 0 && 
                ascii_str[str.charAt(j)] <= ascii_ptr[str.charAt(j)] ) 
                count++; 
      
            if (count == ptr_len) 
            { 
                while ( ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)] 
                    || ascii_ptr[str.charAt(start)] == 0) 
                { 
      
                    if (ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)]) 
                        ascii_str[str.charAt(start)]--; 
                    start++; 
                } 
      
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
      
        if (start_index == -1) 
        { 
        System.out.println("window doesn't exists"); 
        return ""; 
        } 
      
        return str.substring(start_index, start_index + min_len); 
    } 
      
    public static void main(String[] args) 
    { 
        String str = "ADOBECODEBANC"; 
        String pat = "ABC"; 
      
    System.out.print("Smallest window is :\n " + 
                        findMinWindow(str, pat)); 
    } 
} 

/* Try more Inputs
case 1: 
actual = findMinWindow("a","a")
expected = Smallest window is : a

case2: 
 actual = findMinWindow("zaaskzaa", "zsk")
 expected = Smallest window is : skz
 
case3: 
actual = findMinWindow("tutorial","oti")
expected = Smallest window is : tori


*/
