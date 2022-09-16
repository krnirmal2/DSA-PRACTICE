package AdvancedDSA.Arrays.one;

import java.util.*;

public class rainWaterTrap {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public static int trap( List<Integer> A) {
            int n = A.size();
//            ArrayList<Integer> left_max = new ArrayList<Integer>(Collections.nCopies(A.size(),0));
//            ArrayList<Integer> right_max = new ArrayList<Integer>(Collections.nCopies(A.size(),0));

            int left_max[] = new int[A.size()];
            int right_max[] = new int[A.size()];
            left_max[0] = A.get(0);
            right_max[n-1]=A.get(n-1);
            // first find the prefix max
            for(int i = 1; i<A.size(); i++){
                left_max[i] = Math.max(left_max[i-1], A.get(i));
//                left_max.add(i,Math.max(left_max.get(i-1), A.get(i))) ;
            }
            // suffix max
            for(int i = A.size()-2 ; i>=0; i--){
                right_max[i] = Math.max(right_max[i+1], A.get(i));

//                right_max.add(i,Math.max(right_max.get(i+1), A.get(i)));
            }

            int totalUnitOfWater =0;
            int left_closest_max, right_closest_max;
            // find the left and right max of the currenet element during iteration
            // so need to take min(left and right max)-currenet element and them up
            int min_of_left_right_max = 0;
            for(int k = 1; k< A.size()-1 ; k++){
                // so closest max of left and right
                left_closest_max = left_max[k-1];
                right_closest_max = right_max[k+1];
//                left_closest_max = left_max.get(k - 1);
//                right_closest_max = right_max.get(k + 1);

                min_of_left_right_max = Math.min(left_closest_max, right_closest_max) - A.get(k);

                totalUnitOfWater+= min_of_left_right_max;




            }

            return totalUnitOfWater;
        }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
//        a.add(3);
//        a.add(1);
//        a.add(0);
//        a.add(2);
//        a.add(-4);
//        System.out.println(a.get(0));
        System.out.println(trap(a));
    }

    }


