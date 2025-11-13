package StandardProblemDSA.VII_BACKTRACKING;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a string s, return all possible partitions where every substring is a palindrome.
 * Example: "aab" -> [["a","a","b"], ["aa","b"]]
 *
 * <p>Pattern: Backtracking (DFS) with choose → explore → unchoose, checking palindrome at each step
 * to prune.
 *
 * <p>Follow-ups: 1. Find minimum cuts for palindrome partitioning (DP - Palindrome Partitioning
 * II). 2. Optimize palindrome checking with memoization (O(N^2) preprocessing). 3. Use bitmasking
 * to generate partitions and filter palindromes.
 *
 * <p>LeetCode Similar Problems: 131. Palindrome Partitioning, 132. Palindrome Partitioning II
 *
 * <p>Time Complexity: O(N * 2^N) → 2^(N-1) partitions × O(N) palindrome checks. Space Complexity:
 * O(N) recursion depth + O(N) path storage.
 */
public class PalindromicPartition {
  public List<List<String>> partition(String s) {
    // Backtracking
    // Edge case
    if (s == null || s.length() == 0) return new ArrayList<>();

    List<List<String>> result = new ArrayList<>();
    helper(s, new ArrayList<>(), result);
    return result;
  }

  public void helper(String s, List<String> step, List<List<String>> result) {
    // Base case
    if (s == null || s.length() == 0) {
      result.add(new ArrayList<>(step));
      return;
    }
    for (int i = 1; i <= s.length(); i++) {
      String temp = s.substring(0, i);
      if (!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome
      // choose
      step.add(temp);
      helper(s.substring(i), step, result); // explore
      // unchoose
      step.remove(step.size() - 1);
    }
  }

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }
}
