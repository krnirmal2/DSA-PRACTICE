package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.Stack;

public class PerviousSmallerElement {
  /*
  Problem:
  For each element in the array, find the nearest smaller element to its left.
  If none exists, return -1.

  Pattern:
  Monotonic Increasing Stack (stores values, not indices).
  - Traverse left to right.
  - Maintain a stack where elements are in increasing order from bottom to top.
  - Pop until we find a smaller element.
  - The top of the stack (if any) is the nearest smaller element.

  Time Complexity:
  O(n) — each element is pushed and popped at most once.

  Space Complexity:
  O(n) — stack + result array.

  LeetCode Similar Questions:
  - 503. Next Greater Element II (variation)
  - 739. Daily Temperatures (next greater variant)
  - 84. Largest Rectangle in Histogram (uses nearest smaller)

  Follow-up Questions:
  - How to return indices instead of values?
  - How to handle circular arrays?
  - Can we adapt it for next smaller element on the right?
  */

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4};
    int[] result = previousSmallerElement(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] previousSmallerElement(int[] arr) {
    // Steps
    /*  - **Approach:**
          - Traverse the array from **left to right**.
          - Maintain a stack where the **top** contains the previous smaller element for upcoming elements.
          - Push/pop as necessary to maintain order.
    - **Stack Type:** Monotonic **increase** Stack from bottom to top
         */
    int length = arr.length;
    int[] result = new int[length];
    Stack<Integer> s = new Stack<>();
    // travers each element
    for (int i = 0; i < length; i++) {
      // if stack is not empty and the element is at i less than stack peek then pop that element
      // as we need increase element in the stack so remove the top
      while (!s.isEmpty() && arr[i] <= s.peek()) {
        s.pop();
      }
      // if stack is empty then put -1 to the result else the peek element
      result[i] = s.isEmpty() ? -1 : s.peek();
      // and then push the element not above satisfy
      s.push(arr[i]);
    }
    return result;
  }
}
