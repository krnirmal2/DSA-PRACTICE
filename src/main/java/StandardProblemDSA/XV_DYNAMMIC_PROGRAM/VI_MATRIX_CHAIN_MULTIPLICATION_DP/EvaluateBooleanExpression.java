package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

public class EvaluateBooleanExpression {
  /*
  Boolean Parenthesization Problem
  Given a boolean expression `s` of length `n` (with symbols 'T', 'F' and operators '&', '|', '^'),
  find the number of ways to parenthesize the expression such that it evaluates to True.

  ---
  Example 1:
  Input: s = "T|F&T"
  Output: 2
  Explanation:
    1. (T | (F & T)) = T | F = T
    2. ((T | F) & T) = T & T = T

  Example 2:
  Input: s = "T^T^F"
  Output: 0

  ---
  ❓ Why:
  - Each way of adding parentheses changes the order of evaluation and thus the result.
  - We need to count all such valid parenthesizations that evaluate to `True`.

  ---
  💡 Pattern:
  - This is a **Matrix Chain Multiplication / Interval DP** problem.
  - We break the expression at every operator and evaluate left and right subexpressions for both `True` and `False`.
  - Recurrence:
      ways(i, j, true) =
          Σ over k [ ways(i, k-1, LT) * ways(k+1, j, RT) ] for all operator outcomes that evaluate to `True`.

  - Memoization table: `dp[i][j][2]` to store ways for `True` and `False` for substring `s[i..j]`.

  ---
  ⏱ Time Complexity: O(n³)
  📦 Space Complexity: O(n²) for DP table (or O(n³) if storing for True/False separately).

  ---
  🔄 Follow-up:
  - Convert recursion to bottom-up tabulation.
  - Optimize by precomputing operator results.
  - Can also be solved with a 3D DP array: `dp[i][j][boolean]`.

  ---
  🔗 LeetCode / Related:
  - GFG: Boolean Parenthesization Problem
  - Related: 312. Burst Balloons, Matrix Chain Multiplication, 241. Different Ways to Add Parentheses
  */
  /*Approach:
  The recursive algorithm steps are as follows:
  Convert the problem to a recursive function marked by the pointers i and j and the isTrue variable discussed above.
  Use a loop to check all possible partitions of the expression and calculate the total number of ways.
  Return the total number of ways calculated.
  Base case 1: If i > j, we will return 0.
  Base case 2: If i and j become equal, we will observe two different cases:
  Case 1 (If we want the number of ways of true(i.e. isTrue = 1)):
  If the single operand left is T(true), it will return 1 way and if it is F(false), it will return 0 ways.
  Case 2 (If we want the number of ways of false(i.e. isTrue = 0)):
  If the single operand left is T(true), it will return 0 ways and if it is F(false), it will return 1 way.*/

  static final int MOD = 1000000007; // modulor for large no.

  static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
    // Base case 1: When the start index is greater than the end index, no ways to evaluate.
    if (i > j) {
      return 0;
    }
    // Base case 2: When the start and end indices are the same.
    if (i == j) {
      if (isTrue == 1) {
        return exp.charAt(i) == 'T' ? 1 : 0;
      } else {
        return exp.charAt(i) == 'F' ? 1 : 0;
      }
    }

    if (dp[i][j][isTrue] != null) {
      return dp[i][j][isTrue];
    }

    long ways = 0;
    for (int ind = i + 1;
        ind <= j - 1;
        ind += 2) { // no of partition means no. operator in the current expression
      long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
      long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp);
      // right half true and false evaluation
      long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
      long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);

      char operator = exp.charAt(ind);
      // NO of ways we will get true and false in truth table of the operator
      if (operator
          == '&') { // for and operator only both left and right half true will give true and other
        // false
        if (isTrue == 1) {
          ways = (ways + (lT * rT) % MOD) % MOD;
        } else {
          ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
        }
      } else if (operator
          == '|') { // for OR operator only false and false of subproblem give false else true
        if (isTrue == 1) {
          ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
        } else {
          ways = (ways + (lF * rF) % MOD) % MOD;
        }
      } else {
        if (isTrue == 1) { // for XOR operator left true and right false True and vice versa
          ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
        } else {
          ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
        }
      }
    }

    dp[i][j][isTrue] = ways;
    return ways;
  }

  static int evaluateExpWays(String exp) {
    int n = exp.length();
    Long[][][] dp =
        new Long[n][n]
            [2]; // dp[i][j][k] stores the number of ways to evaluate the subexpression from index i
    // to j with the result k (0 or 1).
    return (int) evaluateExpressionWays(exp, 0, n - 1, 1, dp);
  }

  public static void main(String[] args) {
    String exp = "F|T^F";
    int ways = evaluateExpWays(exp);
    System.out.println("The total number of ways: " + ways);
  }
}

  /* class GfG {
  [Expected Approach 1]- Using Top-Down DP – O(n^3) Time and O(n^2) Space
  If we notice carefully, we can observe that the above recursive solution holds the following two properties of Dynamic Programming:
  1. Optimal Substructure: Number of ways to make expression s[i, j] evaluate to req depends on the optimal solutions of countWays(i, k-1, 0), countWays(i, k-1, 1), countWays(k+1, j, 0) and countWays(k+1, j, 1) where k lies between i and j.
  2. Overlapping Subproblems: While applying a recursive approach in this problem, we notice that certain subproblems are computed multiple times. For example, countWays(0, 4, 1) and countWays(0, 7, 1) will call the same subproblem countWays(0, 2, 0) twice.

          // Function to evaluate a
          // boolean condition.
          static boolean evaluate(int b1, int b2, char op)
          {
              if (op == '&') {
                  return (b1 & b2) == 1;
              }
              else if (op == '|') {
                  return (b1 | b2) == 1;
              }
              return (b1 ^ b2) == 1;
          }

          // Function which returns the number of ways
          // s[i:j] evaluates to req.
          static int countRecur(int i, int j, int req, String s,
                                int[][][] memo)
          {

              // Base case:
              if (i == j) {
                  return (req == (s.charAt(i) == 'T' ? 1 : 0))
                          ? 1
                          : 0;
              }

              // If value is memoized
              if (memo[i][j][req] != -1) {
                  return memo[i][j][req];
              }

              int ans = 0;
              for (int k = i + 1; k < j; k += 1) {

                  // Count Ways in which left substring
                  // evaluates to true and false.
                  int leftTrue = countRecur(i, k - 1, 1, s, memo);
                  int leftFalse
                          = countRecur(i, k - 1, 0, s, memo);

                  // Count Ways in which right substring
                  // evaluates to true and false.
                  int rightTrue
                          = countRecur(k + 1, j, 1, s, memo);
                  int rightFalse
                          = countRecur(k + 1, j, 0, s, memo);

                  // Check if the combinations result
                  // to req.
                  if (evaluate(1, 1, s.charAt(k)) == (req == 1)) {
                      ans += leftTrue * rightTrue;
                  }
                  if (evaluate(1, 0, s.charAt(k)) == (req == 1)) {
                      ans += leftTrue * rightFalse;
                  }
                  if (evaluate(0, 1, s.charAt(k)) == (req == 1)) {
                      ans += leftFalse * rightTrue;
                  }
                  if (evaluate(0, 0, s.charAt(k)) == (req == 1)) {
                      ans += leftFalse * rightFalse;
                  }
              }

              return memo[i][j][req] = ans;
          }

          static int countWays(String s)
          {

              int n = s.length();
              int[][][] memo = new int[n][n][2];
              for (int[][] mat : memo) {
                  for (int[] row : mat) {
                      Arrays.fill(row, -1);
                  }
              }
              return countRecur(0, n - 1, 1, s, memo);
          }

          public static void main(String[] args)
          {
              String s = "T|T&F^T";
              System.out.println(countWays(s));
          }
      }*/
