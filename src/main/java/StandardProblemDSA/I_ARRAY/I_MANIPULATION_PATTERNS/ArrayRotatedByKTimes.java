package StandardProblemDSA.I_ARRAY.I_MANIPULATION_PATTERNS;

import StandardProblemDSA.Utility;
import java.util.Scanner;

public class ArrayRotatedByKTimes {

  public static int[] solve(int[] A, int k) {
    // first k element reverse
    // last n-k element and reverse
    // the full array  reverse
    int n = A.length;

    // first k element means 0 to n-k-1
    for (int i = 0, j = n - k - 1; i < j; i++, j--) {
      Utility.swap(A, i, j);
    }
    // last n-k element means n-k-1 to n-1
    for (int i = n - k, j = n - 1; i < j; i++, j--) {
      Utility.swap(A, i, j);
    }
    // full array means from 0 to n-1
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      Utility.swap(A, i, j);
    }
    return A;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();

    int[] A = new int[input];
    int i = 0;
    while (i < input) {
      int ele = sc.nextInt();
      A[i] = ele;
      i++;
    }
    int B = sc.nextInt();
    B = B % input;
    solve(A, B);
    for (int j = 0; j < input; j++) {
      System.out.print(A[j]);
    }
  }
}
