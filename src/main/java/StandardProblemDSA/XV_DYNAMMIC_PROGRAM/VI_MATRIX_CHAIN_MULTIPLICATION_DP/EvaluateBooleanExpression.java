package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

public class EvaluateBooleanExpression {
  static boolean evaluate(boolean b1, boolean b2, char op) {
    if (op == '&') {
      return b1 & b2;
    } else if (op == '|') {
      return b1 | b2;
    }
    return b1 ^ b2;
  }

  // Function which returns the number of ways
  // s[i:j] evaluates to req.
  static int countRecur(int i, int j, boolean req, String s) {

    // Base case:
    if (i == j) {
      return (req == (s.charAt(i) == 'T')) ? 1 : 0;
    }

    int ans = 0;
    for (int k = i + 1; k < j; k += 1) {

      // Count Ways in which left substring
      // evaluates to true and false.
      int leftTrue = countRecur(i, k - 1, true, s);
      int leftFalse = countRecur(i, k - 1, false, s);

      // Count Ways in which right substring
      // evaluates to true and false.
      int rightTrue = countRecur(k + 1, j, true, s);
      int rightFalse = countRecur(k + 1, j, false, s);

      // Check if the combinations results
      // to req.
      if (evaluate(true, true, s.charAt(k)) == req) {
        ans += leftTrue * rightTrue;
      }
      if (evaluate(true, false, s.charAt(k)) == req) {
        ans += leftTrue * rightFalse;
      }
      if (evaluate(false, true, s.charAt(k)) == req) {
        ans += leftFalse * rightTrue;
      }
      if (evaluate(false, false, s.charAt(k)) == req) {
        ans += leftFalse * rightFalse;
      }
    }

    return ans;
  }

  static int countWays(String s) {

    int n = s.length();
    return countRecur(0, n - 1, true, s);
  }

  public static void main(String[] args) {
    String s = "T|T&F^T";
    System.out.println(countWays(s));
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

}
