package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Converts a string to a number with given base (2-36)
 *
 * <p>Problem Definition: - Convert string representation of number in given base to decimal -
 * Handle digits 0-9 and letters A-Z (case insensitive)
 *
 * <p>Example: Input: "1A", 16 Output: 26 (1*16^1 + 10*16^0)
 *
 * <p>Approach: 1. Validate base 2. Process each character 3. Convert character to digit value 4.
 * Calculate decimal value
 *
 * <p>Pattern: Base conversion. - Validate base range. - Iterate characters: map [0-9A-Z] to digits.
 * - Accumulate result using: result = result * base + digit.
 *
 * <p>Follow-ups: 1. Support negative numbers and fractional parts. 2. Handle very large numbers
 * (BigInteger) to avoid overflow. 3. Implement the reverse (decimal to any base).
 *
 * <p>LeetCode Similar Problems: 504. Base 7, 405. Convert a Number to Hexadecimal, 1017. Convert to
 * Base -2
 *
 * <p>Time Complexity: O(N) — scanning each character once. Space Complexity: O(1) — constant extra
 * space.
 */
public class StringToNumberWithBase {
  public static int convertToDecimal(String str, int base) {
    if (base < 2 || base > 36) {
      throw new IllegalArgumentException("Base must be between 2 and 36");
    }

    str = str.toUpperCase();
    int result = 0;

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int digit;

      if (Character.isDigit(c)) {
        digit = c - '0';
      } else if (c >= 'A' && c <= 'Z') {
        digit = 10 + (c - 'A');
      } else {
        throw new IllegalArgumentException("Invalid character in input string");
      }

      if (digit >= base) {
        throw new IllegalArgumentException("Digit exceeds base value");
      }

      result = result * base + digit;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(convertToDecimal("1010", 2)); // 10
    System.out.println(convertToDecimal("1a", 16)); // 26 (0-9 and A,b,c.d.e.f
    System.out.println(convertToDecimal("ZZ", 36)); // 1295
  }
}
