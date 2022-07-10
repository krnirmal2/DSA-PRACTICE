package Introduction_to_Arrays.Arrays_subarray3.AssignmentWeek2.Day4;
import java.lang.*;
import java.util.*;
import java.lang.Math;
public class IsPrimeNo {
    public static void PrimeNo(int A) {
        int flag = 0;
        if (A == 1) {
            System.out.println("No");
            return;
        }

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                flag = 1;
                break;
            }

        }
        if (flag == 1) {
            System.out.println("NO");

        } else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner myObj = new Scanner(System.in);
        int A = myObj.nextInt();
        PrimeNo(A);

    }
    }
