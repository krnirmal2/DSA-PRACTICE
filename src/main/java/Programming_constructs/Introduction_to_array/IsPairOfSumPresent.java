package Programming_constructs.Introduction_to_array;

public class IsPairOfSumPresent {

    static boolean solution(int[] arr, int k) {
        int n = arr.length;
        boolean result = false;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                result = k - arr[i] == arr[j];

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, -2, 1, 4, 3, 6, 8};
        int k = 4;

        System.out.println(solution(arr, k));


    }


}
