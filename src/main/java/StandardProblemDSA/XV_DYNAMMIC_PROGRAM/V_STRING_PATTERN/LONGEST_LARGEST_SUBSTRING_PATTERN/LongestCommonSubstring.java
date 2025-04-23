package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

public class LongestCommonSubstring {
  /*  ⚠️ Important Note:
    In Longest Common Substring, we need to:
    Track only contiguous matches.
    So we also need to pass the current length of the matching substring during recursion.*/
  public static int longestCommonSubstring(String s1, String s2) {
      return lcs(s1, s2, s1.length(), s2.length(), 0);
  }

    private static int lcs(String s1, String s2, int i, int j, int count) {
        if (i == 0 || j == 0) return count;

        int count1 = count;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            count1 = lcs(s1, s2, i - 1, j - 1, count + 1); // extend substring
        }

        int count2 = lcs(s1, s2, i - 1, j, 0); // reset if breaking substring
        int count3 = lcs(s1, s2, i, j - 1, 0); // reset if breaking substring

        return Math.max(count1, Math.max(count2, count3));
    }

    public static void main(String[] args) {
        String s1 = "abcdfgh";
        String s2 = "abedfgh";
        int len = longestCommonSubstring(s1, s2);
        System.out.println("Length of Longest Common Substring: " + len);
    }

   /*  2. Recursive + Memoization (Optimized):
    We use a 3D DP array to store results for (i, j, count):
    Characters alignment (visual):

s1: a b c d e
s2: a b f d e
Let’s walk through the recursive steps, focusing on the last positions:

i = s1.length = 5

j = s2.length = 5

count = 0 initially

🔁 Key Recursive Calls:
sql
Copy
Edit
lcs("abcde", "abfde", 5, 5, 0)
↓ s1[4] == e, s2[4] == e → match!
→ count1 = lcs(4, 4, 1)
  ↓ s1[3] == d, s2[3] == d → match!
  → count1 = lcs(3, 3, 2)
    ↓ s1[2] == c, s2[2] == f → ❌ no match
    → count1 = 2 (final here)

Track max between:
- count1 = 2 (from above match chain: `de`)
- count2 = lcs(4, 5, 0)
- count3 = lcs(5, 4, 0)
🔚 Final Result:
Longest Common Substring = "de"

Length = 2
    */
//    public class LongestCommonSubstringMemo {
//
//    public static int longestCommonSubstring(String s1, String s2) {
//        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][Math.min(s1.length(), s2.length()) + 1];
//        for (int[][] mat : dp) for (int[] row : mat) java.util.Arrays.fill(row, -1);
//        return lcs(s1, s2, s1.length(), s2.length(), 0, dp);
//    }
//
//    private static int lcs(String s1, String s2, int i, int j, int count, int[][][] dp) {
//        if (i == 0 || j == 0) return count;
//        if (dp[i][j][count] != -1) return dp[i][j][count];
//
//        int count1 = count;
//
//        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//            count1 = lcs(s1, s2, i - 1, j - 1, count + 1, dp);
//        }
//
//        int count2 = lcs(s1, s2, i - 1, j, 0, dp);
//        int count3 = lcs(s1, s2, i, j - 1, 0, dp);
//
//        return dp[i][j][count] = Math.max(count1, Math.max(count2, count3));
//    }
//
//    public static void main(String[] args) {
//        String s1 = "abcdfgh";
//        String s2 = "abedfgh";
//        int len = longestCommonSubstring(s1, s2);
//        System.out.println("Length of Longest Common Substring (Memo): " + len);
//    }
//}
}
