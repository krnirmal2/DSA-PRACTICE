package Sorting;

import java.util.Arrays;
import java.util.List;

public class LargestNoUsingArrangmentOfNO {

        // DO NOT MODIFY THE LIST
        public String largestNumber(final List< Integer > A) {
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
        class Node implements Comparable < Node > {
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

        /*
 public String largestNumber(final int[] A) {
        ArrayList<String> arrList = new ArrayList<String>();
        int sum = 0;
        int n = A.length;
        for(int i=0;i<n;i++) {
            arrList.add(Integer.toString(A[i]));
            sum = sum + A[i];
        }
        if (sum == 0) {
            return "0";
        }
        Collections.sort(arrList, new Comparator<String>(){
            public int compare(String a, String b){
                String firstNum = a+b;
                String secondNum = b+a;
                return firstNum.compareTo(secondNum) > 0 ? -1 : 1;
            }
        });
        String result = String.join("", arrList);
        return result;
    }*/

    }

    public static void main(String[] args) {

    }


}
