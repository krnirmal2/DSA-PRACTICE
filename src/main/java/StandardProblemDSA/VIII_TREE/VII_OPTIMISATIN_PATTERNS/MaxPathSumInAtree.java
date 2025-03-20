package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

public class MaxPathSumInAtree {
}
// Java program to find maximum path sum in Binary Tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize a new node
    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class GfG {

    // Returns the maximum path sum in the subtree with the current node as an endpoint.
    // Also updates 'res' with the maximum path sum.
    static int maxPathSumUtil(Node root, int[] res) {
        // Base case: return 0 for a null node
        if (root == null) return 0;

        // Calculate maximum path sums for left and right subtrees
        int l = Math.max(0, maxPathSumUtil(root.left, res));
        int r = Math.max(0, maxPathSumUtil(root.right, res));

        // Update 'res' with the maximum path sum passing through the current node
        res[0] = Math.max(res[0], l + r + root.data);

        // Return the maximum path sum rooted at this node
        return root.data + Math.max(l, r);
    }

    // Returns maximum path sum in tree with given root
    static int maxPathSum(Node root) {
        int[] res = {root.data};

        // Compute maximum path sum and store it in 'res'
        maxPathSumUtil(root, res);

        return res[0];
    }

    public static void main(String[] args) {
        // Representation of input binary tree:
        //            10
        //           /  \
        //          2    10
        //         / \     \
        //        20  1    -25
        //                 /  \
        //                3    4
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println(maxPathSum(root));
    }
}

