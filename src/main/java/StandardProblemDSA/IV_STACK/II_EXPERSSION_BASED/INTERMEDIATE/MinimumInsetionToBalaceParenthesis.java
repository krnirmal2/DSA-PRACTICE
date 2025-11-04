package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

public class MinimumInsetionToBalaceParenthesis {
  /*
  Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
  Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
  Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
  In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

  For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
  You can insert the characters '(' and ')' at any position of the string to balance it if needed.
  Return the minimum number of insertions needed to make s balanced.

      Example 1:
      Input: s = "(()))"
      Output: 1
      Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.

      Example 2:
      Input: s = "())"
      Output: 0
      Explanation: The string is already balanced.

      Example 3:
      Input: s = "))())("
      Output: 3
      Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
      Constraints:

  1 <= s.length <= 105
  s consists of '(' and ')' only.

  🔑 Better Approach to Understand
  1. Track How Many ) Are Still Needed

  We introduce a counter:
      right = 0 → how many ) we still need to make the string valid.
  Think of it like pending closing brackets.

  2. Rules While Scanning String
  We move left to right, and handle two cases:
   Case A: When we see '('
      Normally it needs two ) → so right += 2.
      BUT if right was odd before, it means we were already waiting for just 1 ) (from an earlier unmatched ) case).
      Example: ")(" → here the first ) forced us to need a fake '('.
      To fix this:
      Insert 1 ) (increase ans).
      Decrease right-- (closing that 1).
      Then add 2 for the new '('.

  Case B: When we see ')'
      Consume one needed ) → so right--.
      If right becomes negative:
      → means we had too many ) and no '(' to match.
          Insert one '(' (increase ans).
          Since this fake '(' expects 2 ), and one is already consumed, set right = 1.
  3. After Scanning
  If after finishing, right > 0, it means we still owe that many ) → so add them to an
  */

  public int minInsertions(String s) {
    int ans = 0; // insertions count
    int right = 0; // pending ')' needed

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        if (right % 2 == 1) { // odd number of ')' pending
          ans++; // insert one ')'
          right--; // fix imbalance
        }
        right += 2; // '(' needs two ')'
      } else { // ch == ')'
        right--; // consume one ')'
        if (right < 0) { // more ')' than '('
          ans++; // insert one '('
          right = 1; // this '(' needs one more ')'
        }
      }
    }
    return ans + right; // add missing ')'
  }
}
/*e: s = "(()))("
| Char | Action                                  | right | ans |
| ---- | --------------------------------------- | ----- | --- |
| `(`  | Needs 2 `)` → `right += 2`              | 2     | 0   |
| `(`  | Needs 2 `)` → `right += 2`              | 4     | 0   |
| `)`  | Consume one `)` → `right--`             | 3     | 0   |
| `)`  | Consume one `)` → `right--`             | 2     | 0   |
| `)`  | Consume one `)` → `right--`             | 1     | 0   |
| `(`  | Needs 2 `)` → but `right` was odd (1) → |       |     |
|      | Insert 1 `)` (`ans++`), `right--`       | 0     | 1   |
|      | Then add 2 for new `(` → `right += 2`   | 2     | 1   |
*/
