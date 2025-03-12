package StandardProblemDSA.ARRAY.BINARY_SERACH.VALLY_PATTERN;

public class FindValleyInValleyArray {
    public static int findValley(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid is the valley point
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return arr[mid];
            }

            // If left side is decreasing, move left
            if (arr[mid] > arr[mid - 1]) {
                high = mid - 1;
            } else {
                // Else move right
                low = mid + 1;
            }
        }
        return arr[low]; // Final valley element
    }

    public static void main(String[] args) {
        int[] valleyArr = {9, 7, 5, 3, 1, 2, 4, 6, 8}; // Valley at 1
        System.out.println("Valley Element: " + findValley(valleyArr));
    }
}
