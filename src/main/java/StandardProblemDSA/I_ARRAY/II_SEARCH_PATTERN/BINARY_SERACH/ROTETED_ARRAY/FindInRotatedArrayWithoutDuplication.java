package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.ROTETED_ARRAY;

public class FindInRotatedArrayWithoutDuplication {
  /*Search in a Rotated Sorted Array (No Duplicates)

You are given a sorted array that has been rotated at some unknown pivot.
 Your task is to search for a target element in this array and return its index.
 If it doesn’t exist, return -1.*/
//  All elements are distinct.
//  Array was originally sorted in ascending order, then rotated.
//  Time complexity must be better than O(n) (i.e., O(log n) using binary search).
  public static int search(int[] a, int target) {

    int high = a.length;
    int low = 0;
    int mid;
    while (low < high) {
      // serach in left and right sorted array
      mid = low + (high - low) / 2;
      // if the element is found in the mid return  the mid
      if (a[mid] == target) {
        return mid;
      }
      //Check which part is sorted and serach on that part
      if (a[low] < a[mid]) {
        //  left sorted array serach in this paret
        if (a[low] < target && target < a[mid]) {
          high = mid - 1; // reduce search space ; // Target is in the left half
        } else {
          // we are not found that in this subarray then serach in the next sorted
          low = mid + 1; // Target is in the right half
        }
      } else {
        //  right srted array search in the
        if (a[mid] < target && target < a[high]) {
          low = mid + 1; // Target is in the right half
        } else { // if the element not in the above range than we will shift the search to next
          // subarray

          high = mid - 1; // Target is in the left half
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Rotated at index 4
    int target = 0;
    System.out.println("Index of target: " + search(arr, target)); // Output: 4
  }
}
