package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

public class NaiveMethodPatternMatching {

  public static void main(String[] args) {
    String text = "";
    String pattern = "";
    search(pattern, text);
  }

  private static void search(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();
    // a loop to slide pattern one by one
    for (int i = 0; i < n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        System.out.println("pattern found at index " + i);
      }
    }
  }
}
