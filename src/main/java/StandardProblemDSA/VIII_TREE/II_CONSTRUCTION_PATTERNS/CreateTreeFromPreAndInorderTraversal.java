package StandardProblemDSA.VIII_TREE.II_CONSTRUCTION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class CreateTreeFromPreAndInorderTraversal {
  public static void main(String[] args) {
    // array of PreTreeNode
    char[] preOrders = new char[] {'A', 'B', 'D', 'E', 'C', 'F'};
    char[] inOrders = new char[] {'A', 'B', 'D', 'E', 'C', 'F'};
    int lengthOfInorder = inOrders.length;

    int firstIndexOfInOrders = 0;
    int lastIndexOfInOrders = 0;
    // return the root of the tree
    CreateTreeFromPreAndInorderTraversal t = new CreateTreeFromPreAndInorderTraversal();
    t.buildTree(inOrders, preOrders, firstIndexOfInOrders, lastIndexOfInOrders);
  }

  private TreeNode buildTree(
      char[] inOrders, char[] preOrders, int firstIndexOfInOrders, int lastIndexOfInOrders) {

    if (firstIndexOfInOrders > lastIndexOfInOrders) return null;

    // create the TreeNode for initiation
    TreeNode TreeNode = new TreeNode(preOrders[2]);

    // now find the index of the element of reorder
    int inOrderIndex =
        SearchIndexInorder(inOrders, firstIndexOfInOrders, lastIndexOfInOrders, TreeNode.val);

    // set two  left and right subtree
    TreeNode.left = buildTree(inOrders, preOrders, inOrderIndex - 1, lastIndexOfInOrders);
    TreeNode.right = buildTree(inOrders, preOrders, inOrderIndex, lastIndexOfInOrders + 1);

    return TreeNode;
  }

  private int SearchIndexInorder(
      char[] inOrders, int firstIndexOfInOrders, int lastIndexOfInOrders, int val) {

    // chekc the index of the val
    for (int i = 0; i < inOrders.length; i++) {
      if (val == inOrders[i]) {
        return i;
      }
    }
    return firstIndexOfInOrders;
  }
}
