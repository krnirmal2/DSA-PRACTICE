package StandardProblemDSA.II_STRING.III_STRING_MANIPULATION_PATTERN;

import static StandardProblemDSA.II_STRING.StringUtility.trimSpaces;

/**
 * Problem: Remove leading and trailing whitespace from a given string. Example: " Hello World! " →
 * "Hello World!".
 *
 * <p>Pattern: Manual two-pointer approach — find first and last non-space characters and create
 * substring.
 *
 * <p>Follow-ups: 1. Implement trimming without using built-in functions like `trim()`. 2. Extend to
 * remove extra spaces between words (full normalization). 3. Handle tabs, newlines, and other
 * whitespace characters.
 *
 * <p>LeetCode Similar Problems: 58. Length of Last Word, 151. Reverse Words in a String
 *
 * <p>Time Complexity: O(N) — single scan to find non-space bounds. Space Complexity: O(1) auxiliary
 * (ignoring output substring).
 */
public class TrimLeadAndTrailWhiteSpace {

  public static void main(String[] args) {
    String input = "   Hello World!   ";

    String trimmed = trimSpaces(input);

    System.out.println("Original: \"" + input + "\"");
    System.out.println("Trimmed: \"" + trimmed + "\"");
  }
}
