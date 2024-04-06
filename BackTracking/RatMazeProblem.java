package com.anurag.BackTracking;


public class RatMazeProblem { 
    static int N; 
    //function to print solution matrix
    void printPath(int path[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print( 
                    " " + path[i][j] + " "); 
            System.out.println(); 
        } 
    } 
     //function to check if x, y is valid index for N * N Maze
    boolean isValid(int matrix[][], int x, int y) 
    { 
        return (x >= 0 && x < N && y >= 0
                && y < N && matrix[x][y] == 0); 
    } 
  
    boolean findPath(int matrix[][]) 
    {   //Creating a N * N 2-D list
        int path[][] = new int[N][N]; 
        //It returns false if no path is possible, otherwise return true and prints the path in the form of 1s
        if (findPathInMaze(matrix, 0, 0, path) == false) { 
            System.out.print("pathution doesn't exist"); 
            return false; 
        } 
  
        printPath(path); 
        return true; 
    } 
    //function to solve Maze problem 
    boolean findPathInMaze(int matrix[][], int x, int y,int path[][]) 
    { 
        //if (x, y is goal) return True
        if (x == N - 1 && y == N - 1 && matrix[x][y] == 0) { 
            path[x][y] = 1; 
            return true; 
        } 
        //Check if maze[x][y] is valid
        if (isValid(matrix, x, y) == true) { 
            //mark x, y as part of solution path
            path[x][y] = 1; 
            //Move forward in x direction
            if (findPathInMaze(matrix, x + 1, y, path)) 
                return true; 
            //If moving in x direction doesn't give solution then Move down in y direction
            if (findPathInMaze(matrix, x, y + 1, path)) 
                return true; 
            //If none of the above movements work then perform backtracking to unmark x, y as part of solution path
            path[x][y] = 0; 
            return false; 
        } 
        return false; 
    } 
  
    public static void main(String args[]) 
    { 
    	RatMazeProblem rat = new RatMazeProblem(); 
        int matrix[][] = { { 0, 1, 0, 1, 1 }, 
                           { 0, 0, 0, 0, 0 }, 
                           { 1, 0, 0, 0, 1 }, 
                           { 0, 0, 1, 0, 0 },
                           { 1, 0, 0, 1, 0 }
        }; 
  
        N = matrix.length; 
        rat.findPath(matrix); 
    } 
} 
