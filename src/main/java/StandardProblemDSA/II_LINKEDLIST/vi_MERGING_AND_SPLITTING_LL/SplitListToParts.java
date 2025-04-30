package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class SplitListToParts {

  public static ListNode[] splitListToParts(ListNode head, int k) {
    // 1. Calculate the length of the linked list
    int n = Utility_linkedList.length(head);

    // 2. Calculate the base size and extra nodes
    int baseSize = n / k;
    int extraNodeSize = n % k;

    // 3. Initialize the result array
    ListNode[] result = new ListNode[k];
    ListNode current = head;

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
        ListNode nextPart = current.next; // Store the next part pointer
        current.next = null; // Break the link
        current = nextPart; // Move to the next partition
      }
    }

    return result;
  }

  // Utility function to print the list parts
  public static void printParts(ListNode[] parts) {
    for (ListNode part : parts) {
      ListNode temp = part;
      while (temp != null) {
        System.out.print(temp.val + " -> ");
        temp = temp.next;
      }
      System.out.println("null");
    }
  }

  public static void main(String[] args) {
    // Example: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    ListNode head = new ListNode(1);
    ListNode current = head;
    for (int i = 2; i <= 10; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }

    ListNode[] parts = splitListToParts(head, 3);
    printParts(parts);
  }
}
