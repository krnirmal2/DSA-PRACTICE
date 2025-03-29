package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.RIGHT_TO_LEFT;

import java.util.Stack;

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
