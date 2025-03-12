package StandardProblemDSA.ARRAY.SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacteReplacement {

    //
    public static int characterReplacement(String s, int k){
        //
        if(s.length() > k) return s.length();
        // now store the map character frequency so that we will get atmost k
        //distinct charater in substring and if we over that then need to udate
        Map<Character, Integer> map = new HashMap<>();

        int longSubStringWithRepeatingCh = 0;

        int maxFrequecy = 0;
        int i =0, j=0;
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            // now update the max fequency present in the array
            maxFrequecy = Math.max(maxFrequecy, map.get(s.charAt(j)));

            // now we have to only take care if the frequency of that character is
            // exceed the k
            if((j-i+1) -maxFrequecy >k) {

                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
             longSubStringWithRepeatingCh = Math.max(longSubStringWithRepeatingCh, (j - i + 1));
        }
        return longSubStringWithRepeatingCh;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("ABAB", 2));  // Output: 4
//        System.out.println(sol.characterReplacement("AABABBA", 1)); // Output: 4
//        System.out.println(sol.characterReplacement("AAABBC", 2)); // Output: 5
    }
}
