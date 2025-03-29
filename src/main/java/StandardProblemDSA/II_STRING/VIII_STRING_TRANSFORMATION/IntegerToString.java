package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Converts an integer to a string (mimics itoa function)
 *
 * <p>Problem Definition: - Handle all integers including negative numbers - Return string
 * representation of the number
 *
 * <p>Example: Input: -123 Output: "-123"
 *
 * <p>Approach: 1. Handle negative numbers 2. Extract digits in reverse order 3. Reverse the digits
 * 4. Return final string
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
