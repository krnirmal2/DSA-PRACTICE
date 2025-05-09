package StandardProblemDSA.II_STRING;

public class StringUtility {

  public static int[] computePatternLps(String pattern) {
    // store the pattern length
    int patternLength = pattern.length();
    // create the lps integer array for pattern legth
    int[] lpsArray = new int[patternLength];

    int prefixSuffixLength = 0; // Length of the previous longest prefix suffix
    int currentIndex = 1; // Start comparing from index 1 (LPS of index 0 is always 0)

    // build the lps till pattern length end
    while (currentIndex < patternLength) {
      // if pattern at privious and current is equal then store the longest prefix which is also
      // suffix
      if (pattern.charAt(currentIndex) == pattern.charAt(prefixSuffixLength)) {
        prefixSuffixLength++;
        lpsArray[currentIndex] =
            prefixSuffixLength; // Store the length of the longest prefix which is also a suffix
        currentIndex++;
      } else {
        if (prefixSuffixLength != 0) {
          prefixSuffixLength =
              lpsArray[prefixSuffixLength - 1]; // Move `j` back to the previous LPS value
        } else {
          lpsArray[currentIndex] = 0; // No prefix suffix match, assign 0
          currentIndex++;
        }
      }
    }
    return lpsArray;
  }

  public static void matchPatWithText(
      String pat, String txt, int i, int n, int j, int m, int[] lps) {
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

  public static void naiveSearchStringPattern(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();
    // a loop to slide pattern one by one
    for (int i = 0; i < n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        System.out.println("pattern found at index " + i);
      }
    }
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
}
