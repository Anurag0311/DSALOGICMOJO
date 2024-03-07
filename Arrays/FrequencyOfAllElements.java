package com.anurag.Arrays;

public class FrequencyOfAllElements {
	 
    //Function to find counts of all elements present in arr[0..n-1]. The array  elements must be range from 1 to n
    public static void countfrequenciesEfficient(int input[]) {
 
        int n = input.length;
        // Subtract 1 from every element so that the elements become in range from 0 to n-1 
        for (int i = 0; i < n; i++) {
            input[i]--;
        }
        //Use every element arr[i] as index and add 'n' to element present at arr[i]%n to keep track of count of occurrences of arr[i] 
        for (int i = 0; i < n; i++) {
            input[input[i] % n] += n;
        }
        //To print counts, simply print the number of times n was added at index corresponding to every element 
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + input[i] / n);
            input[i] = input[i] % n + 1;
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}

/* Try more Inputs
case 1: 
actual = countfrequenciesEfficient([1, 2, 2, 1, 1, 2, 3, 2])
expected = [[1 3],[2 4],[3  1]]

case2: 
 actual = countfrequenciesEfficient([1, 2, 2])
 expected = [[1 1],[2 2]]
 
case3: 
actual = countfrequenciesEfficient([4, 4, 4, 4}])
expected = [[4 4]]
*/
