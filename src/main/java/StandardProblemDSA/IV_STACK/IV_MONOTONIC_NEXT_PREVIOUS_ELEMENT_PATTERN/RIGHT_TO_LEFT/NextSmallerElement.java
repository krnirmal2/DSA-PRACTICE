package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.RIGHT_TO_LEFT;

import java.util.Stack;

/*
Problem:
Given an array, find the Next Smaller Element (NSE) for every element.
The NSE for an element x is the first smaller element to the right of x; if none exists, return -1.

Pattern:
Monotonic Increasing Stack (traverse from right to left):
- Maintain a stack where top always holds the next smaller candidate.
- For each element:
  - Pop all elements greater or equal to it (they can’t be the NSE).
  - If stack is empty → no smaller element exists → result = -1.
  - Else → result = top of stack.
  - Push current element onto the stack.

Time Complexity:
O(n) — each element is pushed and popped at most once.

Space Complexity:
O(n) — for the stack and the result array.

LeetCode Similar Questions:
- 496. Next Greater Element I (opposite logic)
- 503. Next Greater Element II (variation for greater)
- 739. Daily Temperatures (conceptually similar with indices)

Follow-up Questions:
- How to handle circular arrays (wrap-around)?
- Can we do it in-place with O(1) extra space?
- How to modify for "Previous Smaller Element" or "Next Greater Element"?
*/

public class NextSmallerElement {
  public static void main(String[] args) {
    int[] arr = {33, 4, 4, 2, 15, 532};
    int[] result = nextSmallerElement(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] nextSmallerElement(int[] arr) {
    // Steps
    /*  - **Approach:**
          - Traverse the array from **right to left**.
          - Maintain a stack where the **top** contains the next smaller element for upcoming elements.
          - Push/pop as necessary to maintain order.
    - **Stack Type:** Monotonic **increaseing** Stack from bottom to top
    that greater elements remain on top, helping us find next greater  elements efficiently.
         */
    int length = arr.length;
    int[] result = new int[length];
    Stack<Integer> s = new Stack<>();
    // travers right to left
    for (int i = length - 1; i >= 0; i--) {
      //
      while (!s.isEmpty() && arr[i] <= s.peek()) {
        s.pop();
      }
      result[i] = s.isEmpty() ? -1 : s.peek();
      s.push(arr[i]);
    }
    return result;
  }
}
