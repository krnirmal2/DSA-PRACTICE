package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

public class MinimumAddToMakeValidParenthesis {
  /*Return the minimum number of parentheses needed to make a given string valid.

    Example:
    📌 Input: s = "()))(("
    📌 Output: 4 (add 2 ( and 2 ))

    💡 Approach:
    Use a counter for unbalanced parentheses:
    If ( is encountered, increment openCount.
    If ) is encountered:
    If there is an unmatched (, decrement openCount.
    Otherwise, increment closeCount.
    Final answer = openCount + closeCount.

  Pattern: Greedy counting of unmatched '(' and ')'.

  Time Complexity: O(n) — single pass through the string.
  Space Complexity: O(1) — uses only two counters.

  LeetCode Similar Questions:
  - 921. Minimum Add to Make Parentheses Valid
  - 20. Valid Parentheses
  - 1541. Minimum Insertions to Balance a Parentheses String

  Follow-up Questions:
  - Modify to return the corrected valid string instead of just the count.
  - Extend logic to handle all types of brackets ({}, []).
  - Solve in a streaming manner where the input comes in chunks.*/
  public static int minAddToMakeValid(String s) {
    int openCount = 0, closeCount = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') {
        openCount++;
      } else { // ch == ')'
        if (openCount > 0) {
          openCount--; // Matched pair
        } else {
          closeCount++; // Extra ')'
        }
      }
    }
    return openCount + closeCount;
  }

  /*  s= "()))(("
  | Char | open | insertions | Explanation        |
  | ---- | ---- | ---------- | ------------------ |
  | `(`  | 1    | 0          | push `(`           |
  | `)`  | 0    | 0          | matched            |
  | `)`  | 0    | 1          | no `(` → need one  |
  | `)`  | 0    | 2          | again → insert one |
  | `(`  | 1    | 2          | push `(`           |
  | `(`  | 2    | 2          | push `(`           |
  */
  public static void main(String[] args) {
    //        Solution sol = new Solution();
    System.out.println(minAddToMakeValid("()))((")); // 4
  }
}
