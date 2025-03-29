package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.RIGHT_TO_LEFT;

import java.util.Stack;

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
