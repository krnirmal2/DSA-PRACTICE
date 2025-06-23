package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;
import StandardProblemDSA.II_LINKEDLIST.i_TRAVERSAL_BASIC_OPERATION.LinkedList;
import StandardProblemDSA.Utility;

public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = Utility_linkedList.lengthOfListNode(headA);
        int lengthB = Utility_linkedList.lengthOfListNode(headB);
        int diffA=0;
        int diffB=0;
        if(lengthA>lengthB){
            diffA= lengthA-lengthB;
        }else{
            diffB = lengthB-lengthA;
        }

        if(diffA!=0 ||diffB!=0){

            while(diffA>0){
                headA= headA.next;
                diffA--;
            }
            while(diffB>0){
                headB= headB.next;
                diffB--;
            }
        }
        while(headA!=null && headB !=null){
            if(headA == headB){
                return headA;
            }
            headA= headA.next;
            headB= headB.next;
        }
        return null;


    }

    public static void main(String[] args) {
        int[] arrA = {4, 1, 8, 4, 5};
        int[] arrB = {5, 6, 1, 8, 4, 5};

//        ListNode listA = Utility_linkedList.buildListNode(arrA);
//        ListNode listB = Utility_linkedList. buildListNode(arrB);
        // Shared nodes (intersection)
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // List A: 4 → 1 → [8 → 4 → 5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // List B: 5 → 6 → 1 → [8 → 4 → 5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode result = getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
