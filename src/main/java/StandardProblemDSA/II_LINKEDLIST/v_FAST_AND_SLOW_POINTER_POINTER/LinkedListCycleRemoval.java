package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.Node;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class LinkedListCycleRemoval {
  /*
  Problem: Detect and Remove a Loop in a Linked List
  --------------------------------------------------
  Problem Statement:
  Given the head of a singly linked list, detect if a loop exists.
  If a loop is found, remove it and restore the list to a proper singly linked list.

  Approach:
  ---------
  1. **Detect Cycle (Floyd’s Tortoise and Hare)**:
     - Use two pointers `slow` and `fast`.
     - Move `slow` by one and `fast` by two steps.
     - If they meet, a cycle exists.

  2. **Find Start of Loop**:
     - Reset `slow` to `head`.
     - Move both `slow` and `fast` one step at a time until they meet again.
     - Meeting point is the start of the loop.

  3. **Find Last Node in Loop & Break It**:
     - Keep moving `fast` until `fast.next` points to the start node of the loop.
     - Set `fast.next = null` to remove the loop.

  4. **Utility Method `createLoop`**:
     - For testing, links the last node of the list to the node at the given position.

  Time Complexity:
  - **O(n)** — Each pointer traverses the list at most twice.
  Space Complexity:
  - **O(1)** — No extra data structures used.

  Example:
  --------
  Input: 1 → 2 → 3 → 4 → 5 ↘
                       ↑----↙
  Output: 1 → 2 → 3 → 4 → 5 → null

  Edge Cases:
  -----------
  - Empty list (`head = null`) → No action.
  - No cycle present → List remains unchanged.
  - Cycle starting at head.

  Follow-up:
  ----------
  - LeetCode 142: **Linked List Cycle II** (Find the node where the cycle begins).
  - LeetCode 141: **Linked List Cycle** (Detect if a cycle exists).
  */

  // Function to detect and remove the loop
  public static void removeLoop(Node head) {
    if (head == null || head.next == null) return;

    Node slow = head;
    Node fast = head;

    // Step 1: Detect the cycle using Floyd's Algorithm
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      // Cycle detected
      if (slow == fast) {
        break;
      }
    }

    // If no cycle is found, return
    if (fast == null || fast.next == null) {
      return;
    }

    // Step 2: Find the start of the loop
    slow = head;
    while (slow
        != fast) { // here fast is acting as meeting point to find the start point of the loop
      slow = slow.next;
      fast = fast.next;
    }

    /* Now `slow` is pointing to the start of the loop
    1 → 2 → 3 → 4 → 5
              ↑     ↓
              ←←←←←←
    1 → 2 → 3 → 4 → 5 → null

          */

    // Step 3: Find Last Node in Cycle & Break the Loop
    Node loopNode = slow;
    while (fast.next != loopNode) {
      fast = fast.next; // it will reach the last node of the loop
    }

    // Break the loop just remove the link or set the next link of fast pointer
    fast.next = null;
  }

  // Utility function to create a loop in the linked list for testing
  public static void createLoop(Node head, int position) {
    if (head == null || position <= 0) return;

    Node temp = head;
    Node loopNode = null;
    int count = 1;

    while (temp.next != null) {
      if (count == position) {
        loopNode = temp;
      }
      temp = temp.next;
      count++;
    }

    // Create the loop
    if (loopNode != null) {
      temp.next = loopNode;
    }
    // 💡 Efficient (O(n) time, O(1) space).
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    // Create a loop for testing
    createLoop(head, 3);

    // Remove the loop
    removeLoop(head);

    // Print the modified linked list
    printList(head);
  }
}
