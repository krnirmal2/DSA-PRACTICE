package StandardProblemDSA.II_STRING.VI_PALINDROM;

public class CheckPalindromeII {
  /*nalysis of CheckPalindromeII Class
    This Java class contains methods to check if a string can be rearranged into a palindrome. Let me analyze the code and provide a clear explanation.

    Key Points About Palindromic Strings
    For a string to be rearranged into a palindrome:
    For even-length strings: All characters must have even counts
    For odd-length strings: Exactly one character can have an odd count (the middle character)
    Current Implementation Analysis
    The class contains three different approaches (two commented out) to solve this problem:

   1. First Approach (Commented Out)
    Uses a HashMap to count character frequencies
    Checks if all characters are the same (mp.size() == 1)
    Incomplete implementation (missing the odd-length case check)

  2. Second Approach (solve method)
    Uses an integer array of size 26 (for English lowercase letters)
    Counts frequency of each character
    Allows at most one character with an odd count
    Returns 1 if palindrome possible, 0 otherwise

  3. Third Approach (Commented Out)
    Similar to the second approach but more concise
    Directly counts odd frequencies and rejects if more than one
    Improved Solution
    Here's a cleaner version combining the best aspects:

    public class CheckPalindromeII {*/
  public static int solve(String A) {
    int[] freq = new int[26]; // For lowercase English letters

    // Count character frequencies
    for (char c : A.toCharArray()) {
      freq[c - 'a']++;
    }

    int oddCount = 0;
    for (int count : freq) {
      if (count % 2 != 0) {
        oddCount++;
        if (oddCount > 1) {
          return 0; // More than one odd count
        }
      }
    }
    return 1; // Can form palindrome
  }

  public static void main(String[] args) {
    System.out.println(solve("aab")); // Output: 1 ("aba" is palindrome)
    System.out.println(solve("abac")); // Output: 0 (can't form palindrome)
    System.out.println(solve("aabb")); // Output: 1 ("abba" or "baab")
    System.out.println(solve("a")); // Output: 1 (single character)
  }
  /*}
  Time and Space Complexity
  Time Complexity: O(n) where n is string length

  We make two passes: one to count frequencies, one to check odd counts

  Space Complexity: O(1) (fixed size 26 array)

  Edge Cases Handled
  Empty string (returns 1 - technically a palindrome)

  Single character (always a palindrome)

  All characters same (palindrome)

  Even length with all even counts

  Odd length with exactly one odd count
  public static void main(String[] args) {
    solve("nirmal");
  }*/
}
