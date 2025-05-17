package StandardProblemDSA.X_GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphWithLL {
    public final int V;
    public final LinkedList[] adj;

    public   GraphWithLL(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    // A utility function to add an edge in an
    // undirected graph
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        // for a directed graph with an edge pointing from u to v,
        // adj.get(u).add(v);
    }
}
