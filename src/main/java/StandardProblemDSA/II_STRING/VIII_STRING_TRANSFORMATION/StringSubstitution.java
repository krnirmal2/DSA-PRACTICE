package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Apply substring replacement rules on an input string. Example: input = "abcde", rules =
 * {"ab" → "x", "c" → "y"} → "xyde".
 *
 * <p>Pattern: Greedy substitution + longest match: - Iterate over the string left to right. - At
 * each position, try to match the longest possible substring from the rules. - Replace if a match
 * is found; otherwise, append the current character.
 *
 * <p>Follow-ups: 1. Optimize with a trie for faster matching when rule count is large. 2. Handle
 * overlapping rules and precedence conflicts. 3. Extend to regex-based or context-sensitive
 * replacements.
 *
 * <p>LeetCode Similar Problems: 833. Find And Replace in String, 616. Add Bold Tag in String
 *
 * <p>Time Complexity: O(N * L) — N = input length, L = max substring length checked (here ≤ 10).
 * Space Complexity: O(N) — for building the output.
 */
public class StringSubstitution {
  public static String transform(String input, Map<String, String> rules) {
    StringBuilder output = new StringBuilder();
    int n = input.length();
    int i = 0;

    while (i < n) {
      boolean matched = false;
      // Check for longest matching rule starting at i
      for (int len = Math.min(n - i, 10); len > 0; len--) {
        String substr = input.substring(i, i + len);
        if (rules.containsKey(substr)) {
          output.append(rules.get(substr));
          i += len;
          matched = true;
          break;
        }
      }

      if (!matched) {
        output.append(input.charAt(i));
        i++;
      }
    }

    return output.toString();
  }

  public static void main(String[] args) {
    Map<String, String> rules = new HashMap<>();
    rules.put("a", "x");
    rules.put("bc", "yz");

    System.out.println(transform("abc", rules)); // "xyz"

    rules.clear();
    rules.put("1", "one");
    rules.put("12", "twelve");
    System.out.println(transform("12312", rules)); // "one23twelve"
  }
}
