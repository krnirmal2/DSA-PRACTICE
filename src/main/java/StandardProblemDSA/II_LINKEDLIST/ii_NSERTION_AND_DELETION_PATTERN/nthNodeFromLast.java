package StandardProblemDSA.II_LINKEDLIST.ii_NSERTION_AND_DELETION_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class nthNodeFromLast {
  // 1st way to  traverse and delete the nth node
  // steps 1. travers the k-n+1 node from beginnig
  // delete take two pointer next and previous
  public static Node findNthNodFromLast(Node head, int length, int n) {
    if (length == 0) return null;

    Node previous = null;
    Node next = head;

    // iterate with head and previous head
    //    1,2,3,4,5
    //    0,1,2,3,4
    //  last nth node = 3 means index 2 , which will 5-3 = 2 so we will traverse till 2 , so add
    // extra 1 gives index 2+1
    // 3 , so previous wil at index 1 and next at 2   , so we will by pass next by prvious.next.next
    // Step. reach to the element its previous element and update the link
    for (int currNode = 1; currNode < length - n + 1; currNode++) {
      previous = head;
      next = next.next;
    }
    // Step 2;  check if the first node
    if (previous == null) {
      head = head.next;
      return head;
    }
    // Step 3. by pass/override/ delete the node as we reached that node
    previous.next = previous.next.next;
    return head;
  }

  public static void main(String[] args) {

    // create node
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    int length = length(head);
    printList(head);
    findNthNodFromLast(head, length, 3);
    printList(head);
  }

  private static int length(Node head) {
    if (head == null) {
      return 0;
    }
    int count = 0;
    while (head.next != null) {
      head = head.next;
      count++;
    }
    return count;
  }
}
