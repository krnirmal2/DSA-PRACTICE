package StandardProblemDSA.ARRAY.BINARY_SERACH.ROTETED_ARRAY;

public class FindInRotatedArrayWithoutDuplication {
    public static int search(int []a , int target){

        int high = a.length;
        int low = 0;
        int mid ;
        while(low< high){
            // serach in left and right sorted array
            mid = low + (high -low)/2;
            // if the element is found in the mid return  the mid
            if(a[mid] == target){
                return mid;
            }
            // else if don't find
            if(a[low] <a[mid]){
                //serach in the left sorted array
                if(a[low]< target && target<a[mid]){
                    high = mid-1;// reduce search space ; // Target is in the left half
                }
                else{
                    // we are not found that in this subarray then serach in the next sorted
                    low = mid+1;  // Target is in the right half
                }
            }
            else{
                //search in the right srted array
                if(a[mid]<target && target<a[high]){
                    low = mid +1;  // Target is in the right half
                }
                else{// if the element not in the above range than we will shift the search to next subarray

                    high = mid-1;// Target is in the left half
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Rotated at index 4
        int target = 0;
        System.out.println("Index of target: " + search(arr, target)); // Output: 4
    }
}
