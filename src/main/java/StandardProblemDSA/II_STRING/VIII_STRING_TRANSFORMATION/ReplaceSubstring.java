package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

/**
 * Replaces all occurrences of a substring in a string
 *
 * <p>Problem Definition: - Replace all instances of 'oldSub' in 'str' with 'newSub'
 *
 * <p>Example: Input: "hello world, world is big", "world", "earth" Output: "hello earth, earth is
 * big"
 *
 * <p>Approach: 1. Find each occurrence of oldSub 2. Replace with newSub 3. Return modified string
 */
public class ReplaceSubstring {
  public static String replaceAll(String str, String oldSub, String newSub) {
    if (oldSub.isEmpty()) return str;

    StringBuilder result = new StringBuilder();
    int lastIndex = 0;

    while (true) {
      int index = str.indexOf(oldSub, lastIndex);
      if (index == -1) {
        break;
      }
      result.append(str, lastIndex, index);
      result.append(newSub);
      lastIndex = index + oldSub.length();
    }

    result.append(str.substring(lastIndex));
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(replaceAll("hello world, world is big", "world", "earth"));
    // Output: "hello earth, earth is big"

    System.out.println(replaceAll("ababab", "ab", "c"));
    // Output: "ccc"
  }
}
