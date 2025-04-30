package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;
import java.util.*;
public class MergeKSorttedListUsingMinHeap {

  // using minheadp
    public ListNode mergeKLists(ListNode[] lists) {
      // Edge case
      if (lists == null || lists.length == 0) return null;

      // Min-Heap (PriorityQueue) to store nodes in ascending order
      PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

      // Insert all non-null list heads into the minHeap
      for (ListNode list : lists) {
          if (list != null) {
              minHeap.offer(list);
          }
      }

      // Dummy node to build the final sorted list
      ListNode dummy = new ListNode(-1);
      ListNode current = dummy;

      // Process the heap
      while (!minHeap.isEmpty()) {
          // Extract the smallest node
          ListNode minNode = minHeap.poll();
          current.next = minNode;
          current = current.next;

          // If the extracted node has a next node, push it to the heap
          if (minNode.next != null) {
              minHeap.offer(minNode.next);
          }
      }

      return dummy.next; // Return the merged linked list
  }
}
