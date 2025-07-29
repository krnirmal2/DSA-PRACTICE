package StandardProblemDSA.II_STRING.VI_PALINDROM;

/*
        ## ✅ **Question:**
        **Find the longest palindromic substring** in a given string `A`.
A palindrome reads the same forwards and backwards.

        > **Example:**
        > Input: `"aaaabaaa"`
        > Output: `"aaabaaa"`

        ## ✅ **Approach: Center Expansion**
We consider each character (and pair of characters) as the **center of a potential palindrome**, and expand outwards to check how far the palindrome goes.
There are two types of centers:
        1. **Odd length:** center at a single character (e.g., `"aba"`)
        2. **Even length:** center between two characters (e.g., `"abba"`)
For each center, we expand and track the **maximum length palindrome** found so far.

 * Pattern: Expand Around Center — check for both odd and even length palindromes at each index.
 *
 * Follow-ups:
 * 1. Implement Manacher’s algorithm for O(N) time complexity.
 * 2. Return the count of all palindromic substrings instead of the longest one.
 * 3. Adapt to find the longest palindromic subsequence (DP approach).
 *
 * LeetCode Similar Problems: 5. Longest Palindromic Substring, 647. Palindromic Substrings
 *
 * Time Complexity: O(N²) — expanding around each center takes O(N), and there are O(N) centers.
 * Space Complexity: O(1) — no extra space apart from variables.
*/

import StandardProblemDSA.II_STRING.StringUtility;

public class LongestPalindromSubstring {
  // Function to find the longest palindromic substring
  public static String longestPalindrome(String A) {
    if (A == null || A.length() < 1) return "";

    int start = 0, end = 0; // track start and end of longest palindrome

    for (int i = 0; i < A.length(); i++) {
      // Case 1: odd length palindrome
      int len1 = StringUtility.expandAroundCenter(A, i, i);
      // Case 2: even length palindrome
      int len2 = StringUtility.expandAroundCenter(A, i, i + 1);
      // Take the longer one
      int len = Math.max(len1, len2);

      // Update result window if we found a longer palindrome
      if (len > end - start) {
        start = i - (len - 1) / 2; // adjust start index
        end = i + len / 2; // adjust end index
      }
    }

    return A.substring(start, end + 1); // return longest palindromic substring
  }

  public static void main(String[] args) {
    String A = "aaaabaaa";
    String result = longestPalindrome(A);
    System.out.println("Longest Palindromic Substring: " + result);
  }
}
/*
        ## ✅ **Time and Space Complexity:**

        * **Time Complexity: O(n²)**
For each character, we expand both ways — worst case O(n) expansion for each of the n characters.

* **Space Complexity: O(1)**
We are not using any extra space except a few variables. The result is returned using `substring`.

        ## ✅ **Explanation Example (Dry Run):**
For input: `"aaaabaaa"`
        1. At center `i = 4` (character `'b'`), expand left and right:
Matches: `A[3]='a'`, `A[5]='a'` → `A[2]='a'`, `A[6]='a'` → `A[1]='a'`, `A[7]='a'`
Final result: `"aaabaaa"` (7 characters)

This is the longest palindrome in the string.*/
