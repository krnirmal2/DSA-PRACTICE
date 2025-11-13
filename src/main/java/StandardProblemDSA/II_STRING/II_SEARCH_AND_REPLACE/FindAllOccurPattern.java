package StandardProblemDSA.II_STRING.II_SEARCH_AND_REPLACE;

import StandardProblemDSA.II_STRING.StringUtility;
import java.util.ArrayList;
import java.util.List;

public class FindAllOccurPattern {
  /**
   * Problem: Find all starting indices where the pattern occurs in the given text using the KMP
   * algorithm. Example: text = "ABABABCABABABCABABABC", pattern = "ABABC" → [2, 9, 16]
   *
   * <p>Pattern: Knuth-Morris-Pratt (KMP) string matching — preprocess pattern using LPS array to
   * achieve linear search.
   *
   * <p>Follow-ups: 1. Modify to return only the first occurrence or count of occurrences. 2.
   * Implement case-insensitive or wildcard search. 3. Compare with Rabin-Karp for cases with
   * multiple patterns or hash-based searching.
   *
   * <p>LeetCode Similar Problems: 28. Find the Index of the First Occurrence in a String, 686.
   * Repeated String Match, 796. Rotate String
   *
   * <p>Time Complexity: O(N + M) → O(M) for LPS computation + O(N) for searching all matches. Space
   * Complexity: O(M) for storing the LPS array.
   */
  public static List<Integer> findAllOccurrences(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    // Step1 : find the lps of the string
    int[] lps = StringUtility.computePatternLps(pattern);

    List<Integer> occurrences = new ArrayList<>();
    int i = 0, j = 0;

    // Step ; match the pattern and text and add all the indexes
    // during matchPatWithText
    // so we need to manipulate the match function each time for this kind of
    // question
    while (i < n) {
      // case 1 : when both pattern and text length matched we will increase both pointer
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }
      // case 2 :if the pattern pointer reached its end means we found the pattern so add to the
      // result (i-j) as start and i as
      if (j == m) {
        occurrences.add(i - j);
        j = lps[j - 1];
      } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
        // case 3 : if the character is not matched and prefix length is not zero , then either set
        // it to earlier value
        // else increamen tex pointer
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return occurrences;
  }

  public static void main(String[] args) {
    String text = "ababcabcabababd";
    String pattern = "ab";

    List<Integer> occurrences = new ArrayList<>();
    int index = text.indexOf(pattern);
    while (index != -1) {
      occurrences.add(index);
      index = text.indexOf(pattern, index + 1);
    }

    System.out.println("All occurrences at indices: " + occurrences);

    List<Integer> result = findAllOccurrences(text, pattern);
    System.out.println("All occurrences at indices: " + result);
  }
}
