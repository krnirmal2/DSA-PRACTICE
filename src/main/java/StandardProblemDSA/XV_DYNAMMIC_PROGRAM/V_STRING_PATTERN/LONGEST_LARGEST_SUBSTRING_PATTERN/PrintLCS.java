package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

public class PrintLCS {

        public static String printLCS(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            int[][] dp = new int[n + 1][m + 1];

            // Step 1: Fill DP table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Step 2: Trace back to find the actual LCS string
            int i = n, j = m;
            StringBuilder lcs = new StringBuilder();

            while (i > 0 && j > 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs.append(s1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            return lcs.reverse().toString(); // Because we traced from the end
        }

        public static void main(String[] args) {
            String s1 = "AGGTAB";
            String s2 = "GXTXAYB";
            String lcs = printLCS(s1, s2);
            System.out.println("Longest Common Subsequence: " + lcs);  // Output: GTAB
        }
/*Absolutely! Let's walk through a **small dry run** of printing the **LCS** using the example:

### ✨ Input:
```text
s1 = "abcde"
s2 = "ace"
```

We want to find the **LCS** of `"abcde"` and `"ace"`.

---

### 🧩 Step 1: Build the DP Table

Let’s create a table `dp[6][4]` (sizes are `s1.length() + 1` and `s2.length() + 1`) and fill it as per the logic.

#### Initialization (dp[0][*] = 0 and dp[*][0] = 0):

```
      a  c  e
    -------------
  | 0  0  0  0
a | 0
b | 0
c | 0
d | 0
e | 0
```

Now we fill in the table:

#### Iteration:

- `i = 1`, `j = 1` → s1[0] == s2[0] = 'a' → dp[1][1] = 1 + dp[0][0] = 1
- `i = 2`, `j = 1` → 'b' != 'a' → dp[2][1] = max(dp[1][1], dp[2][0]) = 1
- `i = 3`, `j = 2` → 'c' == 'c' → dp[3][2] = 1 + dp[2][1] = 2
- `i = 5`, `j = 3` → 'e' == 'e' → dp[5][3] = 1 + dp[4][2] = 3

🟩 Final DP Table (values only):

```
   0 1 2 3
   -------
0 | 0 0 0 0
1 | 0 1 1 1
2 | 0 1 1 1
3 | 0 1 2 2
4 | 0 1 2 2
5 | 0 1 2 3
```

---

### 🔁 Step 2: Trace Back to Find LCS

Start from `dp[5][3]` and trace back:

- dp[5][3] = 3 → s1[4] == s2[2] = 'e' → add 'e'
- move to dp[4][2]
- dp[3][2] = 2 → s1[2] == s2[1] = 'c' → add 'c'
- move to dp[2][1]
- dp[1][1] = 1 → s1[0] == s2[0] = 'a' → add 'a'
- done!

### ✅ Final LCS (reverse it): `"a" + "c" + "e"` → **`"ace"`**

---

### 🔚 Output:
```
Longest Common Subsequence: ace
```

Would you like a visual of this table as an image or ASCII art?*/
}
