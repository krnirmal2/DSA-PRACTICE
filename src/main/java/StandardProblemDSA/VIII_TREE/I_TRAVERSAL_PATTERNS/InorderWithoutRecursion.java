package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.Stack;

public class InorderWithoutRecursion {
  /*
    (Left → Root → Right)
            🔹 Steps:
    Push all left nodes to stack.
    Process top node (print/store).
    Move to right child and repeat.
  */

  public static void inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) { // Push all left nodes
        stack.push(current);
        current = current.left;
      }

      current = stack.pop(); // Process node
      System.out.print(current.val + " ");

      current = current.right; // Move to right child
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    inorderTraversal(root);
  }
} /*
  🔹 Dry Run
    Stack	Current Node	Output
  [1]	2	-
          [1, 2]	4	-
          [1, 2, 4]	null	4
          [1, 2]	null	2
          [1]	5	5
          [1]	null	1
          []	3	3
          [3]	null	6
          🔹 Output
            Copy
    Edit
  4 2 5 1 3 6*/

/*
Method 1: Using one stack and the binary tree node will be changed. Easy ,not Practical

*/
/**
 * Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *
 * <p>Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *//*

           vector < int > Solution::inorderTraversal(TreeNode * root) {
           vector < int > vector;
           if (!root)
           return vector;
           stack < TreeNode * > stack;
           stack.push(root);
           while (!stack.empty()) {
           TreeNode * pNode = stack.top();
           if (pNode -> left) {
           stack.push(pNode -> left);
           pNode -> left = NULL;
           } else {
           vector.push_back(pNode -> val);
           stack.pop();
           if (pNode -> right)
           stack.push(pNode -> right);
           }
           }
           return vector;
           }
           Method 2: Using one stack and one unordered_map, this will not changed the node. Better

   */
/**
 * Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *//*

           vector < int > Solution::inorderTraversal(TreeNode * root) {
           vector < int > vector;
           if (!root)
           return vector;
           unordered_map < TreeNode * , bool > map; //left child has been visited:true.
           stack < TreeNode * > stack;
           stack.push(root);
           while (!stack.empty()) {
           TreeNode * pNode = stack.top();
           if (pNode -> left && !map[pNode]) {
           stack.push(pNode -> left);
           map[pNode] = true;
           } else {
           vector.push_back(pNode -> val);
           stack.pop();
           if (pNode -> right)
           stack.push(pNode -> right);
           }
           }
           return vector;
           }
           Method 3: Using one stack and will not changed the node. Best(at least in this three solutions)

   */
/**
 * Definition for binary tree struct TreeNode { int val; TreeNode *left; TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {} };
 *//*

          vector < int > Solution::inorderTraversal(TreeNode * root) {
          vector < int > vector;
          stack < TreeNode * > stack;
          TreeNode * pCurrent = root;

          while (!stack.empty() || pCurrent) {
          if (pCurrent) {
          stack.push(pCurrent);
          pCurrent = pCurrent -> left;
          } else {
          TreeNode * pNode = stack.top();
          vector.push_back(pNode -> val);
          stack.pop();
          pCurrent = pNode -> right;
          }
          }
          return vector;
          }

   */
