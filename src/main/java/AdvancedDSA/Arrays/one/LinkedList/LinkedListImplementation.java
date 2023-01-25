package AdvancedDSA.Arrays.one.LinkedList;

public class LinkedListImplementation {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    //initial size of linked List is 0
    private static int size = 0;
    //initial head node is null
    private static ListNode head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        ListNode newNode = new ListNode(value);
        if(position <= 0) return ;

        else if(position == 1){ // head node
            newNode.next = head;
            head = newNode;
        }
        else if(position == size+1){ // insetion at last
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        else if(position > 1 && position <= size){// insertion in between
            ListNode temp = head;
            for(int i = 1 ; i < position - 1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        else
            return;
        size++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        // edgecase : 1
        if (position <= 0)
            return;

        else if (position == 1) { //removing 1st element
            if (head != null)
                head = head.next;
            else
                return;
        }
        else if (position == size) { //removing last element
            ListNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null; // last element is null only
        }

        else if (position > 1 && position  <  size) { //removing in between node
            ListNode temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        // edgecase : 2
        else
            return;

        size--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = head;
        while(temp.next != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
}
