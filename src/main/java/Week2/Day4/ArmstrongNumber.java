package Week2.Day4;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumber {


    static ArrayList<Integer> ArmstrongNoRange(int Num) {


        ArrayList<Integer> arrli
                = new ArrayList<Integer>();

        for (int i = 1; i <= Num; i++) {
            int sum = 0;
            int original = i;
            while (original != 0) {
                int remender = original % 10;
                sum = sum + remender * remender * remender;
                original = original / 10;
            }
            if (sum == i) {
                arrli.add(i);
            }


        }
        return arrli;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int Num = scan.nextInt();

        ArrayList<Integer> result = new ArrayList<Integer>();

        result = ArmstrongNoRange(Num);

        // Printing elements one by one
        for (Integer integer : result) System.out.println(integer);
    }
}
