package StandardProblemDSA.X_GRAPH.V_TOPOLOGICAL_SORTING;

import java.util.*;

public class KahnsAlgorithmUsingBFSandIndegree {
  /*
  Approach:

  Previously, we solved this question using the DFS traversal technique. But in this article,  we will apply the BFS(Breadth First Search) traversal technique. Breadth First Search or BFS is a traversal technique where we visit the nodes level-wise, i.e., it visits the same level nodes simultaneously, and then moves to the next level.

  Initial Configuration:

  Indegree Array: Initially all elements are set to 0. Then, We will count the incoming edges for a node and store it in this array. For example, if indegree of node 3 is 2, indegree[3] = 2.

  Queue: As we will use BFS, a queue is required. Initially, the node with indegree 0 will be pushed into the queue.

  Answer array: Initially empty and is used to store the linear ordering.

  The algorithm steps are as follows:

  First, we will calculate the indegree of each node and store it in the indegree array. We can iterate through the given adj list, and simply for every node u->v, we can increase the indegree of v by 1 in the indegree array.
  Initially, there will be always at least a single node whose indegree is 0. So, we will push the node(s) with indegree 0 into the queue.
          Then, we will pop a node from the queue including the node in our answer array, and for all its adjacent nodes, we will decrease the indegree of that node by one. For example, if node u that has been popped out from the queue has an edge towards node v(u->v), we will decrease indegree[v] by 1.
  After that, if for any node the indegree becomes 0, we will push that node again into the queue.
  We will repeat steps 3 and 4 until the queue is completely empty. Finally, completing the BFS we will get the linear ordering of the nodes in the answer array.
  Let’s understand how to find the indegree(s):

  By visiting the adjacency list, we can find out the indegrees for each node. For example, if node 3 is an adjacent node of node 2, we will just increase indegree[3] by 1 as the adjacency list suggests that node 3 has an incoming edge from node 2.

  Note: If you wish to see the dry run of the above approach, you can watch the video attached to this article.

          Let’s quickly understand the algorithm using the below graph:


  First, we will calculate the indegrees for all 6 nodes. For node 0, it will be 2, for node 1, it will also be 2 and similarly, we will calculate for other nodes. The indegree array will look like this: {2, 2, 1, 1, 0, 0}.
  Next, the queue will be pushed with nodes 4 and 5 as their indegrees are 0. Then we will start the BFS.
  First, node 4 will be popped out and kept in the answer array, and for all its adjacent nodes 0 and 1, the indegrees will be decreased by 1(indegree array: {1, 1, 1, 1, 0, 0} ). No nodes will be pushed into the queue, as there are no other nodes with indegree 0.
  Now, similarly, node 5 will be popped out and indegree[0] and indegree[2] will decrease by 1 keeping node 5 in the answer array. Now, we will push nodes 0 and 2 into the queue as their indegree has become 0(indegree array: {0, 1, 0, 1, 0, 0}).
  Then node 0 will be popped out and as node 0 has no adjacent nodes it will be simply kept in the answer array.
          Next, node 2 will be popped out and kept in the answer array while decreasing indegree[3] by 1(indegree array: {0, 1, 0, 0, 0, 0}). Now indegree[3] is 0 and so node 3 is pushed into the queue.
          Next, node 3 is popped out and kept in the answer array and indegree[1] is decreased by 1 as node 1 is the adjacent node of node 3(indegree array: {0, 0, 0, 0, 0, 0}). Now indegree[1] is 0 and so node 1 is pushed into the queue.
          Lastly, node 1 will be popped out and kept in the answer array, as node 1 has no adjacent nodes. Now, the BFS is completed for the graph.
  Finally, the answer array will look like: {4, 5, 0, 2, 3, 1}.
  Note: Points to remember when a node is popped out, indegrees for all its adjacent nodes are decreased by one and if any of them becomes 0, we push that node into the queue. Meanwhile, we include the current node in the answer immediately after it is popped out of the queue.*/

  // Function to return list containing vertices in Topological order.
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    // create a indegree array to store all the indegree of each node
    // by traverse the vertices and get therir neighber if have increase the
    // indegree of that index to increase
    int indegree[] = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    // insert the indegree= 0 nodes in the queue
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int topo[] = new int[V];
    int i = 0;
    while (!q.isEmpty()) {
      int node = q.poll();
      topo[i++] = node; // add to the result list
      // node is in your topo sort
      // so please remove it from the indegree

      // iterate through all of the indegre and reduce its value till zero,
      // if it is become zero then we will insert it inthe queue;
      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    return topo;
  }

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

    int[] ans = KahnsAlgorithmUsingBFSandIndegree.topoSort(V, adj);
    for (int node : ans) {
      System.out.print(node + " ");
    }
    System.out.println("");
  }
}
/*
Output: 4 5 0 2 3 1

Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).*/
