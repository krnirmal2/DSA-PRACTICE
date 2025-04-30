package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

public class SumOfAllSubarray {

  public static long subarraySum(int[] A) {
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

  // time o(n*n) space = o(1)
  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    System.out.println(subarraySum(A));
  }
}
