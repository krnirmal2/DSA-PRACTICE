package Week2.Day4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumber {


    static ArrayList<Integer> ArmstrongNoRange(int Num){


        ArrayList<Integer> arrli
                = new ArrayList<Integer>();

        if (Num==1){
            arrli.add(Num);

        }
        else {
            for (int i = 2; i <= Num; i++) {
                int sum =0;
                while (i != 0) {
                    int remender = i % 10;
                    sum = sum + remender * remender * remender;
                    i = i / 10;
                }
                if (sum == i) {
                    arrli.add(i);
                }


            }
        }
        return arrli ;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int Num = scan.nextInt();

        ArrayList<Integer> result = new ArrayList<Integer>();

        result = ArmstrongNoRange(Num);

        // Printing elements one by one
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}
