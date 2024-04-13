package Programming_constructs.BitManupulation;

public class LongestConsecutiveOnesWithSwapping {
    /*public static int solve(String A) {
        int n = A.length();
        int ans = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                c++;
            }
        }
        if (c == n){
            return n;
        }
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                int l = 0;
                int r = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1') {
                        l = l + 1;
                    } else {
                        break;
                    }
                }
                for (int j = i + 1; j < n; j++) {
                    if (A.charAt(j) == '1') {
                        r = r + 1;
                    } else {
                        break;
                    }
                }
                int count = 0;
                if (c > l + r) {
                    count = l + r + 1;
                } else {
                    count = l + r;
                }
                if (count > ans) {
                    ans = count;
                }
            }
        }
        return ans;

    }*/
    public static int solve(String A) {
        int n = A.length();
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = (A.charAt(0) == '1') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '0') {
                left[i] = 0;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }


        right[n - 1] = (A.charAt(n - 1) == '1') ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '0') {
                right[i] = 0;

            } else {
                right[i] = right[i + 1] + 1;
            }
        }

        // without replacement length of longest consecutive
        int count = 0, ans = 0, noOfOnes = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') count = 0;
            else {
                noOfOnes++;
                count++;
                ans = Math.max(ans, count);

            }

        }


        // now the count fo consecutive ones with replacement of 0 and 1

        for (int i = 0; i < n; i++) {
            int l = (i == 0) ? 0 : left[i - 1];
            int r = (i == n - 1) ? 0 : right[i + 1];
            if (A.charAt(i) == '0') {
                if (l + r == noOfOnes) {
                    ans = Math.max(ans, l + r);
                } else {
                    ans = Math.max(ans, l + r + 1);

                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String Binary = "11010110000000000";
        System.out.println(solve(Binary));
    }
}
