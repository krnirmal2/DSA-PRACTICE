package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

import StandardProblemDSA.II_STRING.StringUtility;

public class KMP_algo {
  /**
   * Problem: Implement KMP (Knuth-Morris-Pratt) algorithm to find all occurrences of a pattern in a
   * text. Example: text = "abcdabcabcdf", pattern = "abcdf" → match at index 7.
   *
   * <p>Pattern: String matching using preprocessing of the pattern (LPS array) to achieve O(N + M)
   * time.
   *
   * <p>Follow-ups: 1. Modify to find and return all match indices instead of printing. 2. Adapt for
   * case-insensitive search or with wildcards. 3. Compare with Rabin-Karp and Z-algorithm for
   * different use cases.
   *
   * <p>LeetCode Similar Problems: 28. Find the Index of the First Occurrence in a String (Implement
   * strStr), 686. Repeated String Match, 796. Rotate String
   *
   * <p>Time Complexity: O(N + M) → O(M) for LPS computation + O(N) for searching. Space Complexity:
   * O(M) for the LPS array.
   *
   * | Tip                             | Description                                                         |
   * | ------------------------------- | ------------------------------------------------------------------- |
   * | 🔁 Use LPS                      | LPS avoids unnecessary re-comparisons.                              |
   * | 🧪 Dry Run                      | Always dry run the LPS computation with patterns like `"ababaca"`   |
   * | 🔄 Reset only pattern index `j` | On mismatch, don’t restart from beginning — jump to `lps[j-1]`.     |
   * | ⚡ Memory Efficient              | Use `char[]` instead of `String` if working with huge text streams. |
   * | 🧩 Combine with Boyer-Moore     | For hybrid fast search in some engines.                             |
   *
   *| Feature            | KMP                    | Rabin-Karp                     | Z-Algorithm           |
   * | ------------------ | ---------------------- | ------------------------------ | --------------------- |
   * | Time Complexity    | `O(N + M)`             | `O(N + M)` avg, `O(N*M)` worst | `O(N + M)`            |
   * | Use Case           | Deterministic matching | Multiple patterns              | Prefix-based problems |
   * | Preprocessing      | LPS array              | Hashing                        | Z-array               |
   * | Extra Space        | `O(M)`                 | `O(1)` (if single pattern)     | `O(N + M)`            |
   * | Supports Wildcard? | With modification      | Yes (easier)                   | Harder to adapt       |
   *
   * | Problem                                                                                                                                     | Description                                        |
   * | ------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------- |
   * | [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | Classic KMP use case                               |
   * | [686. Repeated String Match](https://leetcode.com/problems/repeated-string-match/)                                                          | Find how many repeats needed to contain pattern    |
   * | [796. Rotate String](https://leetcode.com/problems/rotate-string/)                                                                          | Check if one string is a rotation of another       |
   * | [459. Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)                                                | Use KMP to detect cycles                           |
   * | [214. Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/)                                                              | KMP used in reverse + concat approach              |
   * | [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)                   | Not direct KMP but can optimize with string search |
   */
  public static void main(String[] args) {
    //    String txt = "aabaacaadaabaaba";
    //    String pat = "aaba";
    String txt = "abcdabcabcdf";
    String pat = "abcdf";

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

    // match with pattern and text
    StringUtility.matchPatWithText(pat, txt, i, n, j, m, lps);
  }
}
/*
Let's dry run the KMP algorithm with the following inputs:

mainText: "ABABDABACDABABCABAB"
patternToFind: "ABABCABAB"
        1. computeLPSArray(patternToFind):

patternToFind = "ABABCABAB"
lpsArray will be calculated.
The result of computeLPSArray(patternToFind) is [0, 0, 0, 1, 2, 0, 1, 2, 3].
        2. kmpSearch(patternToFind, mainText):

mainText: "ABABDABACDABABCABAB"

patternToFind: "ABABCABAB"

lpsArray: [0, 0, 0, 1, 2, 0, 1, 2, 3]

textIndex = 0, patternIndex = 0.

Iteration 1:

mainText[0] ('A') == patternToFind[0] ('A').
textIndex = 1, patternIndex = 1.
Iteration 2-8:

The characters match, so textIndex and patternIndex increase.
When textIndex is 8, and patternIndex is 8, mainText[8]('C') == patternToFind[8]('B') is false.
Iteration 9:

patternIndex != 0, so patternIndex = lpsArray[patternIndex - 1] = lpsArray[7] = 2.
textIndex remains 8.
Iterations continue:

The algorithm continues, comparing characters and using the lpsArray to adjust patternIndex when mismatches occur.
Match Found:

When textIndex = 15 and patternIndex is equal to pattern length 9, a full match is found.
        occurrences.add(15-9) which is occurrences.add(6)
patternIndex is set to lpsArray[8] which is 3.
Iterations continue:

The algorithm continues to the end of the main text.
The final occurrences list will contain [6].*/
