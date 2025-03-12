package Programming_constructs.Arrays_subarray3;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarrayEasy {

    public static int maxSubarray(int A, int B, ArrayList<Integer> C) {

        int start = 0, max = 0;
        int end = 0, sum = 0;
        while (end < C.size()) {

            if ((sum + C.get(end)) <= B) {
                sum = sum + C.get(end);
                max = Math.max(max, sum);
                end++;
            } else {
                sum = sum - C.get(start);
                start++;

            }
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(2, 1, 3, 4, 5));
        maxSubarray(5, 12, a);
    }
}
