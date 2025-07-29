package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

import StandardProblemDSA.X_GRAPH.GraphUtility;

/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

🚀 Approach: DFS on Adjacency Matrix
1. Treat each city as a node in a graph.
2. For every unvisited city, start a DFS traversal to mark all connected cities.
3. Each DFS initiation corresponds to discovering a new province.
4. Return the number of DFS initiations.

🔁 Pattern:
- Connected Components in Graph using DFS.

⏱️ Time Complexity: O(n²)
- We may visit all `n²` entries in the adjacency matrix.

📦 Space Complexity: O(n)
- For the `visited[]` array and recursion stack.

⚠️ Edge Cases:
- Single city (1 province).
- All cities isolated (n provinces).
- Fully connected network (1 province).

✅ Related Problems:
- 547. Number of Provinces (LeetCode)
- 200. Number of Islands
- 323. Number of Connected Components in an Undirected Graph*/
public class NumberofProvinces {

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length; // 1.find the no. of vertex or city
    int numberOfComponents = 0; // 2. no. of components with intialise to zero
    boolean[] visit = new boolean[n]; // 3. visited boolean array

    for (int i = 0; i < n; i++) { // iterate over each vertex
      if (!visit[i]) { // if not visiterd then increament the count of no of component
        numberOfComponents++;
        GraphUtility.dfsWithMatrix(i, isConnected, visit); // call dfs of the each node
      }
    }

    return numberOfComponents;
  }
}
