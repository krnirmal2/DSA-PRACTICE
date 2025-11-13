package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Converts a string to a 32-bit signed integer (mimics atoi function)
 *
 * <p>Problem Definition: - Read in and ignore any leading whitespace - Check for '+' or '-' to
 * determine sign - Read digits until non-digit or end of string - Convert digits to integer (clamp
 * to INT range if out of bounds) - Return final integer with sign
 *
 * <p>Example: Input: " -42" Output: -42
 *
 * <p>Approach: 1. Skip whitespace 2. Handle sign 3. Process digits with overflow check 4. Return
 * result with sign
 *
 * <p>Pattern: Parsing + overflow handling. - Skip leading spaces. - Determine sign. - Process
 * consecutive digits while checking for overflow. - Stop when non-digit encountered.
 *
 * <p>Follow-ups: 1. Handle bases other than 10 (e.g., hexadecimal). 2. Implement support for
 * underscores, thousand separators, etc. 3. Compare with `Integer.parseInt` and discuss exception
 * handling.
 *
 * <p>LeetCode Similar Problems: 8. String to Integer (atoi), 65. Valid Number (string parsing
 * validation)
 *
 * <p>Time Complexity: O(N) — scanning each character once. Space Complexity: O(1) — constant extra
 * memory.
 */
public class StringToInteger {
  public static int myAtoi(String s) {
    int index = 0;
    int sign = 1;
    int result = 0;
    int n = s.length();

    // 1. Skip whitespace
    while (index < n && s.charAt(index) == ' ') {
      index++;
    }

    // 2. Handle sign
    if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
      sign = s.charAt(index) == '-' ? -1 : 1;
      index++;
    }

    // 3. Process digits
    while (index < n && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';

      // Check for overflow
      if (result > Integer.MAX_VALUE / 10
          || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      result = result * 10 + digit;
      index++;
    }

    // 4. Return result with sign
    return sign * result;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("42")); // 42
    System.out.println(myAtoi("   -42")); // -42
    System.out.println(myAtoi("4193 with words")); // 4193
    System.out.println(myAtoi("words and 987")); // 0
  }
}
