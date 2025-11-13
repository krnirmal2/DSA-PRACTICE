package StandardProblemDSA.VIII_TREE.BST;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class BSTutility {

  public static void inorderRecursive(TreeNode root) {
    if (root != null) {
      inorderRecursive(root.left);
      System.out.print(root.val + " ");
      inorderRecursive(root.right);
    }
  }

  public static boolean searchRecursiveBST(TreeNode root, int val) {
    if (root == null) {
      return false;
    }

    if (root.val == val) {
      return true;
    } else if (val < root.val) {
      return searchRecursiveBST(root.left, val);
    } else {
      return searchRecursiveBST(root.right, val);
    }
  }

  public static TreeNode insertRecursiveBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (val < root.val) {
      root.left = insertRecursiveBST(root.left, val);
    } else if (val > root.val) {
      root.right = insertRecursiveBST(root.right, val);
    }

    return root;
  }

  public static TreeNode deleteRecursiveBst(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (val < root.val) {
      root.left = deleteRecursiveBst(root.left, val);
    } else if (val > root.val) {
      root.right = deleteRecursiveBst(root.right, val);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.val = minValue(root.right);
      root.right = deleteRecursiveBst(root.right, root.val);
    }

    return root;
  }

  public static int minValue(TreeNode root) {
    int minValue = root.val;
    while (root.left != null) {
      minValue = root.left.val;
      root = root.left;
    }
    return minValue;
  }

  public static TreeNode constructBSTUtil(int[] preOrder, int start, int end) {
    if (start > end) {
      return null;
    }

    TreeNode node = new TreeNode(preOrder[start]);
    int i;
    for (i = start; i <= end; i++) {
      if (preOrder[i] > node.val) {
        break;
      }
    }

    node.left = constructBSTUtil(preOrder, start + 1, i - 1);
    node.right = constructBSTUtil(preOrder, i, end);

    return node;
  }

  public static boolean validateBST(TreeNode node, long lower, long upper) {
    if (node == null) return true;
    if (node.val <= lower || node.val >= upper) return false;
    return validateBST(node.left, lower, node.val) && validateBST(node.right, node.val, upper);
  }

  public static int height(TreeNode node) {
    if (node == null) return 0; // An empty subtree has height 0
    // Recursive height calculation for left subtree
    int leftHeight = height(node.left);
    if (leftHeight == -1)
      return -1; // If it returns -1, it means the left subtree is already unbalanced, so bubble up
    // -1 immediately.
    // Recursive height calculation for right subtree
    int rightHeight = height(node.right);
    if (rightHeight == -1) return -1;
    // Balance check at the current node
    if (Math.abs(leftHeight - rightHeight) > 1)
      return -1; // If the height difference between left and right subtrees is more than 1, mark
    // this subtree as unbalanced by returning -1.
    // If balanced, return the actual height of this subtree.
    return Math.max(leftHeight, rightHeight) + 1;
  }

  /* public static TreeMetricsOperations.BSTInfo postorderBST(TreeNode node) {
    if (node == null) return new TreeMetricsOperations.BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

    TreeMetricsOperations.BSTInfo leftInfo = postorderBST(node.left);
    TreeMetricsOperations.BSTInfo rightInfo = postorderBST(node.right);

    if (leftInfo.isBST && rightInfo.isBST && node.val > leftInfo.max && node.val < rightInfo.min) {
      int size = leftInfo.size + rightInfo.size + 1;
      largestBSTSize = Math.max(largestBSTSize, size);
      int min = (node.left != null) ? leftInfo.min : node.val;
      int max = (node.right != null) ? rightInfo.max : node.val;
      return new TreeMetricsOperations.BSTInfo(true, size, min, max);
    } else {
      // Not a BST; size not needed here.
      return new TreeMetricsOperations.BSTInfo(false, 0, 0, 0);
    }
  }*/

}
