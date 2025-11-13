package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

/*I see why this code is problematic — it’s trying to brute force up to **n = 1,000,000,000**, which is not feasible for `A = 807,414,236`.
        ### Problem
You’re trying to find the **A-th "magical" number** (a number divisible by either B or C) modulo $10^9 + 7$.
This is a known problem:
        * **LeetCode 878. Nth Magical Number**
        ### Pattern
* **Binary search on answer space**:
        * Search between `low = min(B, C)` and `high = A * min(B, C)`.
        * For a mid value, count how many numbers ≤ mid are divisible by B or C:

    \text{count} = \frac{mid}{B} + \frac{mid}{C} - \frac{mid}{LCM(B, C)}
  * Narrow the search based on whether `count < A`.
        ### Optimized Implementation*/

public class magicalNoBorCdivisibleNo {
  static final int MOD = 1_000_000_007;

  // Helper to compute GCD
  private static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  // Helper to compute LCM
  private static long lcm(long a, long b) {
    return (a * b) / gcd(a, b);
  }

  public static int solve(int A, int B, int C) {
    long l = Math.min(B, C);
    long r = (long) A * l; // maximum possible value
    long LCM = lcm(B, C);

    while (l < r) {
      long mid = l + (r - l) / 2;
      long count = mid / B + mid / C - mid / LCM;

      if (count < A) l = mid + 1;
      else r = mid;
    }
    return (int) (l % MOD);
  }

  public static void main(String[] args) {
    System.out.println(solve(807414236, 3788, 38141)); // Efficient!
  }
}
/*

* **Time**: $O(\log(A \times \min(B, C)))$
* **Space**: $O(1)$
        ### Follow-ups
* What if `A`, `B`, and `C` are very large (close to $10^{18}$)?
        * Can we solve for "Nth number divisible by any of multiple numbers"?
*/
