package Graph;

import java.util.ArrayList;

public class GraphUtil {
//    private static int numNodes;
//    private static int[][] matrix;
//
//    public GraphUtil(int numNodes) {
//        this.numNodes = numNodes;
//        matrix = new int[numNodes][numNodes];
//    }
//
//    public void addEdge(int i, int j) {
//        matrix[i][j] = 1;
//        matrix[j][i] = 1;
//    }
//
//    public boolean hasEdge(int i, int j) {
//        return matrix[i][j] == 1;
//    }
//
//    public int getNumNodes() {
//        return numNodes;
//    }
//    public static void printMatrix() {
//        for (int i = 0; i < numNodes; i++) {
//            for (int j = 0; j < numNodes; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        new GraphUtil(5);
//        printMatrix();
//
//
//    }


/*
    Find length of the largest region in Boolean Matrix
    Count number of trees in a forest
    A Peterson Graph Problem
    Clone an Undirected Graph
    Graph Coloring (Introduction and Applications)
    Traveling Salesman Problem (TSP) Implementation
    Vertex Cover Problem | Set 1 (Introduction and Approximate Algorithm)
    K Centers Problem | Set 1 (Greedy Approximate Algorithm)
    Erdos Renyl Model (for generating Random Graphs)
    Chinese Postman or Route Inspection | Set 1 (introduction)
    Hierholzer’s Algorithm for directed graph
    Check whether a given graph is Bipartite or not
    Snake and Ladder Problem
    Boggle (Find all possible words in a board of characters)
    Hopcroft Karp Algorithm for Maximum Matching-Introduction
    Minimum Time to rot all oranges
    Construct a graph from given degrees of all vertices
    Determine whether a universal sink exists in a directed graph
    Number of sink nodes in a graph
    Two Clique Problem (Check if Graph can be divided in two Cliques)

    */

//        public static void main(String[] args)
//        {
//            Scanner sc = new Scanner(System.in);
//
//            // n is the number of vertices
//            // m is the number of edges
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] adjMat = new int[n + 1][n + 1];
//            for (int i = 0; i < m; i++) {
//                int u = sc.nextInt();
//                int v = sc.nextInt();
//                adjMat[u][v] = 1;
//                adjMat[v][u] = 1;
//                // for a directed graph with an edge pointing
//                // from u to v,we just assign adjMat[u][v] as 1
//            }
//        }

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        // for a directed graph with an edge pointing from u to v,
        // adj.get(u).add(v);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void
    printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                    + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                        + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }

}


//class Edge implements Comparable<Edge> {
//    int u, v, weight;
//
//    public Edge(int u, int v, int weight) {
//        this.u = u;
//        this.v = v;
//        this.weight = weight;
//    }
//
//    public int compareTo(Edge other) {
//        return Integer.compare(this.weight, other.weight);
//    }
//}


//static class Pair {
//    int vertex;
//    int weight;
//
//    Pair(int v, int w) {
//        vertex = v;
//        weight = w;
//    }
//}

//    public static void addEdge(ArrayList<ArrayList<Prim.Pair>> adjList, int u, int v, int w) {
//        adjList.get(u).add(new Prim.Pair(v, w));
//        adjList.get(v).add(new Prim.Pair(u, w));
//    }
//ArrayList<ArrayList<Prim.Pair>> adjList = new ArrayList<>();

//    // Adding edges to the adjacency list
//    addEdge(adjList, 0, 1, 2);
//    addEdge(adjList, 0, 3, 6);
//    addEdge(adjList, 1, 2, 3);
//    addEdge(adjList, 1, 3, 8);
//    addEdge(adjList, 1, 4, 5);
//    addEdge(adjList, 2, 4, 7);
//    addEdge(adjList, 3, 4, 9);

//static class Pair implements Comparable<Pair> {
//    int vertex;
//    int weight;
//
//    Pair(int v, int w) {
//        vertex = v;
//        weight = w;
//    }
//    public int compareTo(Graph.Prim.Pair other) {
//        return Integer.compare(weight, other.weight);
//    }
//}


