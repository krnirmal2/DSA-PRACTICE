package StandardProblemDSA.VIII_TREE.BST;

import static StandardProblemDSA.VIII_TREE.BST.BSTutility.*;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class BST {
  private TreeNode root;

  public BST() {
    this.root = null;
  }

  // NOTE : CRUD OPERATION IN BST
  // Method to construct BST from pre-order traversal
  public void constructBST(int[] preOrder) {
    root = constructBSTUtil(preOrder, 0, preOrder.length - 1);
  }

  // Method to search for a node in BST
  public boolean search(int val) {
    return searchRecursiveBST(root, val);
  }

  // Method to insert a node in BST
  public void insert(int val) {
    root = insertRecursiveBST(root, val);
  }

  // Method to delete a node in BST
  public void delete(int val) {
    root = deleteRecursiveBst(root, val);
  }

  // Method to print inorder traversal of BST
  public void inorder() {
    inorderRecursive(root);
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
}
