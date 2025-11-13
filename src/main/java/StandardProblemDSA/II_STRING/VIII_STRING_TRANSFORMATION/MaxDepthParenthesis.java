package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Problem: Maximum Nesting Depth of Parentheses
 *
 * <p>Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the
 * maximum number of nested parentheses.
 *
 * <p>Examples: Input: s = "(1+(2*3)+((8)/4))+1" Output: 3 Explanation: Digit 8 is inside of 3
 * nested parentheses in the string.
 *
 * <p>Input: s = "(1)+((2))+(((3)))" Output: 3 Explanation: Digit 3 is inside of 3 nested
 * parentheses in the string.
 *
 * <p>Input: s = "()(())((()()))" Output: 3
 *
 * <p>Constraints: 1 <= s.length <= 100 s consists of digits 0-9 and characters '+', '-', '*', '/',
 * '(', and ')'. It is guaranteed that s is a valid parentheses string (VPS). Pattern: Single-pass
 * counter — increment on '(', decrement on ')', track maximum depth.
 *
 * <p>Follow-ups: 1. Validate parentheses while computing depth (handle unbalanced strings). 2.
 * Extend to support multiple bracket types: {}, [], (). 3. Return the substring corresponding to
 * the maximum depth.
 *
 * <p>LeetCode Similar Problems: 1614. Maximum Nesting Depth of the Parentheses, 856. Score of
 * Parentheses
 *
 * <p>Time Complexity: O(N) — single traversal of the string. Space Complexity: O(1) — only counters
 * used.
 */
public class MaxDepthParenthesis {

  /**
   * Approach: 1. Initialize two counters: 'res' for the maximum depth, and 'cur' for the current
   * depth. 2. Iterate through each character in the string: - If the character is '(', increment
   * 'cur' and update 'res' to the maximum of 'res' and 'cur'. - If the character is ')', decrement
   * 'cur'. 3. After the loop, 'res' contains the maximum nesting depth.
   *
   * <p>Time Complexity: O(n), where n is the length of the string. Space Complexity: O(1)
   */
  public int maxDepth(String s) {
    int res = 0, cur = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') res = Math.max(res, ++cur);
      if (s.charAt(i) == ')') cur--;
    }
    return res;
  }
}
