package StandardProblemDSA.II_STRING;

public class Pangram {
  /**
   * Problem: Check if a sentence is a pangram. A pangram contains every letter of the English
   * alphabet at least once.
   *
   * <p>Approach: - Convert string to lowercase. - Track occurrences of all 26 alphabets using a
   * frequency array. - If any letter count is zero, it's not a pangram.
   *
   * <p>Time Complexity: O(n) // n = length of sentence Space Complexity: O(1) // fixed-size array
   *
   * <p>Follow-up: - Can also use a `Set<Character>` for simplicity. - Related LeetCode problem:
   * 1832. Check if the Sentence Is Pangram.
   */
  public static boolean isPangram(String sentence) {
    // Step 1: Convert to lowercase
    sentence = sentence.toLowerCase();

    // Step 2: Frequency array of size 26
    int[] freq = new int[26];

    // Step 3: Iterate over characters and record frequency
    for (char ch : sentence.toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        freq[ch - 'a']++;
      }
    }

    // Step 4: Check if any alphabet is missing
    for (int count : freq) {
      if (count == 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPangram("The quick brown fox jumps over a lazy dog")); // true
  }
}
