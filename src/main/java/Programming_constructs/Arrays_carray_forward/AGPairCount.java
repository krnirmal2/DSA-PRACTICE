package Programming_constructs.Arrays_carray_forward;


public class AGPairCount {
    public static int solve(String A) {
        int sizeS = A.length();
        int count = 0, result = 0;
        int[] psg = new int[sizeS];
        int modulo = (int) Math.pow(10, 9) + 7;
        for (int i = 1; i < sizeS; i++) {
            if (A.charAt(i) == 'G')
                psg[i] = psg[i - 1] + 1;
            else
                psg[i] = psg[i - 1];
        }
        for (int j = 0; j < sizeS; j++) {
            if (A.charAt(j) == 'A') {
                count = psg[sizeS - 1] - psg[j];
                result = (result + count) % modulo;
            }
        }

        return (result);
    }

    public static void main(String[] args) {
        String A = "ABCGAG";
        System.out.println(solve(A));
    }
}


/*
public class Solution {
    public int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        //Suffix count of G
        for(int i = n-1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }
        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }
}*/
