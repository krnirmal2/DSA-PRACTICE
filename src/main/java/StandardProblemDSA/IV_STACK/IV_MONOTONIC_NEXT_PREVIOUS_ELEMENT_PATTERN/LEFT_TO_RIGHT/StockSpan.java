package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.Stack;

/*BRUTE FORCE :  idea is to use nested loops, where the outer loop iterates
through the array to process each stock price. For each day,
the inner loop moves leftward in the array, comparing previous prices and
increasing the span count until a higher price is found or the beginning of the array
is reached.*/

public class StockSpan { // ✅ Utility Method: Stock Span Problem → Monotonic Decreasing Stack
  public static int[] stockSpan(int[] prices) {
    int n = prices.length;
    int[] span = new int[n];
    Stack<Integer> stack = new Stack<>();
    //        previousGreaterElement
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
        stack.pop();
      }
      span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
      stack.push(i);
    }
    return span;
  }

  public static void main(String[] args) {

    int[] arr = {10, 4, 5, 90, 120, 80};

    int[] span = stockSpan(arr);

    for (int x : span) {
      System.out.print(x + " ");
    }
  }
  /*
      * Time Complexity : O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of array is added and removed from stack at most once. So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).
  Auxiliary Space : O(n) in worst case when all elements are sorted in decreasing order.

  */
}
