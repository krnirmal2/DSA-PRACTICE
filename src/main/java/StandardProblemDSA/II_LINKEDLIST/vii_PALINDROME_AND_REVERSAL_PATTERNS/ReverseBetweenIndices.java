package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class ReverseBetweenIndices {

  // ---------------------------------------------------
  // 2. Reverse Linked List Between Two Indices
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list and two integers m and n (1-indexed), reverse the nodes from position m to n.

    Brute Force Idea:
       - Convert the list to an array, reverse the portion between m and n, and rebuild the list.

    Optimal Approach:
       - Traverse the list to the (m-1)th node, reverse the next (n-m+1) nodes, then reconnect the reversed sublist back.
       - Time Complexity: O(n)

    Example:
       Input: 1 -> 2 -> 3 -> 4 -> 5, m = 2, n = 4
       Output: 1 -> 4 -> 3 -> 2 -> 5
  */
  public static Node reverseBetween(Node head, int m, int n) {
    if (head == null || m == n) return head;

    // Create a dummy node to handle edge cases (e.g., m = 1).
    Node dummy = Utility_linkedList.createNewNode(0);
    dummy.next = head;
    Node prev = dummy;

    // Move prev to the node just before reversal start (position m-1).
    for (int i = 1; i < m; i++) {
      prev = prev.next;
    }

    // Reverse sublist from m to n.
    Node reverseStart = prev.next;
    Node current = reverseStart;
    Node next = null;
    for (int i = m; i <= n; i++) {
      next = current.next;
      current.next = prev.next;
      prev.next = current;
      current = next;
    }

    // Connect the end of reversed part to the remainder of the list.
    reverseStart.next = current;
    return dummy.next;
  }

  public static void main(String[] args) {
    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    Node head = new Node(1);
    Node current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new Node(i);
      current = current.next;
    }
    // 2. Reverse Linked List Between Two Indices (m = 2, n = 6)
    // Rebuild list for clarity.
    head = new Node(1);
    current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new Node(i);
      current = current.next;
    }
    System.out.println("Original List:");

    printList(head);
    Node reversedBetween = reverseBetween(head, 2, 6);
    System.out.println("After Reversing Between Positions 2 and 6:");
    printList(reversedBetween);
    // Expected Output: 1 -> 6 -> 5 -> 4 -> 3 -> 2 -> 7 -> 8 -> 9

  }
}
