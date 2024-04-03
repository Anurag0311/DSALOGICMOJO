package com.anurag.BackTracking;

import java.util.Arrays;

class NqueensProblem
{
    // N x N chessboard
    public static final int N = 8;
 
    // Function to check if two queens threaten each other or not
    private static boolean isSafe(char board[][], int r, int c)
    {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
            if (board[i][c] == 'Q')
                return false;
 
        // return false if two queens share the same \ diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
 
        // return false if two queens share the same / diagonal
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 'Q')
                return false;
 
        return true;
    }
 
    private static void checkQueen(char board[][], int r)
    {
        // if N queens are placed successfully, print the solution
        if (r == N)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
 
            return;
        }
 
        // place Queen at every square in current row r
        // and recur for each valid movement
        for (int i = 0; i < N; i++)
        {
            // if no two queens threaten each other
            if (isSafe(board, r, i))
            {
                // place queen on current square
                board[r][i] = 'Q';
 
                // recur for next row
                checkQueen(board, r + 1);
 
                // backtrack and remove queen from current square
                board[r][i] = '-';
            }
        }
    }
 
    public static void main(String[] args)
    {
        // board[][] keeps track of position of Queens in
        // the current configuration
        char[][] mat = new char[N][N];
 
        // initialize board[][] by '-'
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '-');
        }
 
        checkQueen(mat, 0);
    }
}
