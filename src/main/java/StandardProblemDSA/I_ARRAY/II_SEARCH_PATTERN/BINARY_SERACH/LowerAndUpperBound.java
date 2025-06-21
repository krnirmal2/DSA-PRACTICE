package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH;

public class LowerAndUpperBound {
    public static int lowerBound(int[] A, int B) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < B) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // Can be A.length if B is greater than all elements
    }
    public static int upperBound(int[] A, int B) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] <= B) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // Can be A.length if no element is greater than B
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 4, 5, 6, 8};

        System.out.println("Lower Bound of 4: " + lowerBound(A, 4)); // 2
        System.out.println("Upper Bound of 4: " + upperBound(A, 4)); // 4
        System.out.println("Lower Bound of 7: " + lowerBound(A, 7)); // 6
        System.out.println("Upper Bound of 7: " + upperBound(A, 7)); // 6
        System.out.println("Lower Bound of 9: " + lowerBound(A, 9)); // 7 (not found, next index)
        System.out.println("Upper Bound of 9: " + upperBound(A, 9)); // 7 (not found, next index)
    }

}
