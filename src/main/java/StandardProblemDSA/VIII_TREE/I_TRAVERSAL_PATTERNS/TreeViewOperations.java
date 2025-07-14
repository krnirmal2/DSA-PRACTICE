package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.Pair;
import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.*;

class TreeViewOperations {

  // ---------------------------------------------------
  // 1. Left View of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Print the left view of a binary tree (i.e., the nodes that are visible when the tree
       is viewed from the left side). This is typically the first node of each level.

    Optimal Approach:
       - Use level order traversal (BFS) and record the first node encountered at each level.

    Time Complexity: O(n), where n is the number of nodes.

    Example:
       For the tree:
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
       Left View: [1, 2, 4]
  */
  public static List<Integer> leftView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        // The first node of this level is part of the left view.
        if (i == 0) {
          result.add(node.val);
        }
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }
    return result;
  }

  // ---------------------------------------------------
  // 2. Right View of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Print the right view of a binary tree (i.e., the nodes visible when the tree is viewed from the right side).
       This is typically the last node of each level.

    Optimal Approach:
       - Use level order traversal (BFS) and record the last node encountered at each level.

    Time Complexity: O(n)

    Example:
       For the tree:
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
       Right View: [1, 3, 6]
  */
  public static List<Integer> rightView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        // The last node of this level is part of the right view.
        if (i == levelSize - 1) {
          result.add(node.val);
        }
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }
    return result;
  }

  // ---------------------------------------------------
  // 3. Top View of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Print the top view of a binary tree. The top view is the set of nodes visible when the tree is viewed from above.
       For each horizontal distance from the root, the top-most (or first encountered in level order) node is included.

    Optimal Approach:
       - Use a level order traversal with a horizontal distance (hd) counter.
       - Use a TreeMap to store the first node encountered at each hd.

    Time Complexity: O(n log n) due to TreeMap insertions.

    Example:
       For the tree:
                    1 (hd = 0)
                   / \
                 2( -1) 3(1)
                 / \     \
              4(-2) 5(0)  6(2)
       Top View: [4, 2, 1, 3, 6]
  */
  public static List<Integer> topView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    // TreeMap will sort keys (horizontal distances) in natural order.
    Map<Integer, Integer> topViewMap = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0)); // hd of root is 0

    while (!queue.isEmpty()) {
      Pair curr = queue.poll();
      TreeNode node = curr.node;
      int hd = curr.hd;
      // If this is the first node encountered at this horizontal distance, add it.
      // As we see from Top so only one elemet of hd is visible so
      // if more than multiple same hd present we will only take the first  of each leel
      // from the queue
      if (!topViewMap.containsKey(hd)) {
        topViewMap.put(hd, node.val);
      }
      if (node.left != null) {
        queue.offer(new Pair(node.left, hd - 1));
      }
      if (node.right != null) {
        queue.offer(new Pair(node.right, hd + 1));
      }
    }

    for (Integer val : topViewMap.values()) {
      result.add(val);
    }
    return result;
  }

  // ---------------------------------------------------
  // 4. Bottom View of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Print the bottom view of a binary tree. The bottom view includes the nodes visible when the tree is viewed from below.
       For each horizontal distance, the bottom-most (last encountered in level order) node is visible.

    Optimal Approach:
       - Use a level order traversal with a horizontal distance counter.
       - Use a TreeMap to store the latest node encountered at each horizontal distance.

    Time Complexity: O(n log n)

    Example:
       For the tree:
                    1 (hd = 0)
                   / \
                 2(-1) 3(1)
                 / \     \
              4(-2) 5(0)  6(2)
       Bottom View: [4, 2, 5, 3, 6]
  */
  public static List<Integer> bottomView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Map<Integer, Integer> bottomViewMap = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair curr = queue.poll();
      TreeNode node = curr.node;
      int hd = curr.hd;
      // For bottom view, update the mapping (later nodes will overwrite earlier ones).
      // each node of the last level will override the horizontal distance
      bottomViewMap.put(hd, node.val);

      if (node.left != null) {
        queue.offer(new Pair(node.left, hd - 1));
      }
      if (node.right != null) {
        queue.offer(new Pair(node.right, hd + 1));
      }
    }

    for (Integer val : bottomViewMap.values()) {
      result.add(val);
    }
    return result;
  }

  // ---------------------------------------------------
  // Main method for demonstration
  // ---------------------------------------------------
  public static void main(String[] args) {
    TreeViewOperations ops = new TreeViewOperations();

    // Build sample tree:
    //             1
    //           /   \
    //          2     3
    //         / \     \
    //        4   5     6
    //           /
    //          7
    //
    // Horizontal distances (hd):
    //  - Node 1: hd = 0
    //  - Node 2: hd = -1, Node 3: hd = 1
    //  - Node 4: hd = -2, Node 5: hd = 0, Node 6: hd = 2
    //  - Node 7: hd = -1
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.left.right.left = new TreeNode(7);

    // 1. Left View
    List<Integer> leftView = leftView(root);
    System.out.println("Left View: " + leftView);
    // Expected Output: [1, 2, 4, 7] or [1,2,4] (depending on tree structure)

    // 2. Right View
    List<Integer> rightView = rightView(root);
    System.out.println("Right View: " + rightView);
    // Expected Output: [1, 3, 6, 7] or [1,3,6] (depending on tree structure)

    // 3. Top View
    List<Integer> topView = topView(root);
    System.out.println("Top View: " + topView);
    // Expected Output: [4, 2, 1, 3, 6] based on hd order

    // 4. Bottom View
    List<Integer> bottomView = bottomView(root);
    System.out.println("Bottom View: " + bottomView);
    // Expected Output: [4, 7, 5, 3, 6] based on hd order (last nodes per hd)
  }
}
