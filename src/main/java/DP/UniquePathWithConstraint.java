package DP;

import java.util.ArrayList;
import java.util.List;

public class UniquePathWithConstraint {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(0, 0, 0, 0, 1, 0, 0, 0, 0));

        System.out.println();
    }

    // Online C++ compiler to run C++ program online
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

        // row and coloumn for ArrayList
        int row = A.size();
        int col = A.get(0).size();

//  we also send the dp
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }
        // we need to count the no of ways
        return noOfWay(A, row, col, dp);

    }

    int noOfWay(ArrayList<ArrayList<Integer>> A, int row, int col, int[][] dp) {
        // starting from start 0,0
        // before that we have to think about constraint
        if (dp[row][col] != -1) return dp[row][col];
        // base case
        if (A.get(row).get(col) == 1) return 0;
        if (row == 0 && col == 0) return 1; // when nothing send
        // if(row == 1 && col == 1) return 1;// only one cell

        // now check the outof bound condition
        if (row < 0 || col < 0) {
            return 0;
        }

        // now first row
        if (row == 0) return noOfWay(A, row, col - 1, dp);
        if (col == 0) return noOfWay(A, row - 1, col, dp);


// atlast return the  both the way if dp not present
        return dp[row][col] = noOfWay(A, row, col - 1, dp) + noOfWay(A, row - 1, col, dp);
    }
}
