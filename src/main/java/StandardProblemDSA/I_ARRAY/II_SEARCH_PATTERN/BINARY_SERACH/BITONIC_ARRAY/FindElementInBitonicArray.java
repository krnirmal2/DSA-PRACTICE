package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.BITONIC_ARRAY;

import StandardProblemDSA.Utility;

import static StandardProblemDSA.Utility.findElementLeftAscendigArray;
import static StandardProblemDSA.Utility.findElementRightDescendtingArray;

public class FindElementInBitonicArray {
    /*Given a bitonic sequence of n distinct elements, and an integer x, the task is to write a program to find given
       element x in the bitonic sequence in O(log n) time.
    Input :  arr[] = {-3, 9, 18, 20, 17, 5, 1}, key = 20
    Output : Found at index 3

          Algorithm
      Find the Peak (Bitonic Point) using Binary Search.
      The peak is where arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1].
      If arr[mid] < arr[mid + 1], the peak is in the right half.
      If arr[mid] > arr[mid + 1], the peak is in the left half.
      Binary Search in the Increasing Half (Left of Peak).

      If the element is found, return its index.
      Binary Search in the Decreasing Half (Right of Peak).

      If the element is found, return its index.
      */
  private static int searchBitonic(int[] bitonicArr, int target) {
    // step1 : find the peack element and return its index
    //    int[] bitonicArr = {1, 3, 8, 12, 14, 11, 5, 2};
    int peakIndex = Utility.peakElement(bitonicArr);

    // step2 now from 0 to peakIndex 1, 3, 8, 12, 14 will be left part Ascending sort array
    int leftPart = findElementLeftAscendigArray(0, peakIndex, bitonicArr, target);
    if (leftPart != -1) return leftPart;
    // step3 now from peakElement to high the descending Array  11, 5, 2
    return findElementRightDescendtingArray(peakIndex, bitonicArr.length - 1, bitonicArr, target);
  }

  public static void main(String[] args) {
    int[] bitonicArr = {1, 3, 8, 12, 14, 11, 5, 2};
    int target = 5;
    int result = searchBitonic(bitonicArr, target);

    if (result != -1) System.out.println("Element found at index: " + result);
    else System.out.println("Element not found");
  }

  /*Time Complexity
  Finding Peak → O(log n)
  Binary Search in Left Half → O(log n)
  Binary Search in Right Half → O(log n) 👉 Total: O(log n) + O(log n) + O(log n) = O(log n)*/
}
