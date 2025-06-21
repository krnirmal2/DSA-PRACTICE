package StandardProblemDSA.II_LINKEDLIST;

import StandardProblemDSA.II_LINKEDLIST.i_TRAVERSAL_BASIC_OPERATION.LinkedList;

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

  // Reverse a Linked List (Iterative)
  public static Node reverseNodes(Node head) {
    Node prev = null;
    Node curr = head;

    while (curr != null) {
      Node nextNode = curr.next;
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

    if (checkTwoHalfPalindrome(secondHalf, firstHalf)) return false;

    return true;
  }

  public static boolean checkTwoHalfPalindrome(ListNode secondHalf, ListNode firstHalf) {
    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) return true;
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    return false;
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

  // 2. Recursive Traversal (Print in Reverse Order)
  // Prints the values of a linked list in reverse order using recursion.
  public static void printReverse(ListNode head) {
    if (head == null) return;
    printReverse(head.next);
    System.out.print(head.val + " ");
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

  public static int length(Node head) {
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

  // Recursive Method
  public static ListNode reverseRecursive(ListNode head) {
    // Base case: If list is empty or has only one node
    if (head == null || head.next == null) {
      return head;
    }

    // Recursive call to reverse the rest of the list
    ListNode newHead = reverseRecursive(head.next);

    // Reverse the current node's link
    head.next.next = head;
    head.next = null;

    return newHead; // Return new head
  }

  // Method to print the LinkedList.
  public static void printList(LinkedList list) {
    Node currNode = list.head;

    System.out.print("\nLinkedList: ");

    // Traverse through the LinkedList
    while (currNode != null) {
      // Print the data at current node
      System.out.print(currNode.data + " ");

      // Go to next node
      currNode = currNode.next;
    }
    System.out.println("\n");
  }

  // Utility function to print the list parts
  public static void printParts(Node[] parts) {
    for (Node part : parts) {
      Node temp = part;
      while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
      }
      System.out.println("null");
    }
  }

  public static int countNodes(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  // Print a flattened multilevel linked list.
  public static void printMultiLevelList(MultiLevelNode head) {
    MultiLevelNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) System.out.print(" -> ");
      curr = curr.next;
    }
    System.out.println();
  }

  // Utility method to print a circular linked list starting at a given node.
  public static void printCircularList(Node start) {
    if (start == null) {
      System.out.println("List is empty.");
      return;
    }
    Node curr = start;
    do {
      System.out.print(curr.data + " ");
      curr = curr.next;
    } while (curr != start);
    System.out.println();
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

  public static Node createNewNode(int data) {
    return new Node(data);
  }

  public static void setNewNodeAsHead(LinkedList list, Node new_node) {
    list.head = new_node;
  }

  public static Node traversedTillLastNode(LinkedList list) {
    // Else traverse till the last node
    // and insert the new_node there
    Node temp = list.head;
    while (temp.next != null) {
      temp = temp.next;
    }
    return temp;
  }

  public static void mergeListWithTwoDummyNode(Node posDummy, Node negDummy) {
    Node pos = posDummy.next,
        neg =
            negDummy.next; // actaul starting of both postive and negative as we take dummy earlier

    Node tail = new Node(0); // dummy for merge

    while (pos != null && neg != null) {
      // if positive
      tail.next = pos;
      tail = tail.next;
      pos = pos.next;
      // if negative
      tail.next = neg;
      tail = tail.next;
      neg = neg.next;
    }
    // still remaining eleent
    if (pos != null) tail.next = pos;
    if (neg != null) tail.next = neg;
  }

  public static Node createLinkedListOfSizeK(Node head, int size) {
    for (int i = size; i >= 1; i--) {
      Node newNode = new Node(i);
      newNode.next = head;
      head = newNode;
    }
    return head;
  }

  // Function to get the Kth node from
  // a given position in the linked list
  public static Node getKthNode(Node temp, int k) {
    // Decrement K as we already
    // start from the 1st node
    k -= 1;

    // Decrement K until it reaches
    // the desired position
    while (temp != null && k > 0) {
      // Decrement k as temp progresses
      k--;

      // Move to the next node
      temp = temp.next;
    }

    // Return the Kth node
    return temp;
  }
}
