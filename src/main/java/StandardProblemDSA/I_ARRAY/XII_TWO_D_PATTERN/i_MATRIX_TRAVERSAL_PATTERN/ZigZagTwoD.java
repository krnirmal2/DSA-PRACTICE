package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.i_MATRIX_TRAVERSAL_PATTERN;

import StandardProblemDSA.I_ARRAY.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTwoD {
    public List<Integer> zigzagTraverse(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {  // left-to-right
                for (int j = 0; j < matrix[i].length; j++)
                    result.add(matrix[i][j]);
            } else {  // right-to-left
                for (int j = matrix[i].length - 1; j >= 0; j--)
                    result.add(matrix[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        ArrayUtility.
//        ArrayUtility.print2DArray(a);
    }
}
