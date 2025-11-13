package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.Stack;

/*
Problem:
For each element in the array, find the nearest greater element to its left.
If none exists, return -1.

Pattern:
Monotonic Decreasing Stack (stores values, not indices).
- Traverse left to right.
- Maintain a stack where elements are in decreasing order from bottom to top.
- Pop all smaller or equal elements until a greater one is found.
- The top of the stack (if any) is the nearest greater element.

Time Complexity:
O(n) — each element is pushed and popped at most once.

Space Complexity:
O(n) — stack + result array.

LeetCode Similar Questions:
- 503. Next Greater Element II
- 739. Daily Temperatures
- 84. Largest Rectangle in Histogram (variation with greater elements)

Follow-up Questions:
- How to return indices instead of values?
- Can we do it for the "next greater element" to the right?
- Can we adapt for circular arrays or streaming data?
*/

public class previousGreaterElement {
  /*    Input: arr[] = [1, 3, 2, 4]
  Output: [3, 4, 4, -1]
  Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4,
  since it doesn’t exist, it is -1.*/
  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4};
    int[] result = previousGreaterElement(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] previousGreaterElement(int[] arr) {
    // Steps
    /*  - **Approach:**
          - Traverse the array from **left to right**.
          - Maintain a stack where the **top** contains the previous greater element for upcoming elements.
          - Push/pop as necessary to maintain order.
    - **Stack Type:** Monotonic **Decreasing** Stack from bottom to top
    that smaller elements remain on top, helping us find next smaller elements efficiently.
         */
    int length = arr.length;
    int[] result = new int[length];
    Stack<Integer> s = new Stack<>();
    // travers right to left
    for (int i = 0; i < length; i++) {
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
