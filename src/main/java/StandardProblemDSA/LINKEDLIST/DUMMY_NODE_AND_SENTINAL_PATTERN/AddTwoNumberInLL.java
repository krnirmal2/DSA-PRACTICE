package StandardProblemDSA.LINKEDLIST.DUMMY_NODE_AND_SENTINAL_PATTERN;

public class AddTwoNumberInLL {
    public static Node addTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0); // Dummy node to store result
        Node current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with carry

            if (l1 != null) { // Add value from l1
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // Add value from l2
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Compute carry for next step
            current.next = new Node(sum % 10); // Store remainder in new node
            current = current.next;
        }

        return dummy.next; // Return result (excluding dummy)
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating first linked list: 1 -> 2 -> 3
        // (represents 123)
        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        // Creating second linked list: 9 -> 9 -> 9
        // (represents 999)
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printList(sum);
    }

    // Corrected reverse function
    public ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = list;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // Return the new head after reversal
    }

    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

