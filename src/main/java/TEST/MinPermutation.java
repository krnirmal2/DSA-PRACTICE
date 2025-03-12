package TEST;

import java.util.Arrays;

public class MinPermutation {
    public static int solve(int[] A) {
        // Step 1 : we need to create the permution of length
        // and store them in a list
        int size = A.length;
        int [] permutation = new int[size] ;

        // permutation
        for(int i= size;i>0;i--){
            permutation[size-i]=i;
        }

        //now sort the array
        Arrays.sort(A);
        reverse(A);
        // now compare each of the element from both of the array
        // and find the differrence between them
        int min= 0;
        for(int i=0;i<size;i++){
            min += permutation[i] - (A[i]);
        }
        return min;
    }
    public static void reverse(int[] a)
    {
        // length of an array
        int n = a.length;

        // swap the first half with the second half
        for (int i = 0; i < n / 2; i++) {

            // Store the first half elements temporarily
            int t = a[i];

            // Assign the first half
            // to the last half
            a[i] = a[n - i - 1];

            // Assign the last half
            // to the first half
            a[n - i - 1] = t;
        }
    }
    public static void main(String[] args) {
        int[] A = {-1,-1,2};
        System.out.printf("thhe min no " + solve(A));
    }
}
