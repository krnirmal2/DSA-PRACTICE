package StandardProblemDSA.VIII_TREE;

// ---------------------------------------------------
// Helper class to hold a tree node and its horizontal distance (hd).
// ---------------------------------------------------
public class Pair {
  public TreeNode node;
  public int hd;

  public Pair(TreeNode node, int hd) {
    this.node = node;
    this.hd = hd;
  }
}
