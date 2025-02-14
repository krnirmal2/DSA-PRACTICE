package StandardProblemDSA.LINKEDLIST.DOUBLY_LL;

public class DoublyLinkedList {  // Node class (inner class)
    // Head and tail pointers of the DLL
    private Node head, tail;

    // Constructor for the DLL
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Test inserting at the front
        dll.insertAtFront(10);
        dll.insertAtFront(5);
        dll.insertAtFront(1);
        System.out.println("After inserting at the front:");
        dll.traverseForward();

        // Test inserting at the end
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        System.out.println("After inserting at the end:");
        dll.traverseForward();

        // Test traversal backward
        System.out.println("Traverse backward:");
        dll.traverseBackward();

        // Test deleting a node
        dll.delete(10);
        System.out.println("After deleting 10:");
        dll.traverseForward();

        // Test deleting a node not in the list
        dll.delete(50);

        // Test clearing the list
        dll.clear();
        System.out.println("After clearing the list:");
        dll.traverseForward();
    }

    /*How It Works
Insertion at the Front:

Adds a new node as the first element.
Updates head pointer and handles cases where the list is empty

Insertion at the End:
Adds a new node as the last element.
Updates tail pointer and handles cases where the list is empty.

Deletion:
Searches for the node with the given value.
Deletes it by updating pointers of the previous and next nodes.
Handles cases where the node is the head, tail, or in between.

Traversal:
Forward traversal starts from head.
Backward traversal starts from tail.
Clear:

Resets both head and tail to null.*/
    // Insert at the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a node with a given value
    public void delete(int data) {
        if (head == null) { // If list is empty
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        // Search for the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) { // Node not found
            System.out.println("Node with data " + data + " not found.");
            return;
        }

        // If the node is the head
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        }
        // If the node is the tail
        else if (current == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null; // List becomes empty
            }
        }
        // If the node is in the middle
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Node with data " + data + " deleted.");
    }

    // Traverse forward
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Traverse backward
    public void traverseBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Clear the entire list
    public void clear() {
        head = null;
        tail = null;
        System.out.println("List cleared.");
    }

    private class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
