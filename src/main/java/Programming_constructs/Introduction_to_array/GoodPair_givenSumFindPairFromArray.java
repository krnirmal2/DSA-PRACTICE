package Programming_constructs.Introduction_to_array;

public class GoodPair_givenSumFindPairFromArray {

    public static int solve(int[] A, int B) {
        int n = A.length;

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                } else if (B - A[i] == A[j]) {
                    result = 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};

        System.out.println(solve(A, 7));
    }
}

