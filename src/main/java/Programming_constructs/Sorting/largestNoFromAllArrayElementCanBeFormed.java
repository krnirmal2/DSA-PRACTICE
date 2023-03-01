package Programming_constructs.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestNoFromAllArrayElementCanBeFormed {
  // DO NOT MODIFY THE LIST
        public static String largestNumber(final List<Integer> A) {
            StringBuffer strBuf = new StringBuffer();
            Node num[];
            int i = 0;
            num = new Node[A.size()];
            for (int n: A) {
                num[i] = new Node(n);
                i++;
            }
            // sorts the array lexicographically
            Arrays.sort(num);
            for (Node n: num) {
                if (n.number == 0 && strBuf.length() != 0)
                    continue;
                strBuf.append(n.number);
            }
            return strBuf.toString();
        }
        static class Node implements Comparable < Node > {
            int number;
            public Node(int number) {
                this.number = number;
            }
            @Override
            public int compareTo(Node o) {
                String first = String.valueOf(this.number) + String.valueOf(o.number);
                String second = String.valueOf(o.number) + String.valueOf(this.number);
                return second.compareTo(first);
            }
        }

    public static void main(String[] args) {
            List<Integer> a;
        a = new ArrayList<>(List.of(3, 30, 34, 5, 9));
        System.out.println(largestNumber(a));
    }
    }
