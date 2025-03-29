package StandardProblemDSA.V_QUEUE.III_QUEUE_WITH_TWO_STACKS;

/*
2️⃣ Reverse a Queue Using Two Stacks
🔹 Approach
Move all elements from the queue to Stack 1

Move elements from Stack 1 to Stack 2 (Reversing Order)

Move elements from Stack 2 back to the queue
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingTwoStacks {
  public static void reverseQueue(Queue<Integer> queue) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // ✅ Move all elements from queue to stack1
    while (!queue.isEmpty()) {
      stack1.push(queue.poll());
    }

    //    // ✅ Move elements from stack1 to stack2 (Reversing order)
    //    while (!stack1.isEmpty()) {
    //      stack2.push(stack1.pop());
    //    }

    // ✅ Move elements from stack2 back to queue
    while (!stack1.isEmpty()) {
      queue.add(stack1.pop());
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    System.out.println("Original Queue: " + queue);
    reverseQueue(queue);
    System.out.println("Reversed Queue: " + queue);
  }
}
/*✅ Time Complexity:

Move to Stack 1 → O(N)

Move to Stack 2 → O(N)

Move back to Queue → O(N)

Total Complexity: O(N)

🚀 Queue successfully reversed using two stacks! 🚀

        🔹 Summary
Operation	Deque Using Two Stacks	Reverse Queue Using Two Stacks
Data Structure Used	Stack (stack1, stack2)	Stack (stack1, stack2)
Insert at Rear (O(1))	✅	❌
Insert at Front (O(N))	✅	❌
Remove from Front (O(1))	✅	❌
Remove from Rear (O(N))	✅	❌
Reverse Entire Queue (O(N))	❌	✅*/
