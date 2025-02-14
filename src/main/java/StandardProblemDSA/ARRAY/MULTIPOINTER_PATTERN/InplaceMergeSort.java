package StandardProblemDSA.ARRAY.MULTIPOINTER_PATTERN;

public class InplaceMergeSort {
    /*Algorithm

Use three pointers:

i for the last valid element in nums1.

j for the last element in nums2.

k for the last position in nums1.

Compare elements from the end of both arrays and place the larger one at position k.

Decrement the respective pointers.

Copy any remaining elements from nums2 to nums1.

*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2, if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        System.out.println("Merged array: " + java.util.Arrays.toString(nums1));
    }
}
