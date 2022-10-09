package Week2.Day4;

public class CountFactorOfNumber {
    static int CountFactorNumber1(){
        int count =0;
        for(int i = 1; i<= 10; i++)
        {
            if(10 % i == 0){
                count++;
            }
        }
        return  count;
    }


    // optimise the code by considering the i and (number % i )
    // and we considering both them as factor
    static int CountFactorNumber2(){
        int count =0;

        for(int i = 1; i*i<= 10; i++)
        {

            if(10 % i == 0){
                if(i== 10 %i )
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
        System.out.println(CountFactorNumber1());
        System.out.println(CountFactorNumber2());

    }
}

