package com.anurag.Arrays;


class FindCelebrity  
{ 
    static int matrix[][] = { { 0, 0, 1, 0 }, 
                               { 0, 0, 1, 0 },  
                              { 0, 0, 0, 0 }, 
                              { 0, 0, 1, 0 } }; 
  
    static boolean knows(int a, int b)  
    { 	boolean isPresent=false;
         for(int i=0;i<matrix.length;i++) {
        	 if(matrix[i][b]==0) {
        		 if(i==a) {
        			 continue;
        		 }
        		 isPresent=false;
        		 break;
        	 }
        	 else {
        		 isPresent=false;
        	 }
         }
         
         for(int i=0;i<matrix.length;i++) {
        	 if(matrix[a][i]==1) {
        		 isPresent=false;
        		 return isPresent;
        	 }
        	 else {
        		 isPresent=true;
        	 }
         }
         return isPresent;
    } 
     // Returns -1 if celebrity is not present. If present,returns id (value from 0 to n-1). 
    static int findCelebrity(int n)  
    { 
         int x=0;
         int y=n-1;
         while(x<y) {
        	 if(matrix[x][y]==1) {
        		 x++;
        	 }
        	 else {
        		 y--;
        	 }
         }
         if(!knows(x,y)) {
        	 return -1;
         }
         return x;
    } 
  
    public static void main(String[] args)  
    { 
        int n = 4; 
        int result = findCelebrity(n); 
        if (result == -1)  
        { 
            System.out.println("No Celebrity"); 
        }  
        else
            System.out.println("Celebrity is " + result); 
    } 
} 


/* Try more Inputs
case 1: 
static int matrix[][] = {{0 1 0}, 
                         {0 0 0}, 
                         {0 1 0}};
expected = 1

case2: 
static int matrix[][] = {{0 1},
                        {1 0}};
 expected = -1
 
Note: The two people at the party both
know each other. None of them is a celebrity
 
case 3: 
static int matrix[][] = { {0, 0, 1, 0},
                            {0, 0, 1, 0},
                         {0, 1, 0, 0},
                         {0, 0, 1, 0} };
expected = -1
*/
