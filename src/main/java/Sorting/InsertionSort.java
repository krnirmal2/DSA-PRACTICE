package Sorting;

import java.util.Arrays;

public class InsertionSort {

    /*In this implementation, we start by iterating through the array starting from the second
     element (i.e., index 1). For each element, we store it in a temporary variable key and then
      iterate backwards from the current element to the start of the array. During this backwards
      iteration, we move any elements that are greater than key one position to the right to make room for key.
Once we've found the correct position for key, we insert it into the array. We repeat this
process for each element in the array until the entire array is sorted in ascending order.
*/

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 1, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 5, 6, 7]

    }
}
