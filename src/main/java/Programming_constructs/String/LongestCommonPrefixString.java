package Programming_constructs.String;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestCommonPrefixString {

    public String longestCommonPrefix(ArrayList<String> A) {
        String result = "";
        HashMap<Character, Integer> commonPrefix = new HashMap<>();
        char pre = 0;
        int k = 0;
        for (int i = 0; i < A.size(); i++) {
            // take each character at k and
            pre = A.get(i).charAt(k);
            if (commonPrefix.containsKey(pre)) {
                commonPrefix.put(pre, commonPrefix.get(pre) + 1);
            } else {
                commonPrefix.put(pre, 1);
            }

        }
        if (commonPrefix.get(pre) != A.size()) {
            return result;
        } else {
            k++;
            longestCommonPrefix(A);
        }
        return result;
    }


}
