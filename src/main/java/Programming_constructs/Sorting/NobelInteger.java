package Programming_constructs.Sorting;

import java.util.Arrays;

public class NobelInteger {
        public static int solve(int[] A) {
            Arrays.sort(A);
            int count =0, i = 0, temp = 0, result =-1;
            int n = A.length;

            while( i+1 < n){
                if(A[i] == A[i+1]){
                    temp = i;
                    count = n-1-i;
                    if(count == A[temp])
                    {
                        result = 1;
                    }
                    else
                        i++;
                }
                else if(A[i]!=A[i+1]){
                    if(n-1-i == A[i]){
                        result = 1;
                        break;
                    }
                    else
                        i++;
                }
//                else{
//                    result =-1;
//                }
            }
            return result;
        }

    public static void main(String[] args) {
        int a[] = {1,3,1,3};
//        solve(a);
        System.out.println(solve(a));


    }
}



