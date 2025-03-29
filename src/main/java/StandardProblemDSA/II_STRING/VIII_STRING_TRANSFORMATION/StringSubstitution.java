package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

import java.util.HashMap;
import java.util.Map;

/**
 * Transforms a string according to substitution rules
 *
 * <p>Problem Definition: - Apply a series of substitution rules to transform input string - Rules
 * are provided as a map of character/string pairs
 *
 * <p>Example: Input: "abc", {'a':'x', 'bc':'yz'} Output: "xyz"
 *
 * <p>Approach: 1. Process string sequentially 2. For each position, check for matching rules 3.
 * Apply the longest matching rule 4. Build transformed string
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
