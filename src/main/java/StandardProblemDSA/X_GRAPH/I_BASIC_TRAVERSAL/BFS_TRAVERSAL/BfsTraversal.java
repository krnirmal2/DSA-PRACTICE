package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.BFS_TRAVERSAL;

import static StandardProblemDSA.X_GRAPH.GraphUtility.BFS;

import StandardProblemDSA.X_GRAPH.GraphWithLL;

class Graphs {
  public static void main(String[] args) {
    GraphWithLL g = new GraphWithLL(4);

    // Step 4. add edges between source node and destination node with weight
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

    // start the Bfs at node 2
    BFS(2);
  }
}
