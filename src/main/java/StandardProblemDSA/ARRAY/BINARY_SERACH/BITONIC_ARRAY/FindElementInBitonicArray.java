package StandardProblemDSA.ARRAY.BINARY_SERACH.BITONIC_ARRAY;

public class FindElementInBitonicArray {
    /*
    Algorithm
Find the Peak (Bitonic Point) using Binary Search.

The peak is where arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1].
If arr[mid] < arr[mid + 1], the peak is in the right half.
If arr[mid] > arr[mid + 1], the peak is in the left half.
Binary Search in the Increasing Half (Left of Peak).

If the element is found, return its index.
Binary Search in the Decreasing Half (Right of Peak).

If the element is found, return its index.*/
    private static int searchBitonic(int[] bitonicArr, int target) {
        //step1 : find the peack element and return its index
        int peakIndex = peakElement(bitonicArr);
        //step2 now from 0 to peakIndex will be left part Ascending sort array
        int leftPart = findElementLeftArray(0, peakIndex,bitonicArr, target);
        if(leftPart != -1)return leftPart;
        // step3 now from peakElement to high
       return findElementRightArray(peakIndex, bitonicArr.length-1, bitonicArr,target);

    }

    private static int findElementLeftArray(int low, int high, int[] bitonicArr,int target) {
        // use binary search on the left part of the peak element
        int mid ;
        while(low<high){
            mid = low + (high - low)/2;
            if(bitonicArr[mid] == target) return mid;

            if(bitonicArr[mid]> target){
                // element will be find in the left side
                high = mid-1;
            }else {
//                elment will be found in right side
                low = mid+1;
            }

        }
        return  -1;
    }
    private static int findElementRightArray(int low, int high, int[] bitonicArr,int target) {
        // use binary search on the right part of the peak element from Descending array
        int mid ;
        while(low<high){
            mid = low + (high - low)/2;
            if(bitonicArr[mid] == target) return mid;

            if(bitonicArr[mid]> target){
                // element will be find in the right  side
                low = mid+1;
            }else {
//                elment will be found in right side
                high = mid-1;
            }

        }
        return  -1;
    }
    private static int peakElement(int[] bitonicArr) {
        // peak element whose left and right have less element
        int low = 0;
        int high = bitonicArr.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if(bitonicArr[mid]> bitonicArr[mid+1]){
                // means peak element will be find in the left part
                high = mid;
            }
            else{
                // the element present in right sid
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bitonicArr = {1, 3, 8, 12, 14, 11, 5, 2};
        int target = 5;
        int result = searchBitonic(bitonicArr, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }

/*Time Complexity
Finding Peak → O(log n)
Binary Search in Left Half → O(log n)
Binary Search in Right Half → O(log n) 👉 Total: O(log n) + O(log n) + O(log n) = O(log n)*/
}
