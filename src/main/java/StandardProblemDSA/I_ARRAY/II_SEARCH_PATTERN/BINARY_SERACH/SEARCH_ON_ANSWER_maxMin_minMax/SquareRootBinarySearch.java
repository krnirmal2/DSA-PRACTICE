package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class SquareRootBinarySearch {
  /*
  Problem Statement:
  Given a non-negative integer x, compute and return the square root of x rounded down to the nearest integer.
  The returned integer should be the floor of the true square root.
  You must not use any built-in exponent function or operator.

  Examples:
  Input: x = 10
  Output: 3
  Explanation: The square root of 10 is approximately 3.16, and since we are returning the floor, answer = 3.

  Input: x = 16
  Output: 4

  Pattern:
  - Binary Search on the answer space.
  - We search in the range [0, x] for the integer y such that y*y ≤ x < (y+1)*(y+1).

  Related LeetCode Questions:
  - LeetCode 69: Sqrt(x) Done

  Follow-ups:
  1. How to compute the square root with decimal precision (e.g., up to 6 places)?
  2. How to handle very large numbers (use `long` to avoid overflow)?
  3. Could we solve it using Newton-Raphson method for faster convergence?
  */

  public static int squareRoot(int x) {
    if (x == 0 || x == 1) {
      return x; // Square root of 0 or 1 is itself
    }

    int low = 0, high = x, result = 0; // we  can't take x/2 as high it will give divide zero error

    while (low <= high) {
      int mid = low + (high - low) / 2; // take care of divide zero

      // If mid*mid equals x, return mid
      if (mid <= x / mid) { // To avoid overflow, use x/mid instead of mid*mid
        result = mid; // Store potential result
        low = mid + 1; // Search in the right half
      } else {
        high = mid - 1; // Search in the left half
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int x = 10;
    System.out.println("Square root of " + x + " is: " + squareRoot(x));

    x = 16;
    System.out.println("Square root of " + x + " is: " + squareRoot(x));

    x = 50;
    System.out.println("Square root of " + x + " is: " + squareRoot(x));
  }
}
