package StandardProblemDSA.Tree.BST;

public class BST {

    private static Node node;

    public static void createBSTFromPreOrder(int[] pre) {
        //Steps 1. take each element from the preorder
        // steps 2. add new node when we will get null node when left.val<root.data<right.data satisfy

        for (int i = 0; i < pre.length; i++) {
//            Node firstNode = new Node(pre[i]);
            node = createBstUtil(pre[i], node);
        }
//        Node root =
        inorderRec(node);
    }

    private static Node createBstUtil(int currentNodeVal, Node node) {
        // check if the node data is greater or less
        if (node == null) {
            node = new Node(currentNodeVal);
        }

        // decide where we will go
        if (node.val > currentNodeVal) {
            node.left = createBstUtil(currentNodeVal, node);
        }
        // decide where we will go
        if (node.val < currentNodeVal) {
            node.right = createBstUtil(currentNodeVal, node);
        }

        return node;
    }

    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val);
            System.out.print(" ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        //create a binary Search Tree from preOrder
        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        createBSTFromPreOrder(pre);
        //
    }

    public void insertElementInBST() {

    }

    public void deleteElementBST() {

    }

    public void serachElementInBST() {

    }

    public void convertNormalToBST() {

    }

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
