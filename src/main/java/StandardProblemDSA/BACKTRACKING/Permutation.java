package StandardProblemDSA.BACKTRACKING;

public class Permutation {

    // Function to print permutations of the string
    // This function takes two parameters:
    // 1. Character array
    // 2. Starting index of the array.
    static void permuteRec(char[] s, int start) {

        // Base case
        if (start == s.length - 1) {
            System.out.println(new String(s));
            return;
        }

        for (int i = start; i < s.length; i++) {

            // Swapping
            swap(s, start, i);

            // First idx+1 characters fixed
            permuteRec(s, start + 1);

            // Backtrack
            swap(s, start, i);
        }
    }

    // Wrapper function
    static void permute(String s) {
        permuteRec(s.toCharArray(), 0);
    }

    // Helper function to swap characters in the character array
    static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s);
    }
}



