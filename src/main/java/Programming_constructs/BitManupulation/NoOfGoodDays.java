package Programming_constructs.BitManupulation;

public class NoOfGoodDays {

    public static void main(String[] args) {
        int a = 99;
        System.out.println(solve(a));
    }

    private static int  solve(int A) {
                // no  of one in the no.
                int i =0, count=0;
                //     while (A!=0){
                //         if(((A>>i)&1) != 0){
                //             count++;
                //         }
                //         i++;
                //     }
                //     return count ;
                // }
                if(A==0){
                    return 0;
                }
                else{
                    while (i<32){
                        if((A&(1<<i)) !=0 ){
                            count++;
                        }
                        i++;
                    }
                    return count ;
                }
            }
        }
