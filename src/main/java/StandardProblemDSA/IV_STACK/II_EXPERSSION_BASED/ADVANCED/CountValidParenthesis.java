package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

/*🔹 Problem Statement
Given an even number n, return the number of valid parentheses expressions that can be formed using n characters (i.e., n / 2 pairs).
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
  public int countValidParentheses(int n) {
    if (n % 2 != 0) return 0; // must be even
    int k = n / 2;
    long[] dp = new long[k + 1];
    dp[0] = 1;

    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - 1 - j];
      }
    }

    return (int) dp[k];
  }
}
