package StandardProblemDSA.IV_STACK.I_CUSTOM_STACK_DESIGN_PATTERN;

import java.util.ArrayList;
import java.util.Stack;

/*
    Problem:
    --------
    Implement a SetOfStacks data structure:
        • It should behave like a single stack.
        • When the current stack exceeds a threshold capacity,
          create a new stack.
        • Support push(), pop(), peek(), and isEmpty() operations.

    Approach:
    ---------
    • Maintain an ArrayList<Stack<Integer>> to hold multiple stacks.
    • threshold → maximum capacity of a single stack.
    • push(x):
        - If no stacks exist or the last stack is full, create a new stack.
        - Push onto the last stack.
    • pop():
        - Pop from the last stack.
        - If the last stack becomes empty, remove it.
    • peek():
        - Return the top element of the last stack.
    • isEmpty():
        - Return true if there are no stacks or all stacks are empty.

    Pattern:
    --------
    Stack of Stacks (variation of “stack capacity partitioning”).

    Time Complexity:
    ----------------
        • push, pop, peek → O(1)
        • isEmpty → O(1)

    Space Complexity:
    -----------------
        • O(n) for n elements distributed across all stacks.

    Follow-ups:
    -----------
    1. Implement popAt(index) to pop from a specific stack.
    2. Add automatic shifting of elements to maintain balance after popAt().
    3. Generic version for any type T.

    Related Problems:
    -----------------
        • Cracking the Coding Interview Q3.3 – Set of Stacks.
        • Stack capacity management for bounded stacks.
*/

public class SetOfStacks {
  private final ArrayList<Stack<Integer>> stacks; // List to store the set of stacks
  private final int threshold; // The threshold limit for each stack

  // Constructor to initialize the Set of Stacks
  public SetOfStacks(int threshold) {
    this.stacks = new ArrayList<>();
    this.threshold = threshold;
  }

  // Main method to test the Set of Stacks
  public static void main(String[] args) {
    SetOfStacks stackSet =
        new SetOfStacks(3); // Set of stacks with a threshold of 3 plates per stack

    // Push plates onto the stack
    stackSet.push(1);
    stackSet.push(2);
    stackSet.push(3);
    stackSet.push(4); // A new stack is created because the first stack reached its threshold
    stackSet.push(5);

    // Peek the top plate
    System.out.println("Top plate (peek): " + stackSet.peek()); // Should return 5

    // Pop plates
    System.out.println("Popped plate: " + stackSet.pop()); // Should return 5
    System.out.println("Popped plate: " + stackSet.pop()); // Should return 4

    // Check if Set of Stacks is empty
    System.out.println("Is the Set of Stacks empty? " + stackSet.isEmpty()); // Should return false
  }

  // Push a plate onto the stack
  public void push(int plate) {
    // If the last stack is full, create a new one
    if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == threshold) {
      Stack<Integer> newStack = new Stack<>();
      newStack.push(plate);
      stacks.add(newStack);
    } else {
      // Otherwise, push the plate onto the last stack
      stacks.get(stacks.size() - 1).push(plate);
    }
  }

  // Pop a plate from the top of the stack
  public int pop() {
    if (stacks.isEmpty()) {
      throw new IllegalStateException("No plates in the stack");
    }

    Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
    int plate = lastStack.pop();

    // If the last stack is now empty, remove it
    if (lastStack.isEmpty()) {
      stacks.remove(stacks.size() - 1);
    }

    return plate;
  }

  // Peek at the top plate of the last stack
  public int peek() {
    if (stacks.isEmpty()) {
      throw new IllegalStateException("No plates in the stack");
    }

    return stacks.get(stacks.size() - 1).peek();
  }

  // Check if the Set of Stacks is empty
  public boolean isEmpty() {
    return stacks.isEmpty();
  }
}
