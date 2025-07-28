package StandardProblemDSA.VIII_TREE.BST;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.Stack;

public class BstIteratorUsingStack {
  /*
  Problem:
      Implement an iterator over a Binary Search Tree (BST) that returns nodes in ascending order
      (in-order traversal). With the `reverse` flag, it can also work in descending order (reverse in-order).

  Approach:
      - Use a stack to simulate in-order traversal.
      - Constructor pushes all the way down the leftmost path (or rightmost if reverse = true).
      - `next()` pops the top node, then pushes its right (or left if reverse) subtree.
      - `hasNext()` checks if any nodes remain in the stack.

  Pattern:
      - Controlled in-order traversal using a stack.
      - Same idea as LeetCode 173: BST Iterator.

  Similar Problems:
      - Used with two iterators (in-order + reverse in-order) for "Two Sum IV – Input is a BST" (LC 653).

  Time Complexity:
      - `next()` and `hasNext()` run in amortized O(1) time; across all calls each node is processed once.
      - Stack operations are O(h) in worst case, where h = tree height.

  Space Complexity:
      - O(h) for the stack, where h = height of the BST.

  Follow-ups:
      - Add `peek()` to look at the next element without advancing.
      - Support for both ascending and descending iteration using `reverse` flag.
  */

  // create a stack where we memic the inorder traversal of bst

  private final Stack<TreeNode> stack = new Stack<>();
  private final boolean reverse; // false = inorder, true = reverse inorder

  public BstIteratorUsingStack(TreeNode root) {
    this(root, false);
  }

  public BstIteratorUsingStack(TreeNode root, boolean reverse) {
    this.reverse = reverse;
    pushNodes(root);
  }

  public int next() {
    TreeNode node = stack.pop();
    // Depending on traversal direction, push the next branch
    if (!reverse) {
      if (node.right != null) pushNodes(node.right);
    } else {
      if (node.left != null) pushNodes(node.left);
    }
    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void pushNodes(TreeNode node) {
    while (node != null) {
      stack.push(node);
      // In inorder, we go all the way left; in reverse, all the way right
      node = reverse ? node.right : node.left;
    }
  }
}
