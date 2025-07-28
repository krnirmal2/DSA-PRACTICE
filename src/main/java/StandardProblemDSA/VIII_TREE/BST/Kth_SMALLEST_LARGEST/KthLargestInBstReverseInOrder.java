package StandardProblemDSA.VIII_TREE.BST.Kth_SMALLEST_LARGEST;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class KthLargestInBstReverseInOrder {
  /*
  Problem: Find the kth largest element in a Binary Search Tree (BST).

  Approach:
      - Use reverse in-order traversal (right → root → left).
      - Keep a counter to track the number of nodes visited.
      - When counter equals k, store the node value and stop traversal.

  Pattern:
      - BST property + in-order traversal
      - Reverse in-order = descending order
      - Early stopping once kth element is found.

  Similar LeetCode Problems:
      - 230. Kth Smallest Element in a BST (mirror problem)
      - 538. Convert BST to Greater Tree

  Time Complexity:
      - Average: O(h + k), h = height of tree.
        We may skip large portions of the tree due to early stopping.
      - Worst case: O(n) when the tree is skewed or k = n.

  Space Complexity:
      - O(h) recursion stack, where h = tree height.
        O(log n) in a balanced BST, O(n) in a skewed BST.

  Follow-up Questions:
      - How to handle duplicates in the BST?
      - Can we do it iteratively using a stack instead of recursion?
      - How to support multiple kth largest queries efficiently (augment nodes with subtree sizes)?
  */

  // Helper for kth largest in BST
  private int count = 0;
  private int kthLargestVal = -1;

  public int kthLargestInBST(TreeNode root, int k) {
    count = 0;
    kthLargestVal = -1;
    reverseInorder(root, k);
    return kthLargestVal;
  }

  private void reverseInorder(TreeNode node, int k) {
    if (node == null || count >= k) return;
    reverseInorder(node.right, k);
    count++;
    if (count == k) {
      kthLargestVal = node.val;
      return;
    }
    reverseInorder(node.left, k);
  }
}
