package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import java.util.*;

public class MergeKSorttedListUsingMinHeap {
  /*🔷 Statement:
  You are given an array of k sorted linked lists, each linked list is sorted in ascending order.
  Write a function to merge all the linked lists into one sorted linked list and return its head.
  input --->
      lists = [
        1 -> 4 -> 5,
        1 -> 3 -> 4,
        2 -> 6
      ]
  out put ==> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6


  */
  // using minheadp
  public ListNode mergeKLists(ListNode[] lists) {
    // if lists is empty or null return null
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

  public static void main(String[] args) {
    // Initialize test lists
    ListNode[] lists = new ListNode[3];

    // List 1: 1 -> 4 -> 5
    lists[0] = new ListNode(1);
    lists[0].next = new ListNode(4);
    lists[0].next.next = new ListNode(5);

    // List 2: 1 -> 3 -> 4
    lists[1] = new ListNode(1);
    lists[1].next = new ListNode(3);
    lists[1].next.next = new ListNode(4);

    // List 3: 2 -> 6
    lists[2] = new ListNode(2);
    lists[2].next = new ListNode(6);

    // Merge the lists
    MergeKSorttedListUsingMinHeap merger = new MergeKSorttedListUsingMinHeap();
    ListNode mergedHead = merger.mergeKLists(lists);

    // Print result
    System.out.print("Merged Sorted List: ");
    printList(mergedHead);
  }

  // Utility to print the linked list
  private static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}
