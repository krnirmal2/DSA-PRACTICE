package StandardProblemDSA.IV_STACK.I_CUSTOM_STACK_DESIGN_PATTERN;

/*
    Problem:
    --------
    Design a stack that supports:
        • push(x) – O(1)
        • pop() – O(1)
        • randomAccessAtIndex(i) – O(1) random access to any element.

    Approach:
    ---------
    • Use an ArrayList<Integer> as the underlying data structure.
    • push(x):
        - Append to the end of ArrayList → O(1).
    • pop():
        - Remove the last element of ArrayList → O(1).
    • randomAccessAtIndex(i):
        - Validate index boundaries.
        - Use ArrayList.get(i) → O(1).

    Pattern:
    --------
    Stack implemented with dynamic arrays to support random access.

    Time Complexity:
    ----------------
        • push, pop, randomAccessAtIndex → O(1).

    Space Complexity:
    -----------------
        • O(n) for n elements.

    Follow-ups:
    -----------
    1. Add peek() to get the top element in O(1).
    2. Implement generic type support (Stack<T>).
    3. Handle concurrency using synchronized methods.

    Related Problems:
    -----------------
        • Custom Stack implementation with random access.
        • LeetCode 707 - Design Linked List (conceptually similar but with linked structure).
*/

import java.util.ArrayList;

/* Solution Design
To support Push, Pop, and Random Access:

Use a dynamic array (like ArrayList in Java) to store stack elements.
Push and Pop can be performed on the last element of the array in O(1).
Random Access can be done using get(i) in O(1).*/
public class RandomStackElementAccess {
  // to create an stack we have to create an
  ArrayList<Integer> stack;

  RandomStackElementAccess() {
    stack = new ArrayList<>();
  }

  public static void main(String[] args) {
    // we have to create the stack using the constructor
    RandomStackElementAccess s = new RandomStackElementAccess();

    // now define push method for insert element
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    // now define pop method for deleting element
    s.pop(); // pop top element is 4

    // now for random access
    System.out.println("Element at index 2 " + s.randomAccessAtIndex(2));
    System.out.println("Element at index 1" + s.randomAccessAtIndex(1));
  }

  // push method
  public void push(int element) {
    // As this arraylist so no overflow will be happend
    stack.add(element);
  }

  // pop method
  public int pop() {
    // we will check if the size of the stack is empty
    if (stack.isEmpty()) {
      System.out.println("no element to be deleted");
      return -1;
    }
    return stack.remove(stack.size() - 1);
  }

  // Random access on Stack
  public int randomAccessAtIndex(int index) {
    // validate the index boundary
    if (index == -1 || index >= stack.size()) {
      return -1; // invalid index so return -1 to indicate error
    }
    return stack.get(index);
  }
}
