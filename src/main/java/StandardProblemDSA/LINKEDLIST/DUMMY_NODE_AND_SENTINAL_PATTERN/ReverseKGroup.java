package StandardProblemDSA.LINKEDLIST.DUMMY_NODE_AND_SENTINAL_PATTERN;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge case: If the list is empty or has less than k nodes, return as is
        if (head == null || k <= 1) return head;

        // Dummy node to track new head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Pointers to track the previous group's tail and the start of the next group
        ListNode prevTail = dummy, current = head;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode temp = current;
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            // If we don't have enough nodes, break
            if (count < k) break;

            // Reverse k nodes and get new head & tail
            ListNode reversedHead = reverse(current, k);

            // Connect previous part with newly reversed list
            prevTail.next = reversedHead;

            // Move prevTail and current pointers to the next segment
            prevTail = current;
            current = prevTail.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, current = head, next = null;

        while (k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // `head` is now the tail of the reversed segment, so it should point to the next segment
        head.next = current;

        // `prev` is the new head of the reversed segment
        return prev;
    }

}
