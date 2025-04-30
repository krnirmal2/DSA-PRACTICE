package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MULTI_PEAK_AND_VALLEY_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class FindAllValleys {
  public static List<Integer> findAllValleys(int[] arr) {
    List<Integer> valleys = new ArrayList<>();
    int n = arr.length;

    if (n == 0) return valleys;

    // Check first element
    if (n > 1 && arr[0] < arr[1]) valleys.add(0);

    // Check middle elements
    for (int i = 1; i < n - 1; i++) {
      if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
        valleys.add(i);
      }
    }

    // Check last element
    if (n > 1 && arr[n - 1] < arr[n - 2]) valleys.add(n - 1);

    return valleys;
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 8, 1, 4, 6, 2, 7};
    List<Integer> valleys = findAllValleys(arr);
    System.out.println("Valley indices: " + valleys);
  }
}
