package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

public class MinimumNoOfCutPalindromicPartition {
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
