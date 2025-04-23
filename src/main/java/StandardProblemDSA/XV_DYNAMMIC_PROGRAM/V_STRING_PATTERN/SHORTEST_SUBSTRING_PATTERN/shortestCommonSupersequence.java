package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.SHORTEST_SUBSTRING_PATTERN;


import static StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN.LongestCommonSubsequence.longestCommonSubsequence;

public class shortestCommonSupersequence {
   /* ✅ Shortest Common Supersequence (SCS):
    Given two strings str1 and str2, the SCS is the shortest possible string that is a supersequence of both.

            ➡️ That means both str1 and str2 are subsequences of this new string.

📌 Example:
    Let’s say:
    str1 = "AGGTAB"
    str2 = "GXTXAYB"
    LCS = "GTAB" (common part)
    So we use the formula:

    SCS length = str1.length() + str2.length() - LCS length
           = 6 + 7 - 4
                   = 9
                   👉 So, a possible Shortest Common Supersequence could be: "AGXGTXAYB"

            ✔️ It contains all characters of "AGGTAB" in order
✔️ It contains all characters of "GXTXAYB" in order

🧠 Analogy:
    Think of:
    Subsequence: You’re erasing parts (cutting things out).
    Supersequence: You’re inserting things (expanding it) but keeping the original stuff in order.

*/
    public static int shortestCommonSupersequence(String text1, String text2) {
        int lcsLength = longestCommonSubsequence(text1, text2);
        return text1.length() + text2.length() - lcsLength;
    }
    public static void main(String[] args) {

        System.out.println(shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
    }

}
