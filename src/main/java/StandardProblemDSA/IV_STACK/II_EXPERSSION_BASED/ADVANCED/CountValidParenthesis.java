package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

/*🔹 Problem Statement
Given an even number n, return the number of valid parentheses expressions that can be formed using n characters (i.e., n / 2 pairs).
If n is odd → return 0 (since parentheses must come in pairs).
Input: n = 4
Output: 2
Explanation: ["(())", "()()"]
Input: n = 6
Output: 5
Explanation: ["((()))", "(()())", "(())()", "()(())", "()()()"]*/

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
