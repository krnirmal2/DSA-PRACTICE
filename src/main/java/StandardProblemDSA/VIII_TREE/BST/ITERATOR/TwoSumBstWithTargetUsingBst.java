package StandardProblemDSA.VIII_TREE.BST.ITERATOR;

import StandardProblemDSA.VIII_TREE.BST.BstIteratorUsingStack;
import StandardProblemDSA.VIII_TREE.TreeNode;

public class TwoSumBstWithTargetUsingBst {
  /*
  Problem: Find if there exist two elements in a BST such that their sum equals a given target k.

  Approach:
      - Use two iterators:
          * In-order iterator → gets the next smallest value.
          * Reverse in-order iterator → gets the next largest value.
      - Works like two pointers on a sorted array: move left or right pointer based on sum.

  Pattern:
      - BST traversal
      - Two-pointer technique using iterators
      - Space-efficient solution (no full inorder array required)

  Similar LeetCode Problems:
      - 653. Two Sum IV – Input is a BST
      - 173. Binary Search Tree Iterator

  Time Complexity:
      - Each node is visited at most once → O(n)
      - Each iterator operation amortized O(1), worst O(h), h = height of the tree.

  Space Complexity:
      - Each iterator uses O(h) stack space, total O(h).
      - O(log n) for balanced BST, O(n) for skewed BST.

  Follow-up Questions:
      - How would you do this without using any extra space (Morris traversal)?
      - How to extend the approach if duplicates are allowed?
      - How to handle non-BST binary trees efficiently?
  */

  public boolean findTarget(TreeNode root, int k) {
    BstIteratorUsingStack leftItr = new BstIteratorUsingStack(root, false);
    BstIteratorUsingStack rightItr = new BstIteratorUsingStack(root, true);

    int left = leftItr.next(), right = rightItr.next();
    while (left < right) {
      if (left + right == k) return true;
      if (left + right < k) left = leftItr.next();
      else right = rightItr.next();
    }
    return false;
  }
  /*You’re trying to determine whether two nodes in a BST add up to a given target k.
  You're using:
  BSTIterator → in-order traversal (next smallest)
  BSTReverseIterator → reverse in-order traversal (next largest)
  🧠 Time Complexity
  Each call to next() or hasNext() in a BST Iterator is O(h) in the worst case, where h = height of tree.
  But due to amortization (we only visit each node once across the whole tree):
  ✅ Total time complexity is:
  In the worst case, you might traverse every node (e.g., when the sum is not found).
  You're moving the left and right iterators across the whole tree (like two pointers walking in from both sides).
  So even though each individual call to next() is O(h), across all calls the total work done is O(n).
  💾 Space Complexity
  You're not storing all n values — just enough stack space for each iterator.
  Each BST Iterator uses a stack to maintain the traversal state:
  The stack size at any time is at most O(h).
  So total space complexity:
  mathematica
  O(h) + O(h) = O(h)
  Where h is the height of the tree:
  O(log n) in a balanced BST
  O(n) in a skewed BST*/
}
