package StandardProblemDSA.VIII_TREE.BST.ITERATOR;

import java.util.Stack;

public class TwoSumBstWithTargetUsingBst {
  private class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  private class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse; // flag for decide need to either inorder or reverse inorder

    BSTIterator(TreeNode root, boolean reverse) {
      this.reverse = reverse;
      push(root);
    }

    int next() {
      TreeNode top = st.pop();
      push(!reverse ? top.right : top.left);
      return top.val;
    }

    private void push(TreeNode root) {
      while (root != null) {
        st.push(root);
        // if reverese false then pushed left else push right
        root = !reverse ? root.left : root.right;
      }
    }
  }

  class Solution {
    public boolean findTarget(TreeNode root, int k) {
      BSTIterator leftItr = new BSTIterator(root, false);
      BSTIterator rightItr = new BSTIterator(root, true);

      int left = leftItr.next(), right = rightItr.next();
      while (left < right) {
        if (left + right == k) return true;
        if (left + right < k) left = leftItr.next();
        else right = rightItr.next();
      }
      return false;
    }
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
