package StandardProblemDSA.VI_RECURSION;

public class KthSymbol {
  /*
  Problem:
  Find the K-th symbol in grammar using brute force string generation.

  Approach:
  - Start with "0".
  - For each row, replace '0' → "01" and '1' → "10".
  - Stop after generating A rows.
  - Return the B-th character.

  Pattern:
  - String generation based on grammar rules.

  Time Complexity:
  O(2^A) — string size doubles each row.
  Space Complexity:
  O(2^A) — storing all characters.

  Similar LeetCode:
  - 779. K-th Symbol in Grammar.

  Follow-up:
  - Optimize using recursion/bit manipulation to O(A) time and O(1) space.
  */

  public static int solve(int A, int B) {
    // BRUTE FORCE
    String s = "0";
    int count = 0;
    if (A == 0) return 0;

    char indexValue = '0';
    // now append the String
    for (int i = 0; i < s.length(); i++) {
      count++;
      if (s.charAt(i) == '0') {
        s += "01";
      } else s += "10";
      if (count == A) break;
    }

    for (int i = 0; i < B; i++) {
      indexValue = s.charAt(i);
    }
    return indexValue;
  }

  public static void main(String[] args) {
    solve(2, 2);
  }
}
