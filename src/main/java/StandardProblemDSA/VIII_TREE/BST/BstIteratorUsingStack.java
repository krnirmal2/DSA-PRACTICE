package StandardProblemDSA.VIII_TREE.BST;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.Stack;

public class BstIteratorUsingStack {

  // create a stack where we memic the inorder traversal of bst

  private Stack<StandardProblemDSA.VIII_TREE.TreeNode> stack = new Stack<>();
  private boolean reverse; // flag for decide need to either inorder or reverse inorder

  public BstIteratorUsingStack(StandardProblemDSA.VIII_TREE.TreeNode root) {
    // we will push all the left most element first
    // then node
    // then right
    pushLeft(root);
  }

  public BstIteratorUsingStack(StandardProblemDSA.VIII_TREE.TreeNode root, boolean reverse) {
    this.reverse = reverse;
    pushLeft(root);
  }

  // return  the next smallest no
  public int next() {
    StandardProblemDSA.VIII_TREE.TreeNode node = stack.pop();
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

  /**
   * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
   * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */
}
