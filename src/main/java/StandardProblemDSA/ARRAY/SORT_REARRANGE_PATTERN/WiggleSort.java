package StandardProblemDSA.ARRAY.SORT_REARRANGE_PATTERN;

public class WiggleSort {
    /*Explanation

In Wiggle Sort, the goal is to rearrange the array such that it follows a peak-valley pattern. Specifically, for an array nums, the arrangement should satisfy:

nums[0] <= nums[1] >= nums[2] <= nums[3] ...

This means elements at odd indices are greater than their neighbors, while elements at even indices are smaller.

Algorithm

Traverse the array and compare adjacent elements.

If the current index i is even, ensure nums[i] <= nums[i+1].

If i is odd, ensure nums[i] >= nums[i+1].

Swap elements if the above conditions are not met.*/
    public static void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                // Swap nums[i] and nums[i+1]
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println("Wiggle sorted array: " + java.util.Arrays.toString(nums));
    }
}
