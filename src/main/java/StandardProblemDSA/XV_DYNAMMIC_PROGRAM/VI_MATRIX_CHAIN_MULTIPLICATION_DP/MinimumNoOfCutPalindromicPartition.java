package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

public class MinimumNoOfCutPalindromicPartition {
  /*
      132. Palindrome Partitioning II – Minimum Number of Cuts for Palindromic Partitioning

      Problem:
      --------
      Given a string s, partition s such that every substring of the partition is a palindrome.
      Return the minimum number of cuts needed to make such a partition.

      Examples:
      ---------
      Input:  s = "aab"
      Output: 1
      Explanation: ["aa","b"] → 1 cut

      Input:  s = "a"
      Output: 0

      Input:  s = "ab"
      Output: 1

      Why Important?
      --------------
      • Classic Dynamic Programming problem similar to Matrix Chain Multiplication.
      • Tests understanding of optimal substructure and overlapping subproblems.
      • Builds intuition for string partitioning, palindrome checking, and subproblem reuse.

      Pattern:
      --------
      • Type: Partition DP (Matrix Chain Multiplication pattern)
      • State: Minimum cuts for substring s[i..j].
      • Choice: Try every possible partition index k between i and j.
      • Recurrence:
          if s[i..j] is palindrome → 0
          else → min(1 + cuts(i, k) + cuts(k+1, j)) for all i ≤ k < j

      Follow-ups:
      -----------
      1. Can we precompute palindromes to optimize repeated checks?
      2. How to convert recursion to DP (memoization/tabulation)?
      3. Can we reduce O(n²) palindrome checks using Manacher’s algorithm?
      4. Is there an O(n²) DP solution (instead of O(n·2ⁿ))?

      Complexities:
      -------------
      Recursive:
          Time:  O(n * 2^n) – try all cuts, each checking palindrome O(n)
          Space: O(n) – recursion stack
      Optimized DP:
          Time:  O(n²) with palindrome precomputation
          Space: O(n²) (memo + palindrome table)

      Related Problems:
      -----------------
      • LeetCode 132 – Palindrome Partitioning II
      • LeetCode 131 – Palindrome Partitioning (generate all partitions)
      • Matrix Chain Multiplication pattern
  */

  /*In this approach, we recursively evaluate the following conditions:
  Base Case: If the current string is a palindrome, then we simply return 0, no Partitioning is required.
  Else, like the Matrix Chain Multiplication problem,
  we try making cuts at all possible places,
  recursively calculate the cost for each cut
  return the minimum value.
  O(n*2^n) Time and O(n) Space
  */
  // Function to check if a substring is a palindrome
  static boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  // Recursive function to find the minimum number of
  // cuts needed for palindrome partitioning
  static int palPartitionRec(String s, int i, int j) {

    // Base case: If the substring is empty
    // or a palindrome, no cuts needed
    if (i >= j || isPalindrome(s, i, j)) return 0;

    int res = Integer.MAX_VALUE, cuts;

    // Iterate through all possible partitions
    // and find the minimum cuts needed
    for (int k = i; k < j; k++) {
      cuts = 1 + palPartitionRec(s, i, k) + palPartitionRec(s, k + 1, j);
      res = Math.min(res, cuts);
    }

    return res;
  }

  static int palPartition(String s) {
    return palPartitionRec(s, 0, s.length() - 1);
  }

  public static void main(String[] args) {
    String s = "geek";
    System.out.println(palPartition(s));
  }
  /*

  Memoization) – O(n^3) Time and O(n^2) Space
  // Function to check if a substring is a palindrome
   static boolean isPalindrome(String s, int i, int j) {
       while (i < j) {
           if (s.charAt(i) != s.charAt(j))
               return false;
           i++;
           j--;
       }
       return true;
   }

   // Recursive function to find the minimum number of
  // cuts needed for palindrome partitioning
   static int palPartitionRec(String s, int i, int j, int[][] memo) {

       // check in memo for previously computed results
       if (memo[i][j] != -1)
           return memo[i][j];

       // Base case: If the substring is empty or
     	// a palindrome, no cuts needed
       if (i >= j || isPalindrome(s, i, j))
           return memo[i][j] = 0;

       int res = Integer.MAX_VALUE, cuts;

       // Iterate through all possible partitions and
     	// find the minimum cuts needed
       for (int k = i; k < j; k++) {
           cuts = 1 + palPartitionRec(s, i, k, memo)
             		 + palPartitionRec(s, k + 1, j, memo);
           res = Math.min(res, cuts);
       }

       return memo[i][j] = res;
   }

   static int palPartition(String s) {
       int n = s.length();
       int[][] memo = new int[n][n];

       // Initialize memo array with -1
       for (int[] row : memo)
           Arrays.fill(row, -1);

       return palPartitionRec(s, 0, n - 1, memo);
   }

   public static void main(String[] args) {
       String s = "geek";
       System.out.println(palPartition(s));
   }

   */
}
