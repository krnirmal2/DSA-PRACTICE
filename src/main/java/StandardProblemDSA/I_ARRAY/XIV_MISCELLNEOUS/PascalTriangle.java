package StandardProblemDSA.I_ARRAY.XIV_MISCELLNEOUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
   /* Recursion Approach:

    Base case: If numRows is 1, return [[1]].
    Recursively generate the triangle for numRows - 1.
    Calculate the current row by summing adjacent elements from the previous row.*/



    // we use TAIL recursion her

    public List<List<Integer>> generate(int numRows) {
        //Base cases

        if(numRows==0) return new ArrayList<>();
        if(numRows==1){
            List<List<Integer>> result =   new ArrayList<>();
            result.add(Arrays.asList(1));
        }

        // recursively geerate the triangle for numrow -1
        List<List<Integer>> prevRows = generate(numRows-1);
        List<Integer> newRow = new ArrayList<>();

        for(int i =0;i<numRows;i++){
            newRow.add(1);
        }
        // f
        for(int i=1;i<numRows-1;i++){
            newRow.set(i,prevRows.get(numRows-2).get(i-1) + prevRows.get(numRows-2).get(i));
        }

        prevRows.add(newRow);
        return prevRows;
    }

    /*
       List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;
    }
    }*/
}
