package StandardProblemDSA.II_STRING.II_SEARCH_AND_REPLACE;

import java.util.ArrayList;
import java.util.List;

public class FindAllOccurPattern {

  public static int[] computeLPS(String pattern) {
    int m = pattern.length();
    int[] lps = new int[m];
    int j = 0;
    int i = 1;

    while (i < m) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        j++;
        lps[i] = j;
        i++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }

  public static List<Integer> findAllOccurrences(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    int[] lps = computeLPS(pattern);

    List<Integer> occurrences = new ArrayList<>();
    int i = 0, j = 0;

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
