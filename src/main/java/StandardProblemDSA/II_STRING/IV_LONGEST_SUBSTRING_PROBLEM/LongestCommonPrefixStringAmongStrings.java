package StandardProblemDSA.II_STRING.IV_LONGEST_SUBSTRING_PROBLEM;

import java.util.ArrayList;
import java.util.List;

/**
 * ✅ Problem:
 * Find the longest common prefix among an array of strings.
 * Example: Input: ["flower", "flow", "flight"] → Output: "fl"
 *
 * 🧠 Pattern:
 * Horizontal Scanning — use the first string as a base and compare each character index with all other strings.
 *
 * 💡 Follow-up Questions:
 * 1. Implement vertical scanning (character by character across all strings).
 * 2. Use divide-and-conquer approach to recursively compute prefix pairs.
 * 3. Use a Trie data structure for scalable prefix querying.
 * 4. Optimize for large datasets by breaking early when prefix becomes empty.
 * 5. Support case-insensitive, locale-aware, or Unicode-aware prefix comparison.
 *
 * 🔍 LeetCode Similar Problems:
 * 1. 14. Longest Common Prefix — https://leetcode.com/problems/longest-common-prefix/
 * 2. 208. Implement Trie (Prefix Tree) — https://leetcode.com/problems/implement-trie-prefix-tree/
 * 3. 720. Longest Word in Dictionary — https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * 📊 Time Complexity:
 * - Worst case: O(S) where S = total number of characters across all strings.
 * - For n strings of length up to m: O(n * m)
 *
 * 📦 Space Complexity:
 * - O(1) auxiliary space (ignoring input and output).
 *
 * 🔄 Comparison of Approaches:
 * | Method             | Time Complexity | Space | Use Case                      |
 * |--------------------|------------------|--------|-------------------------------|
 * | Horizontal Scanning| O(n * m)         | O(1)   | Simple, intuitive              |
 * | Vertical Scanning  | O(n * m)         | O(1)   | When early mismatch is common |
 * | Divide & Conquer   | O(n * m log n)   | O(log n)| Faster on balanced inputs     |
 * | Trie-based         | O(S)             | O(S)   | Best when many overlapping prefixes |
 *
 */

public class LongestCommonPrefixStringAmongStrings {
  /*find the longest/Maximum common prefix among this Strings "flower", "flow", "flight" , which will "fl";*/
  public static String longestCommonPrefix(List<String> A) {
    if (A == null || A.isEmpty()) return "";

    for (int i = 0; i < A.get(0).length(); i++) { // iterate over the first String length
      char c = A.get(0).charAt(i); // take the character of the first one by one and then

      for (int j = 1; j < A.size(); j++) { // compare the rest of the string character one by one
        // If i is out of bounds OR char at i doesn't match
        if (i >= A.get(j).length()
            || A.get(j).charAt(i) != c) { // if list empty or first String character
          // does not match with other String character at same index
            return A.get(0).substring(0, i); // take the substring of the first string from 0 to current i character
        }
      }
    }

    return A.get(0); // Entire first string is a common prefix
    /*
    | i | A\[0].charAt(i) | All strings match at i? | Action                    |
    | - | --------------- | ----------------------- | ------------------------- |
    | 0 | f               | ✅ Yes                   | continue                  |
    | 1 | l               | ✅ Yes                   | continue                  |
    | 2 | o               | ❌ “flight” has 'i'      | return A[0][0:2] → "fl" |
    n = number of strings
    m = length of the shortest string
    🔹 Time: O(n * m)
    Worst case: all strings are the same → compare every character
    🔹 Space: O(1)
    Only constant space used (no additional data structures)
    */
  }

  public static void main(String[] args) {
    List<String> A = new ArrayList<>(List.of("flower", "flow", "flight"));
    System.out.println(longestCommonPrefix(A));
  }
}
/*
  private static boolean isCommonPrefix(List<String> A, int mid){
    String prefix  = A.get(0).substring(0,mid);
    for(int i=1;i<A.size();i++){
      if(!A.get(i).startsWith(prefix)) return false;
    }
    return true;
  }

public static String BinarySolutionOfLCP(List<String> A){
  // here thought , as we have to check each string character
  // and find maximum length of the character can be matched
  // and this maximum thing arise the concept of binary
  //other factor support that if substring from 0 to mid is matched in every string means we can search for
  // mid+1 but if less then we can reduce right part to mid-1
  // which helps binary search on answer space
  if(A==null || A.isEmpty()) return "";

  // step 1: find the minimum length string
  int minString = Integer.MAX_VALUE;
  for(String s:A){
    minString = Math.min(minString, s.length());

  }

  // Step 2: now take the string minString length as high
  int low =0, high = minString;
  while(low<high){
    int mid = (high +low)/2;
    if(isCommonPrefix(A,mid)){
      low = mid+1; // if previous character matched from o to  mid then we can
    }else{
      high= mid -1; // means earlier character not matched shrink to left of it
    }
  }
  // Step 3: return longest common prefix of length `high`
  return A.get(0).substring(0,high);
    */
/*
    ⏱ Time Complexity:
Let n = number of strings, m = min length among strings
Binary search takes O(log m)
For each mid, we compare n strings → O(n)
Total = O(n * log m) → More efficient when strings are long*//*

                                                             }*/
