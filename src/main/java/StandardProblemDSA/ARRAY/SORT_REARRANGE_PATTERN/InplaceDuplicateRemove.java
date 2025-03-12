package StandardProblemDSA.ARRAY.SORT_REARRANGE_PATTERN;

public class InplaceDuplicateRemove {
    public static int removeDuplicates(int[] nums) {
        /*Approach:
Loop through each element in the array.
For each element, compare it with all previous elements.
If it has not appeared before, keep it; otherwise, remove it.*/
        if (nums.length == 0) {
            return 0; // No elements to process
        }

        int n = nums.length;
        int index = 0; // Pointer to track the position of unique elements

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            // Compare with previous elements to check for duplicates
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If no duplicate, place the element at the unique position
            if (!isDuplicate) {
                nums[index] = nums[i];
                index++;
            }
        }

        // The first `index` elements in nums are unique
        return index; // The number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
