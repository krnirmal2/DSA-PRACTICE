package Programming_constructs.Arrays2D14;

public class Rotate90DegreeMatrix {
    public static int[][] solve(int[][] A) {
        int temp;
        // FIRST TRANSPOSE THE MATRIX AND THEN REVERSE EACH ELEMENT
        // TRANSPOSE
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                {
                    temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
                // System.out.println("%d  %d ",A[i][j] ,A[j][i] );

            }
        }

//        for (int i = 0; i < 2; i++)
//            for (int j = 0; j < 2; j++)
//                System.out.println("arr[" + i + "][" + j + "] = "
//                        + A[i][j]);
//        System.out.println("\n");
        // now REVERSE each row of the MATRIX
//        int k = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int k = A.length - 1;
            for (int j = 0; j < A[0].length; j++) {
                while (j < k) {

                    temp = A[i][j];
                    A[i][j] = A[i][k];
                    A[i][k] = temp;
                    k--;
                }
            }
//            System.out.println("\n");
//            for (i = 0; i < 2; i++)
//                for (int j = 0; j < 2; j++)
//                    System.out.println("arr[" + i + "][" + j + "] = "
//                            + A[i][j]);
//

        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        arr = solve(arr);

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                        + arr[i][j]);

    }
}
