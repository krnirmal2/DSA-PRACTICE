package Programming_constructs.Introduction_to_array;

import java.lang.*;
import java.util.*;
public class ArrayRotatedByKTimes {

    public static int[] solve(int A[], int B) {
        // first k element reverse
        // last n-k element and reverse
        // the full array  reverse
        int n = A.length;
        int temp;
        for (int i = n - B, j = n - 1; i < j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
        for (int i = 0, j = n - B - 1; i < j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
        return A;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int A[] = new int[input];
        int i = 0;
        while (i < input) {
            int ele = sc.nextInt();
            A[i] = ele;
            i++;
        }
        int B = sc.nextInt();
        B = B % input;
        solve(A, B);
        for (int j = 0; j < input; j++) {
            System.out.print(A[j]);
        }
    }
}



//public class Main {
//    public static void reverse(int[] A, int start, int end) {
//        int i, j;
//        for (i = start, j = end; i < j; i++, j--) {
//            int temp = A[i];
//            A[i] = A[j];
//            A[j] = temp;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = sc.nextInt();
//        }
//        int B = sc.nextInt() % n;
//        reverse(A, 0, n - 1);
//        reverse(A, 0, B - 1);
//        reverse(A, B, n - 1);
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(A[i] + " ");
//        }
//        System.out.println("");
//
//    }
//}
