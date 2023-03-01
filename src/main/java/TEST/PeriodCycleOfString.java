package TEST;

import java.util.HashMap;
import java.util.Map;

public class PeriodCycleOfString {
        public static int solve(String A) {

            Integer result =0;
            HashMap<Character,Integer> mp = new HashMap<>();

            if(A.length()==1) result= 1;
            for(int i=0;i<A.length();i++){
                if(mp.containsKey(A.charAt(i))){
                    mp.put(A.charAt(i),mp.get(A.charAt(i))+1);
                }
            else{
                    mp.put(A.charAt(i),1);
                }
            }
            // first element in the mp
            Integer firstValue =  mp.get(A.charAt(0));
            for(Map.Entry i: mp.entrySet()){
                if(mp.size() ==1){
                    return 1;
                }
                if(firstValue != i.getValue()){
                    result= A.length();
                }
                else{
                    result= firstValue;
                }

            }

            return  result;
        }

    public static void main(String[] args) {
        System.out.println(solve("opxasvxcqosentp"));
    }
}
