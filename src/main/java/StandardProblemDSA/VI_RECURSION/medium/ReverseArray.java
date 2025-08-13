package StandardProblemDSA.VI_RECURSION.medium;

// Problem 8: Reverse an array using recursion

import java.util.Arrays;

import static StandardProblemDSA.I_ARRAY.ArrayUtility.swap;

public class ReverseArray {

  public static void reverse(int[] arr, int left, int right) {
    if (left >= right) return;
    swap(arr, left, right);
    reverse(arr, left + 1, right - 1);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    reverse(arr, 0, arr.length - 1);
    System.out.println("Reversed Array: " + Arrays.toString(arr));
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N) - recursion stack
