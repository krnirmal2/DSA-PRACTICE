package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

import java.util.*;

public class GenerateAllparenthesis {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, "", 0, 0, n);
    return result;
  }

  private void backtrack(List<String> result, String current, int open, int close, int max) {
    if (current.length() == max * 2) {
      result.add(current);
      return;
    }

    if (open < max) {
      backtrack(result, current + "(", open + 1, close, max);
    }

    if (close < open) {
      backtrack(result, current + ")", open, close + 1, max);
    }
  }
  /*
  🧠 Dry Run (n = 2)
      We build step-by-step:

      pgsql
              Copy
      Edit
      Start with: "", open=0, close=0
              → "(", open=1
              → "((", open=2
              → "(()", close=1
              → "(())", close=2 ✅ Valid

  → "()", open=1, close=1
              → "()(", open=2
              → "()()", close=2 ✅ Valid
      Output: ["(())", "()()"]

              ⏱️ Time & Space Complexity
      Time: O(2^2n) worst case
              (But actual count is the nth Catalan Number, Cₙ = (1/(n+1))·C(2n,n))

      Space: O(n) recursion depth + result list
  */

}
