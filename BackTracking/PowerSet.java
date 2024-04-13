package com.anurag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private ArrayList<ArrayList<Integer>> output;

    public PowerSet() {
        output = new ArrayList<>();
    }

    static void powerSet(String str, int index, String curr) {
        // Base case: if index reaches end of string
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }

        // Exclude current character and move to next character
        powerSet(str, index + 1, curr);

        // Include current character and move to next character
        powerSet(str, index + 1, curr + str.charAt(index));
    }

    public void backTrack(int first, ArrayList<Integer> curr, int[] array) {
        // Base case: if current subset size equals array size
        if (curr.size() == array.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < array.length; ++i) {
            curr.add(array[i]);
            backTrack(i + 1, curr, array);
            curr.remove(curr.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] array) {
        backTrack(0, new ArrayList<>(), array);
        return output;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "123";
        int index = 0; // Start index from 0
        String curr = "";
        powerSet(str, index, curr);

        // Example usage of subsets method
        PowerSet powerSetObj = new PowerSet();
        int[] array = {1, 2, 3};
        ArrayList<ArrayList<Integer>> subsets = powerSetObj.subsets(array);
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}