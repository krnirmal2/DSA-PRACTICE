package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

/*
    Problem:
    --------
    Given a string s containing '(', ')', and '*', determine if it can be a valid parentheses string.
    '(' and ')' behave normally.
    '*' can be treated as '(' or ')' or empty string.

    Examples:
    ---------
      Input: "()"
      Output: true

      Input: "(*))"
      Output: true

    Approach:
    ---------
      Use a greedy range-tracking approach with two counters:
      - low: the minimum possible number of open '(' at current position.
      - high: the maximum possible number of open '(' at current position.

      For each char:
        '(' → low++, high++
        ')' → low--, high--
        '*' → low-- (treat as ')'), high++ (treat as '(')

      At any point:
        - If high < 0 → too many ')' → invalid.
        - Clamp low to zero because open count can't be negative.

      At the end:
        - If low == 0 → string can be balanced.

    Intuition:
    ----------
      Track the possible open parentheses range to handle '*'.

### Pattern
- **Greedy two-pointer / range tracking**
- Maintain a range `[low, high]` of possible open parentheses count:
  - `'('` → `low++`, `high++`
  - `')'` → `low--`, `high--`
  - `'*'` → `low--`, `high++` (treat `*` as `(` or `)` or empty)
- If at any point `high < 0` → invalid (more `)` than `(`)
- Clamp `low` to at least `0` since open parentheses can't be negative
- If at end `low == 0` → valid string

---

### Time and Space Complexity
- **Time:** O(n), one pass over the string
- **Space:** O(1), constant extra space

---

### Similar LeetCode Questions
- [678. Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)
- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [1249. Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

---

### Follow-up Questions
1. Can you solve this with a stack instead of greedy pointers?
2. How to handle multiple types of brackets with `*` allowed?
3. Can you return the number of possible valid interpretations of the string?
4. What if `*` can only be empty or `'('` (no `')'`)? How does that change the algorithm?
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
  public static boolean checkValidString(String s) {
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

  /*   "(*))"
    low = 0, high = 0
  i=0: '(' → low = 1, high = 1
  i=1: '*' → low = 0, high = 2
  i=2: ')' → low = -1 → clamp to 0, high = 1
  i=3: ')' → low = -1 → clamp to 0, high = 0

          → low == 0 at end → ✅ valid*/

  public static void main(String[] args) {
    System.out.println(checkValidString("()")); // true
    System.out.println(checkValidString("(*)")); // true
    System.out.println(checkValidString("(*))")); // true
    System.out.println(checkValidString("(((**)")); // true
    System.out.println(checkValidString("((*)")); // true
    System.out.println(checkValidString("(()*")); // true
    System.out.println(checkValidString("(*)(")); // false
    System.out.println(checkValidString("((())")); // false
  }
}
