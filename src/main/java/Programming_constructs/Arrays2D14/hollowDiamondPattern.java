package Programming_constructs.Arrays2D14;

import java.util.Scanner;

public class hollowDiamondPattern {
// add this command in demo branch for merging

    public static void main(String[] args) {
        // take custom input
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
//logic to print the first half pattern
        for (int i = 1; i <=input; i++) {
            for (int j = 1; j <=input - i + 1; j++) {
                System.out.print("*");
            }
//loop calculates space
            for (int k = 1; k <= 2 * i - 2; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= input - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//logic to print the second half pattern
        for (int i = input-1; i >= 1; i--) {
            for (int j = i; j <= input; j++) {
                System.out.print("*");
            }
//loop calculates space
            for (int k = 1; k <= (2 * i) - 2; k++) {
                System.out.print(" ");
            }
            for (int j = i; j <= input; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
