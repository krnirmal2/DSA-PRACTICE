package StandardProblemDSA;

import java.util.*;

public class Utility {
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

  public static void reverseArray(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
  public static void reverseList(List<Integer> A, int start, int end) {
    while (start < end) {
      Collections.swap(A, start, end);
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

  /**
   * Prints the array elements in a single line.
   *
   * @param arr the array to print
   */
  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }


  /**
   * Swaps two elements in the array.
   *
   * @param arr the array
   * @param i index of first element
   * @param j index of second element
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  /**
   * Performs binary search on a sorted array.
   *
   * @param arr sorted array
   * @param target the value to search for
   * @return index of target if found, otherwise -1
   */
  public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) return mid;
      else if (arr[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }

  /**
   * Finds and returns the maximum element in the array.
   *
   * @param arr the array
   * @return maximum value in the array
   */
  public static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
      if (num > max) max = num;
    }
    return max;
  }

  /**
   * Finds and returns the minimum element in the array.
   *
   * @param arr the array
   * @return minimum value in the array
   */
  public static int findMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int num : arr) {
      if (num < min) min = num;
    }
    return min;
  }

  public static int[] createNewArrayOfSizeN(int sizeOfResultArrray) {
    int[] result = new int[sizeOfResultArrray];
    return result;
  }
  public static void countFrequencyEachElement(int[] A, HashMap<Integer, Integer> mapA) {
    // insert the element and count the frequency of each element in A and B
    for (int i = 0; i < A.length; i++) {
      if (mapA.containsKey(A[i])) {
        mapA.put(A[i], mapA.get(A[i]) + 1);
      } else {
        mapA.put(A[i], 1);
      }
    }
  }

  public static long getTotalSubArraySumOfArray(int[] A) {
    long result = 0;
    long sum = 0;
    int sizeA = A.length;
    for (int i = 0; i < sizeA; i++) {
      sum = 0;
      for (int j = i; j < sizeA; j++) {
        sum = sum + A[j];
        result = result + sum;
      }
    }
    return result;
  }

  public static int getMiniMumValue() {
    int minIndex = Integer.MAX_VALUE;
    return minIndex;
  }
  public static int getMaxiMumValue() {
    int minIndex = Integer.MIN_VALUE;
    return minIndex;
  }

  public static int getArrayLength(int[] numbers) {
    return numbers.length;
  }
  public static int[] arrayWithPosiNegativeValue() {
    int[] a = {
            4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9,
            -4, 4, -8
    };
    return a;
  }

  public static int[] getUnsortedArray() {
    int[] arr = {12, 11, 13, 5, 6, 7};
    return arr;
  }

  public static void sortArrayWithArrySort(int[] A) {
    Arrays.sort(A);
  }
  public static int[] onlyThreeValueArray() {
    int[] A = {
            2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1,
            2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2,
            1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2,
            2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2,
            1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2
    };
    return A;
  }
  public static int getModulo() {
    int modulo = (int) Math.pow(10, 9) + 7;
    return modulo;
  }

  public static void prefixMinMaxWithMinusOneIntialisationINDEX(int[] A, int min, int max, int[] prefixMin, int[] prefixMax) {
    int lastMinIndex = -1, lastMaxIndex = -1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == min) lastMinIndex = i;
      if (A[i] == max) lastMaxIndex = i;

      prefixMin[i] = lastMinIndex;
      prefixMax[i] = lastMaxIndex;
    }
  }
  public static void suffixSum(int[] A, int[] suffixSum) {
    // Compute suffix sum
    suffixSum[ getArrayLength(A) - 1] = A[getArrayLength(A) - 1];
    for (int i =  getArrayLength(A) - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + A[i];
    }
  }

  public static void prefixSum(int[] A, int[] prefixSum) {
    // Compute prefix sum
    prefixSum[0] = A[0];
    for (int i = 1; i < getArrayLength(A); i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i];
    }
  }

  public static void suffixMaxValues(List<Integer> A, int[] right_max, int n) {
    // suffix max
    right_max[n - 1] = A.get(n - 1);
    for (int i = A.size() - 2; i >= 0; i--) {
      right_max[i] = Math.max(right_max[i + 1], A.get(i));
    }
  }

  public static void prefixMaxValues(List<Integer> A, int[] left_max) {
    left_max[0] = A.get(0);

    // first find the prefix max
    for (int i = 1; i < A.size(); i++) {
      left_max[i] = Math.max(left_max[i - 1], A.get(i));
    }
  }
  public static void prefixEvenOddSum(int[] A, int[] prefixEven, int[] prefixOdd, int n) {
    prefixEven[0] = A[0];
    prefixOdd[0] = 0;

    for (int i = 1; i < n; i++) {
      prefixEven[i] = prefixEven[i - 1];
      prefixOdd[i] = prefixOdd[i - 1];

      if (i % 2 == 0) {
        prefixEven[i] += A[i];
      } else {
        prefixOdd[i] += A[i];
      }
    }
  }

  public static void cyclicSort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int correctIndex = nums[i] - 1; // Correct index for nums[i]
      if (nums[i] != nums[correctIndex]) {
        // Swap nums[i] with the number at its correct position
        Utility.swap(nums,i,correctIndex);
      } else {
        i++; // Move to the next element
      }
    }
  }

  public static Map<Character, Integer> getCharFrequencyOfString(String pattern) {
    Map<Character, Integer> patternMap = new HashMap<>();
    for (char ch : pattern.toCharArray()) {
      patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
    }
    return patternMap;
  }
  public static void createCharacterFrequencyArray(String pattern, int[] patFreq) {
    // Fill pattern frequency
    for (char ch : pattern.toCharArray()) {
      patFreq[ch - 'a']++; // strore the frequency of the character
    }
  }

  public static boolean matches(int[] patFreq, int[] winFreq) {
    // check both the character at the same position are same or not
    for (int i = 0; i < 26; i++) {
      if (patFreq[i] != winFreq[i]) {
        return false;
      }
    }
    return true;
  }
   // ✅ Helper method to check if a string is a valid integer
   public static boolean isNumeric(String str) {
    if (str.isEmpty()) return false;
    if (str.charAt(0) == '-' && str.length() > 1)
      str = str.substring(1); // Handle negative numbers
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c)) return false; // Return false if any non-digit character is found
    }
    return true;
  }
    // ✅ Returns precedence of operators
  public static int precedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

      case '^':
        return 3; // Exponent has the highest precedence
        
      default:
        return 0; // For non-operator characters
    }
  }
}
