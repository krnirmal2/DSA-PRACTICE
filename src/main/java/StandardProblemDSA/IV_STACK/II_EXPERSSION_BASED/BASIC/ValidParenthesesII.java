package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.BASIC;

/*
🔹 Problem Statement
Given a string s containing '(', ')', and '*', return true if the string is valid.

        '(' and ')' are normal parentheses.

'*' can be treated as:

        '('

        ')'

or an empty string

You need to check if it's possible to convert the string into a valid parentheses string by treating stars optimally.

*/

public class ValidParenthesesII {
  /*  🔍 Approach: Greedy (Two Pointers / Min-Max Balance)
      We track possible open parentheses count using a range:
      low: minimum number of open parentheses at this point
      high: maximum number of open parentheses at this point
  🪄 Greedy Insight:
              '(' → both low++, high++
              ')' → both low--, high--
              '*' → could be '(', ')', or empty:
      So low--, high++

              ✅ If high ever becomes negative → more ) than ( → invalid
  ✅ Clamp low = max(0, low)
  ✅ At the end, if low == 0, it's valid.*/
  public boolean checkValidString(String s) {
    int low = 0, high = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        low++;
        high++;
      } else if (ch == ')') {
        low--;
        high--;
      } else { // ch == '*'
        low--; // treat as ')'
        high++; // treat as '('
      }

      if (high < 0) return false; // Too many ')'
      low = Math.max(low, 0); // Clamp low to 0
    }

    return low == 0;
  }
  // System.out.println(checkValidString("()"));       // true
  // System.out.println(checkValidString("(*)"));      // true
  // System.out.println(checkValidString("(*))"));     // true
  // System.out.println(checkValidString("(((**)"));   // true
  // System.out.println(checkValidString("((*)"));     // true
  // System.out.println(checkValidString("(()*"));     // true
  // System.out.println(checkValidString("(*)("));     // false
  // System.out.println(checkValidString("((())"));    // false

}
