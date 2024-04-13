package Programming_constructs.Arrays_subarray3;

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
//
        }
        return result;
    }
//        public static long subarraySum(int[] A) {
//            int sizeA = A.length;
//            long result =0;
//            int ps[]= new int[sizeA];
//            // ps[0]= A[0];
//            for(int i=1;i<sizeA;i++){
//                ps[i]= ps[i-1]+A[i];
//            }
//            long sum = 0;
////            int sizeA= A.length;
//            for(int i=0;i<sizeA;i++)
//            {
//                for(int j=i ;j<sizeA;j++){
//                    if(i==0){
//                        sum = ps[j];
//                    }
//                    else
//                        sum = ps[j]-ps[j-1];
//                }
//                // result = sum;
//            }
//            return sum;
//        }


    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(subarraySum(A));
    }

}
