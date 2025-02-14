package StandardProblemDSA.LINKEDLIST.MERGING_AND_SPLITTING_LL;

public class ConcatenationTwoList {
    static Node concat(Node head1,
                       Node head2) {

        if (head1 == null) return head2;

        // Find the last node of the first list
        Node curr = head1;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Link the last node of the first list
        // to the head of the second list
        curr.next = head2;

        // Return the head of the concatenated list
        return head1;
    }

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create first linked list: 1 -> 2 -> 3
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Create second linked list: 4 -> 5
        Node head2 = new Node(4);
        head2.next = new Node(5);

        Node concatHead = concat(head1, head2);
        printList(concatHead);
    }
}
