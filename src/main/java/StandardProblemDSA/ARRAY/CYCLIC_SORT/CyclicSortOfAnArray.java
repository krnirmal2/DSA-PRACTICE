package StandardProblemDSA.ARRAY.CYCLIC_SORT;

import java.util.Arrays;

public class CyclicSortOfAnArray {
    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // Correct index for nums[i]
            if (nums[i] != nums[correctIndex]) {
                // Swap nums[i] with the number at its correct position
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++; // Move to the next element
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4, 5]
    }


}
