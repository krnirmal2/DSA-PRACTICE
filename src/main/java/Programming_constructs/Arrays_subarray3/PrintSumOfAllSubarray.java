package Programming_constructs.Arrays_subarray3;

public class PrintSumOfAllSubarray {


    public static void subarraySum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(A[k]);
                    sum = sum + A[k];
                    System.out.println(sum);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3};


        subarraySum(A);
//        System.out.println(subarraySum(A));
    }
}
