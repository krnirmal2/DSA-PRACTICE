package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.Stack;

public class LargestRectangleArea {
  /*

      The problem requires finding the largest rectangular area in a histogram, where the histogram is represented as an array of heights.
              🔹 Approach:
      We use a Monotonic Increasing Stack to efficiently find:
      The next smaller height (right boundary).
      The previous smaller height (left boundary).
      By maintaining a stack of increasing heights, we can pop elements when a smaller height is encountered and calculate the maximum area possible.
              🔹 Step-by-Step Algorithm
      Use a stack to store indices of histogram bars.
      Traverse the histogram:
      If the current height is greater than or equal to the top of the stack, push it.
      If the current height is smaller, pop the stack and calculate the largest possible rectangle using the popped height as the smallest height.
      At the end, process remaining bars in the stack to compute areas.
      Return the maximum area found.
  */
  // ✅ Utility Method: Largest Rectangle in Histogram → Monotonic Increasing Stack
  public static int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>(); // Stack to store indices of histogram bars
    int maxArea = 0; // Variable to track maximum rectangular area
    int n = heights.length; // Number of bars in the histogram

    // Iterate through each bar and one extra iteration (i == n) for final calculations
    for (int i = 0; i <= n; i++) {
      // Treat an extra height of 0 at the end to ensure all bars are processed
      int h = (i == n) ? 0 : heights[i];
      // If the current height is smaller than the height at stack top, process stack
      while (!stack.isEmpty() && h < heights[stack.peek()]) {
        int height = heights[stack.pop()]; // Pop the top height from the stack
        // Calculate the width of the rectangle
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        // Calculate the area and update maxArea if it's greater
        maxArea = Math.max(maxArea, height * width);
      }
      // Push the current index into the stack
      stack.push(i);
    }

    return maxArea; // Return the maximum area found
  }

  // ✅ Driver Code to Test the Function
  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3};
    System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
  }
  /*🔹 Dry Run Example
  Input:
          heights = {2, 1, 5, 6, 2, 3}
  Stack Operations:
  Index (i)	Height (h)	Stack (top → bottom)	Action	Computed Area
          0	2	[0]	Push 0	-
          1	1	[]	Pop 0, Compute 2 × 1	2
          1	1	[1]	Push 1	-
          2	5	[1, 2]	Push 2	-
          3	6	[1, 2, 3]	Push 3	-
          4	2	[1, 2]	Pop 3, Compute 6 × 1	6
          4	2	[1]	Pop 2, Compute 5 × 2	10
          4	2	[1, 4]	Push 4	-
          5	3	[1, 4, 5]	Push 5	-
          6	0	[1, 4]	Pop 5, Compute 3 × 1	3
          6	0	[1]	Pop 4, Compute 2 × 4	8
          6	0	[]	Pop 1, Compute 1 × 6	6
  Final Output:
  Largest Rectangle Area: 10*/
}
