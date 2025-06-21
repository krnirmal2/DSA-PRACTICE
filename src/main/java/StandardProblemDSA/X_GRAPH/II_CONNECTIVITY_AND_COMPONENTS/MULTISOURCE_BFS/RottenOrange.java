package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS.MULTISOURCE_BFS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
  /* 📝 Problem Statement: Rotting Oranges
      You are given an m x n grid where:
              0 represents an empty cell
  1 represents a fresh orange
  2 represents a rotten orange
      Every minute, any fresh orange adjacent (up, down, left, or right) to a rotten orange becomes rotten.
              🛑 Goal: Find the minimum time required to rot all fresh oranges.
      If all oranges become rotten, return the time taken.
      If some oranges cannot rot, return -1.
              🚀 Optimized Approach: BFS (Multi-Source)
      Identify Initial Rotten Oranges:
      Traverse the grid and store all rotten oranges (2) in a queue.
      Count the total number of fresh oranges (1).
      Perform BFS (Breadth-First Search):
      Process all rotten oranges level by level.
      For each rotten orange, infect all adjacent fresh oranges (up, down, left, right).
      Reduce the count of fresh oranges when they turn rotten.
      Check for Completion:
      If all fresh oranges rot, return the time taken.
      If any fresh orange remains, return -1.
  */

  public static int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int totalFresh = 0;

    // Step 1: Store initial rotten oranges in queue & count fresh oranges
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 2) {
          queue.offer(new int[] {r, c}); // Rotten orange added to queue
        } else if (grid[r][c] == 1) {
          totalFresh++; // Count fresh oranges
        }
      }
    }

    // Step 2: If there are no fresh oranges, return 0 (no need to wait)
    if (totalFresh == 0) {
      return 0;
    }

    // Step 3: Define directions for BFS (up, down, left, right)
    int[][] directions = GraphUtility.getFourDirection();
    int timeElapsed = 0;

    // Step 4: Process the queue using BFS
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean rotted = false;

      // for each rotten orange
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        int row = current[0];
        int col = current[1];

        // Check all 4 directions
        for (int[] dir : directions) {
          int newRow = row + dir[0];
          int newCol = col + dir[1];
          // check the boundary of x and y after geting all the direction if  it is invalide
          // return also if grid contain 0 and 2 then continue
          // Ensure within grid bounds & infect fresh oranges
          if (GraphUtility.checkFourBoundaryOfMatrixWithOne(grid, newRow, newCol)) {
            grid[newRow][newCol] = 2; // Mark as rotten
            queue.offer(new int[] {newRow, newCol}); // Add to queue
            totalFresh--; // Reduce fresh count
            rotted = true;
          }
        }
      }

      if (rotted) {
        timeElapsed++; // Increase time only if rotting happened
      }
    }

    // Step 5: If any fresh orange is left, return -1
    return totalFresh == 0 ? timeElapsed : -1;
  }

  // Main method to test the function
  public static void main(String[] args) {
    int[][] grid = {
      {2, 1, 1},
      {1, 1, 0},
      {0, 1, 1}
    };

    int result = orangesRotting(grid);
    System.out.println("Minimum time to rot all oranges: " + result);
  }
}
  /*⏱️ Time & Space Complexity
  Operation	Complexity
  Grid Traversal (Initial Setup)	O(m × n)
  BFS Processing (Worst Case)	O(m × n)
  Overall Time Complexity	O(m × n)
  Space Complexity (Queue Storage)	O(m × n)*/
