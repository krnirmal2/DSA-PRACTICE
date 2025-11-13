package StandardProblemDSA.IV_STACK.I_CUSTOM_STACK_DESIGN_PATTERN;

import java.util.Stack;

/*
    Problem:
    --------
    Design a stack with extended functionalities:
        • push(x) and pop() - standard stack operations.
        • getMin() - returns the minimum element in O(1).
        • getMax() - returns the maximum element in O(1).
        • Handles updates for min and max stacks during push/pop.

    Approach:
    ---------
    • Maintain three stacks:
        - `stack`: holds actual elements.
        - `minStack`: tracks the minimum value at each level.
        - `maxStack`: tracks the maximum value at each level.

    • push(x):
        - Push x onto the main stack.
        - Push min(x, top of minStack) onto minStack.
        - Push max(x, top of maxStack) onto maxStack.

    • pop():
        - Pop from all three stacks to keep them in sync.

    • getMin() / getMax():
        - Return top of minStack or maxStack.

    Pattern:
    --------
    Stack with auxiliary data structures for O(1) min/max retrieval.

    Time Complexity:
    ----------------
        • push, pop, getMin, getMax → O(1).

    Space Complexity:
    -----------------
        • O(n) for n elements (due to maintaining three stacks).

    Follow-ups:
    -----------
    1. Implement middle-element retrieval in O(1) (requires DLL + pointers).
    2. Support increment operations (lazy propagation).
    3. Support stack size optimization by storing differences instead of full duplicates.

    Related Problems:
    -----------------
        • LeetCode 155 - Min Stack
        • Design a stack that supports getMin() and getMax() in O(1).
*/

public class MultipleOperationStack {

  // min/max get element ==> we need to track the min and max stack array
  // each time during push and pop
  Stack<Integer> stack;
  Stack<Integer> minStack;
  Stack<Integer> maxStack;

  public MultipleOperationStack() {
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
    this.maxStack = new Stack<>();
  }

  public static void main(String[] args) {
    // we need to create the object of multiOperation Stack

    MultipleOperationStack ms = new MultipleOperationStack();
    // now add the element in to the stack
    ms.push(1);
    ms.push(2);
    ms.push(5);
    ms.push(3);
    ms.push(-1);

    // now for element get min and max
    System.out.println("min in the stack : " + ms.getMin()); // return -1
    System.out.println("Max  in the stack : " + ms.getMax()); // return 5

    // now pop element and we will check the current min and max

    ms.pop();
    // now for element get min and max
    System.out.println("min in the stack : " + ms.getMin()); // return -1
    System.out.println("Max  in the stack : " + ms.getMax()); // return 5

    ms.pop();
    // now for element get min and max
    System.out.println("min in the stack : " + ms.getMin()); // return -1
    System.out.println("Max  in the stack : " + ms.getMax()); // return 5
  }

  public void push(int element) {
    // check if the minStack  has minimum value till each element entry or not
    if (minStack.isEmpty() || maxStack.isEmpty()) {
      minStack.push(element);
      maxStack.push(element);
      stack.push(element);
      return;
    }
    // if the element is small from the peak element of the minstack then add that element other
    // wise it will add the current pick element of the min stack
    // continue the element which is already min
    boolean minValue =
        element <= minStack.peek() ? minStack.add(element) : minStack.add(minStack.peek());
    // if the element is greater tha already pick eleemnt in max stack then add other wise add
    // already present stack
    boolean maxValue =
        element >= maxStack.peek() ? maxStack.add(element) : maxStack.add(maxStack.peek());

    // at the end add the element in the stack
    stack.add(element);
  }

  public int getMin() {
    if (minStack.isEmpty()) {
      throw new IllegalStateException("Stack is empty. No minimum value.");
    }
    return minStack.peek();
  }

  public int getMax() {
    if (maxStack.isEmpty()) {
      throw new IllegalStateException("Stack is empty. No maximum value.");
    }
    return maxStack.peek();
  }

  // pop
  public int pop() {
    // during pop we need to check both min and max  should be also
    // updated
    if (stack.isEmpty()) {
      throw new IllegalStateException("Stack is empty. Cannot pop.");
    }

    if (!minStack.isEmpty()) {
      minStack.pop();
    }
    if (!maxStack.isEmpty()) {
      maxStack.pop();
    }
    return stack.pop();
  }
}
