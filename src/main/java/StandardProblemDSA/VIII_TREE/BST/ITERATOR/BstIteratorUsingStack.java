package StandardProblemDSA.VIII_TREE.BST.ITERATOR;

import java.util.Stack;

public class BstIteratorUsingStack {
  private class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  class BSTIterator {
    // create a stack where we memic the inorder traversal of bst

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
      // we will push all the left most element first
      // then node
      // then right
      pushLeft(root);
    }

    // return  the next smallest no
    public int next() {
      TreeNode node = stack.pop();
      if (node.right != null) {
        pushLeft(node.right);
      }
      return node.val;
    }

    public boolean hasNext() {
      // just check if stack is emepty or not
      return !stack.isEmpty();
    }

    public void pushLeft(TreeNode node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
  }

  /**
   * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
   * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */
}
