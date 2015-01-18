package com.interviewexposed.arraynstring;

public class SetMatrixZeroes {
	/*public static void main(String[] args) {
		int[][] matrix = 
	}*/
	
	public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int SMALLINT = -999999;
        
        for (int i=0; i<ROWS; i++) {
        	for (int j=0; j<COLS; j++) {
        		if (matrix[i][j] == 0) {
        			// set the ith row
        			for (int col=0; col<COLS; col++) {
        				if (matrix[i][col] != 0) {
        					matrix[i][col] = SMALLINT;
        				}
        			}
        			// set the jth col
        			for (int row=0; row<ROWS; row++) {
        				if (matrix[row][j] != 0) {
        					matrix[row][j] = SMALLINT;
        				}
        			}
        		}
        	}
        }
        
        for (int i=0; i<ROWS; i++) {
        	for (int j=0; j<COLS; j++) {
        		if (matrix[i][j] == SMALLINT) {
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
}
