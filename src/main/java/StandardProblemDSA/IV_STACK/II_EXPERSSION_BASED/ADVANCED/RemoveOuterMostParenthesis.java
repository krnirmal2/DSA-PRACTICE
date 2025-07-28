package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

public class RemoveOuterMostParenthesis {
  /*
      Problem:
      --------
      Given a valid parentheses string S, remove the outermost parentheses
      of every primitive substring.

      Example:
      --------
          Input:  S = "(()())(())"
          Output: "()()()"

      Approach:
      ---------
          • Use an integer counter `openCount` instead of a stack.
          • For each character:
              - When encountering '(':
                  - If `openCount` > 0, append to result.
                  - Increment `openCount`.
              - When encountering ')':
                  - Decrement `openCount`.
                  - If `openCount` > 0, append to result.

      Pattern:
      --------
          Counting-based parentheses processing.

      Dry Run:
      --------
          S = "(()())(())"
          openCount progression: [1,2,1,2,1,0][1,2,1,0]
          Result: "()()()"

      Time Complexity:
      ----------------
          • O(N), single traversal of string.

      Space Complexity:
      -----------------
          • O(N) for StringBuilder.

      Follow-ups:
      -----------
          1. Can this be extended to remove outermost brackets of other types?
          2. Can we do this in-place (modifying char array)?
  */

  public static String removeOuterParentheses(String s) {
    StringBuilder result = new StringBuilder();
    int openCount = 0;

    for (char c : s.toCharArray()) {
      if (c == '(' && openCount++ > 0) result.append(c);
      if (c == ')' && --openCount > 0) result.append(c);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    //        Solution sol = new Solution();
    System.out.println(removeOuterParentheses("(()())(())")); // "()()()"
  }
}
