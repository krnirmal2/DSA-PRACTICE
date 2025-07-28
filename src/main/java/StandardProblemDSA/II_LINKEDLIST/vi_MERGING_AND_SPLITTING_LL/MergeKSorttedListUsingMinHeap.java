package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

import java.util.PriorityQueue;

public class MergeKSorttedListUsingMinHeap {
  /*
  Problem: Merge K Sorted Linked Lists using Min-Heap
  ---------------------------------------------------
  You are given an array of `k` sorted linked lists. Merge all lists into one sorted linked list.

  Approach:
  ---------
  1. **Use Min-Heap (PriorityQueue)**:
     - Insert the head of each non-null list into a min-heap, sorted by node value.
     - Repeatedly extract the smallest node, attach it to the merged list, and push its `next` into the heap.

  2. **Dummy Node**:
     - Use a dummy node to simplify handling the head of the merged list.

  3. **Continue until heap is empty**:
     - Every time we poll from the heap, we attach the smallest node to our merged list.

  Time Complexity:
  - Building the heap: `O(k)` (k = number of lists)
  - Extracting & inserting each of `N` nodes: `O(N log k)`
  - Total: **O(N log k)**

  Space Complexity:
  - Min-Heap stores up to `k` nodes: **O(k)**.

  Example:
  --------
  Input: [
    1 → 4 → 5,
    1 → 3 → 4,
    2 → 6
  ]
  Output: 1 → 1 → 2 → 3 → 4 → 4 → 5 → 6

  Follow-ups:
  -----------
  - Can we do this without extra heap space? → Yes, using Divide & Conquer: merge lists in pairs.
  - LeetCode Reference: **LeetCode 23** (Merge k Sorted Lists)
  */

  // using minheadp
  public ListNode mergeKLists(ListNode[] lists) {
    // if lists is empty or null return null
    if (lists == null || lists.length == 0) return null;

    // Step1:  Min-Heap (PriorityQueue) to store nodes in ascending order
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

    // Step 2: Insert all non-null list heads into the minHeap
    for (ListNode list : lists) {
      if (list != null) {
        minHeap.offer(list);
      }
    }

    // step 3: Dummy node to build the final sorted list
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;

    // Process the heap
    while (!minHeap.isEmpty()) {
      // Step %: Extract the smallest node
      ListNode minNode = minHeap.poll();
      // step 5 : chain the list using current till minheap doesn't got empty
      current.next = minNode;
      current = current.next;

      // If the extracted node has a next node, push it to the heap
      if (minNode.next != null) {
        // push the node to minheap next to minheap again which create again that no. of list
        // and compare there first node out of each list of nodes and sort acc.
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
