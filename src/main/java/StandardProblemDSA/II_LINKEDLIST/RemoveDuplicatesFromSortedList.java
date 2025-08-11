package StandardProblemDSA.II_LINKEDLIST;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        // ALL duplicate , we can use array as extra space but not
        // we will do using ll
        ListNode prev = head;
        ListNode next = head.next;

        while (next != null) {
            if (prev.val == next.val) {
                prev.next = next.next;
                next.next = prev.next;
            }
            prev = prev.next;
            next = next.next;
        }
        System.out.println(prev);

        if (next.next == null) {
            System.out.println(prev.val);
            System.out.println(next.val);
            //  if(prev.val == next.val){
            prev.next = null;
            // next.next = null;
            // }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        list.next.next = new ListNode(3);
        deleteDuplicates(list);
    }
}
