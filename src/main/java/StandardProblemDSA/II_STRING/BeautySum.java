package StandardProblemDSA.II_STRING;

/*The beauty of a string is the difference in frequencies between the most frequent and least frequent
characters.

        For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

        Example 1:
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:
Input: s = "aabcbaa"
Output: 17
Constraints:
        1 <= s.length <= 500
s consists of only lowercase English letters.


 * Approach:
 * - For every substring s[i..j], maintain frequency of 26 lowercase chars.
 * - For each extension of j, update freq and compute beauty = maxFreq - minFreq.
 * - Accumulate to total beauty.
 *
 * Follow-ups:
 * 1. Optimize to avoid recalculating min/max frequencies O(26) every time.
 * 2. Use sliding window techniques if constraints were larger.
 * 3. Extend to handle Unicode or case-sensitive inputs.
 *
 * LeetCode Similar Problems: 1781. Sum of Beauty of All Substrings.
 *
 * Time Complexity: O(N² × 26) — N² substrings, each beauty computation takes O(26).
 * Space Complexity: O(1) — fixed-size frequency array.*/

public class BeautySum {

  // Function to calculate the beauty of a substring based on character frequencies
  public static int calculateBeauty(int[] charFreq) {
    int minFreq = Integer.MAX_VALUE;
    int maxFreq = 0;

    // Iterate through the character frequency array
    for (int freq : charFreq) {
      if (freq > maxFreq) {
        maxFreq = freq;
      }
      if (freq > 0 && freq < minFreq) {
        minFreq = freq;
      }
    }

    // Calculate and return the beauty of the substring
    return maxFreq - minFreq;
  }

  public static int beautySum(String s) {
    int length = s.length();
    int totalBeauty = 0;

    // Iterate through all possible substrings
    for (int i = 0; i < length; i++) {
      // Initialize an array to store character frequencies for the current substring
      int[] charFreq = new int[26]; // Assuming lowercase English letters

      for (int j = i; j < length; j++) {
        // Update the character frequency array based on characters in the substring
        charFreq[s.charAt(j) - 'a']++;

        // Calculate the beauty of the current substring and add it to the total beauty
        totalBeauty += calculateBeauty(charFreq);
      }
    }

    // Return the total sum of beauty for all substrings
    return totalBeauty;
  }

  public static void main(String[] args) {
    String s = "aabcb";
    System.out.println(beautySum(s));
  }
}
