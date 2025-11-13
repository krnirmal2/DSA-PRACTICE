package StandardProblemDSA.X_GRAPH.V_TOPOLOGICAL_SORTING;

import java.util.ArrayList;

public class Course_I {
  /*
    207. Course Schedule

    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
    prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
            For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0. So it is possible.
    Example 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

    Constraints:
            1 <= numCourses <= 2000
            0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
            0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.

    Approach:
  ---------
  - Build a **directed graph** using adjacency list.
  - Perform a **DFS-based cycle detection** using a `visited` and `pathVisited` (recursion stack) array.
  - If any cycle is detected, return `false`. Otherwise, return `true`.

  Pattern:
  --------
  - **Graph Traversal**
  - **Cycle Detection in Directed Graph using DFS**
  - **Topological Sort Validity Check**

  Time & Space Complexity:
  ------------------------
  - Time Complexity: O(V + E) where V = number of courses, E = number of prerequisites
  - Space Complexity: O(V + E) for adjacency list and visited arrays

  Related LeetCode Questions:
  ---------------------------
  - 210. Course Schedule II 🔁 (Return valid order using topological sort)
  - 133. Clone Graph (DFS on directed graph)
  - 261. Graph Valid Tree (Cycle detection)
  - 785. Is Graph Bipartite?
  - 329. Longest Increasing Path in a Matrix (Topological sort style traversal)

  Follow-ups:
  -----------
  1. Can this be solved using **Kahn's Algorithm** (BFS Topological Sort)?
  2. Can you detect the exact nodes involved in a cycle if one exists?
  3. What changes if prerequisites can form a **multi-graph** (multiple edges between nodes)?*/
  class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
      }
      for (int[] pre : prerequisites) {
        int v = pre[0];
        int u = pre[1];
        adj.get(u).add(v);
      }
      boolean[] vis = new boolean[numCourses];
      boolean[] pathVis = new boolean[numCourses];
      for (int i = 0; i < numCourses; i++) {
        if (!vis[i] && dfs(i, adj, pathVis, vis)) return false;
      }
      return true;
    }

    static boolean dfs(
        int node, ArrayList<ArrayList<Integer>> adj, boolean[] pathVis, boolean[] vis) {
      vis[node] = true;
      pathVis[node] = true;
      for (int nei : adj.get(node)) {
        if (pathVis[nei]) return true;
        if (!vis[nei] && dfs(nei, adj, pathVis, vis)) return true;
      }
      pathVis[node] = false;
      return false;
    }
  }
}
