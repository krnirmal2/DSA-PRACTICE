package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import StandardProblemDSA.Utility;

public class IsPermutaionContainOrNot {
  public static boolean checkInclusion(String pattern, String text) {
    // edge case , pattern length if greater than the string length return false
    if (pattern.length() > text.length()) {
      return false;
    }
    // create two frequency array pattern earlier
    // and during traversal of the window
    int[] patFreq = new int[26];
    int[] winFreq = new int[26];

    Utility.createCharacterFrequencyArray(pattern, patFreq);

    int i = 0;
    for (int j = 0; j < text.length(); j++) {
      //CASE 1: EXPAND WINDOW
      // Add current char to window
      winFreq[text.charAt(j) - 'a']++;
      //CASE 2: EQUAL WINDOW SIZE TO K
      // Window size larger than pattern -> shrink from left
      if (j - i + 1 > pattern.length()) {
        winFreq[text.charAt(i) - 'a']--;
        //CASE 3: SHRINK WINDOW
        i++; // shrinking the window if the characcter is greater in the window
      }

      // Compare pattern frequency and window frequency
      if (Utility.matches(patFreq, winFreq)) {
        return true;
      }
    }

    return false;
  }



  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eiobaooo"));
  }
}
