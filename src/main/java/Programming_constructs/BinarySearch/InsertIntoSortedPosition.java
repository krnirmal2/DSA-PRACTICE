package Programming_constructs.BinarySearch;//package Programming_constructs.BinarySearch;
//
//public class InsertIntoSortedPosition {
//
//    public static void main(String[] args) {
//        int[] A = {1,2,3,5,6,7,9};
//        int left = 0;
//        int right = A.length-1;
//
//        System.out.println(solve(A,left,right,4));
//    }
//
//    private static int solve(int[] A, int left, int right,int B) {
//
//        int mid = (left +right )/2;
//        int result =0;
//
//        // base case
//        if(A[mid] == B) return   mid;
//        if(A[mid] > B) return result=  mid -1;
//        if(A[mid] < B) return  result=  mid +1;
//
//
//        if(A[mid] < B) solve(A,mid+1,right,B);
//        if(A[mid] > B) solve(A,left,mid-1,B);
//
//
//        return result;
//
//
//    }
//}

public class InsertIntoSortedPosition {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 6, 7, 9};
        int left = 0;
        int right = A.length - 1;

        System.out.println(solve(A, left, right, 4));
    }

    private static int solve(int[] A, int left, int right, int B) {

        int mid = (left + right) / 2;
        int result = 0;

        // base case
        if (A[mid] == B) return mid;
        if (A[mid] > B) return result = mid - 1;
        if (A[mid] < B) return result = mid + 1;


        if (A[mid] < B) solve(A, mid + 1, right, B);
        if (A[mid] > B) solve(A, left, mid - 1, B);


        return result;


    }
}
