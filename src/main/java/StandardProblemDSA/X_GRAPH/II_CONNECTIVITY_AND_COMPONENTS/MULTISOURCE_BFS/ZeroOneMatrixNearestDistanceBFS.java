package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS.MULTISOURCE_BFS;

import StandardProblemDSA.X_GRAPH.GraphUtility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Statement:
Given an m × n binary matrix mat, where each cell contains either 0 or 1, return a matrix of the same size where each cell (i, j)
 contains the shortest distance to the nearest 0.
The distance between two adjacent cells is always 1 (4-directionally: up, down, left, right).
Example Walkthrough
Example 1:
Input:
mat = [
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Explanation:
The 1 at (1,1) is one step away from the nearest 0.
All other 0s remain 0 because they are already 0.

Example 2:
Input:mat = [
  [0,0,0],
  [0,1,0],
  [1,1,1]
]
Output:[
  [0,0,0],
  [0,1,0],
  [1,2,1]
]
Explanation:
The 1 at (1,1) is one step away from the nearest 0.
The 1 at (2,0) is one step away from (1,0), which is 0, so its value becomes 1.
The 1 at (2,1) is two steps away from the nearest 0, so its value becomes 2.
The 1 at (2,2) is one step away from (1,2), which is 0, so its value becomes 1.

Approach to Solve the Problem
1. BFS (Breadth-First Search) Approach - Optimal Solution
Why BFS?
Since we need the shortest path from 1 to 0, BFS is the best choice because it explores all nodes at the current distance level before moving to the next level.
Steps:
Initialize a queue (Queue<int[]>) and add all 0 positions to it.
Set all 1 positions to a large value (infinity-like) to indicate they haven't been processed yet.
Process the queue:
Dequeue an element (x, y).
Check its four neighbors (up, down, left, right).
If a neighbor is a 1 (unprocessed), update its distance (current distance + 1) and add it to the queue.
Continue until all 1s are processed.
2. DP (Dynamic Programming) Approach - Another Alternative
Why DP?
We can update the matrix using two passes:
First pass: Traverse from top-left to bottom-right, updating distances.
Second pass: Traverse from bottom-right to top-left, refining distances.\


\🔍 Approach: Multi-Source BFS
1. Enqueue all cells with `0` and mark all `1`s as unprocessed (-1).
2. BFS level by level:
   - For each cell, update unprocessed neighbors with `current distance + 1`.
   - Add updated neighbors to the queue.
3. Continue until all cells are processed.

⏱️ Time Complexity:
- O(m × n): Each cell is visited once.

📦 Space Complexity:
- O(m × n): Queue holds at most all cells.

📘 Similar LeetCode Problem:
- 542. 01 Matrix

🔁 Pattern:
- Multi-Source BFS, shortest path in unweighted grid.

🔄 Follow-up:
- DP solution with two passes (top-left → bottom-right, then bottom-right → top-left).
*/
public class ZeroOneMatrixNearestDistanceBFS {
  public int[][] updateMatrix(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;
    Queue<int[]> queue = new LinkedList<>();

    // Step 1: Initialize distances and enqueue all '0' positions
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new int[] {i, j}); // Add 0's to queue
        } else {
          mat[i][j] = -1; // Mark unprocessed '1's with -1
        }
      }
    }

    // Step 2: Define directions for moving in 4 possible directions (Up, Down, Left, Right)
    int[][] directions = GraphUtility.getFourDirection();

    // Step 3: Process the queue using BFS
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0];
      int y = cell[1];

      for (int[] dir : directions) {
        int newX = x + dir[0];
        int newY = y + dir[1];

        // Step 4: Check boundaries and process only unvisited cells (-1)
        if (GraphUtility.checkFourBoundaryOfMatrix(mat, newX, newY, rows, cols)) {
          mat[newX][newY] = mat[x][y] + 1; // Update distance
          queue.offer(new int[] {newX, newY}); // Add new cell to queue
        }
      }
    }

    return mat;
  }

  // Main method to test the solution
  public static void main(String[] args) {
    ZeroOneMatrixNearestDistanceBFS sol = new ZeroOneMatrixNearestDistanceBFS();
    int[][] mat = {
      {0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    };

    int[][] result = sol.updateMatrix(mat);

    // Print the updated matrix
    for (int[] row : result) {
      System.out.println(Arrays.toString(row));
    }
  }
}
