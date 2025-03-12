package Programming_constructs.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderWithOutRecursion {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public static ArrayList<Integer> preorderTraversal(TreeNode A) {
            ArrayList<Integer> preOrder = new ArrayList();
            Stack<TreeNode> s = new Stack();
            if (A == null) {
                preOrder.add(-1);
            }
            s.push(A);
            while (!s.empty()) {
                TreeNode temp = s.pop();
                preOrder.add(temp.val);
                if (temp.right != null) {
                    s.push(temp.right);
                }
                if (temp.left != null) {
                    s.push(temp.left);
                }
            }

//        }
            return preOrder;
        }

        public static void main(String[] args) {

            TreeNode a = new TreeNode(1);
            a.left = new TreeNode(6);
            a.left.left = new TreeNode(5);
            a.right = new TreeNode(2);
            a.right.right = new TreeNode(4);
            a.right.left = new TreeNode(9);

            ArrayList<Integer> result = preorderTraversal(a);
            System.out.print(result);


        }

    }
}
