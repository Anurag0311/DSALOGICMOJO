package com.anurag.HeapAndHashing;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
 
class RelativeSorting
{
    public static void customSort(int[] first, int[] second)
    {
        // map to store frequency of each element of first array
        Map<Integer, Integer> freq = new TreeMap<>();
 
        // freq frequency of each element of first array and
        // store it in a map.
        for (int i: first) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
 
        // Note that once we have the frequencies of all elements of
        // first array, we can overwrite elements of first array
 
        int index = 0;
 
        // do for every element of second array
        for (int i: second)
        {
            // If current element is present in the map, print it n times
            // where n is the frequency of that element in first array
            int n = freq.getOrDefault(i, 0);
            while (n-- > 0) {
                first[index++] = i;
            }
 
            // erase the element from map
            freq.remove(i);
        }
 
        // Now we are only left with elements that are only present
        // in the first array but not present in the second array
        // We need to sort the remaining elements present in the map
        // Since we use a TreeMap, keys are already sorted
 
        for (var entry: freq.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                first[index++] = entry.getKey();
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] first = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };
        int[] second = { 3, 5, 7, 2 };
 
        customSort(first, second);
        System.out.println("After sorting the array is : " + Arrays.toString(first));
    }
}

/* Try more Inputs
Case 1:
int[] first = { 2,3,1,3,2,4,6,7,9,2,19 };
int[] second = { 2,1,4,3,9,6 };
customSort(first, second);
expected = [2,2,2,1,4,3,3,9,6,7,19]

Case 1:
int[] first = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
int[] second = {2, 1, 8, 3};
customSort(first, second);
expected = [2,2,1,1,8,8,3,5,6,7,9]
*/



