package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.ROTETED_ARRAY;

/*
* Problem Statement:
* ------------------
* Find the Minimum Element in a Rotated Sorted Array (No Duplicates).
*
* You are given an integer array `a` that was originally sorted in ascending order,
* but has been rotated at some unknown pivot. Your task is to find and return the
* minimum element in the array.
*
* Example:
* --------
* Input:  a = [5, 6, 1, 2, 3, 4]
* Output: 1
*
* Approach:
* ---------
* - Use binary search instead of linear scan for O(log n) time.
* - The smallest element is the only element for which the previous element is larger.
* - Check mid against high:
*     1. If a[mid] <= a[high]: right half is sorted → minimum is in the left half (including mid).
*     2. Else: left half is sorted → minimum is in the right half.
* - If the array is already sorted (a[low] < a[high]), return a[low].
*
* Pattern:
* --------
* - Binary Search on Rotated Sorted Array (finding minimum element).
*
* Time and Space Complexity:
* --------------------------
* - Time: O(log n), as the array is halved at each step.
* - Space: O(1), no extra space used.
*

*
* Follow-ups:
* -----------
* - How to handle duplicates? (Need to skip equals to restore sorted property.)
* - Can you also return the rotation count (index of minimum element)?
*/

public class MinMumElementInRotedSortedArray {

  public static int findMin(int[] a) {
    /*The smallest element is the only one where the previous element is greater than it.
    In a binary search approach:
    If the right half is sorted → minimum is on the left
    If the left half is unsorted → minimum lies in the unsorted part
    When the array is already sorted, the smallest is simply arr[0]*/
    // we can find theis using order of n but use binary serch
    int high = a.length - 1;
    int low = 0;
    int mid;
    // iterate over the array
    // approach '
    // 1. if a[mid] <= a[high] means from mid to high the array is already sorted
    // 2. if a[mid]> a[high] means from low to mid array is sorted
    // so if both side is sorted means it is rotated sorted array and
    // and we will came to add the end where low and mid and high will be point same pinoint
    // and low pointer will give the lowest element
    while (low < high) {
      // The current subarray is already sorted,
      // the minimum is at the low index
      if (a[low] < a[high]) {
        // set the high to mid
        return a[low];
      }
      // We reach here when we have at least
      // two elements and the current subarray
      // is rotated
      mid = low + (high - low) / 2;
      // The right half is not sorted. So
      // the minimum element must be in the
      // right hal
      if (a[mid] > a[high]) {
        low = mid + 1;
      } // The right half is sorted. Note that in
      // this case, we do not change high to mid - 1
      // but keep it to mid. As the mid element
      // itself can be the smallest
      else {
        high = mid;
      }

      // The left half is sorted, the maximum must
      /*  // be either arr[mid] or in the right half.
          if (arr[mid] > arr[lo])
              lo = mid;
          else
              hi = mid - 1;
      }*/
    }
    // return at the low
    return a[low];
  }

  public static void main(String[] args) {
    int[] arr = {5, 6, 1, 2, 3, 4};
    System.out.println(findMin(arr));
  }
}
