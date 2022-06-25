package AssignmentWeek2.Day4;
import java.lang.*;
import java.util.*;

public class PerfectNo {
        public static void PerfectNumber(int Num){
            int sum =1;
            for(int i=1 ;i*i<Num;i++){
                if(Num % i ==0) {
                    if (Num % i == i) {
                        sum = sum +i+(Num%i);
                    }
                    else{
                        sum = sum + i;
                    }

                }

            }
            if(sum == Num){
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





