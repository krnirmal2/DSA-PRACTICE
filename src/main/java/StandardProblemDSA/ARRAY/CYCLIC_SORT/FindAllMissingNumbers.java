package StandardProblemDSA.ARRAY.CYCLIC_SORT;


import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {
    public static List<Integer> findMissingNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // The correct index for nums[i]
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++; // Move to the next element
            }
        }

        // Find missing numbers
        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Missing numbers = [5, 6]
        System.out.println("Missing Numbers: " + findMissingNumbers(nums));
        // Output: [5, 6]
    }
}
