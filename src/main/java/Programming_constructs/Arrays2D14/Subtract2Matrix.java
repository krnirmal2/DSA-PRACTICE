package Programming_constructs.Arrays2D14;

public class Subtract2Matrix {

    public static int[][] solve(int[][] A, int[][] B) {
        int sizeOfRow = A.length;
        int sizeofColoumn = A[0].length;
        int sumOfAB[][] = new int[sizeOfRow][sizeofColoumn];

        for(int r = 0; r<sizeOfRow;r++){
            for(int c = 0; c<sizeofColoumn;c++){
                sumOfAB[r][c]= A[r][c]- B[r][c];
            }
        }

        return sumOfAB;
    }
    public static void main (String[] args)
    {
        int A[][] = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        int B[][] = {
                {1, 13, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        int row = A.length, col = A[0].length;
        int C[][]=new int[row][col];
        C=solve(A,B);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
                System.out.print(C[i][j] + " ");
            System.out.print("\n");
        }

    }
}
