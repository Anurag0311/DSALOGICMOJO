package com.anurag.Arrays;


import java.io.*; 
  
public class MatrixRotate90  
{ 
      
static int N = 4; 
// In-place rotate it by 90 degrees in clockwise direction 
static void matrixRotation(int matrix[][]) 
{ 
  
    for(int i=0;i<N/2;i++) {
    	for(int j=i;j<N-1-i;j++) {
    		int temp=matrix[j][N-1-i];
    		matrix[j][N-1-i]=matrix[i][j];
    		matrix[i][j]=matrix[N-1-j][i];
    		matrix[N-1-j][i]=matrix[N-1-i][N-1-j];
    		matrix[N-1-i][N-1-j]=temp;
    	}
    }
} 
  
static void printMatrix(int matrix[][]) 
{ 
    for (int i = 0; i < N; i++) 
    { 
        for (int j = 0; j < N; j++) 
        System.out.print( matrix[i][j] + " "); 
        System.out.println(); 
    } 
} 
  
  
    public static void main (String[] args)  
    { 
            int matrix[][] = { { 1, 2, 3, 4 }, 
                      { 5, 6, 7, 8 }, 
                      { 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16 } }; 
    matrixRotation(matrix); 
    printMatrix(matrix); 
    } 
} 


/* Try more Inputs
case 1: 
int matrix[][] = { { 1, 2, 3}, 
                   { 4, 5, 6}, 
                   { 7, 8, 9}}; 

actual = matrixRotation(matrix)
expected = 7  4  1 
           8  5  2 
           9  6  3
*/