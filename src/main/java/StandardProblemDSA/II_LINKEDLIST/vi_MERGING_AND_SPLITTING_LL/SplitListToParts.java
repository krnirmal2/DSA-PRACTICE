package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printParts;

public class SplitListToParts {
  /*
  Problem: Split Linked List into k Parts
  ----------------------------------------
  Given the head of a linked list and an integer `k`, split the list into `k` consecutive parts.
  Each part should have lengths as equal as possible.
  If `n % k != 0`, then the first `n % k` parts have one extra node each.

  Approach:
  ---------
  1. **Calculate length** of the linked list (`n`).
  2. **Determine sizes**:
     - Base size of each part = `n / k`.
     - First `n % k` parts get one extra node.
  3. **Split into parts**:
     - For each part:
       - Set head for this part.
       - Traverse `partSize - 1` nodes.
       - Break the link (`current.next = null`) to separate this part.
  4. **Store in an array** and return.

  Time Complexity:
  - `O(n)` — single traversal of the list.

  Space Complexity:
  - `O(k)` — for the array of parts.

  Example:
  --------
  Input: head = 1 → 2 → 3 → 4 → 5 → 6 → 7, k = 3
  Output:
    [
      1 → 2 → 3,
      4 → 5,
      6 → 7
    ]

  Follow-ups:
  ------------
  - If `k` > `n`, some parts will be `null`.
  - LeetCode Reference: **LeetCode 725** (Split Linked List in Parts)
  */

  public static Node[] splitListToParts(Node head, int k) {
    // 1. Calculate the length of the linked list
    int n = Utility_linkedList.length(head);

    // 2. Calculate the base size and extra nodes
    int baseSize = n / k;
    int extraNodeSize = n % k;

    // 3. Initialize the result array
    Node[] result = new Node[k];
    Node current = head;

    // 4. Split the linked list into k parts
    for (int i = 0; i < k; i++) {
      // Assign the current pointer to the result array
      result[i] = current;

      // Calculate the size of this partition
      int partSize = baseSize + (i < extraNodeSize ? 1 : 0);

      // Traverse to the last node of this partition
      for (int j = 0; j < partSize - 1 && current != null; j++) {
        current = current.next;
      }

      // Break the link and move to the next partition
      if (current != null) {
        Node nextPart = current.next; // Store the next part pointer
        current.next = null; // Break the link
        current = nextPart; // Move to the next partition
      }
    }

    return result;
  }

  public static void main(String[] args) {
    // Example: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    Node head = new Node(1);
    Node current = head;
    for (int i = 2; i <= 10; i++) {
      current.next = new Node(i);
      current = current.next;
    }

    Node[] parts = splitListToParts(head, 3);
    printParts(parts);
  }
}
