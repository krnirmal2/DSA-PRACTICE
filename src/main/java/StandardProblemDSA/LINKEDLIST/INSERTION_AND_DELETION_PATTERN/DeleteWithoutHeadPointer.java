package StandardProblemDSA.LINKEDLIST.INSERTION_AND_DELETION_PATTERN;

public class DeleteWithoutHeadPointer {
    /*Approach
    Key Idea:
    Since we don't have access to the head of the list, we cannot traverse the list to find the previous node. Instead, we "overwrite" the current node's data with the next node's data and then delete the next node.
    Constraints:
    The node to be deleted cannot be the last node in the list because there is no way to update the previous node's reference to null.
    Steps:
    Copy the data of the next node into the current node.
    Update the current node's next pointer to skip the next node.
    Effectively, this removes the next node from the list.*/
    // Method to delete a node without head pointer
    public static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to be deleted cannot be null or the last node.");
        }

        // Copy the data from the next node to the current node
        node.data = node.next.data;

        // Bypass the next node
        node.next = node.next.next;
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        /*Edge Cases
            Null Node:
            If the node to be deleted is null, throw an exception or handle the error gracefully.

            Last Node:
            If the node to be deleted is the last node, the method cannot work since there’s no next node to copy data from. An exception is thrown in this case.

            Single Node List:
            Deleting the only node in a list is not possible using this method.*/
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Delete the node with value 3 (we are given only the node, not the head)
        Node nodeToDelete = head.next.next; // Node with value 3
        deleteNode(nodeToDelete);

        System.out.println("Linked List after deleting node 3:");
        printList(head);
    }

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
