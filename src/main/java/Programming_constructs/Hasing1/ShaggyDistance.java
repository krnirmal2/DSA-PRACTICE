package Programming_constructs.Hasing1;

import java.util.HashMap;

public class ShaggyDistance {

    public static int solve(int[] a) {

        HashMap<Integer, Integer> mp = new HashMap<>();


        int minIndx = Integer.MAX_VALUE;
        int flag = 0;
        int shaggydist = -1;
        for (int i = 0; i < a.length; i++) {
            if (mp.containsKey(a[i])) {
                shaggydist = Math.abs(mp.get(a[i]) - i);
                minIndx = Math.min(minIndx, shaggydist);
                flag = 1;
            } else {
                mp.put(a[i], i);
            }

        }

        if (flag == 0)
            return -1;
        else
            return minIndx;


    }


    public static void main(String[] args) {
        int[] a = {7, 1, 3, 4};
        System.out.println(solve(a));
    }


}
