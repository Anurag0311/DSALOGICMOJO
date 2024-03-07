package com.anurag.Arrays;

public class SearchElement2DMatrix { 

	private static void searchElement(int[][] matrix, int n, int x) 
	{ 
		for(int i=n-1;i>=0;i--) {
			if(matrix[0][i]>x) {
				if(matrix[0][i]==x) {
					System.out.print(0+" "+i);
					return;
				}
				continue;
			}
			else {
				for(int j=1;j<n;j++) {
					if(matrix[j][i]==x) {
						System.out.print(j+" "+i+" ");
						return;
					}
					else if(matrix[j][i]>x) {
						break;
					}
					else {
						continue;
					}
				}
			}
		}
	} 
	
	public static void main(String[] args) 
	{ 
		int matrix[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 36, 46 }, 
						{ 28, 32, 37, 48 }, 
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
