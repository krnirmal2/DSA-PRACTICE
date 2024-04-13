package Programming_constructs.Recursion;

public class KthSymbol {
    public static int solve(int A, int B) {
        // BRUTE FORCE
        String s = "0";
        int count = 0;
        if (A == 0) return 0;

        char indexValue = '0';
        // now append the String
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (s.charAt(i) == '0') {
                s += "01";
            } else s += "10";
            if (count == A) break;
        }


        for (int i = 0; i < B; i++) {
            indexValue = s.charAt(i);
        }
        return indexValue;
    }

    public static void main(String[] args) {
        solve(2, 2);

    }
}
