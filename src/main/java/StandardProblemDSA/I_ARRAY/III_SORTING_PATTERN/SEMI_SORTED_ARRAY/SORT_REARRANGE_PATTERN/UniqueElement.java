package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

public class UniqueElement {

  public static int solve(int[] A) {
    int N = A.length;
    Arrays.sort(A);
    int count = 0;
    for (int i = 1; i < N; i++) {
      if (A[i - 1] >= A[i]) {
        count += A[i - 1] + 1 - A[i];
        A[i] = A[i - 1] + 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2};

    solve(a);
  }
}
