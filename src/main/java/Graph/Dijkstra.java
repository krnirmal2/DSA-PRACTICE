package Graph;

import java.util.*;

class Dijekstra {
    private final int V;
    private final List<List<iPair>> adj;

    Dijekstra(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int V = 9;
        Dijekstra g = new Dijekstra(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        // Priority queue to extract the minimum distance each time
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.vertex));
        // Array for distances of each node
        int[] dist = new int[V];
        // Fill every node with infinite value
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Insert source into priority queue with distance as 0
        pq.add(new iPair(0, src));
        // Set source distance to zero
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().weight; // Remove the vertex with minimum distance

            for (iPair v : adj.get(u)) { // Check the adjacent nodes of the current node
                if (dist[v.vertex] > dist[u] + v.weight) { // If the distance of node v is greater than distance of node u + distance of edge from u to v
                    dist[v.vertex] = dist[u] + v.weight; // Update the distance of node v
                    pq.add(new iPair(dist[v.vertex], v.vertex)); // Add the updated distance of node v to the priority queue
                }
            }
        }


        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int vertex, weight;

        iPair(int first, int second) {
            this.vertex = first;
            this.weight = second;
        }
    }
}

