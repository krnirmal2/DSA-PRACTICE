package StandardProblemDSA.ARRAY.BINARY_SERACH.BITONIC_ARRAY;


public class FirstLastOccurrenceBitonic  {

    private static int searchBitonic(int[] bitonicArr, int target) {
        int peakIndex = peakElement(bitonicArr);

        // Find first occurrence in the left increasing part
        int firstOccurrence = findFirstOccurrence(0, peakIndex, bitonicArr, target);

        // Find last occurrence in the right decreasing part
        int lastOccurrence = findLastOccurrence(peakIndex, bitonicArr.length - 1, bitonicArr, target);

        // If the target exists in both halves, return first and last occurrence
        if (firstOccurrence != -1 && lastOccurrence != -1)
            return firstOccurrence + lastOccurrence;

        // If found only in one half, return that index
        return (firstOccurrence != -1) ? firstOccurrence : lastOccurrence;
    }

    private static int findFirstOccurrence(int low, int high, int[] bitonicArr, int target) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bitonicArr[mid] == target) {
                result = mid;  // Store the index
                high = mid - 1; // Move left to find first occurrence
            } else if (bitonicArr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(int low, int high, int[] bitonicArr, int target) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bitonicArr[mid] == target) {
                result = mid;  // Store the index
                low = mid + 1; // Move right to find last occurrence
            } else if (bitonicArr[mid] > target) {
                low = mid + 1; // Move right as it's a descending array
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int peakElement(int[] bitonicArr) {
        int low = 0, high = bitonicArr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (bitonicArr[mid] > bitonicArr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bitonicArr = {1, 3, 8, 12, 14, 11, 5, 5, 2};
        int target = 5;
        int result = searchBitonic(bitonicArr, target);

        if (result != -1)
            System.out.println("First and Last occurrence indices: " + result);
        else
            System.out.println("Element not found");
    }
}

