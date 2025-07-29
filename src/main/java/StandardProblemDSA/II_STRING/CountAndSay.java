package StandardProblemDSA.II_STRING;

public class CountAndSay {
  /*  RLE) is a string compression method that works by replacing consecutive identical
      characters (repeated 2 or more times) with the concatenation of the character and the number
       marking the count of the characters (length of the run). For example, to compress the string
        "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11".
        Thus the compressed string becomes "23321511".
       Given a positive integer n, return the nth element of the count-and-say sequence.
       Example 1:
       Input: n = 4
       Output: "1211"
       Explanation:

       countAndSay(1) = "1"
       countAndSay(2) = RLE of "1" = "11"
       countAndSay(3) = RLE of "11" = "21"
       countAndSay(4) = RLE of "21" = "1211"
       Example 2:
       Input: n = 1
       Output: "1"
       Explanation:
       This is the base case.
       Constraints:
               1 <= n <= 30

   * Approach:
  * - Base case: n = 1 → "1".
  * - For each next term, apply Run-Length Encoding (RLE) on the previous term:
  *      - Traverse the string, count consecutive characters.
  *      - Append count + character to form new string.
  * - Repeat until reaching n.
  *
  * Example:
  *    n = 4:
  *      1 → "1"
  *      2 → "11" (one 1)
  *      3 → "21" (two 1s)
  *      4 → "1211" (one 2, one 1)
  *
  * Time Complexity: O(2^n) (string length roughly doubles each step).
  * Space Complexity: O(2^n) for storing intermediate results.
  *
  * Follow-up:
  * - Optimize memory by using a char array builder.
  * - Related to LeetCode 38: Count and Say. */
  public String countAndSay(int n) {
    if (n == 1) return "1";

    String result = "1";
    // as each time we create new no. so traverse all of them
    for (int i = 2; i <= n; i++) {
      result = encode(result);
    }
    return result;
  }

  // Helper function to perform Run-Length Encoding
  private String encode(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 1;
    char prev = s.charAt(0);

    for (int i = 1; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == prev) {
        count++;
      } else {
        sb.append(count).append(prev);
        count = 1;
        prev = curr;
      }
    }
    sb.append(count).append(prev); // Append the last group
    return sb.toString();
  }
}
