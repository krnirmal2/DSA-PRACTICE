package StandardProblemDSA.VII_BACKTRACKING;
import java.util.*;
public class AllSubSet {
   /* 🧠 Concept Recap:
    This is generating subsets of all sizes: from 0 to nums.length.
    For each size r, we use the combination logic (with backtracking).
    Output is a list of all subsets (i.e., Power Set).
            ⏱️ Time & Space Complexity:
    Time: O(2^n) subsets generated (as each element is either included or excluded).
    Space: O(2^n * n) to store all subsets (each subset can be up to length n).
    ✅ Space Breakdown:
1. Result storage (List<List<Integer>> result)
Stores 2^n subsets.
Each subset (in the worst case) can take up to O(n) space.
So total space:
🔸 O(2^n * n)
2. Recursive call stack (temporary memory while recursion runs)
Depth of recursion: at most n (since we add one element at a time).
Each frame uses some space for local variables (like temp list, loop vars).
So auxiliary space:
🔸 O(n) (due to recursion stack and temp list)
    */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};  // You can modify this array
        List<List<Integer>> result = subsets(nums);

        // Print all subsets
        System.out.println("Power Set:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    // Main function to generate all subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Optional: to get subsets in lexicographical order

        // Generate all length of subset from 0 to n-1 that is why use for loop
        for (int r = 0; r <= nums.length; r++) {
            backtrack(result, new ArrayList<>(), nums, r, 0);
        }

        return result;
    }

    // Backtracking function to generate combinations of size 'r'
    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int r, int start) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp)); // Add a copy of the current subset
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);                         // Choose the current element
            backtrack(result, temp, nums, r, i + 1);    // Explore further
            temp.remove(temp.size() - 1);               // Backtrack
        }
    }
}
