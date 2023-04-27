package AdvancedDSA.Arrays.one.Array.SubArray;

import java.util.ArrayList;
import java.util.List;

public class AlternativeSubarray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int c) {
        int B= 2*c+1;

        int i=0, k=0, j=0;
        int sizeA= A.size();
        ArrayList<Integer> result = new ArrayList<>();

        while(j<sizeA){
            k=i;
            if(j-i+1 <B){
                j++;
            }
            else if(j-i+1 == B){
                while(k<j){
                    if(A.get(k) != A.get(j) ||A.get(k) == A.get(k+1) ) {
                        break;
                    }
                        k++;
                        j--;
                        if(k==j){
                            result.add(k);
                        }
                }
                i++;
                j=i;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of( 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1)),1).size());
    }
}


// public class Solution {
//    public int[] solve(int[] A, int B) {
//        ArrayList < Integer > l1 = new ArrayList < > ();
//        int n = A.length;
//        int len = 2 * B + 1;
//        for (int i = 0; i < n - len + 1; i++) {
//            int curr = -1;
//            int flag = 1;
//            for (int j = i; j < i + len; j++) {
//                if (A[j] == curr) {
//                    flag = 0;
//                    break;
//                }
//                curr = A[j];
//            }
//            if (flag == 1) {
//                l1.add(i + B);
//            }
//        }
//        int[] ret = new int[l1.size()];
//        for (int i = 0; i < l1.size(); i++) {
//            ret[i] = l1.get(i);
//        }
//        return ret;
//    }
// }
