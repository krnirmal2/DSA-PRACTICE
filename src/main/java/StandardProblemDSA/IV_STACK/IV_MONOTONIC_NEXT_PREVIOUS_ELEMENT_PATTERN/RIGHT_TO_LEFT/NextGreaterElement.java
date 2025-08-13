package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.RIGHT_TO_LEFT;

import java.util.Stack;

/*
Problem:
Given an array, find the Next Greater Element (NGE) for every element.
The NGE for an element x is the first greater element to the right of x; if none exists, return -1.

Pattern:
Monotonic Decreasing Stack (traverse from right to left):
- Maintain a stack where top always holds the next greater candidate.
- For each element:
  - Pop all elements smaller or equal to it (they can’t be the NGE).
  - If stack is empty → no greater element exists → result = -1.
  - Else → result = top of stack.
  - Push current element onto the stack.

Time Complexity:
O(n) — each element is pushed and popped at most once.

Space Complexity:
O(n) — for the stack and the result array.

LeetCode Similar Questions:
- 496. Next Greater Element I : DONE
- 503. Next Greater Element II (circular array variation)
- 739. Daily Temperatures (similar logic with indices) DONE

Follow-up Questions:
- How to handle a circular array (wrap-around)?
- Can we do it in-place with O(1) extra space?
- How to adapt for "Next Smaller Element" or "Previous Greater Element"?
*/

public class NextGreaterElement {
  /*    Input: arr[] = [1, 3, 2, 4]
  Output: [3, 4, 4, -1]
  Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4,
  since it doesn’t exist, it is -1.*/
  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4};
    int[] result = nextGreaterElement(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] nextGreaterElement(int[] arr) {
    // Steps
    /*  - **Approach:**
          - Traverse the array from **right to left**.
          - Maintain a stack where the **top** contains the next greater element for upcoming elements.
          - Push/pop as necessary to maintain order.
    - **Stack Type:** Monotonic **Decreasing** Stack from bottom to top
    that smaller elements remain on top, helping us find next smaller elements efficiently.
         */
    int length = arr.length;
    int[] result = new int[length];
    Stack<Integer> s = new Stack<>();
    // travers right to left
    for (int i = length - 1; i >= 0; i--) {
      //
      while (!s.isEmpty() && arr[i] >= s.peek()) {
        s.pop();
      }
      result[i] = s.isEmpty() ? -1 : s.peek();
      s.push(arr[i]);
    }
    return result;
  }
}
