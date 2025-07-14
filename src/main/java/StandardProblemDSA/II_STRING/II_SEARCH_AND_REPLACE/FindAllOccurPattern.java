package StandardProblemDSA.II_STRING.II_SEARCH_AND_REPLACE;

import StandardProblemDSA.II_STRING.StringUtility;
import java.util.ArrayList;
import java.util.List;

public class FindAllOccurPattern {

  public static List<Integer> findAllOccurrences(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    // Step1 : find the lps of the string
    int[] lps = StringUtility.computePatternLps(pattern);

    List<Integer> occurrences = new ArrayList<>();
    int i = 0, j = 0;

    // Step ; match the pattern and text and add all the indexes
    // during matchPatWithText
    // so we need to manipulate the match function each time for this kind of
    // question
    while (i < n) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == m) {
        occurrences.add(i - j);
        j = lps[j - 1];
      } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return occurrences;
  }

  public static void main(String[] args) {
    String text = "ababcabcabababd";
    String pattern = "ab";

    List<Integer> occurrences = new ArrayList<>();
    int index = text.indexOf(pattern);
    while (index != -1) {
      occurrences.add(index);
      index = text.indexOf(pattern, index + 1);
    }

    System.out.println("All occurrences at indices: " + occurrences);

    List<Integer> result = findAllOccurrences(text, pattern);
    System.out.println("All occurrences at indices: " + result);
  }
}
