package Programming_constructs.Hasing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class K_Occurrences {
    public static int getSum(int A, int B, ArrayList<Integer> C) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int sum = 0;
            int result = -1;
            // one time put the character count to the hashmap with frequency
            for(Integer val : C){
                map.put(val,(map.getOrDefault(val,0)+1));
            }
            int singleCount=0;

            //second time check that if the character occure more than one time
            for(Integer val : C){
                if(map.containsKey(val)){
                    if((map.get(val)%B)==0) {
                        sum += val;
                        result = sum;
                    }
                    map.remove(val);


                }
            }

            return sum>=0? result %(1000000007):result;
    }

    public static void main(String[] args) {
//        System.out.println(getSum(5 ,2 ,new ArrayList<>(List.of(1, 2 ,2 ,3, 3))));
//        System.out.println(getSum(5 ,5 ,new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(getSum(4 ,1 ,new ArrayList<>(List.of(0, 0, 0, 0))));
//        System.out.println(getSum(3 ,2 ,new ArrayList<>(List.of(0, 0, 1 ))));
    }

}
