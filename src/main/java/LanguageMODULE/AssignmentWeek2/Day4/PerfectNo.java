package LanguageMODULE.AssignmentWeek2.Day4;

import java.util.Scanner;

public class PerfectNo {
    public static void PerfectNumber(int Num) {
        int sum = 0;

        /// NEED TO OPTIMISE THIS CODE TO SQURE ROOT OF N
        for (int i = 1; i <= Num; i++) {
            if (Num % i == 0) {
                sum += i;
                if (i * i != Num) {
                    sum += Num % i;
                }
            }
        }
        if (sum - Num == Num) {
            System.out.println("YES");
        } else
            System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int A = myObj.nextInt();

        while (A != 0) {
            int inputNum = myObj.nextInt();
            PerfectNumber(inputNum);
            A--;
        }
    }

}


//10
//        81    NO
//        84    NO
//        94    NO
//        50    NO
//        39    NO
//        6     YES
//        39    NO
//        83    NO
//        8     NO
//        73    NO

//10
//        81
//        NO
//        84
//        NO
//        94
//        NO
//        50
//        NO
//        39
//        NO
//        6
//        YES
//        39
//        NO
//        83
//        NO
//        8
//        NO
//        73
//        NO
