package StandardProblemDSA.VIII_TREE.II_CONSTRUCTION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.HashMap;
import java.util.Map;

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
  static int preIndex = 0; // Tracks position in preorder array
  static Map<Character, Integer> inorderMap = new HashMap<>();

  public static void main(String[] args) {
    // array of PreTreeNode
    char[] preOrders = {'A', 'B', 'D', 'E', 'C', 'F'};
    char[] inOrders = {'D', 'B', 'E', 'A', 'F', 'C'};
    int lengthOfInorder = inOrders.length; // till all the node from the array  have to iterate
    // Fill map with inorder positions
    for (int i = 0; i < inOrders.length; i++) {
      inorderMap.put(inOrders[i], i);
    }
    int firstIndexOfInOrders = 0;
    int lastIndexOfInOrders = lengthOfInorder - 1;
    // return the root of the tree
    TreeUtility.printPreorder(
        buildTree(inOrders, preOrders, firstIndexOfInOrders, lastIndexOfInOrders));
  }

  private static TreeNode buildTree(
      char[] inOrders, char[] preOrders, int firstIndexOfInOrders, int lastIndexOfInOrders) {

    if (firstIndexOfInOrders > lastIndexOfInOrders) return null;

    // create the TreeNode for initiation
    TreeNode TreeNode = new TreeNode(preOrders[preIndex++]);
    // If this node has no children
    if (firstIndexOfInOrders == lastIndexOfInOrders) return TreeNode;

    // now find the index of the element of Inorder
    int inOrderIndex = inorderMap.get(TreeNode.val);
    //            searchIndexInorder(inOrders, firstIndexOfInOrders,lastIndexOfInOrders,
    // TreeNode.val);

    // set two  left and right subtree
    TreeNode.left = buildTree(inOrders, preOrders, firstIndexOfInOrders, inOrderIndex - 1);
    TreeNode.right = buildTree(inOrders, preOrders, inOrderIndex + 1, lastIndexOfInOrders);

    return TreeNode;
  }

  private static int searchIndexInorder(char[] inOrders, int start, int end, int val) {
    for (int i = start; i <= end; i++) {
      if (inOrders[i] == val) return i;
    }
    return -1;
  }
}
