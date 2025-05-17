package StandardProblemDSA.X_GRAPH.ii_SHORTEST_PATH_ALGORTHIMS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import StandardProblemDSA.X_GRAPH.Tuple;
import java.util.*;

public class PathWithMinimumEffort {
  /*u are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

  A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

  Examples:

  Example 1:
  Input:
  heights = [[1,2,2],[3,8,2],[5,3,5]]
  Output:
  2
  Explanation:

  The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

  Example 2:

  Input:

  heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
  Output:
  0
  Explanation:
  The route of [1,1,1,1,1,1,1,1,1,1,1,1,1,1] has a maximum absolute difference of 0 in consecutive cells.This is better than the route of [1,1,1,1,1,1,2,1], where the maximum absolute difference is 1.
  Solution*/

  /*The Algorithm consists of the following steps :

  Start by creating a queue that stores the distance-node pairs in the form {dist,(row, col)} and a dist matrix with each cell initialized with a very large number ( to indicate that they’re unvisited initially) and the source cell marked as ‘0’.
  We push the source cell to the queue along with its distance which is also 0.
  Pop the element at the front of the queue and look out for its adjacent nodes (left, right, bottom, and top cell). Also, for each cell, check the validity of the cell if it lies within the limits of the matrix or not.
  If the current difference value of a cell from its parent is better than the previous difference indicated by the distance matrix, we update the difference in the matrix and push it into the queue along with cell coordinates.
  A cell with a lower difference value would be at the front of the queue as opposed to a node with a higher difference. The only difference between this problem and Dijkstra’s Standard problem is that there we used to update the value of the distance of a node from the source and here we update the absolute difference of a node from its parent.
  We repeat the above three steps until the queue becomes empty or until we encounter the destination node.
  Return the calculated difference and stop the algorithm from reaching the destination node. If the queue becomes empty and we don’t encounter the destination node, return ‘0’ indicating there’s no path from source to destination.
  Here’s a quick demonstration of the Algorithm’s 1st iteration ( all the further iterations would be done in a similar way ) :*/

  int MinimumEffort(int heights[][]) {

    // Create a priority queue containing pairs of cells
    // and their respective distance from the source cell in the
    // form {diff, {row of cell, col of cell}}.
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

    int n = heights.length;
    int m = heights[0].length;
    // Create a distance matrix with initially all the cells marked as
    int[][] dist = GraphUtility.initaliseMatrixWithLargeValue(n, m);

    dist[0][0] = 0;
    pq.add(new Tuple(0, 0, 0));

    // The following delta rows and delts columns array are created such that
    // each index represents each adjacent node that a cell may have
    // in a direction.
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, 1, 0, -1};

    // Iterate through the matrix by popping the elements out of the queue
    // and pushing whenever a shorter distance to a cell is found.
    while (pq.size() != 0) {
      Tuple it = pq.peek();
      pq.remove();
      int diff = it.distance;
      int row = it.row;
      int col = it.col;

      // Check if we have reached the destination cell,
      // return the current value of difference (which will be min).
      if (row == n - 1 && col == m - 1) return diff;
      // row - 1, col
      // row, col + 1
      // row - 1, col
      // row, col - 1
      for (int i = 0; i < 4; i++) {
        int newr = row + dr[i];
        int newc = col + dc[i];

        // Checking validity of the cell.
        if (GraphUtility.onlyFourSideCheck(newr, newc, n, m)) {

          // Effort can be calculated as the max value of differences
          // between the heights of the node and its adjacent nodes.
          int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);

          // If the calculated effort is less than the prev value
          // we update as we need the min effort.
          if (newEffort < dist[newr][newc]) {
            dist[newr][newc] = newEffort;
            pq.add(new Tuple(newEffort, newr, newc));
          }
        }
      }
    }
    // If the destination is unreachable.
    return 0;
  }

  public void main(String[] args) {
    int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    int ans = MinimumEffort(heights);
    System.out.print(ans);
    System.out.println();
  }
}
