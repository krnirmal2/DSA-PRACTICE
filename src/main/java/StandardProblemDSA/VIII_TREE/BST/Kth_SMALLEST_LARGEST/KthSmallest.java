package StandardProblemDSA.VIII_TREE.BST.Kth_SMALLEST_LARGEST;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallest {
  /*
  Problem: Find the kth smallest element in a Binary Search Tree (BST).


  Pattern:
      - BST property + in-order traversal (left → root → right)
      - Uses stack to simulate recursion.

  Similar LeetCode Problems:
      - 230. Kth Smallest Element in a BST
      - 173. Binary Search Tree Iterator (same concept with `hasNext()` and `next()`)

  Time Complexity:
      - O(h + k), where h = height of BST.
        We traverse down to the leftmost node and pop k nodes.
      - Worst case: O(n) in a skewed tree.

  Space Complexity:
      - O(h) for the stack.
        O(log n) in a balanced BST, O(n) in a skewed BST.

  Follow-up Questions:
      - How to support multiple kth queries efficiently?
        → Augment each node with the size of its left subtree.
      - Can this be converted to find kth largest?
        → Yes, use reverse in-order traversal (right → root → left).
  */
  /* Approach:
        - Iterative in-order traversal using a stack.
        - In-order traversal of a BST visits nodes in ascending order.
        - Push all left nodes, pop and decrement k each time.
        - When k == 0, the current node is the kth smallest.
  */
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    Set<Integer> set = new HashSet<>();

    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // only add this to inorder to get the kthsmallest element
      k--;
      if (k == 0) return root.val;
      root = root.right;
    }
  }
}
