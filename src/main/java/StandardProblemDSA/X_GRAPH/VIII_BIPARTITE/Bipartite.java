package StandardProblemDSA.X_GRAPH.VIII_BIPARTITE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
  /*
  🧩 Problem Statement:
  ---------------------
  Given an undirected graph, determine whether it is **bipartite** or not.

  A graph is bipartite if we can split its set of vertices into two independent sets such that every edge connects a vertex from one set to the other.
  This is equivalent to being able to color the graph using **2 colors** such that no two adjacent vertices share the same color.

  This implementation assumes the graph is provided in an **adjacency list** format.

  📘 Example:
  ----------
  Input:
  0 -- 1
  |    |
  3 -- 2
  Output: True (It is bipartite)

  Input:
  0 -- 1
  |  /
  2
  Output: False (It is not bipartite)

  🎯 Approach (BFS-based Coloring):
  ---------------------------------
  - Use **Breadth-First Search (BFS)** traversal.
  - Maintain a `color[]` array to track coloring of nodes:
    - -1 = uncolored, 0 = Red, 1 = Blue
  - For every component (graph can be disconnected), start BFS from unvisited node:
    1. Color it `0` and enqueue it.
    2. While queue is not empty:
       - For each neighbor:
         - If it's uncolored, assign alternate color and enqueue.
         - If it's already colored with the same color as current node, return False.
  - If no conflict found, graph is bipartite.

  📌 Pattern:
  -----------
  - **BFS Traversal**
  - **Graph Coloring**
  - **Connected Components**
  - **Disjoint Graph Traversal**

  🕒 Time Complexity:
  -------------------
  - O(V + E)
    - Traverse each vertex and edge once during BFS.

  🧠 Space Complexity:
  --------------------
  - O(V) for `color[]` and `queue`

  🔗 Related LeetCode Problems:
  -----------------------------
  - 785. Is Graph Bipartite?
    https://leetcode.com/problems/is-graph-bipartite/
  - 886. Possible Bipartition
    https://leetcode.com/problems/possible-bipartition/

  💡 Follow-up Questions:
  -----------------------
  1. Can you implement the same check using **DFS** instead of BFS?
  2. What would change if the graph is **directed** instead of undirected?
  3. How do you handle **large sparse graphs** for bipartite checking efficiently?
  4. Can you return the **actual two partitions** if the graph is bipartite?

  */

  // pass the adjancy list and no. of vertices
  public static void isBipartite(ArrayList<ArrayList<Integer>> vertexes, int noOfvertex) {
    // create some datastructure for colouring and traversing of nodes
    // coloured with -1 means Blue
    int[] col = new int[noOfvertex];
    Arrays.fill(col, -1);

    // create a queue with vertex with its color
    Queue<Pairs> queue = new LinkedList<>();

    // initialise the first vertex with Red color ==0
    for (int i = 0; i < noOfvertex; i++) { // loop if the graph is not connected
      if (col[i] == -1) { // if the vertx is not colour
        // color the vertex with red
        int currentVertex = col[i];
        int currentVertexColor = 0;
        queue.add(new Pairs(currentVertex, currentVertexColor));

        // put the first color as red =0
        col[i] = 0;
        while (!queue.isEmpty()) { // queue is not empty till then we will continue
          Pairs p = queue.poll();
          int parentVertx = p.vertex;
          int parentColor = p.color;
          // now take the current node and iterate over its neighbour
          for (int j : vertexes.get(parentVertx)) {
            if (col[j] == parentColor) {}
            // if uncoloured then color them wtih blue
            col[j] = (parentColor == 1) ? 0 : 1;
            queue.add(new Pairs(j, col[j]));
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    // create the main function with graphancancy list of vertex
    int noOfvertex = 5;
    // loop them in a 2d array
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // create the blank graphancy list of each vertex
    for (int i = 0; i < noOfvertex; i++) {
      graph.add(new ArrayList<>());
    }

    // instantaite them
    graph.get(0).add(1);
    graph.get(0).add(2);

    graph.get(1).add(0);
    graph.get(1).add(2);

    graph.get(2).add(1);
    graph.get(2).add(3);

    graph.get(3).add(0);
    graph.get(3).add(2);
  }

  // create a pair of class
  static class Pairs {
    int vertex;
    int color;

    public Pairs(int vertex, int color) {
      this.vertex = vertex;
      this.color = color;
    }
  }
}
