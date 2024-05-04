package StandardProblemDSA.Tree.BST;

import StandardProblemDSA.Tree.TreeNode;

public class BST {
/*
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
    }*/

    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        bst.constructBST(preOrder);

        System.out.println("Inorder traversal:");
        bst.inorder();

        int key = 7;
        if (bst.search(key)) {
            System.out.println(key + " found in the tree");
        } else {
            System.out.println(key + " not found in the tree");
        }

        System.out.println("Inserting 20 into the tree");
        bst.insert(20);
        bst.inorder();

        System.out.println("Deleting 40 from the tree");
        bst.delete(40);
        bst.inorder();
    }

    // Method to construct BST from pre-order traversal
    public void constructBST(int[] preOrder) {
        root = constructBSTUtil(preOrder, 0, preOrder.length - 1);
    }

    private TreeNode constructBSTUtil(int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preOrder[i] > node.val) {
                break;
            }
        }

        node.left = constructBSTUtil(preOrder, start + 1, i - 1);
        node.right = constructBSTUtil(preOrder, i, end);

        return node;
    }

    // Method to search for a node in BST
    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        } else if (val < root.val) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }

    // Method to insert a node in BST
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        return root;
    }

    // Method to delete a node in BST
    public void delete(int val) {
        root = deleteRecursive(root, val);
    }

    private TreeNode deleteRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRecursive(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = minValue(root.right);
            root.right = deleteRecursive(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    // Method to print inorder traversal of BST
    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }

}
