package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED;

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
  Final answer = openCount + closeCount.*/
  public static int minAddToMakeValid(String s) {
    int openCount = 0, closeCount = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') {
        openCount++;
      } else if (openCount > 0) {
        openCount--; // Matched pair
      } else {
        closeCount++; // Extra ')'
      }
    }
    return openCount + closeCount;
  }

  public static void main(String[] args) {
    //        Solution sol = new Solution();
    System.out.println(minAddToMakeValid("()))((")); // 4
  }
}
