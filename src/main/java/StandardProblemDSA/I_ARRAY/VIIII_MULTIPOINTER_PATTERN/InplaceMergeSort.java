package StandardProblemDSA.I_ARRAY.VIIII_MULTIPOINTER_PATTERN;

public class InplaceMergeSort {
  /*
  Question:
  Given two sorted arrays nums1 and nums2, merge nums2 into nums1 in-place so that nums1 becomes
  a single sorted array. nums1 has enough space (m + n) to hold additional elements from nums2.

  Example:
  Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3
         nums2 = [2, 5, 6], n = 3
  Output: [1, 2, 2, 3, 5, 6]

  Approach:
  1. Use three pointers:
     - i → last valid element in nums1 (m - 1)
     - j → last element in nums2 (n - 1)
     - k → last position in nums1 (m + n - 1)
  2. Compare elements from the back:
     - If nums1[i] > nums2[j], place nums1[i] at nums1[k], move i and k.
     - Else, place nums2[j] at nums1[k], move j and k.
  3. Copy remaining elements of nums2 (if any) into nums1.

  Pattern:
  - Two-Pointer Pattern (merging from the end).

  Time Complexity:
  - O(m + n) since each element is processed once.
  Space Complexity:
  - O(1) as the merge is done in-place.

  Follow-up Questions:
  1. What if nums1 doesn’t have enough extra space?
  2. How would you modify the code to merge into a new array instead of in-place?
  3. Can you generalize this approach to merge k sorted arrays?
  4. How does this compare to using `System.arraycopy`?
  5. Can we do the same merge if nums1 and nums2 are sorted in descending order?

  Similar LeetCode/Interview Questions:
  - LeetCode 88. Merge Sorted Array
  - LeetCode 21. Merge Two Sorted Lists (linked list version)
  - LeetCode 977. Squares of a Sorted Array (merge logic for transformed arrays)
  */

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1; // Pointer for nums1
    int j = n - 1; // Pointer for nums2
    int k = m + n - 1; // Pointer for the merged array

    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }

    // Copy remaining elements from nums2, if any
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3, n = 3;

    merge(nums1, m, nums2, n);
    System.out.println("Merged array: " + java.util.Arrays.toString(nums1));
  }
}
