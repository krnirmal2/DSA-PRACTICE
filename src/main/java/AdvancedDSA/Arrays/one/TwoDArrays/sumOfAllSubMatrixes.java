package AdvancedDSA.Arrays.one.TwoDArrays;

public class sumOfAllSubMatrixes {



    public static int solve(int[][] A) {

        int sum =0;
        for(int row =0; row <A.length; row++){
            for(int col = 0 ;col < A[0].length; col++){
                sum+= A[row][col] * ((row+1)*(col+1) * (A.length- row) *(A[0].length-col));
            }
        }

        return sum ;


    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 3, 4 } };

        int result = solve(arr);
        System.out.println(result);
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                        + arr[i][j]);
    }

}


