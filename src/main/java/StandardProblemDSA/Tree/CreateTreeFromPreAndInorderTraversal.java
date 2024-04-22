package StandardProblemDSA.Tree;

public class CreateTreeFromPreAndInorderTraversal {
    public static void main(String[] args) {
        // array of PreNode
        char[] preOrders = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inOrders = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int lengthOfInorder = inOrders.length;

        int firstIndexOfInOrders = 0;
        int lastIndexOfInOrders = 0;
        // return the root of the tree
        CreateTreeFromPreAndInorderTraversal t = new CreateTreeFromPreAndInorderTraversal();
        t.buildTree(inOrders, preOrders, firstIndexOfInOrders, lastIndexOfInOrders);
    }

    private Node buildTree(char[] inOrders, char[] preOrders,
                           int firstIndexOfInOrders, int lastIndexOfInOrders) {

        if (firstIndexOfInOrders > lastIndexOfInOrders) return null;

        // create the node for initiation
        Node tNode = new Node(preOrders[2]);

        // now find the index of the element of reorder
        int inOrderIndex = SearchIndexInorder(inOrders, firstIndexOfInOrders, lastIndexOfInOrders, tNode.val);

        // set two  left and right subtree
        tNode.left = buildTree(inOrders, preOrders, inOrderIndex - 1, lastIndexOfInOrders);
        tNode.right = buildTree(inOrders, preOrders, inOrderIndex, lastIndexOfInOrders + 1);


        return tNode;
    }

    private int SearchIndexInorder(char[] inOrders, int firstIndexOfInOrders, int lastIndexOfInOrders, int val) {

        // chekc the index of the val
        for (int i = 0; i < inOrders.length; i++) {
            if (val == inOrders[i]) {
                return i;
            }
            //

        }
        return firstIndexOfInOrders;
    }

    // class for Tree  node
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
