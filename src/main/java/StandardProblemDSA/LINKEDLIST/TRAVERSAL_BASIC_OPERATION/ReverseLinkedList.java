package StandardProblemDSA.LINKEDLIST.TRAVERSAL_BASIC_OPERATION;

import static StandardProblemDSA.LINKEDLIST.TRAVERSAL_BASIC_OPERATION.LinkedList.insert;
import static StandardProblemDSA.LINKEDLIST.TRAVERSAL_BASIC_OPERATION.LinkedList.printList;

public class ReverseLinkedList {

    public static LinkedList.Node reverseLinkedList(LinkedList.Node head) {

        //taking three pointers

        LinkedList.Node prev = null;
        LinkedList.Node current = head;

        while (current != null) {
            // Store next node
            LinkedList.Node next = current.next;//Store the next node (next = curr.next).
            // Reverse the link
            current.next = prev;  //Reverse the link (curr.next = prev).
            // Move pointers one step forward
            prev = current;  //Move the prev and curr pointers forward.
            current = next;


        }
        return prev;

    }

    public static void main(String[] args) {

        /* Start with the empty list. */
        LinkedList list = new LinkedList();
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        printList(list);

        reverseLinkedList(list.head);

        printList(list);


    }
}
