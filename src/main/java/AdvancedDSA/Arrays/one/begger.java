package AdvancedDSA.Arrays.one;

import java.util.ArrayList;
import java.util.Collections;

public class begger {
    public static int[] solve(int A, int[][] B) {
        int[] result = new int[A];
        //  iterate over all the query and add the value at that correspondig index
        for (int start = 0; start < B[0].length; start++) {
            int end = B[start][1];
            int value = B[start][2];

            int sum_from_left = 0;
            result[start] = result[start] + value;
//            result[end] = result[]   - value;
            // now take each query value and add the value to the particular index of the A
            for (int j = end; j <= A; j++) {
//                result[j] = result[j]+ value;
//                result[start] = result[start] + value;
                result[end + 1] = result[j] - value;
            }


        }


        return result;

    }


    public static void main(String[] args) {

        int A = 5;
        ArrayList<Integer> arrayA = new ArrayList<Integer>(Collections.nCopies(A, 0));
//        ArrayList<ArrayList<Integer> > x = new ArrayList<ArrayList<Integer> >();
        int[][] B = {{1, 2}, {3, 4}};

        solve(A, B);


    }
}
