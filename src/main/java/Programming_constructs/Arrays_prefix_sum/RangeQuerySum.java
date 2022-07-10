package Programming_constructs.Arrays_prefix_sum;

public class RangeQuerySum {
        public static void main(String[] args) {
            int A [] = {7,3,1,5,5, 5, 1, 2, 4, 5 };
            int B [][] = {{7, 10},
                    {3, 10},
                    {3, 5},
                    {1, 10}
            };
            int result [] =rangeQuerySum(A, B);
            for (int i= 0;i<result.length;i++){
                System.out.println(result[i]);
            }
        }
        private static int[] rangeQuerySum(int[] a, int[][] b) {
            int size = a.length;
            int result [] = new int[100];
            int sum = a[0];
            int prefixSum [] = new int[size] ;
            // find the prefix sum of the given aray a
            for(int i=1;i<size;i++){
                sum = sum + a[i];
                prefixSum[i] = sum;
            }
            for(int j=0,k =1;j<b[0].length;j++){
                int leftIndex , rightIndex;
                leftIndex = b[j][0];
                rightIndex =b[j][1];
                if(leftIndex >= 0 && rightIndex <a.length)
                {
                    result[j] = prefixSum[rightIndex]-prefixSum[leftIndex-1];}

            }
            return result;

        }

    }


//public class Solution {
//    public long[] rangeSum(int[] A, int[][] B) {
//        int n = A.length;
//        int M = B.length;
//        long [] PS = new long[n];
//        PS[0] = A[0];
//        for(int i =1;i<n;i++){
//            PS[i] = PS[i-1] + A[i];
//        }
//        long [] ans = new long[M];
//        for(int i = 0;i<M;i++){
//            int l = B[i][0];
//            int r = B[i][1];
//            if(l==1){
//                ans[i] = PS[r-1];
//            }
//            else{
//                ans[i] = PS[r-1]-PS[l-2];
//            }
//        }
//        return ans;
//    }
//}
