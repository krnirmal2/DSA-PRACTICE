package StandardProblemDSA.I_ARRAY.IV_CARRY_FORWARD_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
Given a string A consisting of uppercase English letters, count the number of pairs (i, j) such that:
- i < j
- A[i] = 'A' and A[j] = 'G'

Example:
Input: A = "ABCGAG"
Output: 3
Explanation:
- Valid pairs: (A at index 0, G at index 3), (A at index 0, G at index 5), (A at index 4, G at index 5).

Approach:
1. Compute a prefix array psg[] where psg[i] = number of 'G's up to index i.
2. Traverse the string again:
   - For each 'A', count how many 'G's occur after it using totalG - psg[currentIndex].
   - Add to result modulo a given value.
3. Return the total count.

Pattern:
- Prefix Sum Pattern.
- Optimized counting of character pairs using cumulative counts.

Time Complexity:
- O(n) for prefix calculation + O(n) for counting → O(n).
Space Complexity:
- O(n) for the prefix array.

Follow-up Questions:
1. Can we optimize space to O(1) by keeping only a running count of 'G's?
2. How to count "AG", "AB", or any other specific pair efficiently?
3. Can we extend this logic to count triplets like "ABC"?
4. How would you handle a very large string (memory optimization)?
5. How do you modify the solution to count pairs in reverse (i > j)?

Similar LeetCode/Interview Questions:
- Count pairs of characters (custom problem, common in interviews)
- LeetCode 1512. Number of Good Pairs (pair counting)
- LeetCode 560. Subarray Sum Equals K (prefix sum pattern)
*/

public class AGPairCount {
  public static int solve(String A) {
    int sizeS = A.length();
    int count = 0, result = 0;
    int[] psg = new int[sizeS];
    int modulo = Utility.getModulo();
    // prefix for character G if find then increament the prefix else kept as it is
    // psg=[ 0, 0, 0, 1, 1, 2 ] for "ABCGAG"
    for (int i = 1; i < sizeS; i++) {
      if (A.charAt(i) == 'G') {
        psg[i] = psg[i - 1] + 1;
      } else psg[i] = psg[i - 1];
    }
    // suffix for character A if find then increament from the back and add the result
    for (int j = 0; j < sizeS; j++) {
      if (A.charAt(j) == 'A') {
        count = psg[sizeS - 1] - psg[j];
        result = (result + count) % modulo;
      }
    }

    return (result);
  }

  public static void main(String[] args) {
    String A = "ABCGAG";
    System.out.println(solve(A));
  }
}

/*
public class Solution {
    public int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        //Suffix count of G
        for(int i = n-1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }
        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }
}*/
