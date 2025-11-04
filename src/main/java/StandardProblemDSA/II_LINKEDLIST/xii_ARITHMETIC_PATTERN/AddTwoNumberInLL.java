package StandardProblemDSA.II_LINKEDLIST.xii_ARITHMETIC_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;


/*
 Problem: Add two numbers represented as linked lists.

 Given two non-empty linked lists representing two non-negative integers, where each node contains a single digit
 and digits are stored in reverse order, add the two numbers and return the sum as a linked list.

 Example:
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807

 Pattern:
    - Linked List
    - Elementary Math Addition
    - Dummy Node for simplified list building

 Similar LeetCode Problems:
    - 2. Add Two Numbers
    - 445. Add Two Numbers II (digits stored in forward order)
    - 66. Plus One (array version)

 Follow-up Questions:
    - How to handle numbers stored in forward order?
    - Can you implement without using a dummy node?
    - How to handle lists of unequal lengths?
    - Can this be extended to add multiple numbers?

 Time Complexity: O(max(m, n)), where m and n are lengths of the two lists
 Space Complexity: O(1) excluding output list
*/

public class AddTwoNumberInLL {
 /* public static Node addTwoLists(Node l1, Node l2) {
    Node dummy = new Node(0); // Dummy node to store result
    Node current = dummy;
    int carry = 0;

    // Traverse both lists
    while (l1 != null || l2 != null || carry > 0) {
      int sum = carry; // Start with carry

      if (l1 != null) { // Add dataue from l1
        sum += l1.data;
        l1 = l1.next;
      }
      if (l2 != null) { // Add dataue from l2
        sum += l2.data;
        l2 = l2.next;
      }

      carry = sum / 10; // Compute carry for next step
      current.next = new Node(sum % 10); // Store remainder in new node
      current = current.next;
    }

    return dummy.next; // Return result (excluding dummy)
  }

  public static void main(String[] args) {

    // Creating first linked list: 1 -> 2 -> 3
    // (represents 123)
    Node num1 = new Node(1);
    num1.next = new Node(2);
    num1.next.next = new Node(3);

    // Creating second linked list: 9 -> 9 -> 9
    // (represents 999)
    Node num2 = new Node(9);
    num2.next = new Node(9);
    num2.next.next = new Node(9);

    Node sum = addTwoLists(num1, num2);
    printList(sum);
  }*/
}
