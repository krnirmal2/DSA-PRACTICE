package StandardProblemDSA.LINKEDLIST.TRAVERSAL_BASIC_OPERATION;

public class mergeTwoSortedList {

    public static Nodes mergeTwoLists(Nodes list1, Nodes list2) {
        // Approach : 1. iterate over the two linked list with two pointer
        //   2. compare each pointer data and which pointer data will be less put it to result list
        // and increament both pointer
        // 3. if still data left in any list so we will take the that pointer and add to the result list
        // Dummy node to simplify edge cases
        Nodes dummy = new Nodes(-1);
        Nodes tail = dummy; // Tail pointer to build the new list

        // Merge lists using two-pointer approach
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // If any nodes are left in either list, attach them
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next; // Return the merged list (skip dummy node)
    }

    public static void main(String[] args) {
        mergeTwoSortedList solution = new mergeTwoSortedList();

        Nodes list1 = new Nodes(1, new Nodes(3, new Nodes(5)));
        Nodes list2 = new Nodes(2, new Nodes(4, new Nodes(6)));

        System.out.println("List 1:");
        printList(list1);
        System.out.println("List 2:");
        printList(list2);

        Nodes mergedList = mergeTwoSortedList.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedList);
    }

    // Utility function to print linked list
    public static void printList(Nodes head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

class Nodes {
    int val;
    Nodes next;

    Nodes() {
    }

    Nodes(int val) {
        this.val = val;
    }

    Nodes(int val, Nodes next) {
        this.val = val;
        this.next = next;
    }
}
