package AdvancedDSA.Arrays.one.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static String solve(int A) {
        Queue<String> q = new LinkedList();
        q.add("1");
        q.add("2");
        for(int i=0; i<A-1; i++){
            String str = q.peek();
            q.remove();
            q.add(str + "1");
            q.add(str + "2");
        }
        String p = q.peek();
        StringBuilder sb = new StringBuilder(p);
        String t = sb.reverse().toString();
        return p+t;
    }

    public static void main(String args[])
    {
        System.out.println(solve(4));
    }
}