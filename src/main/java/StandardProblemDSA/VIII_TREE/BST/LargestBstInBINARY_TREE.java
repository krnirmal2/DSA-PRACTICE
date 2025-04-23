package StandardProblemDSA.VIII_TREE.BST;

public class LargestBstInBINARY_TREE {

  // BF : SOLUTION :
  // USE A UTILITY METHOD AND CHECK IF A NODE WHICH IS PASSING IS VALIED OR NOT
  // IF VALIDE THEN CALCULATE THE SIZE OF THAT BINARY TREE ELSE LEAVE
  // FOR THIS
  // VALIDATION WILL TAKE O(N) FOR A SINGLE NODE
  // AND N NODE ARE THERE MEANS N*(N) WHICH WILL TAKE square of N
  // space complexity : O(h) of node as stack trace
  // Now -------------------------
  // optimal solution
  // we will traverse from the bottom up and check it the left and right child
  // is satisfy the BST condition or not
  // if yes then we will return 1+size of left tree+ size of right tree
  // if not then we will return INT MAX AND INT MIN BASEED ON RQUIEREMENT SO THAT THEY ARE NOT CAME
  // BACK INTO PICTURE
  // WE USE POST ORDER TRAVERSAL AND EACH NODE CONTAIN MIN MAX AND SIZE OF THE TREE

  // own data structure for complex thing
  class NodeValue {
    int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
      this.maxNode = maxNode;
      this.minNode = minNode;
      this.maxNode = maxNode;
    }
  }

  class Solution {
    private class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int x) {
        val = x;
        left = right = null;
      }
    }

    private NodeValue largestBstFromBinarTree(TreeNode root) {
      if (root == null) {
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
      }

      // get values from left and right subtree of current tree
      NodeValue left = largestBstFromBinarTree(root.left);
      NodeValue right = largestBstFromBinarTree(root.right);

      // now we will set the current node value with min, max, size
      // if root value is greater than the
      // its left node and smaller than its right node
      if (left.maxNode < root.val && root.val < right.minNode) {
        // means it is a BST
        return new NodeValue(
            Math.min(root.val, left.minNode),
            Math.max(root.val, right.maxNode),
            left.maxSize + right.maxSize + 1);
      }
      // else it is not BST
      return new NodeValue(
          Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
  }
}
