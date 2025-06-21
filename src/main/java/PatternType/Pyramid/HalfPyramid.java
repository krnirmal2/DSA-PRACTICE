package PatternType.Pyramid;

public class HalfPyramid {
    // 3. Half Pyramid
    static void halfPyramid(int n) {
        System.out.println("\n3. Half Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}
