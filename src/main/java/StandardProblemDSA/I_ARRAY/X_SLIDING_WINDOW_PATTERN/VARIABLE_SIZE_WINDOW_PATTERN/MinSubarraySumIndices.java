package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

import java.util.Arrays;

public class MinSubarraySumIndices {
  /**
   * Finds the starting and ending indices of the first contiguous subarray with a sum equal to B
   * and having the minimum length.
   *
   * <p>Approach: Sliding Window
   *
   * <p>1. Initialize variables to track the minimum length, start and end indices of the result,
   * current window sum, and the start of the current window. 2. Iterate through the array with the
   * 'windowEnd' pointer, expanding the window. 3. Maintain the 'currentSum' of the elements within
   * the current window. 4. If 'currentSum' exceeds B, shrink the window from the left by
   * incrementing the 'windowStart' pointer and subtracting the corresponding element from
   * 'currentSum'. 5. If 'currentSum' equals B, calculate the current window length. If this length
   * is smaller than the 'minLen' found so far, update 'minLen', 'start', and 'end' to store the
   * indices of this minimum length subarray. 6. After iterating through the entire array, if a
   * subarray with sum B was found (indicated by 'start' not being -1), return the start and end
   * indices. 7. If no such subarray was found, return an array containing -1.
   *
   * <p>Time Complexity: O(N), where N is the length of the input array A. Space Complexity: O(1),
   * constant extra space is used.
   *
   * @param A The input array of positive integers.
   * @param B The target sum.
   * @return An array containing the start and end indices of the minimum length subarray with sum
   *     B, or [-1] if no such subarray exists.
   */
  public static int[] solve(int[] A, int B) {
    /* this is modification of MiniSubArrayLengthOfSumK , by adding first and second and change Math.min with manual
    condition check
    int minLength = Integer.MAX_VALUE;
int sum = 0;
int left = 0, right = 0;
int first = -1, second = -1;

while (right < arr.length || (sum >= target && left < arr.length)) {//Loop condition (while (left < arr.length)) is insufficient.
//This may exit prematurely if right < arr.length and you're still building up the sum.
  if (sum >= target) {
    if (right - left < minLength) {
      minLength = right - left;
      first = left;
      second = right - 1;
    }
    sum -= arr[left];
    left++;
  } else {
    if (right < arr.length) {
      sum += arr[right];
      right++;
    } else {
      break;
    }
  }
}

if (first != -1 && second != -1) {
  System.out.println("First Index: " + first + ", Last Index: " + second);
  System.out.println("Length: " + minLength);
} else {
  System.out.println("No valid window found.");
}
*/
    /*Question:

    You are given an array of positive integers A and a target integer B.
     Your task is to find the starting and ending indices (inclusive) of the first contiguous
     subarray within A whose sum is equal to B and has the minimum length.
     If multiple such subarrays exist with the same minimum length,
      you should return the indices of the one that appears earliest in the array
       (i.e., has the smallest starting index). If no such subarray exists, return an array containing
       only -1.

    Time and Space Complexity Analysis:*/
    int n = A.length;
    int minLen = Integer.MAX_VALUE; // Initialize minimum length to maximum possible value
    int start = -1; // Initialize start index of the result
    int end = -1; // Initialize end index of the result
    int currentSum = 0; // Initialize the sum of the current window
    int windowStart = 0; // Initialize the starting index of the current window
    /*Time Complexity: O(N)

    The windowEnd pointer iterates through the array A at most once (O(N)).
    The windowStart pointer also moves forward at most N times in total (because it never goes backward).
    Therefore, the overall time complexity of the solve function is linear, O(N), where N is the length of the input array A.*/
    // Iterate through the array using the end of the sliding window
    for (int windowEnd = 0; windowEnd < n; windowEnd++) {
      //Step1. Expanding phase
      currentSum += A[windowEnd]; // Expand the window by adding the current element

      // Step 2 : Shrink the window from the left if the current sum exceeds the target
      while (currentSum > B) {
        currentSum -= A[windowStart];
        windowStart++;
      }

      //step 3:  If the current window sum equals the target
      if (currentSum == B) {
        int currentLen = windowEnd - windowStart + 1; // Calculate the length of the current window
        // If the current length is smaller than the minimum length found so far
        if (currentLen < minLen) {
          minLen = currentLen; // Update the minimum length
          start = windowStart; // Update the start index of the result
          end = windowEnd; // Update the end index of the result
        }
      }
    }

    // If a subarray with sum B was found, return its start and end indices
    if (start != -1) {
      return new int[] {start, end};
    } else {
      // If no such subarray was found, return [-1]
      return new int[] {-1};
    }
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5};
    int B = 5;
    int[] result = solve(A, B);
    System.out.println(Arrays.toString(result)); // Output: [0, 1]

    int[] A2 = {1, 2, 1, 2, 1};
    int B2 = 3;
    int[] result2 = solve(A2, B2);
    System.out.println(Arrays.toString(result2)); // Output: [0, 2]

    int[] A3 = {5, 1, 2, 3};
    int B3 = 5;
    int[] result3 = solve(A3, B3);
    System.out.println(Arrays.toString(result3)); // Output: [0, 0]

    int[] A4 = {1, 2, 3, 4, 5};
    int B4 = 15;
    int[] result4 = solve(A4, B4);
    System.out.println(Arrays.toString(result4)); // Output: [0, 4]

    int[] A5 = {1, 2, 3, 4, 5};
    int B5 = 16;
    int[] result5 = solve(A5, B5);
    System.out.println(Arrays.toString(result5)); // Output: [-1]
  }
}
