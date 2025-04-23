package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

public class LinkedListSortingOperations {

  // Definition for singly-linked list node.
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // ---------------------------------------------------
  // 1. Merge Sort for Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list, sort the list using merge sort.

    Brute Force Approach:
       - Convert the linked list into an array.
       - Sort the array (e.g., using Arrays.sort).
       - Convert the array back to a linked list.
       - Time: O(n log n) but uses extra space O(n).

    Optimal Approach:
       - Use a recursive merge sort that splits the list in half (using slow/fast pointers),
         recursively sorts each half, then merges them.
       - Time Complexity: O(n log n)
       - Space Complexity: O(log n) due to recursion stack.

    Example:
       Input: 4 -> 2 -> 1 -> 3
       Output: 1 -> 2 -> 3 -> 4
  */
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // Split list into halves
    ListNode mid = getMiddle(head);
    ListNode nextToMid = mid.next;
    mid.next = null; // Break the list

    // Recursively sort the halves
    ListNode left = mergeSort(head);
    ListNode right = mergeSort(nextToMid);

    // Merge sorted halves
    return sortedMerge(left, right);
  }

  // Utility: Get the middle of the list using slow/fast pointers.
  private ListNode getMiddle(ListNode head) {
    if (head == null) return head;
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Utility: Merge two sorted lists.
  private ListNode sortedMerge(ListNode a, ListNode b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }

    if (a.val <= b.val) {
      a.next = sortedMerge(a.next, b);
      return a;
    } else {
      b.next = sortedMerge(a, b.next);
      return b;
    }
  }

  // ---------------------------------------------------
  // 2. Quick Sort for Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list, sort the list using quick sort.

    Brute Force Approach:
       - Convert the list to an array, quick sort the array, then rebuild the list.

    Optimal Approach:
       - Use quick sort in place on the linked list.
       - Partition the list around a pivot, then recursively sort partitions.
       - Time Complexity: Average O(n log n); worst-case O(n^2)
       - Note: In practice, merge sort is often preferred for linked lists.

    Example:
       Input: 3 -> 5 -> 2 -> 4 -> 1
       Output: 1 -> 2 -> 3 -> 4 -> 5
  */
  public ListNode quickSort(ListNode head) {
    return quickSortRec(head, getTail(head));
  }

  // Utility: Get tail of the list.
  private ListNode getTail(ListNode head) {
    while (head != null && head.next != null) {
      head = head.next;
    }
    return head;
  }

  // Utility: Recursively quick sort from head to tail.
  private ListNode quickSortRec(ListNode head, ListNode tail) {
    if (head == null || head == tail) {
      return head;
    }

    ListNode[] partitioned = partition(head, tail);
    ListNode newHead = partitioned[0];
    ListNode pivot = partitioned[1];
    ListNode newTail = partitioned[2];

    // Sort the part before pivot
    if (newHead != pivot) {
      // Find node before pivot
      ListNode temp = newHead;
      while (temp.next != pivot) {
        temp = temp.next;
      }
      temp.next = null;
      newHead = quickSortRec(newHead, temp);
      // Reconnect pivot
      temp = getTail(newHead);
      temp.next = pivot;
    }

    // Sort the part after pivot
    pivot.next = quickSortRec(pivot.next, newTail);
    return newHead;
  }

  // Utility: Partition list using last element as pivot.
  // Returns array: {newHead, pivot, newTail}
  private ListNode[] partition(ListNode head, ListNode tail) {
    ListNode pivot = tail;
    ListNode prev = null, curr = head, end = pivot;
    ListNode newHead = null;

    // During partition, both head and tail might change.
    while (curr != pivot) {
      if (curr.val < pivot.val) {
        if (newHead == null) {
          newHead = curr;
        }
        prev = curr;
        curr = curr.next;
      } else { // Move node to end
        if (prev != null) prev.next = curr.next;
        ListNode temp = curr.next;
        curr.next = null;
        end.next = curr;
        end = curr;
        curr = temp;
      }
    }

    if (newHead == null) {
      newHead = pivot;
    }
    return new ListNode[] {newHead, pivot, end};
  }

  // ---------------------------------------------------
  // 3. Segregate Even and Odd Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Rearrange the linked list so that all even-valued nodes appear before odd-valued nodes.

    Brute Force Approach:
       - Traverse the list, store even and odd nodes in separate arrays/lists,
         then combine them.

    Optimal Approach:
       - Use two dummy nodes to build separate even and odd lists while traversing once,
         then join them.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6
       Output: 8 -> 2 -> 4 -> 6 -> 17 -> 15 -> 9
  */
  public ListNode segregateEvenOdd(ListNode head) {
    if (head == null) return null;
    ListNode evenDummy = new ListNode(0);
    ListNode oddDummy = new ListNode(0);
    ListNode evenTail = evenDummy, oddTail = oddDummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val % 2 == 0) {
        evenTail.next = curr;
        evenTail = evenTail.next;
      } else {
        oddTail.next = curr;
        oddTail = oddTail.next;
      }
      curr = curr.next;
    }
    // Combine even and odd lists.
    oddTail.next = null;
    evenTail.next = oddDummy.next;
    return evenDummy.next;
  }

  // ---------------------------------------------------
  // 4. Rearrange List Alternately (Positive and Negative Nodes)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Rearrange the linked list so that positive and negative numbers alternate.
       The order of appearance should be maintained as in the original list.

    Brute Force Approach:
       - Traverse the list, extract positive and negative nodes into two lists,
         then merge them alternately.

    Optimal Approach:
       - Using two dummy nodes, separate positive and negative nodes while traversing.
       - Merge the two lists by alternately linking nodes.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 1 -> -2 -> 3 -> -4 -> 5 -> -6
       Output: 1 -> -2 -> 3 -> -4 -> 5 -> -6
       (If already alternating, the order remains. If not, adjust accordingly.)
  */
  public ListNode rearrangePosNeg(ListNode head) {
    if (head == null) return null;
    ListNode posDummy = new ListNode(0), negDummy = new ListNode(0);
    ListNode posTail = posDummy, negTail = negDummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val >= 0) {
        posTail.next = curr;
        posTail = posTail.next;
      } else {
        negTail.next = curr;
        negTail = negTail.next;
      }
      curr = curr.next;
    }
    // End the lists.
    posTail.next = null;
    negTail.next = null;

    // Merge alternately: choose the list that comes first in original order.
    ListNode newHead = posDummy.next != null ? posDummy.next : negDummy.next;
    ListNode pos = posDummy.next, neg = negDummy.next;
    ListNode tail = new ListNode(0); // dummy for merge

    while (pos != null && neg != null) {
      tail.next = pos;
      tail = tail.next;
      pos = pos.next;

      tail.next = neg;
      tail = tail.next;
      neg = neg.next;
    }
    if (pos != null) tail.next = pos;
    if (neg != null) tail.next = neg;

    return newHead;
  }

  // ---------------------------------------------------
  // 5. Partition Linked List Around a Value
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a linked list and a value x, partition it such that all nodes less than x
       come before nodes greater than or equal to x. The original relative order should be preserved.

    Brute Force Approach:
       - Convert list to an array, partition the array, then rebuild the list.

    Optimal Approach:
       - Use two dummy nodes: one for nodes less than x, another for nodes greater or equal.
       - Traverse the list, appending nodes to the appropriate list.
       - Merge the two lists.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
       Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
  */
  public ListNode partitionAroundValue(ListNode head, int x) {
    ListNode beforeDummy = new ListNode(0);
    ListNode afterDummy = new ListNode(0);
    ListNode before = beforeDummy, after = afterDummy;

    while (head != null) {
      if (head.val < x) {
        before.next = head;
        before = before.next;
      } else {
        after.next = head;
        after = after.next;
      }
      head = head.next;
    }
    after.next = null;
    before.next = afterDummy.next;
    return beforeDummy.next;
  }

  // ---------------------------------------------------
  // Utility Method: Print the linked list.
  // ---------------------------------------------------
  public void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) System.out.print(" -> ");
      curr = curr.next;
    }
    System.out.println();
  }

  // ---------------------------------------------------
  // Main method for demonstration of each functionality.
  // ---------------------------------------------------
  public static void main(String[] args) {
    LinkedListSortingOperations ops = new LinkedListSortingOperations();

    // Example for Merge Sort:
    // Build unsorted list: 4 -> 2 -> 1 -> 3
    ListNode mergeHead = ops.new ListNode(4);
    mergeHead.next = ops.new ListNode(2);
    mergeHead.next.next = ops.new ListNode(1);
    mergeHead.next.next.next = ops.new ListNode(3);
    System.out.println("Original List for Merge Sort:");
    ops.printList(mergeHead);
    ListNode sortedMerge = ops.mergeSort(mergeHead);
    System.out.println("Sorted List using Merge Sort:");
    ops.printList(sortedMerge);

    // Example for Quick Sort:
    // Build unsorted list: 3 -> 5 -> 2 -> 4 -> 1
    ListNode quickHead = ops.new ListNode(3);
    quickHead.next = ops.new ListNode(5);
    quickHead.next.next = ops.new ListNode(2);
    quickHead.next.next.next = ops.new ListNode(4);
    quickHead.next.next.next.next = ops.new ListNode(1);
    System.out.println("Original List for Quick Sort:");
    ops.printList(quickHead);
    ListNode sortedQuick = ops.quickSort(quickHead);
    System.out.println("Sorted List using Quick Sort:");
    ops.printList(sortedQuick);

    // Example for Segregate Even and Odd Nodes:
    // Build list: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6
    ListNode evenOddHead = ops.new ListNode(17);
    evenOddHead.next = ops.new ListNode(15);
    evenOddHead.next.next = ops.new ListNode(8);
    evenOddHead.next.next.next = ops.new ListNode(9);
    evenOddHead.next.next.next.next = ops.new ListNode(2);
    evenOddHead.next.next.next.next.next = ops.new ListNode(4);
    evenOddHead.next.next.next.next.next.next = ops.new ListNode(6);
    System.out.println("Original List for Even/Odd Segregation:");
    ops.printList(evenOddHead);
    ListNode segregatedList = ops.segregateEvenOdd(evenOddHead);
    System.out.println("List after segregating Even and Odd Nodes:");
    ops.printList(segregatedList);

    // Example for Rearranging Alternately (Positive and Negative):
    // Build list: 1 -> -2 -> 3 -> -4 -> 5 -> -6
    ListNode posNegHead = ops.new ListNode(1);
    posNegHead.next = ops.new ListNode(-2);
    posNegHead.next.next = ops.new ListNode(3);
    posNegHead.next.next.next = ops.new ListNode(-4);
    posNegHead.next.next.next.next = ops.new ListNode(5);
    posNegHead.next.next.next.next.next = ops.new ListNode(-6);
    System.out.println("Original List for Positive/Negative Rearrangement:");
    ops.printList(posNegHead);
    ListNode rearrangedList = ops.rearrangePosNeg(posNegHead);
    System.out.println("List after alternating Positive and Negative Nodes:");
    ops.printList(rearrangedList);

    // Example for Partition Around a Value:
    // Build list: 1 -> 4 -> 3 -> 2 -> 5 -> 2, with x = 3
    ListNode partitionHead = ops.new ListNode(1);
    partitionHead.next = ops.new ListNode(4);
    partitionHead.next.next = ops.new ListNode(3);
    partitionHead.next.next.next = ops.new ListNode(2);
    partitionHead.next.next.next.next = ops.new ListNode(5);
    partitionHead.next.next.next.next.next = ops.new ListNode(2);
    System.out.println("Original List for Partitioning:");
    ops.printList(partitionHead);
    ListNode partitionedList = ops.partitionAroundValue(partitionHead, 3);
    System.out.println("List after Partitioning around value 3:");
    ops.printList(partitionedList);
  }
}
