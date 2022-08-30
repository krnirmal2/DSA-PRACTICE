package Programming_constructs.Hasing2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueElementINEachSubArrrayOfSizeB {
    /*public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        for (int i = 0; i < B; i++) {
            int num = A.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ans.add(map.size());
        for (int i = B; i < n; i++) {
            int num = A.get(i);
            int out = A.get(i - B);
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            ans.add(map.size());
        }
        return ans;
    }*/
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        // if()
//        1, 2, 1, 3, 4, 3
        ArrayList<Integer> result = new ArrayList();
        HashMap<Integer,Integer>  uniqueKey= new HashMap<Integer, Integer>();

        int startWindow = 0, endWindow = 0;

        while (endWindow < A.size()) {
            uniqueKey.put(A.get(endWindow), uniqueKey.get(A.get(endWindow) +1));

            if (endWindow - startWindow + 1 < B) {
                endWindow++;
            } else if (endWindow - startWindow + 1 == B) {
                result.add(uniqueKey.size());
                uniqueKey.put(A.get(startWindow),uniqueKey.get(A.get(startWindow)-1));

                startWindow++;
                endWindow++;
//                endWindow = startWindow;
            }


        }
        return result;
    }




    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add( 1);
        A.add( 3 );
        A.add( 4);
        A.add( 3);

        int B =3;
        A= dNums(A,B);
        for(Integer i : A){
            System.out.println(i);
        }

    }
}
