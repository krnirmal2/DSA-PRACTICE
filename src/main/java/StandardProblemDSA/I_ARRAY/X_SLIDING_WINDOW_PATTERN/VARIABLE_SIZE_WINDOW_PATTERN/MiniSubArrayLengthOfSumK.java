package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

public class MiniSubArrayLengthOfSumK {
  /* Given an array of positive integers and a positive integer,
  write a function that returns the minimal length of a contiguous subarray,
  where the sum is greater than or equal to the integer being passed in.
  If there isn’t one, return 0.*/

  public static int minSubArrayLen(int[] arr, int target) {
    int minLength = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;
    int right = 0;
    int first =0, second =0;
    while (left < arr.length) {
      if (sum >= target) {
        // store the current minimal length
        minLength = Math.min(minLength, (right - left));
        // shrink the window:
        // (1) subtract the value at left idx
        // (2) move the left panel one index further to the right
        sum -= arr[left];
        left++;
      } else if (sum < target && right < arr.length) {
        // expand the window:
        // (1) sum up the current value
        // (2) move the right panel one index further to the right
        sum += arr[right];
        right++;
      } else break;
    }

    return (minLength == Integer.MAX_VALUE ? 0 : minLength);
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 2, 4, 3};
    int target = 6;
    System.out.println(minSubArrayLen(arr, target));
  }
}
