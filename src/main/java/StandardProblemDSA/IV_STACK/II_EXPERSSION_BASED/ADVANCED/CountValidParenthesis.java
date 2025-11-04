package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

/*🔹 Problem Statement
Given an even number n, return the number of valid parentheses expressions that can be formed using
n characters (i.e., n / 2 pairs).
If n is odd → return 0 (since parentheses must come in pairs).
Input: n = 4
Output: 2
Explanation: ["(())", "()()"]

Input: n = 6
Output: 5
Explanation: ["((()))", "(()())", "(())()", "()(())", "()()()"]

 (well-formed parentheses combinations) using n characters (n/2 pairs).

    Explanation:
    ------------
    • If n is odd → return 0, as valid parentheses require pairs.
    • For even n = 2k, the number of valid expressions = k-th Catalan number.
    • Catalan number recurrence:
        C(n) = Σ (C(i) * C(n - 1 - i)) for i = 0 to n-1
        Base case: C(0) = 1

    Approach:
    ---------
    • Use dynamic programming (DP array of size k + 1).
    • Build up Catalan numbers from 0 to k.
    • Return dp[k].

    Pattern:
    --------
    Catalan Numbers / DP / Parentheses Counting.

    Time Complexity:
    ----------------
        • O(k²) where k = n/2
    Space Complexity:
        • O(k)

    Follow-ups:
    -----------
        1. Generate all valid parentheses (LeetCode 22).
        2. Compute Catalan numbers for large n using BigInteger.
        3. Use direct formula: C(n) = (1 / (n + 1)) * (2n choose n).

    Related Problems:
    -----------------
        • Unique BSTs (LeetCode 96).
        • Number of ways to triangulate a polygon.
        • Count non-crossing handshakes.*/

public class CountValidParenthesis {
  static int helper(int left, int right, int[] ans) {

    // If no more left and right parentheses
    // are remaining, a valid combination is found
    if (left == 0 && right == 0) {
      ans[0]++;
      return ans[0];
    }

    // If more right parentheses than left, return
    // (invalid state)
    if (left > right) {
      return 0;
    }

    // Try adding a left parenthesis if available
    if (left > 0) {
      helper(left - 1, right, ans);
    }

    // Try adding a right parenthesis if available
    if (right > 0) {
      helper(left, right - 1, ans);
    }

    return ans[0];
  }

  // Function to count valid parentheses arrangements of
  // length n
  static int findWays(int n) {

    // If n is odd, no valid arrangements
    // possible
    if (n % 2 == 1) return 0;
    int[] ans = {0};
    return helper(n / 2, n / 2, ans);
  }

  public static void main(String[] args) {
    int n = 6;
    int res = findWays(n);
    System.out.println(res);
    /*
    // Returns value of Binomial Coefficient C(n, k)
    static int binomialCoeff(int n, int k) {
      int res = 1;

      // Since C(n, k) = C(n, n-k)
      if (k > n - k)
        k = n - k;

      // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
      for (int i = 0; i < k; ++i) {
        res *= (n - i);
        res /= (i + 1);
      }

      return res;
    }

    // A Binomial coefficient based function to
    // find nth catalan number in O(n) time
    static int catalan(int n) {

      // Calculate value of 2nCn
      int c = binomialCoeff(2 * n, n);

      // return 2nCn/(n+1)
      return (int) (c / (n + 1));
    }

    // Function to find possible ways to put balanced
    // parenthesis in an expression of length n
    static int findWays(int n) {

      // If n is odd, not possible to
      // create any valid parentheses
      if ((n & 1) == 1)
        return 0;

      // Otherwise return n/2'th Catalan
      // Number
      return catalan(n / 2);
    }

    public static void main(String[] args) {
      int n = 6;
      System.out.println(findWays(n));
    }*/ }
}
