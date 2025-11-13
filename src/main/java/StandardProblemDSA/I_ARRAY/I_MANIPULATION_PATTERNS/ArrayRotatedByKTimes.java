package StandardProblemDSA.I_ARRAY.I_MANIPULATION_PATTERNS;

import static StandardProblemDSA.Utility.reverseArray;

import java.util.Scanner;

public class ArrayRotatedByKTimes {

  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n; // in case k > n

    reverseArray(nums, 0, n - 1); // reverse entire array
    reverseArray(nums, 0, k - 1); // reverse first k elements
    reverseArray(nums, k, n - 1); // reverse the rest
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
    rotate(A, B);
    for (int j = 0; j < input; j++) {
      System.out.print(A[j]);
    }
  }
}
