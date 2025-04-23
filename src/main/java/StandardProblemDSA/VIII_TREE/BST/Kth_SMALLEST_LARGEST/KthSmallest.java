package StandardProblemDSA.VIII_TREE.BST.Kth_SMALLEST_LARGEST;

import java.util.Stack;

public class KthSmallest {

  public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {
    public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> stack = new Stack<>();
      while (true) {
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        k--;
        if (k == 0) return root.val;
        root = root.right;
      }
    }
  }
  /* ✅ Solution Using a Wrapper Class or Array:
      To fix this, use a wrapper object or array for count and result so they can be updated across recursive calls.

      class Solution {
          public int kthSmallest(TreeNode root, int k) {
              int[] count = new int[1];  // acts like a reference
              int[] result = new int[1];
              recu(root, count, k, result);
              return result[0];
          }

          public void recu(TreeNode root, int[] count, int k, int[] result) {
              if (root == null) return;

              recu(root.left, count, k, result);

              count[0]++;
              if (count[0] == k) {
                  result[0] = root.val;
                  return;
              }

              recu(root.right, count, k, result);
          }
      }
  */
}
