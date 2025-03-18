package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

public class PrintBinaryOfaNumber {
    public static void printBinaryReprsentation(int n, int[] result) {
        /// our approach just
        // append 0 and 1 for the array first
        int intialValue = 0;
        utility(n, result, intialValue);
    }

    // Function to print the output
    static void printTheArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void utility(int n, int[] result, int i) {
        // base case if i is equal to n means we generate n length binary
        // value , so we will either store it in linkedlist or
        // print it
        if (i == n) {
            printTheArray(result, n);
            return;
        }
        // case 1 : we generate first with 0
        result[i] = 0;
        utility(n, result, i + 1);

        // case 2 : we generate the second with start from 1
        result[i] = 1;
        utility(n, result, i + 1);
    }

    public static void main(String[] args) {
        int n;
        n = 4;
        int[] result = new int[n];
        printBinaryReprsentation(n, result);

    }
}
