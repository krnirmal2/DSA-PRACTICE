package Graph;

import java.util.*;
//In this implementation, Kruskal is the main class that performs Kruskal's algorithm. The class has an inner class Edge to represent edges in the graph. The DisjointSet class is used to keep track of the disjoint sets of vertices in the graph.
//
//        The addEdge method is used to add edges to the graph. The kruskal method performs Kruskal's algorithm and returns the minimum spanning tree as a list of edges.
//
//        The main method shows an example usage of the Kruskal class. It creates a graph with 4 vertices and 5 edges, and then runs Kruskal's algorithm on the graph. The
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

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class graph {
    int V, E;
    Edge[] edges;

    graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
        for (int i = 0; i < E; ++i)
            edges[i] = new Edge();
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        i = 0;
        while (e < V - 1) {
            Edge next_edge = edges[i++];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }


}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int V = 6;  // number of vertices
        int E = 9;  // number of edges

        graph graph = new graph(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 4;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 3;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 1;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 5;

        graph.edges[5].src = 2;
        graph.edges[5].dest = 4;
        graph.edges[5].weight = 6;

        graph.edges[6].src = 3;
        graph.edges[6].dest = 4;
        graph.edges[6].weight = 7;

        graph.edges[7].src = 3;
        graph.edges[7].dest = 5;
    }
}


//class Kruskal {
//    int V;
//    List<Edge> edges;
//
//    public Kruskal(int V) {
//        this.V = V;
//        edges = new ArrayList<>();
//    }
//
//    public void addEdge(int u, int v, int weight) {
//        edges.add(new Edge(u, v, weight));
//    }
//
//    public List<Edge> kruskal() {
//        List<Edge> mst = new ArrayList<>();
//        DisjointSet ds = new DisjointSet(V);
//
//        Collections.sort(edges);
//
//        for (Edge e : edges) {
//            int u = e.u, v = e.v, w = e.weight;
//
//            if (!ds.find(u, v)) {
//                ds.union(u, v);
//                mst.add(e);
//            }
//        }
//
//        return mst;
//    }
//
//    public static void main(String[] args) {
//        Kruskal kruskal = new Kruskal(4);
//        kruskal.addEdge(0, 1, 10);
//        kruskal.addEdge(0, 2, 6);
//        kruskal.addEdge(0, 3, 5);
//        kruskal.addEdge(1, 3, 15);
//        kruskal.addEdge(2, 3, 4);
//
//        List<Edge> mst = kruskal.kruskal();
//
//        for (Edge e : mst) {
//            System.out.println(e.u + " - " + e.v + " : " + e.weight);
//        }
//    }
//}
//
//class DisjointSet {
//    int[] parent, rank;
//
//    public DisjointSet(int n) {
//        parent = new int[n];
//        rank = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    public int find(int x) {
//        if (parent[x] != x) {
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//
//    public boolean find(int x, int y) {
//        return find(x) == find(y);
//    }
//
//    public void union(int x, int y) {
//        int px = find(x), py = find(y);
//
//        if (px == py) {
//            return;
//        }
//
//        if (rank[px] < rank[py]) {
//            parent[px] = py;
//        } else if (rank[py] < rank[px]) {
//            parent[py] = px;
//        } else {
//            parent[py] = px;
//            rank[px]++;
//        }
//    }
//}

