package Programming_constructs.BinarySearch;

public class SquareRootBinarySearch {

    public static int squareRoot(int x) {
        if (x == 0 || x == 1) {
            return x; // Square root of 0 or 1 is itself
        }

        int low = 0, high = x, result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid*mid equals x, return mid
            if (mid <= x / mid) { // To avoid overflow, use x/mid instead of mid*mid
                result = mid; // Store potential result
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("Square root of " + x + " is: " + squareRoot(x));

        x = 16;
        System.out.println("Square root of " + x + " is: " + squareRoot(x));

        x = 50;
        System.out.println("Square root of " + x + " is: " + squareRoot(x));
    }
}

