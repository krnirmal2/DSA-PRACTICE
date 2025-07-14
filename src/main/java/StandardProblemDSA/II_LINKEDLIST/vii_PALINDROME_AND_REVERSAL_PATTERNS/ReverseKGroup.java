package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

class Main {
  /*
  1. Initialize Pointers
      temp → points to the start of the current group
      prevLast → keeps track of the last node of the previous reversed group
      head → update this if the first group is reversed

  2. Loop Through the List While temp != null
      For each group:
      🔹 a. Find the k-th node
          Use a helper like getKthNode(temp, k)
          If kThNode == null, there are fewer than k nodes left → skip reversal or leave as-is
      🔹 b. Cut the Sublist
          Store kThNode.next as nextNode
          Set kThNode.next = null to isolate the group
      🔹 c. Reverse the Isolated Group
          Use standard reversal (reverseNodes(temp)), which flips .next pointers within the isolated group
      🔹 d. Re-link the Reversed Group
          If it's the first group, update head = kThNode
          Else, connect previous group: prevLast.next = kThNode
      🔹 e. Update prevLast
          After reversal, the original group head (temp) becomes the tail → update prevLast = temp
      🔹 f. Move temp to nextNode
  This begins the next group*/
  // Function to reverse nodes in groups of K
  static Node kReverse(Node head, int k) {
    // Step 1: Initialize a temporary
    // node to traverse the list
    Node temp = head;

    // Step 2: Initialize a pointer to track the
    // last node of the previous group
    Node prevLast = null;

    while (temp != null) {

      // Step 3:   Get the Kth node of the current group
      // by sending the head node each time , as temp holding the head node of the
      // next group
      Node kThNode = Utility_linkedList.getKthNode(temp, k);

      // Step 4:  If the Kth node is NULL means less then k no. of nodes in the last group
      // (not a complete group) → skip reversal or leave as-is
      if (kThNode == null) {

        // If there was a previous group,
        // link the last node to the current node
        if (prevLast != null) {
          prevLast.next = temp;
        }

        // Exit the loop
        break;
      }
      // 5 → 4 → 3 → 7 → 9 → 2
      // Step 5: Store the next node
      // after the Kth node for attach the reversed node to it
      Node nextNode = kThNode.next;

      // Disconnect the Kth node
      // to prepare for reversal
      kThNode.next = null;

      // Step 6: Reverse the nodes from
      // temp to the Kth node
      Utility_linkedList.reverseNodes(temp);

      // Step 7: After reversed of the group done
      // Adjust the head if the reversal
      // starts from the head
      if (temp == head) {
        head = kThNode; // update this if the first group is reversed
      } else {
        // Link the last node of the previous
        // group to the reversed group
        prevLast.next = kThNode;
      }

      // Step 8: Update the pointer to the
      // last node of the previous group
      prevLast = temp;

      // Move to the next group
      temp = nextNode;
    }

    // Return the head of the
    // modified linked list
    return head;
  }

  /*
  ## 🔢 Input:
  Linked List: 5 → 4 → 3 → 7 → 9 → 2
  k = 2
  4 → 5 → 7 → 3 → 2 → 9

  ## 📊 Dry Run Table:

  | Step | temp starts at | getKthNode(k=2) | nextNode | Reverse   | prevLast → next | Update prevLast | Move temp   |
  | ---- | -------------- | --------------- | -------- | --------- | --------------- | --------------- | ----------- |
  | 1    | 5              | 4               | 3        | 5→4 → 4→5 | head = 4        | prevLast = 5    | temp = 3    |
  | 2    | 3              | 7               | 9        | 3→7 → 7→3 | 5.next = 7      | prevLast = 3    | temp = 9    |
  | 3    | 9              | 2               | null     | 9→2 → 2→9 | 3.next = 2      | prevLast = 9    | temp = null |

  ## 🔁 Step-by-Step Breakdown
  ### 🔹 Step 1:

  * `temp = 5`
  * `kThNode = 4`
  * `nextNode = 3`

  Disconnect: `4.next = null`
  Reverse: `5 → 4` → becomes `4 → 5`
  Link:
  * Since it's first group: `head = 4`
  * `prevLast = 5`

  Move: `temp = 3`
  ### 🔹 Step 2:

  * `temp = 3`
  * `kThNode = 7`
  * `nextNode = 9`

  Disconnect: `7.next = null`
  Reverse: `3 → 7` → becomes `7 → 3`
  Link:

  * `prevLast.next = 7`
  * `prevLast = 3`

  Move: `temp = 9`
  ### 🔹 Step 3:

  * `temp = 9`
  * `kThNode = 2`
  * `nextNode = null`

  Disconnect: `2.next = null`
  Reverse: `9 → 2` → becomes `2 → 9`
  Link:

  * `prevLast.next = 2`
  * `prevLast = 9`

  Move: `temp = null` → loop ends

  ---

  ## ✅ Final Result:

  ```text
  4 → 5 → 7 → 3 → 2 → 9
  ```

  ---

  ## 🧠 Summary of Links:

  * `head = 4`
  * 4 → 5
  * 5 → 7
  * 7 → 3
  * 3 → 2
  * 2 → 9
  * 9 → null
  */
  public static void main(String[] args) {
    // Create a linked list with
    // values 5, 4, 3, 7, 9 and 2
    Node head = new Node(5);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(7);
    head.next.next.next.next = new Node(9);
    head.next.next.next.next.next = new Node(2);

    // Print the original linked list
    System.out.print("Original Linked List: ");
    printList(head);

    // Reverse the linked list
    head = kReverse(head, 2);

    // Print the reversed linked list
    System.out.print("Reversed Linked List: ");
    printList(head);
  }
}
