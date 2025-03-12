package LanguageMODULE.AssignmentWeek2.Day4;

import java.util.Scanner;

public class SumOfNumber {

    static int SumOfNaturalNumber(int Num) {

        return (((Num + 1) * Num) / 2);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int A = myObj.nextInt();

        int result = SumOfNaturalNumber(A);

        System.out.println(result);
    }
}
