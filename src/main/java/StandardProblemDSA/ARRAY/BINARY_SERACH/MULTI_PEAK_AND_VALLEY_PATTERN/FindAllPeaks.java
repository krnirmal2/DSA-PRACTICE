package StandardProblemDSA.ARRAY.BINARY_SERACH.MULTI_PEAK_AND_VALLEY_PATTERN;

import java.util.*;

public class FindAllPeaks {
    public static List<Integer> findAllPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        int n = arr.length;

        if (n == 0) return peaks;

        // Check first element
        if (n > 1 && arr[0] > arr[1]) peaks.add(0);

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peaks.add(i);
            }
        }

        // Check last element
        if (n > 1 && arr[n - 1] > arr[n - 2]) peaks.add(n - 1);

        return peaks;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 1, 2, 6, 0, 8, 7};
        List<Integer> peaks = findAllPeaks(arr);
        System.out.println("Peak indices: " + peaks);
    }
}
