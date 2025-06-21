package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

public class PrintSumOfAllSubarray {
  public static void subarraySum(int[] A) {
    for (int i = 0; i < A.length; i++) {
      int sum = 0;
      for (int j = i; j < A.length; j++) {
        sum += A[j];
        System.out.print("Subarray: ");
        for (int k = i; k <= j; k++) {
          System.out.print(A[k] + " ");
        }
        System.out.println("→ Sum: " + sum);
      }
    }
  }

  public static void subarraySumPrefix(int[] A) {//Avoid recalculating sum again and again. Precompute prefix sums.
    int n = A.length;
    int[] prefix = new int[n + 1]; // prefix[0] = 0

    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + A[i];
    }

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int sum = prefix[j + 1] - prefix[i];
        System.out.println(" => Sum: " + sum);
      }
    }
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    subarraySum(A);
    //        System.out.println(subarraySum(A));
  }
}
