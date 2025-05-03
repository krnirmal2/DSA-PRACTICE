package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

public class KMP_algo {

  public static void main(String[] args) {
    String txt = "aabaacaadaabaaba";
    String pat = "aaba";

    kmpSearch(pat, txt);
  }

  private static int[] computePatternLps(String pat) {
    // store the pattern length
    int m = pat.length();
    // create the lps integer array for pattern legth
    int[] lps = new int[m];

    int j = 0, // length of the previous longest prefix suffix
        i = 1; // start comparing from index 1 )since LPS of index 0 is alwasy 0

    // build the lps till pattern length end
    while (i < m) {
      // if pattern at privious and current is equal then store the longest prefix which is also
      // suffix
      if (pat.charAt(i) == pat.charAt(j)) {
        j++;
        lps[i] = j; // Store the length of the longest prefix which is also a suffix
        i++;
      } else {
        if (j != 0) {
          j = lps[j - 1]; // Move `j` back to the previous LPS value
        } else {
          lps[i] = 0; // No prefix suffix match, so assign 0
          i++;
        }
      }
    }
    return lps;
  }

  private static void kmpSearch(String pat, String txt) {
    // find the length of the each
    int n = txt.length();
    int m = pat.length();

    // Step1;
    // create array for precompute LPS array
    // compute LPC of the pattern not the string
    int[] lps = computePatternLps(pat);

    // Step 2:
    int i = 0; // Pointer for text
    int j = 0; // Pointer for pattern

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
        System.out.println("pattern found at index " + (i - j));
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
