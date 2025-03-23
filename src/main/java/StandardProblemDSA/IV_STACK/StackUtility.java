package StandardProblemDSA.IV_STACK;

import java.util.Stack;

public class StackUtility {

  /**
   * Reverses a given stack recursively. This method modifies the input stack such that the order of
   * elements is reversed.
   *
   * @param stack the stack to reverse
   */
  public static <T> void reverseStack(Stack<T> stack) {
    if (stack.isEmpty()) return;
    T temp = stack.pop();
    reverseStack(stack);
    insertAtBottom(stack, temp);
  }

  /**
   * Helper method to insert an element at the bottom of a stack.
   *
   * @param stack the stack
   * @param item the item to insert at the bottom
   */
  private static <T> void insertAtBottom(Stack<T> stack, T item) {
    if (stack.isEmpty()) {
      stack.push(item);
    } else {
      T temp = stack.pop();
      insertAtBottom(stack, item);
      stack.push(temp);
    }
  }

  /**
   * Sorts a stack in ascending order using recursion. This method is applicable to stacks of
   * integers.
   *
   * @param stack the stack to sort
   */
  public static void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int temp = stack.pop();
      sortStack(stack);
      sortedInsert(stack, temp);
    }
  }

  /**
   * Helper method for sorted insertion into a stack. It inserts an element into the sorted stack
   * such that the stack remains sorted.
   *
   * @param stack the stack (sorted in ascending order)
   * @param element the element to insert
   */
  private static void sortedInsert(Stack<Integer> stack, int element) {
    if (stack.isEmpty() || element > stack.peek()) {
      stack.push(element);
      return;
    }
    int temp = stack.pop();
    sortedInsert(stack, element);
    stack.push(temp);
  }

  /**
   * Prints the elements of the stack. Note: This prints elements in the order as they are stored in
   * the stack.
   *
   * @param stack the stack to print
   */
  public static <T> void printStack(Stack<T> stack) {
    for (T item : stack) {
      System.out.print(item + " ");
    }
    System.out.println();
  }
}
