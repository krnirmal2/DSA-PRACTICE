package TEST;

public class NearestMultiple {

    public static ListNode solve(ListNode A, int B) {
        ListNode temp = A;
        int i = 1;
        boolean True = true;

        while (temp.next != null) {
            while (True) {
                if (B * i >= temp.val) {
                    temp.val = B * i;

                    True = false;
                }
                i++;
            }
            temp = temp.next;
            True = true;
            i = 1;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        System.out.println(solve(a, 2));
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
