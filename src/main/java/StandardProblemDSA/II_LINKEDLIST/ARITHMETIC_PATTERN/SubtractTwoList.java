package StandardProblemDSA.II_LINKEDLIST.ARITHMETIC_PATTERN;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/*Reverse Both Lists:
Since the numbers are stored in reverse order (least significant digit at the head), we first reverse both linked lists to make subtraction easier.

Compare the Two Numbers:
Determine which number is larger. This helps ensure we always subtract a smaller number from a larger one.

Iterate Over Both Lists:
Traverse both lists simultaneously to subtract corresponding digits.

Handle Borrowing:

If the digit of the smaller number is greater than the corresponding digit of the larger number, borrow 10 from the next digit.
Adjust the carry accordingly:
carry
=
(
bigger number digit
+
10
)
/
10
carry=(bigger number digit+10)/10
Construct the Resulting List:
Create a new linked list with the subtraction results.

Remove Leading Zeros:
If the result contains leading zeros (e.g., 000123), trim them.

Return the Result:
Exclude the dummy node and return the final list.*/
public class SubtractTwoList {

    // Function to reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Function to compare two lists and return true if list1 >= list2
    private static boolean isGreaterOrEqual(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        if (len1 != len2) return len1 > len2;

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return l1.val > l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true; // They are equal
    }

    // Function to get the length of a linked list
    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode subtractLists(ListNode l1, ListNode l2) {
        // Reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Ensure l1 is the larger number
        if (!isGreaterOrEqual(l1, l2)) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int borrow = 0;

        while (l1 != null) {
            int x = l1.val - borrow;
            int y = (l2 != null) ? l2.val : 0;

            if (x < y) {
                x += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            curr.next = new ListNode(x - y);
            curr = curr.next;

            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Reverse the result to get correct order
        ListNode result = reverse(dummy.next);

        // Remove leading zeros
        while (result != null && result.val == 0) {
            result = result.next;
        }

        return (result == null) ? new ListNode(0) : result;
    }

    // Utility function to print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: 943 - 587 (943 -> 3 -> 4 -> 9, 587 -> 7 -> 8 -> 5)
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(5);

        ListNode result = subtractLists(l1, l2);
        printList(result); // Expected output: 3 -> 5 -> 6 -> null (356)
    }
}
