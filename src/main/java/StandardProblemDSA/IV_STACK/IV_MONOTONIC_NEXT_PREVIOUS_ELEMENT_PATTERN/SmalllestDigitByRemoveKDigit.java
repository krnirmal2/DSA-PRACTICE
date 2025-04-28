package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN;

public class SmalllestDigitByRemoveKDigit {
  /*402. Remove K Digits
  Solved
  Medium
  Topics
  Companies
  Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



  Example 1:

  Input: num = "1432219", k = 3
  Output: "1219"
  Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
  Example 2:

  Input: num = "10200", k = 1
  Output: "200"
  Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
  Example 3:

  */
  public class Solution {
    public String removeKdigits(String num, int k) {
      // Use a StringBuilder as a stack
      StringBuilder stack = new StringBuilder();

      for (char digit : num.toCharArray()) {
        // While k > 0 and the last digit in stack > current digit, remove last digit
        while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
          stack.deleteCharAt(stack.length() - 1);
          k--;
        }
        stack.append(digit);
      }

      // If k > 0, remove remaining digits from the end
      while (k > 0 && stack.length() > 0) {
        stack.deleteCharAt(stack.length() - 1);
        k--;
      }

      // Remove leading zeros
      int start = 0;
      while (start < stack.length() && stack.charAt(start) == '0') {
        start++;
      }

      String result = stack.substring(start);

      // If result is empty, return "0"
      return result.isEmpty() ? "0" : result;
    }
  }
  /*We'll use:

  ini
  Copy
  Edit
  num = "1432219", k = 3
  We want the smallest possible number after removing 3 digits.

  Initialize:

  Stack = empty

  k = 3

  Step-by-Step Traversal:

  '1': Stack empty → push '1' → Stack = ['1']

  '4': '4' > '1' → push '4' → Stack = ['1', '4']

  '3': '3' < '4' → '4' is bigger!

  Remove '4' (k = 2) → Stack = ['1']

  Now '3' > '1' → push '3' → Stack = ['1', '3']

  '2': '2' < '3' → '3' is bigger!

  Remove '3' (k = 1) → Stack = ['1']

  Now '2' > '1' → push '2' → Stack = ['1', '2']

  '2': '2' = '2' → push '2' → Stack = ['1', '2', '2']

  '1': '1' < '2' → '2' is bigger!

  Remove '2' (k = 0) → Stack = ['1', '2']

  Now '1' > '2' is false → push '1' → Stack = ['1', '2', '1']

  '9': k = 0 → just push '9' → Stack = ['1', '2', '1', '9']

  Now, k = 0 ✅

  Final Stack = ['1', '2', '1', '9']

  Result = "1219"

  ✅

  */
}
