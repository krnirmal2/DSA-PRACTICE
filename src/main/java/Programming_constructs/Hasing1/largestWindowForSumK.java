package Programming_constructs.Hasing1;

import java.util.ArrayList;

public class largestWindowForSumK {

    public  static ArrayList<Integer> solve(ArrayList<Integer> a){
        int size = a.size();
        ArrayList<Integer> result= new ArrayList<>();

        Integer start =0;
        Integer end =0;
        int sum = 0;
        int maxWindow = 0;

        while(end<size){
            sum += a.get(end);

            if(sum<0){
                end++;
            }
            else if (sum == 0){
                maxWindow = Math.max(maxWindow, end-start+1);
                end++;


            }

            else if(sum>0){
                while(sum>0)
                {
                    sum-=a.get(start);
                    start++;}
                if(sum ==0){
                    maxWindow = Math.max(maxWindow, end-start+1);
                }
                end++;

            }

        }

        for(int i=start;i<end;i++){
            result.add(i);
        }

        return result;


    }


    public static void main(String[] args) {


        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> re = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(-2);
        a.add(4);
        a.add(-4);
        re=solve(a);
        for(int i=0;i<re.size();i++){
            System.out.println(a.get(i));
        }
    }
}
