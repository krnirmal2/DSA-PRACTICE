package Programming_constructs.Arrays_carray_forward;

public class LeastAverageSubarrayOfSizeB {
//        private int findMinAvgSubarray(int arr[], int n, int k)
//        {
//
//            // Initialize  beginning index of result
//            int res_index = 0;
//
//            // Compute sum of first subarray of size k
//            int curr_sum = 0;
//            for (int i = 0; i < k; i++)
//                curr_sum += arr[i];
//
//            // Initialize minimum sum as current sum
//            int min_sum = curr_sum;
//
//            // Traverse from (k+1)'th element to n'th element
//            for (int i = k; i < n; i++) {
//                // Add current item and remove first item of
//                // previous subarray
//                curr_sum += arr[i] - arr[i - k];
//
//                // Update result if needed
//                if (curr_sum < min_sum) {
//                    min_sum = curr_sum;
//                    res_index = (i - k + 1);
//                }
//            }
//            return res_index;
//        }


    public class Solution {
        public static int findMinAvgSubarray(int[] A, int B) {
            int i = 0, j = 0;
            int sum = 0;
            int leastavergae = Integer.MAX_VALUE;
            int temp = -1;
            // 3,7,90,20,10,50,40
            while (j < A.length) {
                sum = sum + A[j];
                if (j - i + 1 < B) {
                    j++;
                } else if (j - i + 1 == B) {
                    // float average = sum/B;
                    // // leastavergae = Math.min(leastavergae, average);
                    // if(leastavergae>=average){
                    //     leastavergae= average;
                    //     if(temp<i)
                    //     {
                    //         temp =j-B+1;
                    //         }
                    // }
                    if (sum < leastavergae) {
                        leastavergae = sum;
                        if (temp < i) {
                            temp = i;
                        }
                    }
                    sum = sum - A[i];

                    i++;
                    j++;
                }
            }
            return temp;
        }


        public static void main(String[] args) {

            int[] arr = {3, 7, 90, 20, 10, 50, 40};
            int B = 3;
//            for (int i = 0; i < n; i++) arr[i] = A[i];
            System.out.println(findMinAvgSubarray(arr, B));

        }
    }
}

