package StandardProblemDSA.I_ARRAY.I_TRAVERSAL_AND_MANIPULATION_PATTERNS;

import java.util.Arrays;

public class RotateArrayKStep {
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n; // Handle cases where k > n

    reverse(nums, 0, n - 1); // Step 1: Reverse whole array
    reverse(nums, 0, k - 1); // Step 2: Reverse first K elements
    reverse(nums, k, n - 1); // Step 3: Reverse rest of the array
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(arr, k);
    System.out.println("Rotated Array: " + Arrays.toString(arr));
  }
}
