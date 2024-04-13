package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minMaxAvg {

    public static ArrayList<Integer> recursion(ArrayList<Integer> A, int size) {
        if (size == 0) return A;


        // sort the array
        Collections.sort(A);
        int max = A.get(A.size() - 1);
        int min = A.get(0);

        int avg = (max + min) / 2;
        A.set(A.size() - 1, max - avg);
        A.set(0, min + avg);
        return recursion(A, size - 1);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();


        //helper function
        return recursion(A, N);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 2, 7));

        System.out.println(solve(A));

    }
}


