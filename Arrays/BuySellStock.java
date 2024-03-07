package com.anurag.Arrays;

import java.util.ArrayList;

//Class representing a solution for buying and selling stocks to maximize profit
public class BuySellStock {

 // Inner class to store the buy and sell indices as a result
 static class Result {
     int buy, sell;
 }

 // Method to find and print the buying and selling points to maximize profit
 void findProfit(int array[], int n) {
     // ArrayList to store the results (buying and selling points)
     ArrayList<Result> result = new ArrayList<Result>();

     // Loop through the array to find buying and selling points
     for (int i = 0; i < array.length; i++) {
         Result temp = new Result();

         // Find the local minimum as the buying point
         while ((i < n - 1) && (array[i + 1] <= array[i])) {
             i++;
         }

         // Break if we reach the end of the array
         if (i == n - 1) {
             break;
         }

         temp.buy = i++;

         // Find the local maximum as the selling point
         while ((i < n - 1) && (array[i + 1] >= array[i])) {
             i++;
         }

         // Set the selling point and add the result to the list
         temp.sell = i;
         result.add(temp);
     }
     
     // Further processing can be done with the 'result' ArrayList if needed
 }

 // Main method to demonstrate the usage of the BuySellStock class
 public static void main(String args[]) {
     BuySellStock stock = new BuySellStock();

     // Example input array representing stock prices on different days
     int array[] = { 98, 178, 250, 300, 40, 540, 690 };
     int n = array.length;

     // Call the findProfit method to calculate and print buying and selling points
     stock.findProfit(array, n);
 }
}


/* Try more Inputs
case 1: 
actual = findProfit([7,1,5,3,6,4],6)
expected = 2

Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3

case2: 
 actual = findProfit([1,2,3,4,5],5)
 expected = 4
 Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4
 
case3: 
actual = findProfit([7,6,4,3,1],5)
expected = 0
In this case, no transaction is done, i.e., max profit = 0
*/
