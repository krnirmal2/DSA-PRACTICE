package Week2.Day4;

public class CountFactorOfNumber {
    static int CountFactorNumber1(int number){
        int count =0;
        for(int i =1;i<=number;i++)
        {
            if(number % i == 0){
                count++;
            }
        }
        return  count;
    }


    // optimise the code by considering the i and (number % i )
    // and we considering both them as factor
    static int CountFactorNumber2(int number){
        int count =0;

        for(int i =1;i*i<=number;i++)
        {

            if(number % i == 0){
                if(i==number%i )
                { // if the i and number%i is same then count only one ohter wise count both i and number%i
                    count = count+1;
                }
                else
                    count=count+2 ;
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(CountFactorNumber1(10));
        System.out.println(CountFactorNumber2(10));

    }
}

