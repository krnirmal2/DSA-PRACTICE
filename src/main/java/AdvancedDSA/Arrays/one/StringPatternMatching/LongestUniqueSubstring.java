package AdvancedDSA.Arrays.one.StringPatternMatching;

import java.util.HashMap;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> hm = new HashMap<>();
        // change string to string array
        int ans = 0;
        int i = 0;
        int j = 0;
        while (j < A.length()) {
            if (hm.containsKey(A.charAt(j))) {
                while (A.charAt(i) != A.charAt(j)) {
//                    hm.getValue(A.charAt(j) )--;
                    hm.remove(A.charAt(i));
                    i++;
                }
                hm.remove(A.charAt(i));
                i++;
            }

            hm.put(A.charAt(j), 1);


            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
