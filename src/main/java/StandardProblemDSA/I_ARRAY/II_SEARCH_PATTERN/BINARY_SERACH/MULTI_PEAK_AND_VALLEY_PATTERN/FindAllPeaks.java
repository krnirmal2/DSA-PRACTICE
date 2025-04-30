package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MULTI_PEAK_AND_VALLEY_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class FindAllPeaks {
  public static List<Integer> findAllPeaks(int[] arr) {
    List<Integer> peaks = new ArrayList<>();
    int n = arr.length;

    if (n == 0) {
      return peaks;
    }

    // Check first element
    if (n > 1 && arr[0] > arr[1]) {
      peaks.add(0);
    }

    // Check middle elements
    // if it is greater than both left and right element
    // then add those indexes
    for (int i = 1; i < n - 1; i++) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        peaks.add(i);
      }
    }

    // Check last element is greter then the second last
    // if yes add the last element index also
    if (n > 1 && arr[n - 1] > arr[n - 2]) {
      peaks.add(n - 1);
    }

    return peaks;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 7, 1, 2, 6, 0, 8, 7};
    List<Integer> peaks = findAllPeaks(arr);
    System.out.println("Peak indices: " + peaks);
  }
}
