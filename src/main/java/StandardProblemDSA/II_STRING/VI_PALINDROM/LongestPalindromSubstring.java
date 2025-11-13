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
      int len1 = StringUtility.expandAroundCenter(A, i, i); // same index send to start as centre
      // Case 2: even length palindrome
      int len2 =
          StringUtility.expandAroundCenter(
              A, i, i + 1); // two center need to check the palindrom on both side grow
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
## Example: `s = "babad"`
### Step 1: Initialize
* `start = 0, end = 0` → current best substring is `s[0..0] = "b"`
### Step 2: Iterate each `i`
#### i = 0 (`'b'`)
* Odd case: expand around `(0,0)` → `"b"` → length = 1
* Even case: expand `(0,1)` → `'b' != 'a'` → length = 0
* Max = 1 → update `start=0, end=0` (no change).
---
#### i = 1 (`'a'`)
* Odd case `(1,1)`:
  * expand → `"a"`
  * expand `(0,2)` → `"bab"` ✅ palindrome length = 3
* Even case `(1,2)` → `'a' != 'b'` → length = 0
* Max = 3 → update window:
  ```
  start = 1 - (3-1)/2 = 0
  end   = 1 + 3/2 = 2
  substring = "bab"
  ```

---

#### i = 2 (`'b'`)

* Odd case `(2,2)`:

  * `"b"`
  * expand `(1,3)` → `"aba"` ✅ length = 3
  * expand `(0,4)` → `"babad"` ❌ not palindrome
* Even case `(2,3)` → `'b' != 'a'` → length = 0
* Max = 3 → window length = (end-start) = 2, already 2 → no update.

---

#### i = 3 (`'a'`)

* Odd `(3,3)`:

  * `"a"`
  * expand `(2,4)` → `"bad"` ❌ stop → length = 1
* Even `(3,4)` → `'a' != 'd'` → length = 0
* Max = 1 → no update.

---

#### i = 4 (`'d'`)

* Odd `(4,4)` → `"d"` → length = 1
* Even `(4,5)` → out of bounds → length = 0
* Max = 1 → no update.

---

### Step 3: Result

* Best substring = `"bab"` (or `"aba"`, depending on tie-breaking).
* Output:

  ```
  Longest Palindromic Substring: bab
  ```

---

## 🔑 Key Takeaway

* At each `i`, you expand odd & even centers.
* You keep updating `(start, end)` if a longer palindrome is found.
* In `"babad"`, both `"bab"` and `"aba"` are valid answers.

---

👉 Do you want me to also do a dry run of your earlier test case `"aaaabaaa"` (which gives `"aaabaaa"`) so you see how expansion grows step by step?
*/
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
