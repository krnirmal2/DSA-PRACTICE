package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

import StandardProblemDSA.II_STRING.StringUtility;

public class KMP_algo {

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
