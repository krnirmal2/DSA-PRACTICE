package StandardProblemDSA.II_LINKEDLIST;

// Definition for a multilevel linked list node.
// Here, each node has a 'next' pointer and may have a 'child' pointer.
public class MultiLevelNode {
  public int val;
  public MultiLevelNode next;
  public MultiLevelNode child;

  public MultiLevelNode(int x) {
    val = x;
    next = null;
    child = null;
  }

  // Utility method to print a flattened multilevel linked list.
  public static void printMultiLevelList(MultiLevelNode head) {
    MultiLevelNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) {
        System.out.print(" -> ");
      }
      curr = curr.next;
    }
    System.out.println();
  }
}
