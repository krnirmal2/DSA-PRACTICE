package StandardProblemDSA.ARRAY.CYCLIC_SORT;

public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) { // Ignore numbers at correct index
                int correctIndex = nums[i] - 1;
                if (nums[i] == nums[correctIndex]) {
                    return nums[i]; // Duplicate found
                }
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        return -1; // Should never reach here
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2}; // Duplicate number is 3
        System.out.println("Duplicate Number: " + findDuplicate(nums));
        // Output: 3
    }
}
