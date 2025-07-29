package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
Problem:
Generate and print all subsequences (or subsets) of a given string.
A subsequence is a sequence that can be derived by deleting zero or more characters without changing the order.

Pattern:
Backtracking / Recursion with decision tree (Include or Exclude).

Approach:
1️⃣ Use recursion to explore all combinations of characters.
2️⃣ At each step, choose to either include or exclude the current character.
3️⃣ Base case: when input string is empty, add the accumulated result.
4️⃣ Store each result in a global list or return it as a function result.

Time Complexity:
O(2^n) — each character has two choices: include or exclude.

Space Complexity:
O(2^n) — number of subsequences stored in the list.

Similar LeetCode Questions:
- 78. Subsets
- 90. Subsets II
- 131. Palindrome Partitioning

Follow-up Questions:
- How to return only unique subsequences (with duplicate characters)?
- Modify to print only subsequences of a specific length.
- Can you adapt this to numeric arrays?
*/

public class PrintAllSubsequence {
  // Declare a global list
  static List<String> al = new ArrayList<>();

  // Creating a public static Arraylist such that
  // we can store values
  // IF there is any question of returning the
  // we can directly return too// public static
  // ArrayList<String> al = new ArrayList<String>();
  public static void main(String[] args) {
    String s = "abcd";
    findsubsequences(s, ""); // Calling a function
    System.out.println(al);
  }

  private static void findsubsequences(String s, String ans) {
    if (s.length() == 0) {
      al.add(ans);
      return;
    }

    // We add adding 1st character in string
    findsubsequences(s.substring(1), ans + s.charAt(0));

    // Not adding first character of the string
    // because the concept of subsequence either
    // character will present or not
    findsubsequences(s.substring(1), ans);
  }
}
