package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class LinkedListCycleRemoval {

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
