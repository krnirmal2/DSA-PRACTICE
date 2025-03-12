package Programming_constructs.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class InorderWithoutRecursion {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public static ArrayList<Integer> InorderTraversal(TreeNode A) {
            ArrayList<Integer> inorder = new ArrayList();
            Stack<TreeNode> s = new Stack();

            if (A == null) {
                inorder.add(-1);

            }

            TreeNode temp = A;
            while (!s.empty() || temp != null) {

                if (temp != null) {
                    s.push(temp);
                    temp = temp.left;
                } else {
                    temp = s.pop();
                    inorder.add(temp.val);
                    temp = temp.right;
                }


            }
            return inorder;
        }

        public static void main(String[] args) {

            TreeNode a = new TreeNode(1);
            a.left = new TreeNode(6);
            a.left.left = new TreeNode(5);
            a.right = new TreeNode(2);
            a.right.right = new TreeNode(4);
            a.right.left = new TreeNode(9);

            ArrayList<Integer> result = InorderTraversal(a);
            System.out.print(result);


        }

    }
}


/*
Method 1: Using one stack and the binary tree node will be changed. Easy ,not Practical

*/
/**
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * <p>
 * Definition for binary tree
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
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
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
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
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
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
