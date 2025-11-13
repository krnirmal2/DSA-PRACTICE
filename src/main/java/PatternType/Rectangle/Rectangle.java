package PatternType.Rectangle;

import java.util.Scanner;

public class Rectangle {
  /* Function to print solid rectangle*/

  static void solid_rectangle(int n, int m) {

    int i, j;

    for (i = 1; i <= n; i++) {

      for (j = 1; j <= m; j++) {

        System.out.print("*");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {

    int rows, columns;

    Scanner sc = new Scanner(System.in);

    System.out.print("nEnter the number of rows : ");

    rows = sc.nextInt();

    System.out.print("Enter the number of columns : ");

    columns = sc.nextInt();

    System.out.println();

    solid_rectangle(rows, columns);
  }
}
