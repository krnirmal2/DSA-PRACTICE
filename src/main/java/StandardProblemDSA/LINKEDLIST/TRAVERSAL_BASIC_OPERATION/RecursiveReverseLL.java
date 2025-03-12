package StandardProblemDSA.LINKEDLIST.TRAVERSAL_BASIC_OPERATION;


public class RecursiveReverseLL {

    // Recursive Method
    public static ListNode reverseRecursive(ListNode head) {
        // Base case: If list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive call to reverse the rest of the list
        ListNode newHead = reverseRecursive(head.next);

        // Reverse the current node's link
        head.next.next = head;
        head.next = null;

        return newHead; // Return new head
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example List: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = reverseRecursive(head);

        System.out.println("Reversed List:");
        printList(head);
    }

}
