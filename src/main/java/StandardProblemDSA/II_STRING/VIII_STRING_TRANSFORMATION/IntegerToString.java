package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Problem: Convert an integer to its string representation (mimics `itoa`). Example: -123 → "-123",
 * 0 → "0".
 *
 * <p>Pattern: Math-based conversion: - Handle negative numbers separately. - Extract digits from
 * right to left using modulo/division. - Build the string in reverse and then reverse it at the
 * end.
 *
 * <p>Follow-ups: 1. Handle different number bases (binary, hexadecimal, etc.). 2. Implement the
 * reverse (`atoi`) to convert a string back to an integer. 3. Optimize to avoid reversing by
 * appending to a character array from the end.
 *
 * <p>LeetCode Similar Problems: 8. String to Integer (atoi), 7. Reverse Integer
 *
 * <p>Time Complexity: O(log₁₀ N) — proportional to the number of digits. Space Complexity: O(1)
 * auxiliary (ignoring output string).
 */
public class IntegerToString {
  public static String itoa(int num) {
    if (num == 0) return "0";

    boolean isNegative = num < 0;
    if (isNegative) num = -num;

    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      sb.append(num % 10); // give last digit
      num /= 10; // give the remaining number
    }

    if (isNegative) sb.append('-');

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(itoa(123)); // "123"
    System.out.println(itoa(-123)); // "-123"
    System.out.println(itoa(0)); // "0"
  }
}
