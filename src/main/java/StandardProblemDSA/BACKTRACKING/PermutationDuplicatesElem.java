package StandardProblemDSA.BACKTRACKING;

import java.util.HashSet;
import java.util.Set;

public class PermutationDuplicatesElem {


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
