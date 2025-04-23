package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

import java.util.*;

public class IsBipartite {
  /*The algorithm steps are as follows:

  For DFS traversal, we need a start node and a visited array but in this case, instead of a visited array, we will take a colour array where all the nodes are initialised to -1 indicating they are not coloured yet.
  In the DFS function call, make sure to pass the value of the assigned colour, and assign the same in the colour array. We will try to colour with 0 and 1, but you can choose other colours as well. We will start with the colour 0, you can start with 1 as well, just make sure for the adjacent node, it should be opposite of what the current node has.
  In DFS traversal, we travel in-depth to all its uncoloured neighbours using the adjacency list. For every uncoloured node, initialise it with the opposite colour to that of the current node.
  If at any moment, we get an adjacent node from the adjacency list which is already coloured and has the same colour as the current node, we can say it is not possible to colour it, hence it cannot be bipartite. Thereby return a false indicating the given graph is not bipartite; otherwise, keep on returning true.*/
  private boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {

    color[node] = col;

    // traverse adjacent nodes
    for (int it : adj.get(node)) {
      // if uncoloured
      if (color[it] == -1) {
        if (dfs(it, 1 - col, color, adj) == false) return false;
      }
      // if previously coloured and have the same colour
      else if (color[it] == col) {
        return false;
      }
    }

    return true;
  }

  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int color[] = new int[V];
    for (int i = 0; i < V; i++) color[i] = -1;

    // for connected components
    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (dfs(i, 0, color, adj) == false) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // V = 4, E = 4
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(0).add(3);
    adj.get(3).add(0);
    adj.get(1).add(3);
    adj.get(3).add(1);
    adj.get(2).add(3);
    adj.get(3).add(2);

    IsBipartite obj = new IsBipartite();
    boolean ans = obj.isBipartite(4, adj);
    if (ans) System.out.println("1");
    else System.out.println("0");
  }
}
