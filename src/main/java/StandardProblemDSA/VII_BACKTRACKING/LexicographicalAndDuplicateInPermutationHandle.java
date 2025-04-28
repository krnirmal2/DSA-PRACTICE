package StandardProblemDSA.VII_BACKTRACKING;

import java.util.*;

public class LexicographicalAndDuplicateInPermutationHandle {
  // Result list to store all permutations
  static List<String> result = new ArrayList<>();

  // Wrapper function
  static List<String> permute(String s) {
    result.clear(); // clear for fresh use

    // Convert string to char array and sort for lexicographical order
    char[] arr = s.toCharArray();
    Arrays.sort(arr);

    // Begin backtracking
    permuteRec(arr, 0);

    return result;
  }

  // Recursive function for generating permutations with duplicate handling
  static void permuteRec(char[] s, int start) {
    // Base case: full permutation is formed
    if (start == s.length - 1) {
      result.add(new String(s));
      return;
    }

    // Track characters we've already used at this recursion depth
    Set<Character> seen = new HashSet<>();

    for (int i = start; i < s.length; i++) {
      // Skip duplicate characters
      if (seen.contains(s[i])) continue;
      seen.add(s[i]);

      // Swap current index with loop index
      swap(s, start, i);

      // Recur with next index
      permuteRec(s, start + 1);

      // Backtrack to original configuration
      swap(s, start, i);
    }
  }

  // Swap helper
  static void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }

  // Main method to test
  public static void main(String[] args) {
    String s = "AAB";
    List<String> permutations = permute(s);
    System.out.println("Permutations:");
    for (String p : permutations) {
      System.out.println(p);
    }
  }
}
