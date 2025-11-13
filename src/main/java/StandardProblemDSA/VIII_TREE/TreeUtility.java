package StandardProblemDSA.VIII_TREE;

import java.util.ArrayList;
import java.util.List;

public class TreeUtility {
  // A utility function to find min and max
  // distances with respect to root.
  public static void findHorizontalDistance(TreeNode node, int[] minMax, int hd) {

    // Base case
    if (node == null) return;

    // Update min and max
    if (hd < minMax[0]) minMax[0] = hd;
    else if (hd > minMax[1]) minMax[1] = hd;

    // Recur for left and right subtrees
    findHorizontalDistance(node.left, minMax, hd - 1);
    findHorizontalDistance(node.right, minMax, hd + 1);
  }

  public static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println("Height of the tree: " + height(root));
    System.out.println("Height of node with value 5: " + nodeHeight(5));
    System.out.println("Level of node with value 5: " + nodeLevel(5));
    //        System.out.println("Is value 3 present in the tree? " + search(3));
    //        System.out.println("Parent of node with value 5: " + findParent(5).val);
    System.out.println("Diameter of the tree: " + diameter(root));
    System.out.println("Leaf nodes: " + findLeafNodes());
    System.out.println("Siblings of node with value 5: " + findSiblings(5));
    System.out.println("Children of node with value 2: " + findChildren(2));
  }

  // Method to find the height of the tree
  public static int height(TreeNode node) {
    // if node is null then return 0
    // Else go for left and right and find the maximum amount
    // them with add extra 1 to
    if (node == null) {
      return 0;
    } else {
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);

      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  // Method to find the height of a specific node
  public static int nodeHeight(int val) {
    return nodeHeight(root, val, 1);
  }

  public static int nodeHeight(TreeNode node, int val, int height) {
    // find the specific noden
    // set the height =1 and then use utility to
    // if node value is matched then return height
    // first go for left with height+1; if level set the
    // second if not getting any thing from left go for  right and return
    // the value level
    if (node == null) return 0;
    if (node.val == val) return height;

    int level = nodeHeight(node.left, val, height + 1);
    if (level != 0) return level;

    level = nodeHeight(node.right, val, height + 1);
    return level;
  }

  // Method to find the level of a given node in the tree
  public static int nodeLevel(int val) {
    // for level of a node just find the height of node and just minus 1 to it
    return nodeHeight(val) - 1;
  }

  // Method to search for a node in the tree

  public static boolean searchNodeWithValue(TreeNode node, int val) {
    if (node == null) return false;
    if (node.val == val) return true;
    return searchNodeWithValue(node.left, val) || searchNodeWithValue(node.right, val);
  }

  // Method to find the parent of a node

  public static TreeNode findParentOfValue(TreeNode node, int val) {
    if (node == null
        || (node.left != null && node.left.val == val)
        || (node.right != null && node.right.val == val)) return node;

    // we check if the current nodes left or right present the value node
    // then the current node will be the parent of it
    TreeNode parent = findParentOfValue(node.left, val);
    if (parent == null) parent = findParentOfValue(node.right, val);

    return parent;
  }

  // Method to find the diameter of the tree
  public static int diameter(TreeNode node) {
    if (node == null) return 0;
    // find the height of the left and right

    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    // then find the left and right diameter of the tree
    int leftDiameter = diameter(node.left);
    int rightDiameter = diameter(node.right);
    // return the maximum of the ( sum of edges of left and right subtree with (root as taken 1) ,
    // maximum of left and rightDiameter)
    return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
  }

  // Method to find all leaf nodes
  public static List<Integer> findLeafNodes() {
    List<Integer> leafNodes = new ArrayList<>();
    findLeafNodes(root, leafNodes);
    return leafNodes;
  }

  public static boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  public static void findLeafNodes(TreeNode node, List<Integer> leafNodes) {
    if (node == null) return;
    if (node.left == null && node.right == null) leafNodes.add(node.val);
    findLeafNodes(node.left, leafNodes);
    findLeafNodes(node.right, leafNodes);
  }

  // Method to find siblings of a node
  public static List<Integer> findSiblings(int val) {
    List<Integer> siblings = new ArrayList<>();
    TreeNode parent = findParentOfValue(root, val);
    if (parent != null) {
      if (parent.left != null && parent.left.val != val) siblings.add(parent.left.val);
      if (parent.right != null && parent.right.val != val) siblings.add(parent.right.val);
    }
    return siblings;
  }

  // Method to find children of a node
  public static List<Integer> findChildren(int val) {
    List<Integer> children = new ArrayList<>();
    // first find the node of give value
    TreeNode node = findNode(root, val);
    // if node found then check its left and right child and return if
    // they aren't null
    if (node != null) {
      if (node.left != null) children.add(node.left.val);
      if (node.right != null) children.add(node.right.val);
    }
    return children;
  }

  public static TreeNode findNode(TreeNode node, int val) {
    if (node == null) return null;
    if (node.val == val) return node;
    TreeNode left = findNode(node.left, val);
    if (left != null) return left;
    return findNode(node.right, val);
  }

  // Tree Traversals: Inorder, Preorder and Postorder
  public static void inorderTraversal(TreeNode node) {
    if (node != null) {
      inorderTraversal(node.left);
      System.out.print(node.val + " ");
      inorderTraversal(node.right);
    }
  }

  public static void preorderTraversal(TreeNode node) {
    if (node != null) {
      System.out.print(node.val + " ");
      preorderTraversal(node.left);
      preorderTraversal(node.right);
    }
  }

  public static void postorderTraversal(TreeNode node) {
    if (node != null) {
      postorderTraversal(node.left);
      postorderTraversal(node.right);
      System.out.print(node.val + " ");
    }
  }

  public static void preorderHelper(TreeNode node, List<Integer> result) {
    if (node == null) return;
    result.add(node.val); // Visit root
    preorderHelper(node.left, result); // Traverse left subtree
    preorderHelper(node.right, result); // Traverse right subtree
  }

  public static void rootToLeafPathNodeUtil(
      TreeNode node, List<Integer> current, List<List<Integer>> paths) {
    if (node == null) return;
    current.add(node.val);
    if (node.left == null && node.right == null) { // leaf
      paths.add(new ArrayList<>(current));
      // Without copy: [[1,3], [1,3]]
      /*With copy:    [[1,2,4], [1,3]]
      we have to create the new list other wise it will*/
      // take the same reference of the list and override the earlier and save to path list

    } else {
      rootToLeafPathNodeUtil(node.left, current, paths);
      rootToLeafPathNodeUtil(node.right, current, paths);
    }
    current.remove(current.size() - 1); // backtrack
  }

  // (b) Check if there is a root-to-leaf path with a given sum.
  public static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    // If leaf, check if path sum equals targetSum.
    if (root.left == null && root.right == null) {
      return (root.val == targetSum);
    }
    // Otherwise, check in left or right subtree with reduced target.
    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //    if the current node is either null or any of the two node return the node
    if (root == null || root == p || root == q) return root;
    // else go left or right of the root node and again check if found
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // if after traversal both left and right are none leaf node then return that current root node
    // because that is the parent node of the both
    if (left != null && right != null) return root;
    // else if one of them is a parent of one then that will be the meeting node
    // because one of the side after above left and right search give null value
    return (left != null) ? left : right;
  }

  // Helper: find distance from root to a given node value.
  public static int findLevel(TreeNode root, int val, int level) {
    if (root == null) return -1;
    if (root.val == val) return level;
    int left = findLevel(root.left, val, level + 1);
    if (left != -1) return left;
    return findLevel(root.right, val, level + 1);
  }

  public static boolean findAncestors(TreeNode root, int target, List<Integer> ancestors) {
    if (root == null) return false;
    if (root.val == target) return true;
    // we use HEAD  recursion during return we will add the values
    // means bottom up collect the element during return phase so use wisely head and tails
    // recursion to get
    // desired result
    if (findAncestors(root.left, target, ancestors)
        || findAncestors(root.right, target, ancestors)) {
      ancestors.add(root.val);
      return true;
    }
    return false;
  }

  public static void findPathsMatching(
      TreeNode node,
      List<Integer> pattern,
      int patternIndex,
      List<Integer> current,
      List<List<Integer>> matchingPaths) {
    if (node == null) return;
    current.add(node.val);
    // Check pattern match so far.
    if (patternIndex < pattern.size() && node.val == pattern.get(patternIndex)) {
      patternIndex++;
    }
    // If leaf node, check if the pattern was matched as a prefix.
    if (node.left == null && node.right == null) {
      if (patternIndex == pattern.size()) {
        matchingPaths.add(new ArrayList<>(current));
      }
    }
    findPathsMatching(node.left, pattern, patternIndex, current, matchingPaths);
    findPathsMatching(node.right, pattern, patternIndex, current, matchingPaths);
    current.remove(current.size() - 1); // backtrack
  }

  // ---------------------------------------------------
  // 3. Rotate Tree (Right Rotation and Left Rotation)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Perform tree rotations at a given node. These rotations are basic operations
       in self-balancing BSTs.

    Brute Force Approach:
       - Reconstruct tree via traversal; however, rotations are localized adjustments.

    Optimal Approach:
       - For a right rotation: Make left child the new root and reattach.
       - For a left rotation: Make right child the new root and reattach.
       - Time Complexity: O(1) per rotation.

    Example:
       Right Rotation at node 10:
           10                 5
          /  \      -->      / \
         5    15           3   10
        / \                    /  \
       3   7                  7   15
  */
  // Right rotation (rotate around given root)
  public static TreeNode rotateRight(TreeNode root) {
    if (root == null || root.left == null) return root;
    TreeNode newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    return newRoot;
  }

  // Left rotation (rotate around given root)
  public static TreeNode rotateLeft(TreeNode root) {
    if (root == null || root.right == null) return root;
    TreeNode newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;
    return newRoot;
  }

  // Helper method to print a tree in pre-order.
  public static void printPreorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    printPreorder(root.left);
    printPreorder(root.right);
  }

  public static boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
  }

  // ---------------------------------------------------
  // 1. Check if Two Trees are Identical
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine whether two binary trees are identical (structure and node values are the same).

    Brute Force Idea:
       - Traverse both trees simultaneously (e.g., in preorder) and compare nodes.

    Optimal Approach:
       - Use recursion: if both nodes are null, they are identical; if one is null or values differ, they are not.

    Time Complexity: O(n) where n is the number of nodes in the smaller tree.

    Example:
       Tree A:       1         Tree B:       1
                   /   \                   /   \
                  2     3                 2     3
       They are identical.
  */
  public static boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    // if value, left and right of node are same than it is identical
    return (root1.val == root2.val)
        && isIdentical(root1.left, root2.left) // both left should be identical
        && isIdentical(root1.right, root2.right); // both right should be identical
  }

  // ---------------------------------------------------
  // 1. Count Total Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Count the total number of nodes in a binary tree.

    Brute Force Idea:
       - Traverse all nodes (e.g., using recursion) and increment a counter.

    Optimal Approach:
       - Use recursion: count = 1 (current node) + count(left subtree) + count(right subtree).

    Time Complexity: O(n), where n is the number of nodes.

    Example:
       For tree:
               1
              / \
             2   3
            /
           4
       Total nodes = 4.
  */
  public static int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  // ---------------------------------------------------
  // 2. Count Leaf Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Count the number of leaf nodes (nodes with no children) in a binary tree.

    Optimal Approach:
       - Recursively check: if node is null, return 0; if both children are null, return 1;
         otherwise, sum counts from left and right subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
              \
               4
       Leaf nodes: 4 and 3 → count = 2.
  */
  public static int countLeafNodes(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    return countLeafNodes(root.left) + countLeafNodes(root.right);
  }

  public static void nodesAtKDistanceHelper(TreeNode node, int k, List<Integer> result) {
    if (node == null) return;
    if (k == 0) {
      result.add(node.val);
      return;
    }
    nodesAtKDistanceHelper(node.left, k - 1, result);
    nodesAtKDistanceHelper(node.right, k - 1, result);
  }

  // ---------------------------------------------------
  // 4. Sum of All Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Calculate the sum of all node values in a binary tree.

    Optimal Approach:
       - Recursively sum the current node’s value and the sums from the left and right subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
       Sum = 1 + 2 + 3 = 6.
  */
  public static int sumNodes(TreeNode root) {
    if (root == null) return 0;
    return root.val + sumNodes(root.left) + sumNodes(root.right);
  }

  // ---------------------------------------------------
  // 1. Maximum Depth/Height of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Compute the maximum depth (height) of a binary tree, defined as the number of nodes
       along the longest path from the root down to the farthest leaf node.

    Brute Force Idea:
       - Traverse all paths from root to leaves and take the maximum.

    Optimal Approach:
       - Use recursion: height(root) = max(height(root.left), height(root.right)) + 1.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
            /
           4
       Maximum Depth: 3 (path: 1→2→4)
  */
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  // ---------------------------------------------------
  // 2. Minimum Depth/Height of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Compute the minimum depth of a binary tree, defined as the number of nodes along the
       shortest path from the root node down to the nearest leaf node.

    Optimal Approach:
       - Use recursion. Special care is needed when one subtree is null.
         If a node has no left child, use the minimum depth from the right, and vice versa.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              /
             2
              \
               3
       Minimum Depth: 3 (path: 1→2→3, since 3 is a leaf)
  */
  public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    // If one subtree is missing, we use the depth of the other subtree.
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }

  /*   8
         / \
        3   10
       / \    \
      1   6    14
         / \   /
        4   7 13
  */
  public static TreeNode tree() {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);
    return root;
  }
}
