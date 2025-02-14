package Programming_constructs.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Function to create a new binary tree node having a given key
    public TreeNode(int key) {
        val = key;
        left = right = null;
    }
}

class Main {
    // Iterative function to perform preorder traversal on the tree
    /*public static void preorderIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and print it
            Node curr = stack.pop();

            System.out.print(curr.data + " ");

            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }

            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }*/
    public static ArrayList<Integer> preorderTraversal(TreeNode A) {

        ArrayList<Integer> preOrder = new ArrayList();
        Stack<TreeNode> s = new Stack();

        if (A == null) {
            preOrder.add(-1);

        }
        s.push(A);

        while (!s.empty()) {
            TreeNode temp = s.pop();
//            System.out.println(temp);
            if (temp != null) {
                preOrder.add(temp.val);
                if (A.right != null) {
                    s.push(temp.right);
                }
                if (A.left != null) {
                    s.push(temp.left);
                }
            } else {
                preOrder.add(-1);
            }

        }
        return preOrder;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        ArrayList<Integer> result = preorderTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


         /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
    }
}
