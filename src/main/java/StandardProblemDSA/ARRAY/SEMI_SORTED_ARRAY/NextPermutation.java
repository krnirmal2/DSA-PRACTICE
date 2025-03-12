package StandardProblemDSA.ARRAY.SEMI_SORTED_ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class NextPermutation {
    /*next_permutation : find next lexicographically greater permutation
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).*/

// find the next permutation based on lexicographical order for integer here
    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
        int n = A.size();
        List<Integer> result = new ArrayList<Integer>();
        int breakInd = -1;
        // if we need to use two utility method reverse and swap method
//        step1 : Need to find out the index from the backend where the breaking is happedn
        for(int ind = n-2 ; ind>= 0 ; ind--){
            if(A.get(ind)<A.get(ind+1)){
                breakInd = ind;
                // now break the loop
                break;
            }
        }
        // if we don't find any break index than we are sure that this array already sorted with decrement order
        if (breakInd == -1) {
            reverse(A, 0, n - 1);
            return A;
        }
        // step 2 : we have to find the element from the back of the array which is just greate than
        // braek index value
        for(int ind = n-1 ; ind>= 0 ; ind--){
            if(A.get(breakInd)<A.get(ind)){
//                 if we got just swap breakInd and currIndex
                swap( A,breakInd,ind);
                break;
            }
        }
        // step 3. now we have to check the right subarray element should be just greateer than current element
        // so we will reverse that array
        reverse(A, breakInd + 1, n - 1);
        return A;

    }
    private static void reverse(List<Integer> A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
    public static void main(String args[]) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }



}
