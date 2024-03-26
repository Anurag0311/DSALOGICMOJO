package com.anurag.HeapAndHashing;


import java.util.*; 
public class FourSum { 
    static class Numbers 
    { 
        int first, second; 
        public Numbers(int first, int second) 
        { 
            this.first = first; 
            this.second = second; 
        } 
    } 
    static ArrayList<String> FourSumProblem(int array[], int n, int target, ArrayList<String> mlist) 
    { 
        HashMap<Integer,Numbers> map = new HashMap<Integer,Numbers>(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = i + 1; j < n; j++) 
                map.put(array[i] + array[j], new Numbers(i, j)); 
  
        for (int i = 0; i < n - 1; i++) { 
            for (int j = i + 1; j < n; j++) { 
                int sum = array[i] + array[j]; 
                
                if (map.containsKey(target - sum)) { 
                    
                    Numbers p = map.get(target - sum); 
                    if (p.first != i && p.first != j 
                        && p.second != i && p.second != j) { 
                        mlist.add(array[i] + ", " + array[j] + ", " + array[p.first] + ", " + array[p.second]); 
                        return mlist; 
                    } 
                } 
            } 
        }
        return null;
    } 
  
    
    public static void main(String[] args) 
    { 
        int array[] = { 1, 5, 1, 0, 6, 0 }; 
        int n = array.length; 
        int sum = 7; 
        ArrayList<String> mlist = new ArrayList<String>();
        System.out.println(FourSumProblem(array, n, sum,mlist)); 
    } 
} 

/* Try more Inputs
Case 1:
        int array[] = { 10, 2, 3, 4, 5, 9, 7, 8 }; 
        int n = array.length; 
        int sum = 7; 
        ArrayList<String> mlist = new ArrayList<String>();
        System.out.println(FourSumProblem(array, n, sum,mlist));
        expected = [3, 5, 7, 8]

Case2: 
        int array[] = { 1, 2, 3, 4, 5, 9, 7, 8 }; 
        int n = array.length; 
        int sum = 23; 
        ArrayList<String> mlist = new ArrayList<String>();
        System.out.println(FourSumProblem(array, n, sum,mlist));
        expected = [1, 5, 9, 8]
*/
