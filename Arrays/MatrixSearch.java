package com.anurag.Arrays;

public class MatrixSearch { 

	private static void searchElement(int[][] matrix, int n, int value) 
	{ 
		int i=0,j=n-1;
		while(i<n && j>=0) {
			if(matrix[i][j]==value) {
				System.out.print(i+" "+j);
				return;
			}
			if(matrix[i][j] > value) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.print("Value Not Found");
		return;
	} 
	
	public static void main(String[] args) 
	{ 
		int matrix[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 36, 46 }, 
						{ 28, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } }; 

		searchElement(matrix, 4, 32); 
	} 
} 

/* Try more Inputs

case1:
 actual = searchElement([[10, 20, 30, 40], 
		[15, 25, 36, 46], 
		[27, 29, 37, 48],
		[32, 33, 39, 50]],4,32)
 expected = True
 
case2:
actual = searchElement([[10, 20, 30, 40],
		[15, 25, 36, 46], 
		[27, 29, 37, 48], 
		[32, 33, 39, 50]],4,59)
expected = False

*/
