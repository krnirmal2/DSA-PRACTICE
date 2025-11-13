package StandardProblemDSA.II_STRING.VI_PALINDROM;

public class createLargestPalindromNo {
  /**
   * Problem: Given a string of digits, form the largest palindromic number by rearranging the
   * digits. Example: "8666612377" → "876616678".
   *
   * <p>Pattern: Frequency counting + greedy construction: - Count digits 0–9. - Build left half
   * with the highest digits first using pairs. - Place the largest available single digit (if any)
   * in the middle. - Mirror the left half to form the right.
   *
   * <p>Follow-ups: 1. Handle inputs with only zeros (e.g., "0000" → "0"). 2. Optimize for very
   * large inputs (stream processing). 3. Extend to alphanumeric palindromes with custom ordering.
   *
   * <p>LeetCode Similar Problems: 2384. Largest Palindromic Number, 267. Palindrome Permutation II
   *
   * <p>Time Complexity: O(N + 10) ≈ O(N) — count frequencies + build palindrome. Space Complexity:
   * O(1) — fixed-size frequency array.
   */
  /*

       Largest Palindromic Number from Digits
  📜 Problem Statement:
  You are given a string of digits (e.g., "8666612377"). Your task is to form the largest palindromic number (as a string) by rearranging the digits.

  You may use each digit as many times as it appears in the input.

  If no palindrome can be formed, return an empty string "".
  \
  🧠 Intuition:
  To form the largest palindrome, we must:

  Count the frequency of each digit (0–9).

  For each digit from 9 to 0:

  Use the largest even count (e.g., if 4 of '8' → use 2 on left, 2 on right).

  Save any single odd digit to put in the middle (only one allowed).

  Construct:

  Left half (largest digits first),

  Optional middle digit (only one allowed),

  */
  public static String largestPalindrome(String num) {
    int[] freq = new int[10];

    // Step 1: Count frequency of each digit
    for (char c : num.toCharArray()) {
      freq[c - '0']++;
    }

    StringBuilder left = new StringBuilder();
    String mid = "";

    // Step 2: Form the left half (from 9 to 0 for largest)
    for (int digit = 9; digit >= 0; digit--) {
      // Use even number of digits for both sides
      int pairs = freq[digit] / 2;

      // Don't allow leading zero unless it's the only digit
      if (digit == 0 && left.length() == 0) continue;
      // APEND THE PAIR THAT MANY TIMES INTHE LEFT
      for (int i = 0; i < pairs; i++) {
        left.append(digit);
      }

      // Save one digit for the middle if odd freq
      if (freq[digit] % 2 == 1 && mid.equals("")) {
        mid = String.valueOf(digit);
      }
    }

    // Handle case when left is empty (only zeros or no valid digit)
    if (left.length() == 0 && mid.isEmpty()) {
      return freq[0] > 0 ? "0" : "";
    }

    StringBuilder right = new StringBuilder(left).reverse();
    return left + mid + right;
  }

  public static void main(String[] args) {
    System.out.println(largestPalindrome("8666612377")); // Output: 7668667
    System.out.println(largestPalindrome("0000")); // Output: "0"
    System.out.println(largestPalindrome("1")); // Output: "1"
  }
}
