package Programming_constructs.BinarySearch;

import java.util.ArrayList;

public class MagicalNoBorCdivisibleNo {
    public static int solve(int A, int B, int C) {
        ArrayList<Integer> r = new ArrayList<>();
        int n = 1000000000;
        int count = 0;

        // run through one to n
        for (int i = 1; i <= n; i++) {
            if (i % B == 0 || i % C == 0 || (i % B == 0 && i % C == 0)) {

                if (count++ <= A) {
                    r.add(i);

//                        return r.get(A-1)%(n+7);
                }
                if (count == A) break;
            }
        }

        return r.get(A - 1) % (n + 7);
    }

    public static void main(String[] args) {
        System.out.println(solve(807414236, 3788, 38141));
//        System.out.println(solve(11,12,13));
    }

}
