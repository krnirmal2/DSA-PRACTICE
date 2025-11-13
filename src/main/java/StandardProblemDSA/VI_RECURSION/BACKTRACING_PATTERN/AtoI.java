package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

/*
Problem:
Implement `atoi` — convert a string to a 32-bit signed integer following specific constraints:
- Ignore leading spaces.
- Handle optional '+' or '-' sign.
- Parse valid digits until a non-digit is encountered.
- Clamp to [-2^31, 2^31 - 1] in case of overflow.

Pattern:
String parsing + iterative digit construction with overflow handling.

Approach:
1. Skip leading whitespace.
2. Determine the sign (+/-).
3. Convert each digit: `result = result * 10 + digit`.
4. Stop at first non-digit.
5. Clamp result if overflow occurs.

Time Complexity:
O(n) — we process each character at most once.

Space Complexity:
O(1) — only a few variables used.

Similar LeetCode Questions:
- 8. String to Integer (atoi)
- 65. Valid Number
- 67. Add Binary

Follow-up Questions:
- Can you implement without using built-in trim()?
- How to extend this for hexadecimal or floating-point parsing?
- Can you optimize to handle very large inputs without overflow checks on every step?
*/

public class AtoI {
  // convert String to integer with following constraints
  /* Constraints & Considerations
  Ignore leading whitespace (e.g., " 42" → 42).
  Handle optional + or - sign ("-42" → -42, "+42" → 42).
  Convert valid numeric characters until a non-numeric character appears ("42abc" → 42).
  Clamp values to 32-bit integer range ([-2³¹, 2³¹ - 1]):
  If the number exceeds 2³¹ - 1 (2147483647), return 2147483647.
  If the number is less than -2³¹ (-2147483648), return -2147483648.*/
  /*🔹 Approach
  1. Trim leading spaces
  Use a pointer/index to skip initial whitespace.
  2. Identify sign
  Check for + or - and update sign.
  3. Convert characters to digits
  Start reading characters until a non-digit is found.
  Multiply by 10 and add the digit to construct the number.
  4. Handle integer overflow
  If result > Integer.MAX_VALUE / 10 or
  If result == Integer.MAX_VALUE / 10 && next_digit > 7, return Integer.MAX_VALUE (for positive numbers).
  If result == Integer.MIN_VALUE / 10 && next_digit > 8, return Integer.MIN_VALUE (for negative numbers).*/
  public static int myAtoi(String s) {
    return helper(s.trim(), 0, 0, 1);
  }

  private static int helper(String s, int i, int result, int sign) {
    // Base case: If all characters are processed
    if (i >= s.length()) return sign * result;

    char ch = s.charAt(i);

    // Handle sign at the start
    if (i == 0 && (ch == '+' || ch == '-')) {
      return helper(s, i + 1, result, ch == '-' ? -1 : 1);
    }

    // Stop if the character is not a digit
    if (!Character.isDigit(ch)) return sign * result;

    int digit = ch - '0';

    // Overflow handling
    if (result > (Integer.MAX_VALUE - digit) / 10) {
      return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    // Recursively process the next character
    return helper(s, i + 1, result * 10 + digit, sign);
  }

  public static void main(String[] args) {
    //    System.out.println(myAtoi("42")); // Output: 42
    //    System.out.println(myAtoi("   -42")); // Output: -42
    //    System.out.println(myAtoi("4193 with words")); // Output: 4193
    //    System.out.println(myAtoi("words and 987")); // Output: 0
    System.out.println(myAtoi("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
  }

  /* private static int myAtoi(String s) {
      // edge case
      if(s == null || s.length() == 0) return 0;
      //check for other cases
      int result =0;
      int i =0; int sign = 1;
      int n = s.length();
      // step1. ignore white space
      while(i<n && s.charAt(i) == ' ') i++; // i will reach the actual no. index
      // step 2: check for sign
      if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
          sign = (s.charAt(i) == '-') ?-1 :1;
          i++;
      }
      // step 3:convert String to number
      while(i<n && Character.isDigit(s.charAt(i))){
          int digit = s.charAt(i)- '0';
          //over flow check
          if(result> (Integer.MAX_VALUE - digit)/10){
              return  (sign==1) ?Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          // else continue
          result = result *10 + digit;
          i++;
      }

      return sign * result;
  }*/
}
