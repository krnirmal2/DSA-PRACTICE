package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class NthRootOfNumberUsingBinary {

  /*
  Problem Statement:
  ------------------
  Find the N-th root of a number M with a precision of 1e-6 (or up to 6 decimal places).

  - N: the degree of the root.
  - M: the number.
  Return the N-th root of M.

  Example:
  --------
  Input: N = 3, M = 27
  Output: 3.000000 (because 3^3 = 27)

  Pattern:
  --------
  - **Binary Search on Answer**.
  - Search space: [1, M] (if M ≥ 1).
    If M < 1, search in [0, 1].
  - For a given mid, check if mid^N is less than, greater than, or approximately equal to M.
  - Narrow search space until desired precision.

  Why Binary Search Works:
  ------------------------
  - The function f(x) = x^N is monotonically increasing for x > 0.
  - We can check mid^N relative to M to decide which half to keep.

  Complexity:
  -----------
  - Time: O(log(M) * N) → log(M) iterations, each computing mid^N.
  - Space: O(1).

  Related Problems:
  -----------------
  - 69. Sqrt(x) DONE
  - 50. Pow(x, n) todo
  - 367. Valid Perfect Square
  */

  // Helper to compute mid^n and compare with m
  private static double power(double mid, int n) {
    double ans = 1.0;
    for (int i = 0; i < n; i++) {
      ans *= mid;
    }
    return ans;
  }

  public static double findNthRoot(int n, int m) {
    double low = 1.0, high = m;
    double eps = 1e-6; // precision

    // Adjust range for numbers between 0 and 1
    if (m < 1) {
      high = 1.0;
      low = m;
    }

    while ((high - low) > eps) {
      double mid = (low + high) / 2.0;
      double val = power(mid, n);

      if (val > m) {
        high = mid; // mid^n is too big, decrease mid
      } else {
        low = mid; // mid^n is too small, increase mid
      }
    }
    return low; // low (or high) is the approximate root
  }

  public static void main(String[] args) {
    int n = 3, m = 27;
    System.out.printf("The %dth root of %d is %.6f%n", n, m, findNthRoot(n, m));
  }
}
