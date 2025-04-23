package StandardProblemDSA.X_GRAPH.V_TOPOLOGICAL_SORTING;

import java.util.*;

public class TopologicalUsingDFS {
  /*
  Intuition:

  Since we are inserting the nodes into the stack after the completion of the traversal, we are making sure, there will be no one who appears afterward but may come before in the ordering as everyone during the traversal would have been inserted into the stack.

  Note: Points to remember, that node will be marked as visited immediately after making the DFS call and before returning from the DFS call, the node will be pushed into the stack.
  */

  private static void dfs(
      int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
    vis[node] = 1;
    for (int it : adj.get(node)) {
      if (vis[it] == 0) dfs(it, vis, st, adj);
    }
    st.push(node);
  }

  // Function to return list containing vertices in Topological order.
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int vis[] = new int[V];
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        dfs(i, vis, st, adj);
      }
    }

    int ans[] = new int[V];
    int i = 0;
    while (!st.isEmpty()) {
      ans[i++] = st.pop();
    }
    return ans;
  }
}

class tUf {
  public static void main(String[] args) {
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(2).add(3);
    adj.get(3).add(1);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(5).add(0);
    adj.get(5).add(2);

    int[] ans = TopologicalUsingDFS.topoSort(V, adj);
    for (int node : ans) {
      System.out.print(node + " ");
    }
    System.out.println("");
  }
}
/*
Output: 5 4 2 3 1 0

Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.

Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive stack space, where N = no. of nodes.*/
