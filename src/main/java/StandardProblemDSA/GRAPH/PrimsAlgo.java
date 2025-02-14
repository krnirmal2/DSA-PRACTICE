package StandardProblemDSA.GRAPH;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    // Number of vertices in the graph
    private static final int V = 5;
    private static final char[] NODES = {'A', 'B', 'C', 'D', 'E'};

    public static void main(String[] args) {
        PrimsAlgo t = new PrimsAlgo();
        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        // Print the solution
        t.primMST(graph);
    }

    // A utility function to find the vertex with minimum
    // key value, from the set of vertices not yet included
    // in MST
    int minKey(int[] key, Boolean[] mstSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST
    // stored in parent[]
    void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(NODES[parent[i]] + " - " + NODES[i] + "\t" + graph[i][parent[i]]);
        }
    }

    // Function to construct and print MST for a graph
    // represented using adjacency matrix representation
    void primMST(int[][] graph) {
        // Array to store constructed MST
        int[] parent = new int[V];

        // Key values used to pick minimum weight edge in
        // cut
        int[] key = new int[V];

        // To represent set of vertices included in MST
        Boolean[] mstSet = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is
        // picked as first vertex
        key[0] = 0;

        // First node is always root of MST
        parent[0] = -1;

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {

            // Pick the minimum key vertex from the set of
            // vertices not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the
            // adjacent vertices of the picked vertex.
            // Consider only those vertices which are not
            // yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent
                // vertices of m mstSet[v] is false for
                // vertices not yet included in MST Update
                // the key only if graph[u][v] is smaller
                // than key[v]
                if (graph[u][v] != 0 && !mstSet[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }
}

/*

We transform the adjacency matrix into adjacency list using ArrayList<ArrayList<Integer>>. in Java, list of list in Python
and array of
Then we create a Pair class to store the vertex and its weight .
We sort the list on the basis of lowest weight.
We create priority queue and push the first vertex and its weight in the queue
Then we just traverse through its edges and store the least weight in a variable called ans.
At last after all the vertex we return the ans.*/

class Pair implements Comparable<Pair> {
    int v;
    int wt;

    Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }

    // Compare based on weight
    public int compareTo(Pair that) {
        return this.wt - that.wt;
    }
}

class PrimsAlgoOptimized {

    // Function to find the weight of the minimum spanning tree (MST)
    static int spanningTree(int V, int[][] graph) {
        // Adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Initialize adjacency list from the graph (adjacency matrix)
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) { // Only add non-zero edges
                    adj.get(i).add(new Pair(j, graph[i][j]));
                    adj.get(j).add(new Pair(i, graph[i][j])); // For undirected graph
                }
            }
        }

        // Priority queue to pick the edge with the smallest weight
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // Start with vertex 0 and weight 0

        int mstWeight = 0; // Total weight of MST
        boolean[] vis = new boolean[V]; // Visited array

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int u = node.v;
            int wt = node.wt;

            if (vis[u]) continue; // Skip if already visited

            mstWeight += wt; // Add weight to MST
            vis[u] = true; // Mark as visited

            // Add adjacent vertices to the priority queue
            for (Pair adjNode : adj.get(u)) {
                if (!vis[adjNode.v]) {
                    pq.add(adjNode); // Push to pq if not visited
                }
            }
        }

        return mstWeight; // Return the total weight of the MST
    }

    // Driver code
    public static void main(String[] args) {
        // Adjacency matrix representation of the graph
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        // Call the spanningTree function and print the result
        System.out.println(spanningTree(5, graph)); // Output should be the weight of the MST
    }
}