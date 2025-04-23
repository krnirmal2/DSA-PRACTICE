package StandardProblemDSA.VIII_TREE.BST.Kth_SMALLEST_LARGEST;

public class KthLargestInBstReverseInOrder {

  // ---------------------------------------------------
  // 4. Kth Largest Element in a Binary Search Tree (BST)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a Binary Search Tree (BST), find the kth largest element.

    Brute Force Approach:
       - Traverse the BST in-order (ascending order), store elements in an array, and return element at (n-k).
       - Time Complexity: O(n)

    Optimal Approach:
       - Perform a reverse in-order traversal (right-root-left) while counting nodes.
       - Return the kth visited node.
       - Time Complexity: O(h + k) average, where h is the tree height.

    Example:
       BST:
                 5
                / \
               3   7
              / \   \
             2   4   8
       For k = 2, kth largest is 7.
  */
  // BST Node definition (reuse TreeNode from previous section)
  public static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

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
