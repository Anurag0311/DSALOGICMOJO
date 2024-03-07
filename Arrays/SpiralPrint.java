package com.anurag.Arrays;


public class SpiralPrint { 
    static void spiralPrint(int m, int n, int matrix[][]) 
    { 
       int ulc=0;//upperLeftColumn
       int ulr=0;//upperLeftRow
       int urc=matrix[0].length-1;//upperRightColumn
       int blr=matrix.length-1;//bottomLeftRow
       while(ulc<urc && ulr<blr) {
    	   for(int i=ulc;i<urc;i++) {
    		   System.out.println(matrix[ulc][i]);
    	   }
    	   for(int i=ulr;i<blr;i++) {
    		   System.out.println(matrix[i][urc]);
    	   }
    	   for(int i=urc;i>ulc;i--) {
    		   System.out.println(matrix[blr][i]);
    	   }
    	   for(int i=blr;i>ulr;i--) {
    		   System.out.println(matrix[i][ulc]);
    	   }
    	   urc--;
    	   blr--;
    	   ulr++;
    	   ulc++;
       }
    }
    
  
    public static void main(String[] args) 
    { 
        int R = 4; 
        int C = 4; 
        int matrix[][] = { { 1, 2, 3, 4},
                      {5,6,7,8},
                      { 9, 10, 11, 12}, 
                      { 13, 14, 15, 16 } }; 
        spiralPrint(R, C, matrix); 
    } 
} 

/* Try more Inputs
case 1: 
actual = spiralPrint(3,3,[[1,2,3],[4,5,6],[7,8,9]])
expected = [[1,2,3,6,9,8,7,4,5]]

case2: 
 actual = spiralPrint(3,4,[[1,2,3,4],[5,6,7,8],[9,10,11,12]])
 expected = [1,2,3,4,8,12,11,10,9,5,6,7]
 
*/
