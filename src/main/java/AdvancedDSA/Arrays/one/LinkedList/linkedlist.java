package AdvancedDSA.Arrays.one.LinkedList;

public class linkedlist {
    int data;
    linkedlist prev;
    linkedlist next;
    linkedlist head, tail;

    linkedlist() {
    }

    linkedlist(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.add(8);
        list.add(4);
        list.add(6);
        list.display();
    }

    public void add(int data) {
        linkedlist newNode = new linkedlist(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tail.next = null;
    }

    public void display() {
        linkedlist current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
