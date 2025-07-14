package StandardProblemDSA.V_QUEUE.III_QUEUE_WITH_TWO_STACKS;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {}

/* By making pop() operation costly – Push in O(1) and Pop() in O(n)
The new element is always enqueued to q1. In pop() operation, if q2 is empty then all the elements except the last, are moved to q2. Finally, the last element is dequeued from q1 and returned.
Follow the below steps to implement the push(s, x) operation:
Enqueue x to q1 (assuming the size of q1 is unlimited).
Follow the below steps to implement the pop(s) operation:
One by one dequeue everything except the last element from q1 and enqueue to q2.
Dequeue the last item of q1, the dequeued item is the result, store it.
Swap the names of q1 and q2
Return the item stored in step 2.
/* Java Program to implement a stacke */
class Stack {
  Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();

  void remove() {
    if (q1.isEmpty()) return;

    // Leave one element in q1 and
    // push others in q2.
    while (q1.size() != 1) {
      q2.add(q1.peek());
      q1.remove();
    }

    // Pop the only left element
    // from q1
    q1.remove();

    // swap the names of two queues
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  void add(int x) {
    q1.add(x);
  }

  int top() {
    if (q1.isEmpty()) return -1;

    while (q1.size() != 1) {
      q2.add(q1.peek());
      q1.remove();
    }

    // last pushed element
    int temp = q1.peek();

    // to empty the auxiliary queue after
    // last operation
    q1.remove();

    // push last element to q2
    q2.add(temp);

    // swap the two queues names
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
    return temp;
  }

  int size() {
    return q1.size();
  }

  // Driver code
  public static void main(String[] args) {
    Stack s = new Stack();
    s.add(1);
    s.add(2);
    s.add(3);

    System.out.println("current size: " + s.size());
    System.out.println(s.top());
    s.remove();
    System.out.println(s.top());
    s.remove();
    System.out.println(s.top());
    System.out.println("current size: " + s.size());
  }
}
/*ime Complexity:
Push operation: O(1), As, on each push operation the new element is added at the end of the Queue.
Pop operation: O(n), As, on each pop operation, all the elements are popped out from the Queue (q1) except the last element and pushed into the Queue (q2)*/
// This code is contributed by Princi Singh
