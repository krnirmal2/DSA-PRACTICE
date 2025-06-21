package PatternType;

public class Pattern {

    public static void main(String[] args) {
        int n = 5;

        solidRectangle(n);
        hollowRectangle(n);
        halfPyramid(n);
        invertedHalfPyramid(n);
        mirroredHalfPyramid(n);
        fullPyramid(n);
        invertedFullPyramid(n);
        diamond(n);
        hollowDiamond(n);
        butterflyPattern(n);
        leftHalfPyramidNumbers(n);
        rightHalfPyramidNumbers(n);
        floydsTriangle(n);
        zeroOneTriangle(n);
        pascalsTriangle(n);
        rhombus(n);
        hollowRhombus(n);
        numberPyramid(n);
        palindromicPyramid(n);
        alphabeticalPyramid(n);
        alphabeticalTriangle(n);
        zigZagPattern(n);
        hourglassPattern(n);
        sandglassPattern(n);
        rightArrowStar(n);
    }

    // 1. Solid Rectangle
    static void solidRectangle(int n) {
        System.out.println("\n1. Solid Rectangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    // 2. Hollow Rectangle
    static void hollowRectangle(int n) {
        System.out.println("\n2. Hollow Rectangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 3. Half Pyramid
    static void halfPyramid(int n) {
        System.out.println("\n3. Half Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    // 4. Inverted Half Pyramid
    static void invertedHalfPyramid(int n) {
        System.out.println("\n4. Inverted Half Pyramid");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    // 5. Mirrored Half Pyramid
    static void mirroredHalfPyramid(int n) {
        System.out.println("\n5. Mirrored Half Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    // 6. Full Pyramid
    static void fullPyramid(int n) {
        System.out.println("\n6. Full Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 7. Inverted Full Pyramid
    static void invertedFullPyramid(int n) {
        System.out.println("\n7. Inverted Full Pyramid");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 8. Diamond
    static void diamond(int n) {
        System.out.println("\n8. Diamond Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    // 9. Hollow Diamond
    static void hollowDiamond(int n) {
        System.out.println("\n9. Hollow Diamond");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 10. Butterfly Pattern
    static void butterflyPattern(int n) {
        System.out.println("\n10. Butterfly Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 11. Left Half Pyramid with Numbers
    static void leftHalfPyramidNumbers(int n) {
        System.out.println("\n11. Left Half Pyramid with Numbers");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    // 12. Right Half Pyramid with Numbers
    static void rightHalfPyramidNumbers(int n) {
        System.out.println("\n12. Right Half Pyramid with Numbers");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    // 13. Floyd’s Triangle
    static void floydsTriangle(int n) {
        System.out.println("\n13. Floyd’s Triangle");
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(count++ + " ");
            System.out.println();
        }
    }

    // 14. 0-1 Triangle
    static void zeroOneTriangle(int n) {
        System.out.println("\n14. 0-1 Triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }

    // 15. Pascal's Triangle
    static void pascalsTriangle(int n) {
        System.out.println("\n15. Pascal's Triangle");
        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j < n - i; j++)
                System.out.print(" ");
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    // 16. Rhombus
    static void rhombus(int n) {
        System.out.println("\n16. Rhombus");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= n; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 17. Hollow Rhombus
    static void hollowRhombus(int n) {
        System.out.println("\n17. Hollow Rhombus");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    // 18. Number Pyramid
    static void numberPyramid(int n) {
        System.out.println("\n18. Number Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }

    // 19. Palindromic Number Pyramid
    static void palindromicPyramid(int n) {
        System.out.println("\n19. Palindromic Number Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = i; j >= 1; j--) System.out.print(j);
            for (int j = 2; j <= i; j++) System.out.print(j);
            System.out.println();
        }
    }

    // 20. Alphabetical Pyramid (A, AB, ABC...)
    static void alphabeticalPyramid(int n) {
        System.out.println("\n20. Alphabetical Pyramid");
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }

    // 21. Alphabetical Triangle (A, BB, CCC...)
    static void alphabeticalTriangle(int n) {
        System.out.println("\n21. Alphabetical Triangle");
        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    // 22. ZigZag Pattern
    static void zigZagPattern(int n) {
        System.out.println("\n22. ZigZag Pattern (3 rows)");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i + j) % 4 == 0 || (i == 2 && j % 4 == 0))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 23. Hourglass Pattern
    static void hourglassPattern(int n) {
        System.out.println("\n23. Hourglass Pattern");
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 24. Sandglass Pattern
    static void sandglassPattern(int n) {
        System.out.println("\n24. Sandglass Pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * (n - i) - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 25. Right Arrow Star Pattern
    static void rightArrowStar(int n) {
        System.out.println("\n25. Right Arrow Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // Remaining patterns 18–25 to be continued if you want:
    // - Number Pyramid
    // - Palindromic Number Pyramid
    // - Alphabetical Pyramid
    // - Alphabetical Triangle
    // - Zigzag Pattern
    // - Hourglass
    // - Sandglass
    // - Right Arrow Star

    // Let me know if you want those too!
}
/*1. Solid Rectangle
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *

2. Hollow Rectangle
* * * * *
*       *
*       *
*       *
* * * * *

3. Half Pyramid
*
* *
* * *
* * * *
* * * * *

4. Inverted Half Pyramid
* * * * *
* * * *
* * *
* *
*

5. Mirrored Half Pyramid
        *
      * *
    * * *
  * * * *
* * * * *

6. Full Pyramid
    *
   ***
  *****
 *******
*********

7. Inverted Full Pyramid
*********
 *******
  *****
   ***
    *

8. Diamond Pattern
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

9. Hollow Diamond
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *

10. Butterfly Pattern
*        *
**      **
***    ***
****  ****
**********
**********
****  ****
***    ***
**      **
*        *

11. Left Half Pyramid with Numbers
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5

12. Right Half Pyramid with Numbers
        1
      1 2
    1 2 3
  1 2 3 4
1 2 3 4 5

13. Floyd’s Triangle
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

14. 0-1 Triangle
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1

15. Pascal's Triangle
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1

16. Rhombus
    *****
   *****
  *****
 *****
*****

17. Hollow Rhombus
    *****
   *   *
  *   *
 *   *
*****

18. Number Pyramid
    1
   2 2
  3 3 3
 4 4 4 4
5 5 5 5 5

19. Palindromic Number Pyramid
    1
   212
  32123
 4321234
543212345

20. Alphabetical Pyramid
A
A B
A B C
A B C D
A B C D E

21. Alphabetical Triangle
A
B B
C C C
D D D D
E E E E E

22. ZigZag Pattern (3 rows)
    *
  *   *
*       *

23. Hourglass Pattern
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********

24. Sandglass Pattern
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********

25. Right Arrow Pattern
*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* *
* */