package StandardProblemDSA.I_ARRAY;

import java.util.*;

public class ArrayUtility {

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

  public static void print2DArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
      }
    }
  }

  public static void print3DArray(int[][][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        for (int k = 0; k < arr[i][j].length; k++) {
          System.out.println("arr[" + i + "][" + j + "][" + k + "] = " + arr[i][j][k]);
        }
      }
    }
  }

  public static void create2Darray(int[][] arr) {
    int count = 1;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = count++;
      }
    }
  }

  public static void analyzeTestCases(Scanner scanner) {
    int totalTestCases = scanner.nextInt();
    int[][] arrayMain = new int[totalTestCases][];

    for (int i = 0; i < totalTestCases; i++) {
      int eachTestCaseValues = scanner.nextInt();
      arrayMain[i] = new int[eachTestCaseValues];
      for (int j = 0; j < eachTestCaseValues; j++) {
        arrayMain[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < arrayMain.length; i++) {
      int evenCount = 0, oddCount = 0;

      System.out.println("TestCase " + i + " with " + arrayMain[i].length + " values:");
      for (int value : arrayMain[i]) {
        System.out.print(value + " ");
        if (value % 2 == 0) evenCount++;
        else oddCount++;
      }
      System.out.println();
      System.out.println("Total Even numbers: " + evenCount + ", Total Odd numbers: " + oddCount);
    }
  }

  // 1. Put Frequency or First Occurrence in HashMap
  public static Map<Integer, Integer> putFrequencyOrIndex(int[] a) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (mp.containsKey(a[i])) {
        mp.put(a[i], mp.get(a[i]) + 1);
      } else {
        mp.put(a[i], i); // store index of first occurrence
      }
    }
    return mp;
  }

  // 3. Traverse a HashMap and print key-value pairs
  public static void traverseMap(Map<Integer, Integer> map) {
    for (int key : map.keySet()) {
      System.out.println("Key = " + key + ", Value = " + map.get(key));
    }
  }

  // 4. Copy original array A into a padded array starting from (1,1)
  public static int[][] copyToPaddedArray(int[][] A) {
    int[][] paddingArray = new int[A.length + 1][A[0].length + 1];
    for (int i = 1; i < paddingArray.length; i++) {
      if (paddingArray[0].length - 1 >= 0)
        System.arraycopy(A[i - 1], 0, paddingArray[i], 1, paddingArray[0].length - 1);
    }
    return paddingArray;
  }

  // 5. Padding an array with zeros (first row and first column)
  public static void initializePadding2D(int[][] paddingArray) {
    for (int i = 0; i < paddingArray.length; i++) {
      paddingArray[i][0] = 0;
    }
    for (int j = 0; j < paddingArray[0].length; j++) {
      paddingArray[0][j] = 0;
    }
  }

  // 6. Generate Prefix Sum Matrix
  public static int[][] generatePrefix2DSum(int[][] A) {
    int rows = A.length;
    int cols = A[0].length;
    int[][] prefix = new int[rows][cols];

    prefix[0][0] = A[0][0];
    for (int j = 1; j < cols; j++) {
      prefix[0][j] = prefix[0][j - 1] + A[0][j];
    }

    for (int i = 1; i < rows; i++) {
      prefix[i][0] = prefix[i - 1][0] + A[i][0];
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] + A[i][j] - prefix[i - 1][j - 1];
      }
    }

    return prefix;
  }

  /**
   * Reverses the given array in place.
   *
   * @param arr the array to reverse
   */
  public static void reverseArray(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      swap(arr, left, right);
      left++;
      right--;
    }
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
   * Rotates the array to the right by k positions. Example: [1,2,3,4,5] rotated by 2 => [4,5,1,2,3]
   *
   * @param arr the array to rotate
   * @param k number of positions to rotate
   */
  public static void rotateArray(int[] arr, int k) {
    if (arr == null || arr.length == 0) return;
    k = k % arr.length;
    // Reverse entire array
    reverse(arr, 0, arr.length - 1);
    // Reverse first k elements
    reverse(arr, 0, k - 1);
    // Reverse remaining elements
    reverse(arr, k, arr.length - 1);
  }

  /**
   * Helper method to reverse a subarray from index 'left' to 'right'.
   *
   * @param arr the array
   * @param left starting index
   * @param right ending index
   */
  private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
      swap(arr, left, right);
      left++;
      right--;
    }
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

  // ✅ Reusable twoSum with two pointers
  public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
    // result store
    List<List<Integer>> res = new ArrayList<>();
    // two pointer from left and right
    int left = start, right = nums.length - 1;
      // check both the pointer value and based on target either increase or decrease the left and
      // right pointer
    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        res.add(Arrays.asList(nums[left], nums[right]));

        // Skip duplicates if any
        while (left < right && nums[left] == nums[left + 1]) left++;
        while (left < right && nums[right] == nums[right - 1]) right--;

        left++;
        right--;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return res;
  }
}
