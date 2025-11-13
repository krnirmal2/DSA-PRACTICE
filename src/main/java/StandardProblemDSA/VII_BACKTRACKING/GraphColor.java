package StandardProblemDSA.VII_BACKTRACKING;

public class GraphColor {
  static final int V = 4;

  /*
  Problem:
  Color a graph using at most m colors such that no two adjacent vertices share the same color.
  If coloring is possible, print one such coloring.

  Approach:
  - Use backtracking:
    - Assign a color to vertex v (from 1 to m) if it’s safe (no adjacent vertex has same color).
    - Recurse for v + 1.
    - Backtrack if no color leads to a solution.
  - If all vertices are assigned, print the solution.

  Pattern:
  - Backtracking / Graph Coloring Problem.

  Time Complexity:
  O(m^V):
  - Each vertex can be assigned m colors.
  - Backtracking prunes invalid assignments early.

  Space Complexity:
  O(V) for color[] array + recursion stack.

  Similar LeetCode:
  - 785. Is Graph Bipartite? (special case of 2-coloring)
  - 886. Possible Bipartition

  Follow-up:
  - Use greedy coloring for faster approximate solutions.
  - Modify to print all possible colorings instead of just one.
  */

  // A utility function to check if the current color assignment is safe for vertex v
  static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
    for (int i = 0; i < V; i++) if (graph[v][i] && c == color[i]) return false;
    return true;
  }

  // A recursive utility function to solve m coloring problem
  static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
    if (v == V) return true;

    for (int c = 1; c <= m; c++) {
      if (isSafe(v, graph, color, c)) {
        color[v] = c;
        if (graphColoringUtil(graph, m, color, v + 1)) return true;
        color[v] = 0;
      }
    }
    return false;
  }

  // This function solves the m Coloring problem using Backtracking.
  // It returns false if the m colors cannot be assigned, otherwise, return true
  // and prints assignments of colors to all vertices.
  static boolean graphColoring(boolean[][] graph, int m) {
    int[] color = new int[V];
    for (int i = 0; i < V; i++) color[i] = 0;

    if (!graphColoringUtil(graph, m, color, 0)) {
      System.out.println("Solution does not exist");
      return false;
    }

    // Print the solution
    printSolution(color);
    return true;
  }

  // A utility function to print the solution
  static void printSolution(int[] color) {
    System.out.print("Solution Exists: Following are the assigned colors\n");
    for (int i = 0; i < V; i++) System.out.print(" " + color[i] + " ");
    System.out.println();
  }

  // Driver code
  public static void main(String[] args) {
    // Create following graph and test whether it is 3 colorable
    // (3)---(2)
    // |   / |
    // |  /  |
    // | /   |
    // (0)---(1)

    boolean[][] graph = {
      {false, true, true, true},
      {true, false, true, false},
      {true, true, false, true},
      {true, false, true, false}
    };

    // Number of colors
    int m = 3;

    // Function call
    graphColoring(graph, m);
  }

  /*🔁 Time Complexity
  ❗ Worst-case Time Complexity:
  scss
  Copy
  Edit
  O(M^V)
  📖 Why?
  You try to assign one of the M colors to each of the V vertices.

  So, every vertex has M choices → total combinations:
  M × M × M × ... (V times) = M^V
  At each step, we check if the current color is valid (i.e., not equal to any adjacent vertex color), which takes O(V) time in an adjacency matrix.

  So overall:
  Time Complexity = O(M^V * V)
  But since M^V is exponential, we often simplify the complexity to:

  🔺 Final Time: O(M^V)
  🧠 Space Complexity
  1. Color array
  We use an array color[V] to store the color assigned to each vertex.
  Space = O(V)
  2. Adjacency matrix or list
  If adjacency matrix → space = O(V^2)
  If adjacency list → space = O(V + E)
  3. Recursive stack
  Depth of recursion = at most V (one level per vertex)
  So recursion space = O(V)*/
}
