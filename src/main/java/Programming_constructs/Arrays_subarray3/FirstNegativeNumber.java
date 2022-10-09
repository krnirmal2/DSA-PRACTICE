//package Programming_constructs.Arrays_subarray3;
//
//import java.util.ArrayList;
//
//public class FirstNegativeNumber {
//
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(findNegativeNumber(arr,3));
//    }
//
//    private static ArrayList<Integer> findNegativeNumber(int[] arr, int windowSize) {
//
//        ArrayList<Integer> result = new ArrayList<>();
//
//        int i =0, j=0;
//        int n = arr.length;
//        while( j<n){
//            if(arr[j]<0){
//                result.add(arr[j]);
//
//            }
//            if(j-i+1 < windowSize){
//                j++;
//            } else if (j-i+1 == windowSize) {
//
//
//            }
//        }
//
//
//    }
//
//
//}
