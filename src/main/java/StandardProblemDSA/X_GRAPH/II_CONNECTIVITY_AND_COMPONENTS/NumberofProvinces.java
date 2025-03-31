package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

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
isConnected[i][j] == isConnected[j][i]*/
public class NumberofProvinces {
  public void dfs(int node, int[][] isConnected, boolean[] visit) {
    visit[node] = true; // /  mark the node as visited
    for (int i = 0; i < isConnected.length; i++) { // iterate over the each neighbor of the node
      if (isConnected[node][i] == 1
          && !visit[
              i]) { // only the column value is change as its neightbou will be in the same node
        // with same row value that it
        dfs(i, isConnected, visit);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length; // 1.find the no. of vertex or city
    int numberOfComponents = 0; // 2. no. of components with intialise to zero
    boolean[] visit = new boolean[n]; // 3. visited boolean array

    for (int i = 0; i < n; i++) { // iterate over each vertex
      if (!visit[i]) { // if not visiterd then increament the count of no of component
        numberOfComponents++;
        dfs(i, isConnected, visit); // call dfs of the each node
      }
    }

    return numberOfComponents;
  }
}
