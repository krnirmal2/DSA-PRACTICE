package StandardProblemDSA.ARRAY.CYCLIC_SORT;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] ; // Correct index for nums[i]
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                // Swap nums[i] with the number at its correct position
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++; // Move to the next element
            }
        }
// Check for the missing number
    for (i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
            return i;
        }
    }
    return nums.length;
}
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(findMissingNumber(nums)); // Output: 2
    }

}
