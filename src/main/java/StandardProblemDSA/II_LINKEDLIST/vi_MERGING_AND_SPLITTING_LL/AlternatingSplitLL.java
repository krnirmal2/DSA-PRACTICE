package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class AlternatingSplitLL {
  /*
  Problem: Alternating Split of a Linked List
  -------------------------------------------
  Problem Statement:
  Given the head of a singly linked list, split it into two separate lists:
  - List A: nodes at even indices (0, 2, 4, …)
  - List B: nodes at odd indices (1, 3, 5, …)

  Approach:
  ---------
  1. **Traversal with Index Tracking**:
     - Traverse the linked list while keeping an index counter.
     - Even indices go to `listA`, odd indices go to `listB`.

  2. **Use Tail Pointers for Efficient Appending**:
     - Maintain `lastA` and `lastB` as tails for both new lists.
     - Use a helper function `appendNode` to append nodes.

  3. **Terminate Both Lists**:
     - After traversal, set the `next` of the last node in each list to `null` to avoid accidental cross-links.


  Time Complexity: **O(n)** — traverses the list once.
  Space Complexity: **O(1)** — uses constant extra memory.

  Example:
  --------
  Input: 1 → 2 → 3 → 4 → 5 → 6
  Output:
  - List A: 1 → 3 → 5
  - List B: 2 → 4 → 6

  Follow-up:
  ----------
  - LeetCode 328: **Odd Even Linked List** (group all odd-indexed nodes followed by even-indexed nodes).
  */
  /*Positive/negative split is based on value (a node’s data) → can be done in one pass by checking value.
    Alternate splitting is based on position (even/odd index) → requires positional tracking during traversal.
  | Feature                      | Positive/Negative Split    | Alternate Index Split                 |
  | ---------------------------- | -------------------------- | ------------------------------------- |
  | **Split Criteria**           | Based on `node.data` value | Based on position (`index % 2`)       |
  | **Needs index tracking?**    | ❌ No                       | ✅ Yes                                 |
  | **Similar dummy node idea?** | ✅ Yes                      | ✅ Yes                                 |
  | **Can reuse logic fully?**   | ❌ No                       | 🔄 Similar pattern, but not identical |

    */
  // Function to split a linked list into two alternate lists
  // Splits linked list into two alternate node lists: even-indexed → listA, odd-indexed → listB
  public static void splitAlternatingNodes(Node head, Node[] listARef, Node[] listBRef) {
    if (head == null) return;

    Node lastA = null, lastB = null;
    Node current = head;
    int index = 0;
    // so basically list is not like array that it will contain what you have put in the
    // list or varible till we forcefully not make it null or cut from any poin
    // so there for we have to manipulate the list and update the next of the list
    while (current != null) { // 1 -> 2 -> 3 -> 4 -> 5 -> 6
      if (index % 2 == 0) {
        // so we just update or attach the current element of last reference/tail of the list
        lastA = appendNode(listARef, lastA, current);
      } else {
        lastB = appendNode(listBRef, lastB, current);
      }
      current = current.next;
      index++;
    }

    // Terminate both lists
    if (lastA != null) lastA.next = null;
    if (lastB != null) lastB.next = null;
  }

  // Appends the current node to the new list, returns updated tail
  private static Node appendNode(Node[] headRef, Node tail, Node current) {
    if (tail == null) {
      // for 1st time we are set the current node which is the head note of the index and
      headRef[0] = current;
      return current;
    } else {
      // here we just set the last node with current node of the respective list
      tail.next = current;
      return tail.next;
    }
    /*
    | Iteration | `index` | `current.val` | `index % 2` | List A    | List B    |
    | --------- | ------- | ------------- | ----------- | --------- | --------- |
    | 0         | 0       | 1             | 0 (even)    | 1         |           |
    | 1         | 1       | 2             | 1 (odd)     | 1         | 2         |
    | 2         | 2       | 3             | 0 (even)    | 1 → 3     | 2         |
    | 3         | 3       | 4             | 1 (odd)     | 1 → 3     | 2 → 4     |
    | 4         | 4       | 5             | 0 (even)    | 1 → 3 → 5 | 2 → 4     |
    | 5         | 5       | 6             | 1 (odd)     | 1 → 3 → 5 | 2 → 4 → 6 |

        * */
  }

  // Driver code
  public static void main(String[] args) {

    // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    Node head = null;
    head = Utility_linkedList.createLinkedListOfSizeK(head, 6);

    System.out.print("Original Linked List: ");
    printList(head);

    Node[] aRef = new Node[1];
    Node[] bRef = new Node[1];

    // Splitting the linked list into two
    splitAlternatingNodes(head, aRef, bRef);

    System.out.print("\nResultant Linked List 'a': ");
    printList(aRef[0]);

    System.out.print("Resultant Linked List 'b': ");
    printList(bRef[0]);
  }
}
