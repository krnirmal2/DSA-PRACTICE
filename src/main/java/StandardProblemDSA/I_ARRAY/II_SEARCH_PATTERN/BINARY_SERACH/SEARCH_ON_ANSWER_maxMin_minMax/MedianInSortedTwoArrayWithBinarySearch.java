package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class MedianInSortedTwoArrayWithBinarySearch {
  /*
  Problem Statement:
  ------------------
  You are given two sorted arrays `a` and `b` of sizes n1 and n2.
  Find the median of the two sorted arrays.
  The overall run-time complexity should be O(log(min(n1, n2))).

  Definitions:
  - Median:
    - If the total number of elements (n1 + n2) is odd, the median is the middle element.
    - If even, it is the average of the two middle elements.

  Example 1:
  Input: a = [1, 4, 7, 10, 12], b = [2, 3, 6, 15]
  Output: 6.0
  Explanation: Combined sorted array = [1, 2, 3, 4, 6, 7, 10, 12, 15], median = 6.

  Example 2:
  Input: a = [1, 3], b = [2]
  Output: 2.0
  Explanation: Combined sorted array = [1, 2, 3], median = 2.

  Approach:
  ---------
  - Use **Binary Search** on the smaller array.
  - Partition both arrays such that:
      - Left half of `a` + Left half of `b` = (n1 + n2 + 1) / 2
      - Ensure all elements in the left half ≤ all elements in the right half.
  - Key idea:
      - Compare `l1` (max of left of `a`) and `r2` (min of right of `b`)
        and `l2` (max of left of `b`) and `r1` (min of right of `a`).
      - If partitions are valid: return median.
      - Else adjust binary search boundaries.

  Pattern:
  --------
  - **Binary Search on Partition Index**
  - Classic problem: Divide arrays into left and right halves.

  Complexity:
  -----------
  - Time: O(log(min(n1, n2))) - binary search on smaller array
  - Space: O(1)

  Related LeetCode Problems:
  --------------------------
  - 4. Median of Two Sorted Arrays (Hard) DONE

  Follow-ups:
  -----------
  1. What if arrays are unsorted? → Need to sort first (O(n log n)).
  2. What if arrays are streams (infinite)? → Use two heaps.
  3. Can we find the kth element instead of the median? → Yes, generalize partition logic.

  */

  /*
      Algorithm:
  1. First, we have to make sure that the arr1[] is the smaller array. If not by default, we will just swap the arrays.
  Our main goal is to consider the smaller array as arr1[].
  2. Calculate the length of the left half: left = (n1+n2+1) / 2.
  3. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 0 and the high will point to n1(i.e. The size of arr1[]).
  4. Calculate the ‘mid1’ i.e. x and ‘mid2’ i.e. left-x: Now, inside the loop, we will calculate the value of ‘mid1’ using the following formula:
  mid1 = (low+high) // 2 ( ‘//’ refers to integer division)
  mid2 = left-mid1
  5. Calculate l1, l2, r1, and r2: Generally,
  	1. l1 = arr1[mid1-1]
  	2. l2 = arr2[mid2-1]
  	3. r1 = arr1[mid1]
  	4. r2 = arr2[mid2]
  The possible values of ‘mid1’ and ‘mid2’ might be 0 and n1 and n2 respectively. So, to handle these cases, we need to store some default values for these four variables. The default value for l1 and l2 will be INT_MIN and for r1 and r2, it will be INT_MAX.
  1. Eliminate the halves based on the following conditions:
  	1. If l1 <= r2 && l2 <= r1: We have found the answer.
  	2. If (n1+n2) is odd: Return the median = max(l1, l2).
  	3. Otherwise: Return median = (max(l1, l2)+min(r1, r2)) / 2.0
  	4. If l1 > r2: This implies that we have considered more elements from arr1[] than necessary. So, we have to take less elements from arr1[] and more from arr2[]. In such a scenario, we should try smaller values of x. To achieve this, we will eliminate the right half (high = mid1-1).
  	5. If l2 > r1: This implies that we have considered more elements from arr2[] than necessary. So, we have to take less elements from arr2[] and more from arr1[]. In such a scenario, we should try bigger values of x. To achieve this, we will eliminate the left half (low = mid1+1).
  2. Finally, outside the loop, we will include a dummy return statement just to avoid warnings or errors.
  The steps from 4-6 will be inside a loop and the loop will continue until low crosses high.

  */
  public static double median(int[] a, int[] b) {
    int n1 = a.length, n2 = b.length;

    // Step 1: Ensure that `a` is always the smaller array
    // This makes binary search efficient (we search in the smaller array)
    if (n1 > n2) return median(b, a);

    // Step 2: Total length of merged arrays
    int n = n1 + n2;

    // Step 3: Number of elements that should be in the "left half"
    // of the partition when we split arrays
    // Example: if total length is 9 → left half should have 5 elements
    int left = (n1 + n2 + 1) / 2;

    // Step 4: Apply binary search on the smaller array (a)
    int low = 0, high = n1;

    while (low <= high) {
      // Step 5: Partition index for array `a`
      int mid1 = (low + high) / 2;

      // Step 6: Partition index for array `b`
      // It ensures total elements in left = `left`
      int mid2 = left - mid1;

      // Step 7: Values just before and after partition in both arrays
      // If partition is at index 0 → nothing on the left side → take -∞
      // If partition is at the end → nothing on the right side → take +∞
      int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
      int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
      int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
      int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

      // Step 8: Check if partition is valid
      // Valid partition means:
      // - The largest element on left of `a` <= smallest element on right of `b`
      // - AND the largest element on left of `b` <= smallest element on right of `a`
      if (l1 <= r2 && l2 <= r1) {
        // Step 9: If total length is odd, median = max(left half)
        if (n % 2 == 1) return Math.max(l1, l2);
        // Step 10: If even, median = average of max(left half) and min(right half)
        else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
      }
      // Step 11: If l1 > r2 → we cut too much from `a` → move left
      else if (l1 > r2) high = mid1 - 1;

      // Step 12: If l2 > r1 → we cut too little from `a` → move right
      else low = mid1 + 1;
    }

    // Should never reach here if inputs are correct
    return 0;
  }

  public static void main(String[] args) {
    int[] a = {1, 4, 7, 10, 12};
    int[] b = {2, 3, 6, 15};

    System.out.println("The median of two sorted arrays is " + median(a, b));
  }
}
