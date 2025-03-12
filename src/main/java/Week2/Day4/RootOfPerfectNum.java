package Week2.Day4;

import java.util.Scanner;

public class RootOfPerfectNum {
    public static int solve(int n) {
        // double d = Math.log(A);// because we divide the no each time by half
//        int logBase2 = (int) (Math.log(n) / Math.log(2)); // change base formula in log
        int result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i == n) {
                result = i;
            } else {
                result = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println(solve(num));
    }


}
