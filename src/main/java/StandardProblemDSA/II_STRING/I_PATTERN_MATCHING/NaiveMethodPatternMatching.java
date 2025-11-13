package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

import static StandardProblemDSA.II_STRING.StringUtility.naiveSearchStringPattern;

/**
 * Problem: Implement the naive pattern matching algorithm to find all occurrences of a pattern in a
 * text. Check every possible alignment of the pattern in the text by direct comparison. Example:
 * text = "ABABABCABABABCABABABC", pattern = "ABABC" → matches at indices 2, 9, 16.
 *
 * <p>Pattern: Brute-force string matching — check pattern at every position in the text (sliding
 * window).
 *
 * <p>Follow-ups: 1. Optimize using KMP (LPS array), Rabin-Karp (hashing), or Z-algorithm for faster
 * matching. 2. Implement case-insensitive or wildcard matching. 3. Compare efficiency for small vs.
 * large patterns and texts.
 *
 * <p>LeetCode Similar Problems: 28. Find the Index of the First Occurrence in a String (strStr),
 * 459. Repeated Substring Pattern
 *
 * <p>Time Complexity: O((N - M + 1) * M) ≈ O(N * M) in worst case. Space Complexity: O(1) (no extra
 * data structures used).
 */
public class NaiveMethodPatternMatching {

  public static void main(String[] args) {
    String text = "";
    String pattern = "";
    naiveSearchStringPattern(pattern, text);
  }
}
