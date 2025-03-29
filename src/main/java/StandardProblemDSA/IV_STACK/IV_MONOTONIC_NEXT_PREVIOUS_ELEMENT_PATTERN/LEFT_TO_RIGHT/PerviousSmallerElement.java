package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.Stack;

public class PerviousSmallerElement {

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
    // travers right to left
    for (int i = 0; i < length; i++) {
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
