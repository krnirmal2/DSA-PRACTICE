package StandardProblemDSA.II_LINKEDLIST;

public class Utility_linkedList {
  // Reverse a Linked List (Iterative)
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextNode;
    }

    return prev;
  }

  // Reverse a Linked List (Recursive)
  public static ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode newHead = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
  }

  // Find the Middle Node (Slow & Fast Pointer)
  public static ListNode findMiddle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  // Detect Cycle in a Linked List
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }

    return false;
  }

  // Find the Start of a Cycle
  public static ListNode detectCycleStart(ListNode head) {
    ListNode slow = head, fast = head, entry = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        while (entry != slow) {
          entry = entry.next;
          slow = slow.next;
        }
        return entry;
      }
    }

    return null;
  }

  // Merge Two Sorted Linked Lists
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  // Remove N-th Node from End
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }

  // Check if a Linked List is Palindrome
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode middle = findMiddle(head);
    ListNode secondHalf = reverseList(middle);
    ListNode firstHalf = head;

    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) return false;
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }

    return true;
  }

  // Find Intersection of Two Linked Lists
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode a = headA, b = headB;

    while (a != b) {
      a = (a == null) ? headB : a.next;
      b = (b == null) ? headA : b.next;
    }

    return a;
  }

  // Print Linked List
  public static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
    }
    System.out.println("NULL");
  }

  // Convert Array to Linked List
  public static ListNode arrayToLinkedList(int[] arr) {
    if (arr == null || arr.length == 0) return null;

    ListNode head = new ListNode(arr[0]);
    ListNode current = head;

    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }

    return head;
  }

  // Utility: Partition list using last element as pivot.
  // Returns array: {newHead, pivot, newTail}
  public static ListNode[] partition(ListNode head, ListNode tail) {
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

  // Utility: Get tail of the list.
  public static ListNode getTail(ListNode head) {
    while (head != null && head.next != null) {
      head = head.next;
    }
    return head;
  }

  public static void printList(Node curr) {
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
  }


  public static int length(StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL.ListNode head) {
    if (head == null) {
      return 0;
    }
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode head = Utility_linkedList.arrayToLinkedList(arr);

    System.out.println("Original List:");
    Utility_linkedList.printList(head);

    // Reverse Linked List
    head = Utility_linkedList.reverseList(head);
    System.out.println("Reversed List:");
    Utility_linkedList.printList(head);

    // Find Middle Node
    ListNode middle = Utility_linkedList.findMiddle(head);
    System.out.println("Middle Node: " + middle.val);

    // Check for Cycle
    System.out.println("Has Cycle? " + Utility_linkedList.hasCycle(head));
  }
}
