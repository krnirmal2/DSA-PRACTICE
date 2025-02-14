package Programming_constructs.LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCycleRemoval {

    // Function to detect and remove the loop
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect the cycle using Floyd's Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                break;
            }
        }

        // If no cycle is found, return
        if (fast == null || fast.next == null) {
            return;
        }

        // Step 2: Find the start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now `slow` is pointing to the start of the loop

        // Step 3: Remove the loop
        Node loopNode = slow;
        while (fast.next != loopNode) {
            fast = fast.next;
        }

        // Break the loop
        fast.next = null;
    }

    // Utility function to create a loop in the linked list for testing
    public static void createLoop(Node head, int position) {
        if (head == null || position <= 0) return;

        Node temp = head;
        Node loopNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }

        // Create the loop
        if (loopNode != null) {
            temp.next = loopNode;
        }
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop for testing
        createLoop(head, 3);

        // Remove the loop
        removeLoop(head);

        // Print the modified linked list
        printList(head);
    }
}
