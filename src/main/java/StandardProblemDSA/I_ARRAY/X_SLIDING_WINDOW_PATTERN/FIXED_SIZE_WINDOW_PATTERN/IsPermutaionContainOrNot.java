package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

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

    // Fill pattern frequency
    for (char ch : pattern.toCharArray()) {
      patFreq[ch - 'a']++; // strore the frequency of the character
    }

    int i = 0;
    for (int j = 0; j < text.length(); j++) {
      // Add current char to window
      winFreq[text.charAt(j) - 'a']++;

      // Window size larger than pattern -> shrink from left
      if (j - i + 1 > pattern.length()) {
        winFreq[text.charAt(i) - 'a']--;
        i++; // shrinking the window if the characcter is greater in the window
      }

      // Compare pattern frequency and window frequency
      if (matches(
          patFreq, winFreq)) { // check both the character at the same position are same or not
        return true;
      }
    }

    return false;
  }

  private static boolean matches(int[] patFreq, int[] winFreq) {
    for (int i = 0; i < 26; i++) {
      if (patFreq[i] != winFreq[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eiobaooo"));
  }
}
