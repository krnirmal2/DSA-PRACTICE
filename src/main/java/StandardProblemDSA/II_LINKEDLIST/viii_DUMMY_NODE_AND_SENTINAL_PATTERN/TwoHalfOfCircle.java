package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class TwoHalfOfCircle {

  public class SplitCircularList {
    public static void splitList(Node head) {
      if (head == null || head.next == head) {
        System.out.println("List is too small to split.");
        return;
      }

      Node slow = head;
      Node fast = head;

      // Use Floyd’s cycle to find mid point
      while (fast.next != head && fast.next.next != head) {
        slow = slow.next;
        fast = fast.next.next;
      }

      Node head1 = head; // first half
      Node head2 = slow.next; // second half

      // Make two halves circular
      slow.next = head1;

      if (fast.next == head) fast.next = head2;
      else fast.next.next = head2;

      // Print both halves
      printList(head1);
      System.out.println();
      printList(head2);
    }

    public void main(String[] args) {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = head; // circular link

      splitList(head);
    }
  }
}
