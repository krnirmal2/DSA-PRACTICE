package StandardProblemDSA.II_STRING.I_PATTERN_MATCHING;

public class KMP_algo {


    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        kmpSearch(pat, txt);

    }

    private static int[] computePatternLps(String pat) {
        int m = pat.length();
        int[] lps = new int[m];

        int j = 0, //length of the previous longest prefix suffix
                i = 1; // start comparing from index 1 )since LPS of index 0 is alwasy 0

        // build the lps
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j; // Store the length of the longest prefix which is also a suffix
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];// Move `j` back to the previous LPS value
                } else {
                    lps[i] = 0;// No prefix suffix match, so assign 0
                    i++;
                }
            }
        }
        return lps;

    }

    private static void kmpSearch(String pat, String txt) {
        // find the length of the each
        int n = txt.length();
        int m = pat.length();

        //Step1;
        // create array for precompute LPS array
        // compute LPC of the pattern not the string
        int[] lps = computePatternLps(pat);

        //Step 2:
        int i = 0; // Pointer for text
        int j = 0; // Pointer for pattern

        while (i < n) {
            // step 3;
            // case : 1 : if match move both pointer i and j
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            // case : 2 : if match whole we just return the i-j for first index
            if (j == m)// if j is equal to its lenght
            {
                System.out.println("pattern found at index " + (i - j));
                // move next for any further match
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
//                case 3. if not matched
                if (j != 0) {
                    j = lps[j - 1];// Use LPS to skip unnecessary comparisons
                } else {
                    i++; // No LPS, move to the next character in text
                }
            }

        }

    }


}
