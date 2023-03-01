package Programming_constructs.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinWindowSizeForASum {
        public static int solve(ArrayList<Integer> A, int B) {
            int n = A.size();

            int windowSize = Integer.MAX_VALUE;
            int sum =0;
            // sort A and then check last sum
            Collections.sort(A);
            for(int i = n-1;i>=0;i--){
                sum += A.get(i);
                if(sum<=B){
                    windowSize = n -i;
                }
            }
            return windowSize;
    }

    public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println(solve(A, 10));
    }

}
