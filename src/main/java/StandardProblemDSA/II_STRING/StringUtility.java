package StandardProblemDSA.II_STRING;

public class StringUtility {

  public static int[] computePatternLps(String pattern) {
    // store the pattern length
    int patternLength = pattern.length();
    // Step 1 ;create the lps integer array of  pattern length
    int[] lpsArray = new int[patternLength];

    int prefixSuffixLength = 0; // Length of the previous longest prefix suffix
    int currentIndex = 1; // Start comparing from index 1 (LPS of index 0 is always 0)

    //  iterate the currentIndex each time till the length of the pattern
    while (currentIndex < patternLength) {
      // if pattern at privious and current is equal then store the longest prefix which is also
      // suffix
      // CASE 1: IF CHARACTER AT PREFIX SUFFIXLENGHT IS MATCHED WITH CURRENT INDEX
      if (pattern.charAt(currentIndex) == pattern.charAt(prefixSuffixLength)) {
        // if matched we save the value by increament the count till how much we have matched
        prefixSuffixLength++;
        lpsArray[currentIndex] =
            prefixSuffixLength; // Store the length of the longest prefix which is also a suffix
        currentIndex++;
      } else {
        // CASE 2 : IF CHARACTER AT PREFIX SUFFIX LENGTH IS NOT MATCHED THEN RESET PREFIXSUFFIX
        // LENGTH TO BACK TO LAST LPS VALUSE
        if (prefixSuffixLength != 0) { // reset to the first point of the pattern
          prefixSuffixLength =
              lpsArray[prefixSuffixLength - 1]; // Move `j` back to the previous LPS value
        } else {
          //          CASE 3 : IF YET THERE IS NO CALCULATION DONE FOR THAT CHARACTER JUST SET THAT
          // CURRENT INDEX TO ZERO
          // if there is no prefixsuffixlength
          lpsArray[currentIndex] = 0; // No prefix suffix match, assign 0
          currentIndex++;
        }
      }
    }
    return lpsArray;
    /*pattern = "ababcabab"
        At each position i, we are checking if pattern[i] == pattern[j]
        If yes:
             → We extend the current matching prefix/suffix and assign lps[i] = ++j
        If no:
            → We backtrack j to lps[j - 1] and recheck
            → This avoids unnecessary comparisons
    | `i` (currentIndex) | `pattern[i]` | `j` (prefixSuffixLength) | `pattern[j]` | Match? | Action           | `lps[i]` | lps\[] so far                        |
    | ------------------ | ------------ | ------------------------ | ------------ | ------ | ---------------  | -------- | ------------------------------------ |
    | 0                  | -            | -                        | -            | -      | init             | 0        | \[0, \_, \_, \_, \_, \_, \_, \_, \_] |
    | 1                  | b            | 0                        | a            | ❌      | set 0           | 0        | \[0, 0, \_, \_, \_, \_, \_, \_, \_]  |
    | 2                  | a            | 0                        | a            | ✅      | j++             | 1        | \[0, 0, 1, \_, \_, \_, \_, \_, \_]   |
    | 3                  | b            | 1                        | b            | ✅      | j++             | 2        | \[0, 0, 1, 2, \_, \_, \_, \_, \_]    |
    | 4                  | c            | 2                        | a            | ❌      | j = lps\[1] = 0 | 0        | \[0, 0, 1, 2, 0, \_, \_, \_, \_]     |
    | 5                  | a            | 0                        | a            | ✅      | j++             | 1        | \[0, 0, 1, 2, 0, 1, \_, \_, \_]      |
    | 6                  | b            | 1                        | b            | ✅      | j++             | 2        | \[0, 0, 1, 2, 0, 1, 2, \_, \_]       |
    | 7                  | a            | 2                        | a            | ✅      | j++             | 3        | \[0, 0, 1, 2, 0, 1, 2, 3, \_]        |
    | 8                  | b            | 3                        | b            | ✅      | j++             | 4        | \[0, 0, 1, 2, 0, 1, 2, 3, 4]         |
    */
  }

  public static void matchPatWithText(
      String pat,
      String txt,
      int textpointeri,
      int textLength,
      int patternPointerJ,
      int patternLength,
      int[] lps) {
    while (textpointeri < textLength) {
      // step 3;
      // case : 1 : if match move both pointer i and j
      if (txt.charAt(textpointeri) == pat.charAt(patternPointerJ)) {
        textpointeri++;
        patternPointerJ++;
      }
      // case : 2 : if match whole we just return the i-j for first index
      if (patternPointerJ == patternLength) // if j is equal to its length of the pattern
      {
        System.out.println("pattern found at index " + (textpointeri - patternPointerJ));
        // move next for any further match
        patternPointerJ = lps[patternPointerJ - 1];
      } else if (textpointeri < textLength
          && txt.charAt(textpointeri) != pat.charAt(patternPointerJ)) {
        //                case 3. if not matched
        if (patternPointerJ != 0) {
          patternPointerJ = lps[patternPointerJ - 1]; // Use LPS to skip unnecessary comparisons
        } else {
          textpointeri++; // No LPS, move to the next character in text
        }
      }
    }
  }

  public static void naiveSearchStringPattern(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();

    if (m == 0) System.out.println(" no string ");
    // Edge case: empty pattern
    if (m > n) System.out.println("pattern is greater than the text ");
    // a loop to slide pattern one by one
    // step 1; iterate over the text till before the length of pattern
    for (int i = 0; i <= n - m; i++) {
      int j;
      // step 2 : if character at i+j doesn't matched then break and at he end check if
      for (j = 0; j < m; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      // step 3 ; if both pattern length and index of pattern is equal means we reacd/ found the
      // pattern in text
      if (j == m) {
        System.out.println("pattern found at index " + i);
      }
    }
  }

  static String insertChar(StringBuilder sb, char c, int pos) {

    // Insert character at specified position
    sb.insert(pos, c);
    return sb.toString();
  }

  public static void removeCharAtPosition(StringBuilder s, int pos) {
    s.deleteCharAt(pos);
  }

  public static void removeAllOccuranceOfChar(String s, char c) {
    s.replace(String.valueOf(c), "");
  }

  public static String reverse(String str) {
    if (str == null || str.isEmpty()) {
      return str; // Handle null or empty strings
    }
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed.append(str.charAt(i));
    }
    return reversed.toString();
  }

  public static boolean isPalindrome(String str) {
    if (str == null) {
      return false;
    }
    str = str.toLowerCase(); // Make the comparison case-insensitive
    int start = 0, end = str.length() - 1;

    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static String concatenate(String str1, String str2) {
    return str1 + str2; // Concatenation using +
  }

  public static String[] splitByDelimiter(String str, String delimiter) {
    if (str == null || delimiter == null) {
      return new String[0]; // Handle null cases
    }
    return str.split(delimiter); // Split using the delimiter
  }

  public static String extractSubstring(String str, int start, int end) {
    if (str == null || start < 0 || end > str.length() || start > end) {
      throw new IllegalArgumentException("Invalid indices");
    }
    return str.substring(start, end); // Extract substring
  }

  public static String trimSpaces(String str) {
    if (str == null || str.isEmpty()) {
      return ""; // Handle null or empty strings
    }

    int start = 0;
    int end = str.length() - 1;

    // Two poiner Approach
    // Skip leading whitespaces
    while (start <= end && str.charAt(start) == ' ') {
      start++;
    }

    // Skip trailing whitespaces
    while (end >= start && str.charAt(end) == ' ') {
      end--;
    }

    // Manually build the trimmed string using a StringBuilder
    StringBuilder trimmed = new StringBuilder();
    for (int i = start; i <= end; i++) {
      trimmed.append(str.charAt(i));
    }

    return trimmed.toString();
  }

  // Helper function to expand from center and return palindrome length
  public static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--; // expand left
      right++; // expand right
    }
    return right - left - 1; // total length of palindrome
  }

  public static boolean checkPangram(String s) {
    boolean[] vis = new boolean[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') vis[c - 'A'] = true;
      else if (c >= 'a' && c <= 'z') vis[c - 'a'] = true;
    }
    for (int i = 0; i < 26; i++) {
      if (!vis[i]) return false;
    }
    return true;
  }

  public static int isSubstring(String text, String pattern) {
    // If pat is found, returns the index of first
    // occurrence of pat. Otherwise, returns -1
    return text.indexOf(pattern);
  }
}
