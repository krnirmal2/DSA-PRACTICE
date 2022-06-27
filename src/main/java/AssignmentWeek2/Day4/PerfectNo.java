package AssignmentWeek2.Day4;
import java.lang.*;
import java.util.*;

public class PerfectNo {
        public static void PerfectNumber(int Num){
            int sum =0;
            for(int i=1 ;i<=Num;i++){
                if(Num % i ==0) {
                    sum +=i;
                    if(i*i !=Num){
                        sum +=Num%i;
                    }
//                    if (Num % i == i) {
//                        sum = sum +i+(Num%i);
//                    }
//                    else{
//                        sum = sum + i;
//                    }

                }
                //my-first-vert-x-3-application

            }
            if(sum -Num == Num){
                System.out.println("YES");
            }
            else
                System.out.println("NO");

        }
        public static void main(String[] args) {
            // YOUR CODE GOES HERE
            // Please take input and print output to standard input/output (stdin/stdout)
            // DO NOT USE ARGUMENTS FOR INPUTS
            // E.g. 'Scanner' for input & 'System.out' for output
            Scanner myObj = new Scanner(System.in);
            int A = myObj.nextInt();

            while(A!=0) {
                Scanner numchek = new Scanner(System.in);
                int inputNum = numchek.nextInt();
                PerfectNumber(inputNum);
                A--;
            }
        }

    }





//10
//        81
//        84
//        94
//        50
//        39
//        6
//        39
//        83
//        8
//        73