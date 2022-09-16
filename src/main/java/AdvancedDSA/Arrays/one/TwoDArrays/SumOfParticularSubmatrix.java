package AdvancedDSA.Arrays.one.TwoDArrays;

public class SumOfParticularSubmatrix {

    public  static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int result[] = new int[2];

        // step1. calculate the prfix sum of submatrix
        int prefixSumMatrix [][] = new int [A.length][A[0].length];
        // 1st row prefix sum
        prefixSumMatrix[0][0] =A[0][0];
        for(int i=1;i<A[0].length;i++){
            prefixSumMatrix[0][i] =prefixSumMatrix[0][i-1]+ A[0][i];
        }

        // 1st coloumn prefix sum
        for(int j=1;j<A.length;j++){
            prefixSumMatrix[j][0] += prefixSumMatrix[j-1][0] +A[j][0];
        }

        // for rest of the element
        for(int i = 1;i<A.length; i++){
            for(int j =1; j<A[0].length ; j++){
                prefixSumMatrix[i][j] = prefixSumMatrix[i-1][j] + prefixSumMatrix[i][j-1] + A[i][j] - prefixSumMatrix[i-1][j-1];
            }
        }

        // now take the uppper leftmost and  lower rightmost point to define the sub matrix need to calculate the sum of elements
        // of that submatrix
        // for 1st query


        for(int i =0;i<2;i++){
            B[i]=B[i]-1;
            C[i]=C[i]-1;
            D[i]=D[i]-1;
            E[i]=E[i]-1;
        }

        int sum1 = prefixSumMatrix[D[0]] [D[1]];

        if(B[0] !=0){
            sum1 -= prefixSumMatrix[B[0]-1][D[1]];
            result[0] =sum1;
        }
        if(B[1] !=0){
            sum1 -= prefixSumMatrix[D[0]][B[1]-1]; result[0] =sum1;
        }

        if(B[0] !=0 && B[1] !=0 ){
            sum1+= prefixSumMatrix[B[0]-1] [B[1]-1]; result[0] =sum1;
        }



        int sum2 =  prefixSumMatrix[E[0]] [E[1]];
        if(C[0] !=0){
            sum2 -= prefixSumMatrix[C[0]-1][E[1]];
            result[1] =sum2;
        }
        if(C[1] !=0){
            sum2 -= prefixSumMatrix[E[0]][C[1]-1]; result[1] = sum2;
        }

        if(C[0] !=0 && C[1] !=0 ){
            sum2+= prefixSumMatrix[C[0]-1] [C[1]-1]; result[1] = sum2;
        }


    return result;

    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}
        };

        int B[] ={0, 0 };
        int C[] ={0, 0};
        int D[] ={3, 4 };
        int E[] ={1, 1};
        int result[] = solve(arr,B,C, D, E);
        System.out.println(result);
        for (int i = 0; i < 2; i++)
                System.out.println("arr[" + i + "] = "
                        + result[i]);
    }

}



 /*   public static int[] solveSubMatrixSum(int[][] A, int[] B, int[] C, int[] D, int[] E) {
// Sum may be large so take long instead of int
// Prefix sum of rows
// Ex: [[1, 1, 1], [1, 1, 1], [1, 1, 1]] will become => [[1, 1, 1], [2, 2, 2],
// [3, 3, 3]]
        long[][] prefixSum = new long[A.length][A[0].length];

        for (int i = 0; i < A[0].length; i++) {
            prefixSum[0][i] = A[0][i];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                prefixSum[i][j] = A[i][j] + prefixSum[i - 1][j];
            }
        }
// Prefix sum of rows
// Ex: [[1, 1, 1], [1, 1, 1], [1, 1, 1]] will become => [[1, 2, 3], [1, 2, 3],
// [1, 2, 3]]
        long[][] columPrefixSum = new long[prefixSum.length][prefixSum[0].length];
        for (int i = 0; i < prefixSum.length; i++) {
            columPrefixSum[i][0] = prefixSum[i][0];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                columPrefixSum[i][j] = prefixSum[i][j] + columPrefixSum[i][j - 1];
            }
        }

// Now calculate the sum

        int[] output = new int[B.length];
        for (int i = 0; i < B.length; i++) {
// start point
            int a1 = B[i] - 1;
            int b1 = C[i] - 1;

// end point
            int a2 = D[i] - 1;
            int b2 = E[i] - 1;

            long sum = 0;
            if (a1 != 0 && b1 != 0) {
                sum = columPrefixSum[a2][b2] - columPrefixSum[a1 - 1][b2]
                        - columPrefixSum[a2][b1 - 1] + columPrefixSum[a1 - 1][b1 - 1];
            }

            if (a1 != 0 && b1 == 0) {
                sum = columPrefixSum[a2][b2] - columPrefixSum[a1 - 1][b2];
            }
            if (a1 == 0 && b1 != 0) {
                sum = columPrefixSum[a2][b2]
                        - columPrefixSum[a2][b1 - 1];
            }
            if (a1 == 0 && b1 == 0) {
                sum = columPrefixSum[a2][b2];
            }
// validate if sum is very large
            int mod = 1000000007;
            while (sum < 0) {
                sum += mod;
            }
            sum = sum % mod;
            output[i] = (int) sum;
        }

        return output;
    }
*/