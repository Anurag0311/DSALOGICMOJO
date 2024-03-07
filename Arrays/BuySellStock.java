package com.anurag.Arrays;


import java.util.ArrayList; 
    
public class BuySellStock { 
  static class Result { 
    int buy, sell; 
}
    void findProfit(int array[], int n) 
    { 
        ArrayList<Result> result=new ArrayList<Result>();
        for(int i=0;i<array.length;i++) {
        	Result temp=new Result();
        	while((i<n-1) && (array[i+1]<=array[i])) {
        		i++;
        	}
        	if(i<n-1) {
        		break;
        	}
        	temp.buy=i++;
        	while((i<n) && (array[i+1] >= array[i])) {
        		i++;
        	}
        	temp.sell=i;
        	result.add(temp);
        }
         
    } 
  
    public static void main(String args[]) 
    { 
        BuySellStock stock = new BuySellStock(); 
  
        int array[] = { 98, 178, 250, 300, 40, 540, 690 }; 
        int n = array.length; 
  
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
