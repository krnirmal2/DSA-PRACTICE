package StandardProblemDSA.LINKEDLIST.MERGING_AND_SPLITTING_LL;

public class AlternatingSplitLL {
    // Function to split a linked list into two alternate lists
    static void AlternatingSplit(Node source, Node[] aRef, Node[] bRef) {
        if (source == null) return; // Edge case: Empty list

        Node a = null, b = null; // Pointers to keep track of last nodes
        Node current = source;
        int count = 0; // To track even/odd positions

        while (current != null) {
            if (count % 2 == 0) { // Even index -> Goes to list 'a'
                if (a == null) {
                    aRef[0] = current;
                    a = current;
                } else {
                    a.next = current;
                    a = a.next;
                }
            } else { // Odd index -> Goes to list 'b'
                if (b == null) {
                    bRef[0] = current;
                    b = current;
                } else {
                    b.next = current;
                    b = b.next;
                }
            }

            current = current.next; // Move to the next node
            count++;
        }

        // Properly terminate both lists
        if (a != null) a.next = null;
        if (b != null) b.next = null;
    }

    // Function to print nodes in a given linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    // Driver code
    public static void main(String[] args) {

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = null;
        for (int i = 6; i >= 1; i--) {
            Node newNode = new Node(i);
            newNode.next = head;
            head = newNode;
        }

        System.out.print("Original Linked List: ");
        printList(head);

        Node[] aRef = new Node[1];
        Node[] bRef = new Node[1];

        // Splitting the linked list into two
        AlternatingSplit(head, aRef, bRef);

        System.out.print("\nResultant Linked List 'a': ");
        printList(aRef[0]);

        System.out.print("Resultant Linked List 'b': ");
        printList(bRef[0]);
    }
}

// Linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}