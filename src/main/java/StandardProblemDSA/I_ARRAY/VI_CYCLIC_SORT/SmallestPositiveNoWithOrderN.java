package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

public class SmallestPositiveNoWithOrderN {
    /*Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    Example 1:

    Input: nums = [1,2,0]
    Output: 3
    Explanation: The numbers in the range [1,2] are all in the array.
    Example 2:

    Input: nums = [3,4,-1,1]
    Output: 2
    Explanation: 1 is in the array but 2 is missing.
    Example 3:

    Input: nums = [7,8,9,11,12]
    Output: 1
    Explanation: The smallest positive integer 1 is missing.
    Constraints:
    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1*/
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
  /* **dry run** for **Example 3**:
  nums = [7, 8, 9, 11, 12]
  n = 5
  ### **Step 1: Rearrange using swapping**
  We want each number `x` in its correct position at `index x - 1`, but **only if** `1 ≤ x ≤ n`.
  * `i = 0`: `nums[0] = 7`
    * 7 > 5 → ignore.
  * `i = 1`: `nums[1] = 8`
    * 8 > 5 → ignore.
  * `i = 2`: `nums[2] = 9`
    * 9 > 5 → ignore.
  * `i = 3`: `nums[3] = 11`
    * 11 > 5 → ignore.
  * `i = 4`: `nums[4] = 12`
    * 12 > 5 → ignore.

  **Array stays the same:**
  [7, 8, 9, 11, 12]
  ### **Step 2: Find first index where `nums[i] != i + 1`**
  * `i = 0`: `nums[0] = 7`, expected `1` → mismatch!
    **Answer = 1**
  ### **Why?**

  * We were looking for the smallest positive integer.
  * `1` is not in the array, so that’s the answer.
  * Since all elements are greater than `n`, the smallest missing positive is always `1`.

  */
}
