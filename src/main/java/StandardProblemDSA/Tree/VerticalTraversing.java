package StandardProblemDSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalTraversing {


    // A utility function to find min and max
    // distances with respect to root.
    static void findMinMax(Nodes node, int[] minMax, int hd) {

        // Base case
        if (node == null) return;

        // Update min and max
        if (hd < minMax[0]) minMax[0] = hd;
        else if (hd > minMax[1]) minMax[1] = hd;

        // Recur for left and right subtrees
        findMinMax(node.left, minMax, hd - 1);
        findMinMax(node.right, minMax, hd + 1);
    }

    // A utility function to collect all
    // nodes on a given vertical line_no.
    static void collectVerticalLine(Nodes node, int lineNo,
                                    int hd, List<Integer> result) {
        // Base case
        if (node == null) return;

        // If this node is on the given vertical line
        if (hd == lineNo) result.add(node.data);

        // Recur for left and right subtrees
        collectVerticalLine(node.left, lineNo, hd - 1, result);
        collectVerticalLine(node.right, lineNo, hd + 1, result);
    }

    // The main function that returns a list of nodes
    // in vertical order
    static List<Integer> verticalOrder(Nodes root) {
        List<Integer> result = new ArrayList<>();

        // Find min and max distances with respect to root
        int[] minMax = new int[]{0, 0};
        findMinMax(root, minMax, 0);

        // Iterate through all possible vertical
        // lines from leftmost to rightmost
        for (int lineNo = minMax[0]; lineNo <= minMax[1]; lineNo++) {
            collectVerticalLine(root, lineNo, 0, result);
        }

        return result;
    }

    public static void main(String[] args) {

        // Create binary tree
        //            1
        //          /   \
        //         2     3
        //        / \   / \
        //       4   5 6   7
        //              \   \
        //               8   9

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);
        root.right.left.right = new Nodes(8);
        root.right.right.right = new Nodes(9);

        List<Integer> result = verticalOrder(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

class Nodes {
    int data;
    StandardProblemDSA.Tree.Nodes left, right;

    Nodes(int x) {
        data = x;
        left = null;
        right = null;
    }
}