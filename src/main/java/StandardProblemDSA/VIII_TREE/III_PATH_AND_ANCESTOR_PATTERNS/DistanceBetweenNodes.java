package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class DistanceBetweenNodes {

  /*
  Definition
  Distance between two nodes = Number of edges in the shortest path between them.

  Approach
  Find the Lowest Common Ancestor (LCA) of the two nodes.
  Distance(node1, node2) = distance(root, node1) + distance(root, node2) − 2 × distance(root, LCA).
  */
  // ---------------------------------------------------
  // 4. Distance Between Two Nodes
  // ---------------------------------------------------
  /*
      Problem Statement:
         Find the distance (number of edges) between two nodes in a binary tree.

      Optimal Approach:
         - Find the lowest common ancestor (LCA) of the two nodes.
         - Compute distance from LCA to each node, then add them.

      Time Complexity: O(n)
          8
         / \
        3   10
       / \     \
      1   6     14
         / \    /
        4   7  13
  distance(4, 13) = 3 + 3 - 2*0 = 6 edges

  Distance between 4 and 13:
  LCA of 4 and 13 → 8
  distance(8, 4) = 3 → 8 → 3 → 6 → 4
  distance(8, 13) = 3 → 8 → 10 → 14 → 13
    */

  public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
    // find the LCA between two nodes ,as this will be the path both node will share common path
    TreeNode lca = TreeUtility.lowestCommonAncestor(root, new TreeNode(val1), new TreeNode(val2));
    // Note: The above LCA function expects exact node references.
    // In practice, if values are unique, you might need to first locate nodes by value.
    // For demonstration, we assume nodes with these values exist and are unique.
    int d1 = TreeUtility.findLevel(lca, val1, 0);
    int d2 = TreeUtility.findLevel(lca, val2, 0);
    return d1 + d2;
  }
}
/*## **Time & Space Complexity**
            **1. Finding LCA (Lowest Common Ancestor)**
            * Standard approach using recursion → `O(n)` in worst case (where `n` = number of nodes).
            * If you use parent pointers or Euler Tour + RMQ → could be `O(log n)` query time after `O(n)` preprocessing.
**2. Finding Level from LCA to Node**
            * Each `findLevel` is a DFS/BFS search from LCA → worst-case `O(n)`.
            **Overall Time Complexity:**
            * In the current naive form: `O(n)` (LCA) + `O(n)` (findLevel for val1) + `O(n)` (findLevel for val2)
            * **Worst-case total:** **`O(n)`**, because the searches are separate but all bounded by `n`.

            **Space Complexity:**
            * **`O(h)`** where `h` = height of tree (recursion stack).

            * Worst-case skewed tree: `O(n)`
            * Balanced tree: `O(log n)`
            * No extra data structures besides recursion stack.

---

        ## **Follow-up Questions** (Interview Style)

            1. **Optimization with Parent Pointers**
            * If you store parent pointers in a map at construction time, you can find LCA faster by moving both nodes up until they meet.
   * Time complexity for query: `O(h)`
            2. **Multiple Queries**
            * If the question changes to:
            > “You’ll be given **Q** pairs of nodes. Find the distance for each.”
            * Preprocess LCA using Binary Lifting (`O(n log n)` preprocessing, `O(log n)` per query).
            * Could also use Euler Tour + RMQ for `O(1)` queries after `O(n log n)` preprocessing.

3. **Nodes May Not Exist**

            * Handle cases where one or both nodes are not present in the tree (return -1 or error).
            4. **Distance in a BST**
            * If it’s a Binary Search Tree, you can find LCA in `O(h)` without traversing the entire tree.

5. **Distance in an N-ary Tree**

            * Similar logic applies, just LCA and depth calculation are generalized.

---

        ## **Similar LeetCode Problems**

            | Problem                                     | LeetCode #                                                                    | Similarity                                                                              |
            | ------------------------------------------- | ----------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
            | **Lowest Common Ancestor of a Binary Tree** | [236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Core part of the solution                                                               |
            | **Distance Between Two Nodes in a BST**     | (variation)                                                                   | If BST, can use ordered property                                                        |
            | **All Nodes Distance K in Binary Tree**     | [863](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)     | Instead of distance between two given nodes, find all nodes at distance K from one node |
            | **Binary Tree Maximum Path Sum**            | [124](https://leetcode.com/problems/binary-tree-maximum-path-sum/)            | Also uses path concepts, but focuses on max sum instead of distance                     |
            | **Diameter of Binary Tree**                 | [543](https://leetcode.com/problems/diameter-of-binary-tree/)                 | Similar “distance” computation but between farthest nodes                               |
            | **Minimum Distance Between BST Nodes**      | [783](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)      | Related concept but works on BST ordering                                               |

            ---

    If you want, I can also **redesign your function** so that it:

            * Finds the actual node references for `val1` and `val2`
            * Handles “node not found”
            * Optimizes `findLevel` so it’s only run in the relevant subtree

    That would make it *interview-proof*. Would you like me to do that?*/
