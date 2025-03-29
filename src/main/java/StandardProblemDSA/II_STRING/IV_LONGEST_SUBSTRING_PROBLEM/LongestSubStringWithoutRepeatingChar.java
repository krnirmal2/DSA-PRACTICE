package StandardProblemDSA.II_STRING.IV_LONGEST_SUBSTRING_PROBLEM;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChar {
  public static void main(String[] args) {
    String s = "geeksforgeeks";
    // here longest substring is eksforg which is non repeating character
    // return the length of the substring
    System.out.println("Longest Subestring length " + longestSubstringWithoutRepeatingCharacter(s));
  }

  private static int longestSubstringWithoutRepeatingCharacter(String s) {
    // way one brute force , use three loops  and in third loop i will use max function to update if
    // i found duplicate and skip that character to next character
    // optimise way :
    // iterate over the string and use a hashSet and during traversal i will check if the element is
    // present in
    // the set means it is duplicate , so we will remove that from the set and increment the left
    // pointer
    /* Explanation of the Sliding Window Approach
    Use two pointers (left & right) to maintain a window of unique characters.
    Use a HashSet to track characters in the current window.
    Expand right pointer until a duplicate character is found.
    If a duplicate is found, move left until the duplicate is removed.
    Keep track of the maximum window size.

    */
    int left = 0, right = 0;
    int maxLength = 0;
    HashSet<Character> charSet = new HashSet<>();

    while (right < s.length()) {
      char c = s.charAt(right);

      // If character is already in the set, remove from left
      while (charSet.contains(c)) {
        charSet.remove(s.charAt(left));
        left++;
      }

      // Add current character and update maxLength
      charSet.add(c);
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    return maxLength; // ✅ Fix: Return max substring length
  }
  /*  🔹 Explanation of the Sliding Window Approach
      Use two pointers (left & right) to maintain a window of unique characters.
      Use a HashSet to track characters in the current window.
      Expand right pointer until a duplicate character is found.
      If a duplicate is found, move left until the duplicate is removed.
      Keep track of the maximum window size.

  */
}
