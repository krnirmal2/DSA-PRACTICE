package AdvancedDSA.Arrays.one.LinkedList;

public class PalindromeLL {
    public static int lPalin(ListNode A) {
        /* splitting the list into 2 parts */
        ListNode S = A, F = A;
        // after slow and fast pointer is come to mid and end respectively
        while (F.next != null && F.next.next != null) {
            S = S.next;
            F = F.next.next;
        }

// the middle node of the next node which is point by the slow pointer s
        ListNode mh = S.next;
        //break the linked list in the middle by point the next node of slow pointer by null
        S.next = null;
        ListNode t = mh, rh = null;

        /* reversing the 2nd half */
        while (mh != null) {
            t = mh;
            mh = mh.next;
            t.next = rh;
            rh = t;
        }

        /* comparing 1st half and reversed 2nd half */
        while (A != null && rh != null) {
            if (A.val == rh.val) {
                A = A.next;
                rh = rh.next;
            } else return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
//        LinkedList llist = new LinkedList();
//        char[] str = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
//        for (int i = 0; i < 7; i++) {
//            llist.push(str[i]);
//        }
//

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(2);
        ListNode seven = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        System.out.println(lPalin(one));
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
