package StandardProblemDSA.X_GRAPH.VI_DISJOIN_SET;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:
------------------
Implement Disjoint Set Union (DSU) / Union-Find data structure that efficiently supports:
1. **Find**: Determine which subset a particular element belongs to.
2. **Union**: Merge two subsets into a single subset.

Key Features:
- **Path Compression** in `find`: Flattens the structure of the tree, ensuring almost O(1) time.
- **Union by Rank**: Attaches the smaller-depth tree under the root of the deeper tree.
- **Union by Size**: Attaches the smaller-sized tree under the larger-sized tree.

Use Cases:
----------
- Detecting cycles in an undirected graph.
- Kruskal's Algorithm for Minimum Spanning Tree (MST).
- Connected components in a graph.
- Network connectivity problems.

Approach:
---------
- Maintain three arrays/lists:
  - `parent`: Tracks the parent of each node; initially, each node is its own parent.
  - `rank`: Tracks the depth of trees for union by rank.
  - `size`: Tracks the size of trees for union by size.
- `findUparent(node)`:
  - Recursively finds the ultimate parent of `node` and applies **path compression**.
- `unionByRank(u, v)`:
  - Merges sets containing `u` and `v` using tree height (rank) to keep the tree shallow.
- `unionBySize(u, v)`:
  - Merges sets using subtree sizes, attaching the smaller tree under the larger one.

Pattern:
--------
- Disjoint Set Union (DSU)
- Union-Find with Path Compression
- Greedy Algorithm Support (used in Kruskal's MST)

Time & Space Complexity:
------------------------
- Amortized Time Complexity:
  - `find` ≈ O(α(n)), where α(n) is the Inverse Ackermann Function (practically constant).
  - `union` ≈ O(α(n)).
- Space Complexity: O(n) for parent, rank, and size arrays.

Related LeetCode Questions:
---------------------------
- 684. Redundant Connection
- 685. Redundant Connection II
- 547. Number of Provinces
- 1319. Number of Operations to Make Network Connected
- 1579. Remove Max Number of Edges to Keep Graph Fully Traversable

Follow-ups:
-----------
1. How does **path compression** improve performance over naive Union-Find?
2. Compare **union by rank** vs. **union by size**. When to prefer one?
3. How to modify DSU to support **rollback operations** (Undo Union)?
4. Can DSU be extended to track **extra information** (e.g., connected component weights)?
*/

public class DisjointSet {
  // find two component, of the
  // check if the two vertex belongs to same component or not
  // find and parent using Rank or Size
  // Way 1 start implementing using Rank
  public DisjointSet() {}

  // initaitl conf
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {
    // initail configurataion
    for (int i = 0; i <= n; i++) {
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  // find utlimate parent of a node using path compression
  public int findUparent(int node) {
    // if already have the ultimate parent then retunrn
    if (node == parent.get(node)) {
      return node;
    }
    // else do path compression by findeing ultimate parent by
    // recursion
    int ultimParent = findUparent(parent.get(node));

    // set all the node parent to the ulitmate parent
    parent.set(node, ultimParent);
    return parent.get(node);
  }

  // unioin of u to v
  void unionByRank(int u, int v) {
    // find both ultimate parent
    int ulp_u = findUparent(u);
    int ulp_v = findUparent(v);

    // belong to same component then retun
    if (ulp_u == ulp_v) return;
    // if rank of u is lesser than rank v
    // means we join u to v by seting parent of u as v
    if (rank.get(ulp_u) < rank.get(ulp_v)) {
      parent.set(ulp_u, ulp_v);
    } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
      parent.set(ulp_v, ulp_u);
    } else {
      parent.set(ulp_v, ulp_u);
      int rankU = rank.get(ulp_u);
      rank.set(ulp_u, rankU + 1);
    }
    //
  }

  public void unionBySize(int u, int v) {
    int ulp_u = findUparent(u);
    int ulp_v = findUparent(v);
    if (ulp_u == ulp_v) return;
    // if size of u size is less thant v than attached u to v
    if (size.get(ulp_u) < size.get(ulp_v)) {
      parent.set(ulp_u, ulp_v); // attached u to v
      size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // increase the size of the v as
    } else {
      parent.set(ulp_v, ulp_u); // else attached to u
      size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // increase the size of u
    }
  }

  public static void main(String[] args) {
    DisjointSet ds = new DisjointSet(7);
    ds.unionByRank(1, 2);
    ds.unionByRank(2, 3);
    ds.unionByRank(4, 5);
    ds.unionByRank(6, 7);
    ds.unionByRank(5, 6);

    // if 3 and 7 same or not
    if (ds.findUparent(3) == ds.findUparent(7)) {
      System.out.println("Same");
    } else System.out.println("Not Same");

    ds.unionByRank(3, 7);
    if (ds.findUparent(3) == ds.findUparent(7)) {
      System.out.println("Same");
    } else System.out.println("Not Same");
  }
}
