package StandardProblemDSA.LINKEDLIST.INSERTION_AND_DELETION_PATTERN;

public class nthNodeFromLast {
    // 1st way to  traverse and delete the nth node
    // steps 1. travers the k-n+1 node from beginnig
    // delete take two pointer next and previous
    public static NodeL findNthNodFromLast(NodeL head, int length, int n) {
        if (length == 0) return null;

        NodeL previous = null;
        NodeL next = head;

        // iterate with head and previous head
        for (int currNode = 1; currNode < length - n + 1; currNode++) {
            previous = head;
            next = next.next;

        }
        // check if the first node
        if (previous == null) {
            head = head.next;
            return head;
        }
        // delete the node as we reached that node
        previous.next = previous.next.next;
        return head;

    }

    public static void main(String[] args) {

        // create node
        NodeL head = new NodeL(1);
        head.next = new NodeL(2);
        head.next.next = new NodeL(3);
        head.next.next.next = new NodeL(4);
        head.next.next.next.next = new NodeL(5);
        head.next.next = new NodeL(3);
        head.next.next.next = new NodeL(4);
        head.next.next.next.next = new NodeL(5);

        int length = length(head);
        printList(head);
        findNthNodFromLast(head, length, 3);
        printList(head);


    }

    static void printList(NodeL head) {
        NodeL ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    private static int length(NodeL head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static class NodeL {
        int data;
        NodeL next;

        private NodeL(int data) {
            this.data = data;
            this.next = null;

        }


    }
}
