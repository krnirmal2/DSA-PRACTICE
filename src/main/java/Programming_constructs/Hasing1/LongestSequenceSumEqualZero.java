package Programming_constructs.Hasing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSequenceSumEqualZero {


//        public static int[] lszero(int[] A) {
//
//            long []ps =new long[A.length];
//            HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
//
//            ps[0]=(long)A[0];
//            int start=0;
//            int firstindex=0;
//            int diff=0;
//            int ans=0;
//            int count=0;
//
//
//            for(int i=1;i<A.length;i++)  // prefix sum
//            {
//                ps[i]=ps[i-1]+(long)A[i];
//                //System.out.print(ps[i]);
//            }
//            // for edge case when prefix sum has 0 init
//            hm.put(0L, -1);
//
//            for (int i=0;i<A.length;i++)
//            {
//                if (hm.containsKey(ps[i]))
//                {
//                    firstindex =hm.get(ps[i]);  //getting 1 st index
//                    diff= i-firstindex;
//                    if(diff>ans)
//                    {
//                        start=  firstindex;   // cal diff and find max
//                        ans=diff;
//                    }
//
//                }
//                else
//                {
//                    hm.put(ps[i],i);    // adding index first time
//                }
//            }
//            if (ans==0)
//            {
//                return new int[]{ };
//            }                            // for no subarray sum with zero
//
//            int res[]=new int[ans];
//
//            for (int i=0;i<ans;i++)   //start+1 till ans
//            {
//                ++start;
//                res[i]=A[start ];
//
//
//            }
//            return res;
//        }

    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (A == null) return rst;
        int len = 0;
        int sum = 0;
        int l = -1, r = -1;
        map.put(0, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (!map.containsKey(sum))
                map.put(sum, i);
            else {
                if (i - map.get(sum) > len) {
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }
        if (l >= 0 && r >= 0) {
            for (int i = l; i <= r; i++) {
                rst.add(A.get(i));
            }
        }
        return rst;
    }

    public static void main(String[] args) {
//            int [] a = {1,2,-2,4,-4};
        ArrayList<Integer> a = new ArrayList<>(List.of(1, 2, -2, 4, -4));
        System.out.println(lszero(a));
    }
}
