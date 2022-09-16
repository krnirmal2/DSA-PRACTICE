package AdvancedDSA.Arrays.one.TwoDArrays;

public class SearchSortedMatrix {

    public static int solve(int[][] A, int B) {

        int i=0, j = A[0].length -1;
        int index=-1;
        int mid = A[i][j];
        // iterate over the loop
        while(i<A.length && j>=0){
            if(A[i][j] == B){
//                index = (i+1)*1009 + (j+1);
                index=Math.min(index,(i+1)*1009+j+1);
                j--;
                break;
            }
            if(B <A[i][j]){
                j--;
            }
            else
                i++;
        }

        return index;
    }

    public static void main(String[] args) {

        int[][] A = {
                {1, 2, 3},
                {4, 6, 7},
                {10,15 ,20},


        };
        System.out.println(solve(A,2) );
    }


}
//public class Solution {
//    public int solve(int[][] A, int B) {
//
//        int i =0,j=A[0].length-1;
//        int ans=Integer.MAX_VALUE;
//        while(i<A.length && j>=0)
//        {
//            if(A[i][j]==B)
//            {
//                ans=Math.min(ans,(i+1)*1009+j+1);
//                j--;
//            }
//            else if(B>A[i][j])
//                i++;
//            else
//                j--;
//        }
//
//        if(ans ==Integer.MAX_VALUE)
//            return -1;
//        return ans;
//    }
//}