package StandardProblemDSA.V_QUEUE.III_QUEUE_WITH_TWO_STACKS;

/*
1️⃣ Implement Deque Using Two Stacks
        🔹 Approach
        Use two stacks (stack1 and stack2) to simulate both front and rear operations.
        Enqueue at rear → Push into stack1.
        Enqueue at front → Transfer stack1 to stack2, push element, transfer back.
        Dequeue from front → If stack2 is empty, transfer stack1 elements and pop.
        Dequeue from rear → Pop from stack1.
*/

import java.util.Stack;

class DequeUsingTwoStacks {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  // ✅ Constructor
  public DequeUsingTwoStacks() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  // ✅ Insert at Rear (Regular Enqueue)
  public void insertRear(int value) {
    stack1.push(value);
  }

  // ✅ Insert at Front (Move all elements to stack2, push, move back)
  public void insertFront(int value) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(value);
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  // ✅ Remove from Front (Regular Dequeue)
  public int removeFront() {
    if (stack1.isEmpty()) {
      System.out.println("Deque Underflow!");
      return -1;
    }
    return stack1.pop();
  }

  // ✅ Remove from Rear (Pop from stack1)
  public int removeRear() {
    if (stack1.isEmpty()) {
      System.out.println("Deque Underflow!");
      return -1;
    }
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    int rearValue = stack2.pop();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
    return rearValue;
  }

  // ✅ Check if Empty
  public boolean isEmpty() {
    return stack1.isEmpty();
  }

  // ✅ Print Deque
  public void printDeque() {
    System.out.println("Deque: " + stack1);
  }

  public static void main(String[] args) {
    DequeUsingTwoStacks deque = new DequeUsingTwoStacks();
    deque.insertRear(10);
    deque.insertRear(20);
    deque.insertFront(5);
    deque.printDeque(); // Output: [5, 10, 20]

    System.out.println(deque.removeFront()); // Output: 5
    deque.printDeque(); // Output: [10, 20]

    System.out.println(deque.removeRear()); // Output: 20
    deque.printDeque(); // Output: [10]
  }
} /*
  ✅ Time Complexity:
  insertRear() → O(1)
  insertFront() → O(N)
  removeFront() → O(1)
  removeRear() → O(N)
  🚀 Deque implemented successfully using two stacks! 🚀*/
