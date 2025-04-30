package StandardProblemDSA;

public class Utility {
  public static void swap(int[] A, int i, int j) {
    int temp;
    temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static int minOfArray(int[] A) {
    int max = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      max = Math.max(max, A[i]);
    }
    return max;
  }

  public static int maxOfArray(int[] A) {
    int min = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      min = Math.min(min, A[i]);
    }
    return min;
  }

  public static int sumOfArray(int[] A) {
    int sum = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
    }
    return sum;
  }

  public static boolean linearSearch(int[] A, int element) {

    for (int i = 0; i < A.length; i++) {
      if (element == A[i]) {
        return true;
      }
      ;
    }
    return false;
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static int peakElement(int[] bitonicArr) {
    // index of the peak element whose left and right have less element
    int low = 0;
    int high = bitonicArr.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      // here we don't compare with any target but
      // check the mid and mid+1 element
      if (bitonicArr[mid] > bitonicArr[mid + 1]) { // left part is sorted
        // and we will have to go left
        // means peak element will be find in the left part
        high = mid;
      } else { // else right part is sorted
        // the element present in right sid
        low = mid + 1;
      }
    }
    return low;
  }

  public static int findElementLeftAscendigArray(int low, int high, int[] bitonicArr, int target) {
    // return the Index of the target element
    // use binary search on the left part of the peak element
    int mid;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (bitonicArr[mid] == target) return mid; // if found return mid index
      if (bitonicArr[mid] > target) { // means left part of the array
        // element will be find in the left side
        high = mid - 1;
      } else {
        //  element will be found in right side
        low = mid + 1;
      }
    }
    return -1;
  }

  public static int findElementRightDescendtingArray(
      int low, int high, int[] bitonicArr, int target) {
    // use binary search on the right part of the peak element from Descending array
    int mid;
    while (low < high) {
      mid = low + (high - low) / 2;
      // if target element present in the mid then
      // return mid
      if (bitonicArr[mid] == target) return mid;
      // if mid is greater than target means it is decreaseing Array
      if (bitonicArr[mid] > target) {
        // element will be find in the right  side as decreaseing arrray
        low = mid + 1;
      } else {
        // element will be find in inceasing subarray
        high = mid - 1;
      }
    }
    return -1;
  }
}
