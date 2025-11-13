package StandardProblemDSA.II_STRING.II_SEARCH_AND_REPLACE;

import StandardProblemDSA.II_STRING.StringUtility;

/**
 * Problem: Find the first and last occurrence indices of a given pattern in a text using the KMP
 * algorithm. Example: text = "aabaacaadaabaaba", pattern = "aaba" → first = 0, last = 12.
 *
 * <p>Pattern: Knuth-Morris-Pratt (KMP) string matching — preprocess pattern with LPS array for
 * efficient searching.
 *
 * <p>Follow-ups: 1. Modify to return all occurrences (use a list). 2. Handle case-insensitive
 * searches or patterns with wildcards. 3. Compare KMP efficiency with Rabin-Karp and Z-algorithm
 * for different text-pattern sizes.
 *
 * <p>LeetCode Similar Problems: 28. Find the Index of the First Occurrence in a String, 686.
 * Repeated String Match, 796. Rotate String
 *
 * <p>Time Complexity: O(N + M) → O(M) for LPS computation + O(N) for searching. Space Complexity:
 * O(M) for storing the LPS array.
 */
public class FirstAndLastOccuranceOfpattern {
  public static void main(String[] args) {
    String txt = "aabaacaadaabaaba";
    String pat = "aaba";

    kmpSearch(pat, txt);
  }

  private static void kmpSearch(String pat, String txt) {
    // find the length of the each
    int n = txt.length();
    int m = pat.length();

    // Step1;
    // create array for precompute LPS array
    // compute LPC of the pattern not the string
    int[] lps = StringUtility.computePatternLps(pat);

    // Step 2:
    int i = 0; // Pointer for text
    int j = 0; // Pointer for pattern
    int firstOccurrence = -1;
    int lastOccurrence = -1;
    while (i < n) {
      // step 3;
      // case : 1 : if match move both pointer i and j
      if (txt.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
      }
      // case : 2 : if match whole we just return the i-j for first index
      if (j == m) // if j is equal to its lenght
      {
        if (firstOccurrence == -1) {
          firstOccurrence = i - j; // Store the first occurrence
        }
        lastOccurrence = i - j; // Update last occurrence
        // move next for any further match
        j = lps[j - 1];
      } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
        //                case 3. if not matched
        if (j != 0) {
          j = lps[j - 1]; // Use LPS to skip unnecessary comparisons
        } else {
          i++; // No LPS, move to the next character in text
        }
      }
    }

    System.out.println("First occurrence index: " + firstOccurrence);
    System.out.println("Last occurrence index: " + lastOccurrence);
  }
}
