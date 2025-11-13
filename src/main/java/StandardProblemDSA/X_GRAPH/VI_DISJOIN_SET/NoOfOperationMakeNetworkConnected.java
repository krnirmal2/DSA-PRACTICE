package StandardProblemDSA.X_GRAPH.VI_DISJOIN_SET;

public class NoOfOperationMakeNetworkConnected {

  /*There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
  You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
  Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
  Example 1:
  Input: n = 4, connections = [[0,1],[0,2],[1,2]]
  Output: 1
  Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
  Example 2:
  Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
  Output: 2
  Example 3:

  Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
  Output: -1
  Explanation: There are not enough cables.
  Constraints:

  1 <= n <= 105
  1 <= connections.length <= min(n * (n - 1) / 2, 105)
  connections[i].length == 2
  0 <= ai, bi < n
  ai != bi
  There are no repeated connections.
  No two computers are connected by more than one cable.*/

  int[] parent;
  int[] size;

  public NoOfOperationMakeNetworkConnected(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int findUParent(int node) {
    if (parent[node] == node) return node;
    return parent[node] = findUParent(parent[node]);
  }

  public boolean unionBySize(int u, int v) {
    int pu = findUParent(u);
    int pv = findUParent(v);

    if (pu == pv) return false; // already connected → extra edge

    if (size[pu] < size[pv]) {
      parent[pu] = pv;
      size[pv] += size[pu];
    } else {
      parent[pv] = pu;
      size[pu] += size[pv];
    }
    return true;
  }

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) return -1; // Not enough edges to connect all

    NoOfOperationMakeNetworkConnected dsu = new NoOfOperationMakeNetworkConnected(n);
    int extraEdges = 0;

    for (int[] conn : connections) {
      if (!dsu.unionBySize(conn[0], conn[1])) {
        extraEdges++; // counted when union fails
      }
    }

    // Count connected components
    int components = 0;
    for (int i = 0; i < n; i++) {
      if (dsu.findUParent(i) == i) components++;
    }

    return (extraEdges >= components - 1) ? components - 1 : -1;
  }
}
