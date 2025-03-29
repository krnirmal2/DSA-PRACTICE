package StandardProblemDSA.V_QUEUE.XI_CIRCULAR_QUEUE_PATTERN;

import java.util.Stack;

/*4. Reverse Elements in a Circular Queue
Approach
Dequeue all elements and push them into a stack.

Enqueue elements back into the queue from the stack.*/
public class ReverseCircularQueue {
  public static void reverseQueue(CircularQueue queue) {
    if (queue.isEmpty()) return;

    Stack<Integer> stack = new Stack<>();

    // Dequeue all elements into stack
    while (!queue.isEmpty()) {
      stack.push(queue.dequeue());
    }

    // Enqueue back from stack
    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }
  }

  public static void main(String[] args) {
    CircularQueue queue = new CircularQueue(5);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    System.out.println("Before Reversal:");
    queue.display();

    reverseQueue(queue);

    System.out.println("After Reversal:");
    queue.display();
  }
}
