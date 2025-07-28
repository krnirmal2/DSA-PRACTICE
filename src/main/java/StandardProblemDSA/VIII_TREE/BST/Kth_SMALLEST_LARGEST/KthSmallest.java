package StandardProblemDSA.VIII_TREE.BST.Kth_SMALLEST_LARGEST;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.Stack;

public class KthSmallest {
  /*
  Problem: Find the kth smallest element in a Binary Search Tree (BST).

  Approach:
      - Iterative in-order traversal using a stack.
      - In-order traversal of a BST visits nodes in ascending order.
      - Push all left nodes, pop and decrement k each time.
      - When k == 0, the current node is the kth smallest.

  Pattern:
      - BST property + in-order traversal (left → root → right)
      - Uses stack to simulate recursion.

  Similar LeetCode Problems:
      - 230. Kth Smallest Element in a BST
      - 173. Binary Search Tree Iterator (same concept with `hasNext()` and `next()`)

  Time Complexity:
      - O(h + k), where h = height of BST.
        We traverse down to the leftmost node and pop k nodes.
      - Worst case: O(n) in a skewed tree.

  Space Complexity:
      - O(h) for the stack.
        O(log n) in a balanced BST, O(n) in a skewed BST.

  Follow-up Questions:
      - How to support multiple kth queries efficiently?
        → Augment each node with the size of its left subtree.
      - Can this be converted to find kth largest?
        → Yes, use reverse in-order traversal (right → root → left).
  */

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
