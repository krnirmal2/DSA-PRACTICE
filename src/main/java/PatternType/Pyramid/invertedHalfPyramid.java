package PatternType.Pyramid;

public class invertedHalfPyramid {
  // 4. Inverted Half Pyramid
  static void invertedHalfPyramid(int n) {
    System.out.println("\n4. Inverted Half Pyramid");
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) System.out.print("* ");
      System.out.println();
    }
  }
}
