package StandardProblemDSA.VIII_TREE.II_CONSTRUCTION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class CreateTreeFromPreAndInorderTraversal {
  /*
   Problem: Construct a binary tree from preorder and inorder traversal.

   Given two arrays `preorder` and `inorder` of a binary tree, build and return the binary tree.

   Example:
   Input:
      preorder = ['A', 'B', 'D', 'E', 'C', 'F']
      inorder  = ['D', 'B', 'E', 'A', 'C', 'F']
   Output:
          A
         / \
        B   C
       / \    \
      D   E    F

   Pattern:
      - Tree Construction
      - Recursion
      - Divide and Conquer

   Similar LeetCode Problems:
      - 105. Construct Binary Tree from Preorder and Inorder Traversal
      - 106. Construct Binary Tree from Inorder and Postorder Traversal
      - 889. Construct Binary Tree from Preorder and Postorder Traversal

   Follow-up Questions:
      - How to handle duplicate values in the tree?
      - Can you do it iteratively?
      - How to optimize search for inorder index (use a HashMap)?
      - What if the tree is skewed? What's the complexity?

   Time Complexity: O(n²), due to searching the index in inorder array each time
   Space Complexity: O(h), h = height of the tree (recursion stack)
  */

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
