package AdvancedDSA.Arrays.one;

import static java.lang.Integer.MAX_VALUE;

public class SlidingWidowUsingWhileLoop {

    public static int minSubArrayLen(int[] arr, int target) {
        int minLength = MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (left < arr.length) {
            if (sum >= target) {
                // store the current minimal length
                minLength = Math.min(minLength, (right - left));
                // shrink the window:
                // (1) subtract the value at left idx
                // (2) move the left panel one index further to the right
                sum -= arr[left];
                left++;
            } else if (sum < target && right < arr.length) {
                // expand the window:
                // (1) sum up the current value
                // (2) move the right panel one index further to the right
                sum += arr[right];
                right++;
            } else {
                break;
            }
        }
        return minLength == MAX_VALUE ? 0 : minLength;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(arr, 7));

    }
}
