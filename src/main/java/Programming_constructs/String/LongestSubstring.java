// package Programming_constructs.String;
//
// import java.util.*;
// public class LongestSubstring {
//        public static String longestPalindrome(String A) {
//             int longestPalindrome =Integer.MIN_VALUE;
//             // for odd length String
//             int substringLengthCount  ;
// //            char result [] = new char[A.length()];
//            int current_length;
//            int start;
//            String result ="";
//             for(int i=0;i<A.length(); i++){
//                 substringLengthCount =1;
//                 int j = i+1;
//                 int k =i-1;
//                 while(k>0 && j<A.length()){
//                     if(A.charAt(j)== A.charAt(k)){
//                         substringLengthCount +=2;
// //                        result[k]= A.charAt(k);
// //                        result[i] = A.charAt(i);
// //                        result[j] = A.charAt(j);
//                         current_length= k+l;
//
//                     }
//                     else{
//                         break;
//                     }
//                     j++;
//                     k--;
//
//                 }
//
// //                current_length= k+l;
//                 if(longestPalindrome< current_length){
//                     longestPalindrome = current_length;
//                     start = k;
//
//                 }
//                 result = A.substring(k,longestPalindrome);
//
// //                longestPalindrome = Math.max(longestPalindrome, substringLengthCount);
//             }
//
// //
// //            // now even length string where the substringLengthCount may be initial value is 0
//             for(int i=0;i<A.length(); i++){
//                 substringLengthCount =0;
//                 int j = i+1;
//                 int k =i;
//                 while(k>0 && j<A.length()){
//                     if(A.charAt(j)== A.charAt(k)){
//                         substringLengthCount +=2;
//
//                     }
//                     else{
//                         break;
//                     }
//                     j++;
//                     k--;
//                 }
//             }
// //           int start;
//            int current_length = k+l;
//            if(longestPalindrome<current_length){
//                longestPalindrome = current_length;
//                start = k;
//
//            }
//            result = A.substring(k,longestPalindrome);
//
// //                longestPalindrome = Math.max(longestPalindrome, substringLengthCount);
//        }
//
//
//            return A;
//        }
//
//     public static void main(String[] args) {
//         String A = "aaaabaaa";
//         longestPalindrome(A);
//
//     }
//
// }
