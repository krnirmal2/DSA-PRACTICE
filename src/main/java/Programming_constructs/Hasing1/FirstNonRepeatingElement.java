package Programming_constructs.Hasing1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstNonRepeatingElement {
    public static int findFirstNonRepeating(List<Integer> A) {
        // Step 1: Count occurrences using a HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);
        }

        // Step 2: Find the first non-repeating element
        for (int i = 0; i < A.size(); i++) {
            if (hm.get(A.get(i)) == 1) {
                return A.get(i);
            }
        }

        // If no non-repeating element is found
        return -1; // or any other indication
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 5, 1, 2, 1, 4, 5, 3);
        int result = findFirstNonRepeating(A);
        System.out.println("First Non-Repeating Element: " + result);
    }
}
