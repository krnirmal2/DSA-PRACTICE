package LanguageMODULE.AssignmentWeek2.Day4;

import java.util.Arrays;

public class MultipleTimeArrayRotations {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3};
        solve(A, B);
    }

    public static int[] rotateFunction(int[] A, int Bvalue) {

        // first rotate the first Bvalue elemeent
        int temp;

        for (int i = 0, j = Bvalue - 1; i < j & j >= 0; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);

        }
        System.out.println("1st\n");
        //now rotate the array from last to lengthA - Bvalue
        for (int i = A.length - Bvalue - 1, j = A.length - 1; i <= j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);

        }
        System.out.println("2nd\n");
        // rotate the whole array
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);

        }
        System.out.println("3rd\n");
        return A;

    }

    private static void solve(int[] A, int[] B) {
        int lenghtA = A.length;
        int[][] result = new int[B.length][A.length];
        int[] temp = new int[lenghtA];
        for (int i = 0; i < B.length; i++) {
            temp = rotateFunction(A, B[i]);

            System.arraycopy(temp, 0, result[i], 0, lenghtA);
            Arrays.fill(temp, 0);

        }
//        return result;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.print(" ");
        }

    }

}
