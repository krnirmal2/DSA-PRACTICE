package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class IsFullTree {
    public static boolean isFull(TreeNode root) {
        if (root == null) return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;
        return isFull(root.left) && isFull(root.right);
    }
}
