package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

public class LeastAverageSubarrayOfSizeB {

  public static int findMinAvgSubarray(int[] A, int B) {
    // Initialize pointers for the sliding window
    int i = 0; // Start of the window
    int j = 0; // End of the window
    int sum = 0; // To store the sum of elements within the window
    int leastAverage = Integer.MAX_VALUE; // To keep track of the minimum sum (least average)
    int resultIndex = -1; // To store the starting index of the subarray with the least average

    while (j < A.length) {
      // CASE 1 : EXPANDING WINDOW
      // Add the current element to the sum (expanding the window)
      sum += A[j];

      // Check if the window size is less than B
      if (j - i + 1 < B) {
        j++; // Expand the window by moving the end pointer forward
      }
      // CASE 2 :  WINDOW EQUAL TO SIZE
      // If the window size is exactly B, process the current window
      else if (j - i + 1 == B) {
        // Check if the current window's sum is less than the least average
        if (sum < leastAverage) {
          // Update least average and result index
          leastAverage = sum;
          resultIndex = i; // Store the start index of the current window
        }
        // CASE 3 : SHRINK THE WINDOW BY SUBSTRACT THE ELEMENT FROM SUM
        // Shrink the window by removing the first element
        sum -= A[i];
        // Move both pointers forward
        i++;
        j++;
      }
    }
    // Return the starting index of the subarray with the least average
    return resultIndex;
  }

  public static void main(String[] args) {
    // Test the function with sample input
    int[] arr = {3, 7, 90, 20, 10, 50, 40};
    int B = 3; // Size of subarray
    // Output the result
    System.out.println(findMinAvgSubarray(arr, B)); // Expected output: 3
  }
  /*A = [3, 7, 90, 20, 10, 50, 40]
  B = 3
  We need subarrays of size 3 and find the one with the minimum sum (which implies minimum average).


  Step	i (start)	j (end)	Current Window	sum	leastAverage (best sum so far)	resultIndex
  1	0	0	[3]	3	MAX_VALUE	-1
  2	0	1	[3, 7]	10	MAX_VALUE	-1
  3	0	2	[3, 7, 90]	100	100	0
  4	1	3	[7, 90, 20]	117	100	0
  5	2	4	[90, 20, 10]	120	100	0
  6	3	5	[20, 10, 50]	80	80	3
  7	4	6	[10, 50, 40]	100	80	3
  🛠️ Detailed Steps:
  Before the loop starts:
  sum = 0

  leastAverage = Integer.MAX_VALUE

  i = 0, j = 0

  Iteration 1:
  Add A[0] = 3 → sum = 3

  Window size = 1 < 3 → move j to 1

  Iteration 2:
  Add A[1] = 7 → sum = 10

  Window size = 2 < 3 → move j to 2

  Iteration 3:
  Add A[2] = 90 → sum = 100

  Window size = 3 = B → check

  100 < MAX_VALUE → Update leastAverage = 100, resultIndex = 0

  Shrink window: Remove A[0] = 3 → sum = 97

  Move i to 1, j to 3

  Iteration 4:
  Add A[3] = 20 → sum = 117

  Window size = 3 = B → check

  117 > 100 → no update

  Shrink window: Remove A[1] = 7 → sum = 110

  Move i to 2, j to 4

  Iteration 5:
  Add A[4] = 10 → sum = 120

  Window size = 3 = B → check

  120 > 100 → no update

  Shrink window: Remove A[2] = 90 → sum = 30

  Move i to 3, j to 5

  Iteration 6:
  Add A[5] = 50 → sum = 80

  Window size = 3 = B → check

  80 < 100 → Update

  leastAverage = 80

  resultIndex = 3

  Shrink window: Remove A[3] = 20 → sum = 60

  Move i to 4, j to 6

  Iteration 7:
  Add A[6] = 40 → sum = 100

  Window size = 3 = B → check

  100 > 80 → no update

  Shrink window: Remove A[4] = 10 → sum = 90

  Move i to 5, j to 7

  Loop ends (because j == length)
  Final Result:
  resultIndex = 3

  Subarray [20, 10, 50] starting at index 3 has the minimum average.*/
}
