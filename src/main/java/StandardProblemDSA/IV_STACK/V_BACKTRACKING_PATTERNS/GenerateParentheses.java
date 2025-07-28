package StandardProblemDSA.IV_STACK.V_BACKTRACKING_PATTERNS;

import java.util.ArrayList;
import java.util.List;

/*
Problem:
Given n pairs of parentheses, generate all combinations of well-formed parentheses.
Example:
n = 3 → ["((()))","(()())","(())()","()(())","()()()"]

Pattern:
Backtracking — build the string step by step,
adding '(' if we still have some left and ')' if it won’t make the string invalid.

Approach:
- Maintain counts of open and close brackets used.
- Add '(' if open < n.
- Add ')' if close < open.
- When current string length == 2 * n, add to result.

Time Complexity:
O(4^n / √n) — nth Catalan number combinations.
Space Complexity:
O(n) recursion stack + O(4^n / √n) for storing results.

LeetCode Similar Questions:
- 22. Generate Parentheses
- 301. Remove Invalid Parentheses
- 856. Score of Parentheses

Follow-up Questions:
- How would you modify it to generate combinations for multiple bracket types?
- Can you generate them iteratively using a queue (BFS)?
- How would you count the number of valid parentheses without generating them?
*/

public class GenerateParentheses {
  public static List<String> generateParentheses(int n) {
    List<String> result = new ArrayList<>();
    generate(result, "", 0, 0, n);
    return result;
  }

  private static void generate(List<String> result, String current, int open, int close, int n) {
    if (current.length() == 2 * n) {
      result.add(current);
      return;
    }
    if (open < n) generate(result, current + "(", open + 1, close, n);
    if (close < open) generate(result, current + ")", open, close + 1, n);
  }

  public static void main(String[] args) {
    System.out.println(generateParentheses(3));
  }
}
