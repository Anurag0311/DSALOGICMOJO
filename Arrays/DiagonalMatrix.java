package com.anurag.Arrays;

public class DiagonalMatrix{ 
	
	public static int m,n; 
	
	private static void diagonalPrint(int matrix [][]) { 
		int diag=0;
		int diag1=0;
		for(int i=0;i<matrix.length;i++) {
			diag=i;
			for(int j=0;j<=i;j++) {
				System.out.println(matrix[diag][j]);
				diag--;
			}
		}
		diag=0;
		for(int i=matrix.length-1;i<=diag1;i--) {
			
			for(int j=diag;j<matrix[0].length;j++) {
				System.out.println(matrix[i][j]);
				
			}
			diag++;
			diag1++;
		}
		
		
	} 
	
	//CHATGPT answer
	public static void printDiagonalOrder(int[][] matrix) {
		 for (int i = 0; i < m + n - 1; i++) {
	            for (int j = Math.min(i, m - 1); j >= 0 && i - j < n; j--) {
	                System.out.print(matrix[j][i - j] + " ");
	            }
	            System.out.println();
		 }
    }
	
		public static void main(String[] args) 
		{ 
			int matrix[][] = {{1, 2, 3, 4,5}, 
							{6, 7, 8, 9, 10}, 
							{11, 12, 13, 14, 15}, 
							{16, 17, 18, 19, 20},}; 
				
			m=matrix.length; 
			n=matrix[0].length; 
				
			diagonalPrint(matrix); 
		} 
} 
/*
Expected Output 

        1 
        6 2 
        11 7 3 
        16 12 8 4 
        17 13 9 5 
        18 14 10 
        19 15 
        20  
*/


