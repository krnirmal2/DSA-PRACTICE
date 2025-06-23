package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class mergeSortLL {

    // Function to merge two sorted singly linked lists
    static ListNode merge(ListNode first, ListNode second) {

        // If either list is empty, return the other list
        if (first == null) return second;
        if (second == null) return first;

        // Pick the smaller value between first and second ListNodes
        if (first.val < second.val) {

            // Recursively merge the rest of the lists and
            // link the result to the current ListNode
            first.next = merge(first.next, second);
            return first;
        }
        else {
            // Recursively merge the rest of the lists
            // and link the result to the current ListNode
            second.next = merge(first, second.next);
            return second;
        }
    }

    // Function to perform merge sort on a singly linked list
    static ListNode mergeSort(ListNode head) {

        // Base case: if the list is empty or has only one ListNode,
        // it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // 1.Split the list into two halves
        ListNode second = Utility_linkedList.splitLLWithHeadNode(head);

        // 2. Recursively sort each half
        head = mergeSort(head);
        second = mergeSort(second);

        // 3. Merge the two sorted halves
        return merge(head, second);
    }


    public static void main(String[] args) {
        // Create a hard-coded singly linked list:
        // 9 -> 8 -> 5 -> 2
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);

        head = mergeSort(head);
        Utility_linkedList.printList(head);
    }
}
