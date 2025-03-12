package StandardProblemDSA.ARRAY.BINARY_SERACH.ROTETED_ARRAY;

public class FindRotationCount {
    public static int findMin(int [] a){

        // we can find theis using order of n but use binary serch
        int high = a.length -1;
        int low = 0;
        int mid ;
        // iterate over the array
        // approach '
        // 1. if a[mid] <= a[high] means from mid to high the array is already sorted
        // 2. if a[mid]> a[high] means from low to mid array is sorted
        // so if both side is sorted means it is rotated sorted array and
        // and we will came to add the end where low and mid and high will be point same pinoint
        // and low pointer will give the lowest element
        while(low<high){
            // The current subarray is already sorted,
            // the minimum is at the low index
            if(a[low]<a[high]){
                return low;
            }
            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
            mid = low + (high-low)/2;
            // if mid element is greateer than next means mid+1 is the smallest so we just return that element
            // index
            if(mid<high && a[mid] >a[mid+1]) return mid+1;
            //IF mid element is smaller tthan previous element than mid is the smallest
            if (mid> low && a[mid] <a[mid -1]) return mid;


            // The right half is not sorted.search in right half So
            // the minimum element must be in the
            // right hal
            if(a[mid] > a[high]){
                low = mid +1;
            }// The right half is sorted. Note that in
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else{
                high =mid-1;
            }

        }
        // return at the low
        return low;


    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}
