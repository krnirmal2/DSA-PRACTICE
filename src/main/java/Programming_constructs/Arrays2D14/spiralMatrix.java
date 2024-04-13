package Programming_constructs.Arrays2D14;

public class spiralMatrix {
    // Java program to print a given matrix in spiral form


    // Function print matrix in spiral form
    static void spiralPrint(int m, int n, int[][] a) {
        int i, k = 0, l = 0;

		/* k - starting_row_index
		m - ending_row_index
		l - starting_column_index
		n - ending_column_index
		i - iterator
		*/

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int R = 4;
        int C = 4;
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // Function Call
        spiralPrint(R, C, a);
    }
}

// Contributed by Pramod Kumar



/*public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rows, cols;
        int row, col;
        rows = cols = A;
        int num = 1;
        int max = A * A;
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                res.get(i).add(0);
            }
        }
        row = col = 0;
        int dir = 0;
        int layer = 0;
        res.get(0).set(0, 1);
        for (int step = 2; step <= A * A; step++) {
            switch(dir) {
                // Go right
                case 0:
                    if (col == cols - layer - 1) {
                        row++;
                        dir = 1;
                    }
                    else
                        col++;
                    break;
                // Go down
                case 1:
                    if (row == rows - layer - 1) {
                        dir = 2;
                        col--;
                    } else
                        row++;
                    break;
                // Go left
                case 2:
                    if (col == layer) {
                        row--;
                        dir = 3;
                    } else
                        col--;
                    break;
                // Go up
                case 3:
                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else
                        row--;
                    break;
            }
            res.get(row).set(col, step);
        }
        return res;
    }
}*/

