package AdvancedDSA.Arrays.one.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReversingElementsOfQueue {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        Queue<Integer> q = new LinkedList();
        // first remove first B element from the arraylist
        for (int i = 0; i < B; i++) {
            q.add(A.get(i));

        }
        // now reverse the queue
        reverseQueue(q);

        //now traverse the queue and add the element to the arraylist
        for (int i = 0; i < B; i++) {
            int peek = q.remove();
            A.set(i, peek);
        }
        return A;
    }

    public static void reverseQueue(Queue<Integer> q) {
        // base case
        if (q.size() == 0)
            return;
        // storing front(first element) of queue
        int fr = q.peek();

        // removing front
        q.remove();

        // asking recursion to reverse the
        // leftover queue
        reverseQueue(q);

        // placing first element
        // at its correct position
        q.add(fr);
    }

    public static void main(String[] args) {
        solve(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 3);
    }

}
