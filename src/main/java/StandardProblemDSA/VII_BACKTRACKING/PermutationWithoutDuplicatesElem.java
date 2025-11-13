package StandardProblemDSA.VII_BACKTRACKING;

import java.util.HashSet;
import java.util.Set;

public class PermutationWithoutDuplicatesElem {
  /**
   * Problem: Generate all unique permutations of a string that may contain duplicate characters.
   * Example: "AAB" -> AAB, ABA, BAA
   *
   * <p>Pattern: Backtracking with swapping + HashSet at each recursion level to skip duplicates.
   *
   * <p>Follow-ups: 1. Return k-th unique permutation directly without generating all. 2. Generate
   * permutations in lexicographical order. 3. Optimize space by avoiding Set<String> and printing
   * directly.
   *
   * <p>LeetCode Similar Problems: 47. Permutations II, 46. Permutations, 784. Letter Case
   * Permutation
   *
   * <p>Time Complexity: O(N × N!) → N! unique permutations (fewer with duplicates), each taking
   * O(N) to store. Space Complexity: O(N) recursion depth + O(N) for HashSet used in each recursion
   * frame.
   */
  public static void permute(char[] chars, int start, Set<String> result) {
    // Base case: if we've reached the last character, add the permutation to the set

    System.out.println("FUNCTION CALL ");
    if (start == chars.length - 1) {
      result.add(new String(chars)); // Add the permutation to the set
      return;
    }

    // Set to track characters already used at this position to avoid duplicates
    Set<Character> used = new HashSet<>();

    // Try each character in the remaining substring
    for (int i = start; i < chars.length; i++) {
      // Skip duplicate characters at this position
      if (used.contains(chars[i])) {
        continue;
      }
      used.add(chars[i]);

      // Swap to place the current character at the start position
      swap(chars, start, i);

      // Recurse to build the next position
      permute(chars, start + 1, result);

      // Backtrack to restore the original state
      swap(chars, start, i);
    }
    /* Time Complexity:
    Without duplicates: O(n × n!)
      n! permutations
      O(n) time to build and store each one as a string
    With duplicate-skipping (like here):
        Worst-case still O(n × n!), but actual output is fewer, so it’s faster.*/
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static void main(String[] args) {
    // Example input string with duplicate characters
    String input = "AAB";

    // Set to store all unique permutations
    Set<String> result = new HashSet<>();

    // Generate permutations
    permute(input.toCharArray(), 0, result);

    // Display all distinct permutations
    System.out.println("Distinct Permutations of \"" + input + "\": " + result);
  }
}
