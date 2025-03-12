package StandardProblemDSA.LINKEDLIST.MERGING_AND_SPLITTING_LL;

public class MergeKSorttedListUsingMinHeap {
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Merge the two lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining elements from either list
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // Returning merged list head
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) return null;

        // Initialize resultList as the first list
        ListNode resultList = lists[0];

        // Iterate over the rest of the lists
        for (int i = 1; i < lists.length; i++) {
            resultList = mergeTwoSortedList(resultList, lists[i]);
        }

        return resultList;
    }


    //using minheadp
  /*  public ListNode mergeKLists(ListNode[] lists) {
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
    }*/
}
