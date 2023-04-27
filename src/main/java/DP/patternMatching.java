package DP;

import java.io.CharArrayWriter;

public class patternMatching {

    public static void main(String[] args) {
        System.out.println(patternMatch("aabec","a*c"));
    }

    private static int patternMatch(String A, String B) {
        // we have check
        int result = 0;

        int sizeOfA = A.length();
        int sizeOfB = B.length();
        // change both the string to char array
        char [] a = A.toCharArray();
        char [] b= B.toCharArray();

        // if the last character of both A and B not matched then return
        if( b[sizeOfB -1] != a[sizeOfA -1]) return result;

        // now if the last character is ? which match exactly the one character of the string
        if(b[sizeOfB -1] == '?' && sizeOfA !=0 )


        return result;
        return result;
    }
}
