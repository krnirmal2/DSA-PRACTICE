package Week3;

import java.util.Scanner;

public class TC2_class {
    // write program for table of a no.
    public static void main(String[] args) {

        Scanner scanner =new  Scanner(System.in);
        int a = scanner.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(String.format("%s * %s = %s",a,i,a*i));
        }


    }


}
