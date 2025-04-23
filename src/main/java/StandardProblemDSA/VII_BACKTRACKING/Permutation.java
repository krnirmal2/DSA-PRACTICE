package StandardProblemDSA.VII_BACKTRACKING;

public class Permutation {

  // Function to print permutations of the string
  // This function takes two parameters:
  // 1. Character array
  // 2. Starting index of the array.
  static void permuteRec(char[] s, int start) {

    // Base case
    if (start == s.length - 1) {
      System.out.println(new String(s));
      return;
    }

    for (int i = start; i < s.length; i++) {

      // Swapping
      swap(s, start, i);

      // First idx+1 characters fixed
      permuteRec(s, start + 1);

      // Backtrack
      swap(s, start, i);
    }
  }

  // Wrapper function
  static void permute(String s) {
    permuteRec(s.toCharArray(), 0);
  }

  // Helper function to swap characters in the character array
  static void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }

  public static void main(String[] args) {
    String s = "ABC";
    permute(s);
  }
  /*✅ Approach: Backtracking (Swap-based)
This algorithm generates all permutations of a string by:
Fixing one character at a time.
Swapping characters at different positions.
Recursively generating permutations of the remaining substring.
Backtracking by swapping the characters back after the recursion ends, to restore the original configuration.

🔁 How It Works:
For s = "ABC":
Start at index 0:
- Fix A → permute "BC"
   - Fix B → permute "C" → ABC
   - Fix C → permute "B" → ACB
- Fix B → permute "AC"
   - Fix A → permute "C" → BAC
   - Fix C → permute "A" → BCA
- Fix C → permute "AB"
   - Fix A → permute "B" → CAB
   - Fix B → permute "A" → CBA
🧠 Time Complexity:
Let’s say the length of the string is n.
Each character can be placed at every position → n! permutations
For each permutation, we’re doing O(n) operations in the worst case (due to character copying or swapping)
🔹 Total Time Complexity:
O(n × n!)
n! for total permutations
O(n) to print or handle each one (optional based on context)

🧠 Space Complexity:
Auxiliary space is mainly due to the recursive call stack.

In worst-case, recursion depth = n.*/
}
