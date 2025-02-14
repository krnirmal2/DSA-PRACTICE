package StandardProblemDSA.LINKEDLIST.DUMMY_NODE_AND_SENTINAL_PATTERN;

public class RemoveEachSpecificValue {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases for head removal
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy; // start from the dummy node

        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the value `val`
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return dummy.next; // return the new head (which might have changed)
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
