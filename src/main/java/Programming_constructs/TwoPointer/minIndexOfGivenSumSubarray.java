//package Programming_constructs.TwoPointer;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class minIndexOfGivenSumSubarray {
//        public static int[] solve(ArrayList<Integer> A, int B) {
////
////            // using two pointer
////            int sizeOfArray = A.size();
////            int i =0 ;
////            int j =0;
////            int windowSize =-1;
////            ArrayList<Integer> result = new ArrayList<>();
////
////            // as  we know that only min index required then we only break when we got the sum
////            int subArraySum =0;
////            while(j<sizeOfArray-1){
////
////                subArraySum += A.get(j);
////                if(subArraySum <B){
////                    j++;
////                }
////
////                 if(subArraySum == B){
////                    windowSize = j-i+1;
////                    result.add(i);
////                    result.add(j);
////
////                    break;
////                }
////                if(subArraySum>B){
////                    while(subArraySum > B){
////                    subArraySum -=A.get(i);
////                        i++;
////                    }
////                        i++;
////                    j=i;
////                    subArraySum =0;
////
////                }
////            }
////            if(result.size() == 0) result.add(-1);
////
////            return result;
//
//                public int[] solve(int[] A, int B) {
//                    int start = 0, end = 0;
//                    int sum = A[0];
//                    while (end < A.length) {
//                        if (sum == B) {
//                            return Arrays.copyOfRange(A, start, end+1);
//                        } else if (sum < B) {
//                            end++;
//                            if (end < A.length) {
//                                sum += A[end];
//                            }
//                        } else {
//                            sum -= A[start];
//                            start++;
//                        }
//                    }
//                    return new int[]{-1};
//                }
//            }
//
//    public static void main(String[] args) {
//        solve(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 5);
//    }
//    }
//public class Solution {
//    public int[] solve(int[] A, int B) {
//        long n = A.length;
//        int l = 0, r = 0;
//        long sum = A[l];
//        while (r < n) {
//            if (sum == B) {
//                // current window sum = B
//                int[] ans = new int[r - l + 1];
//                for (int i = l; i <= r; i++) ans[i - l] = A[i];
//                return ans;
//            } else if (sum < B) {
//                // current window sum < B
//                r++;
//                if (r < n) sum += A[r];
//            } else {
//                // current window sum > B
//                sum -= A[l];
//                l++;
//                if (l > r && l < n - 1) {
//                    r++;
//                    sum += A[r];
//                }
//            }
//        }
//        int ans[] = new int[1];
//        ans[0] = -1;
//        return ans;
//    }
//}