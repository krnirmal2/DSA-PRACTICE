package Programming_constructs.BitManupulation;

public class BinaryString {
    /*public static String addBinary(String A, String B) {
        int size = Math.max(A.length(), B.length());
        // check which length of the string is greater
        // that will be the result string
        // or create a string
        String result = new String();
        result = "";
        for(int i= size-1; i>=0; i++){
//                System.out.println(A.charAt(i));
//                result = result + (A.charAt(i)+B.charAt(i));
        }
        return result;
    }*/
        /*public static String addBinary(String A, String B) {
            int a = A.length(), b = B.length();
            int carry = 0;
            int len = Math.max(a, b);
            StringBuilder s = new StringBuilder();
            for (int i = 1; i <= len; i++) {
                int c1 = a - i >= 0 ? (int) A.charAt(a - i) / 49 : 0;
                int c2 = b - i >= 0 ? (int) B.charAt(b - i) / 49 : 0;
                int sum = c1 + c2;
                if ((sum > 1)) {
                    if (carry == 0) {
                        carry = 1;
                        s.insert(0, 0);
                    } else {
                        s.insert(0, 1);
                    }
                } else {
                    if (carry == 0) {
                        s.insert(0, sum);
                    } else {
                        if (sum + carry > 1) {
                            s.insert(0, 0);
                        } else {
                            s.insert(0, sum + carry);
                            carry=0;
                        }
                    }
                }
            }
            if (carry > 0) {
                s.insert(0, carry);
            }
            return s.toString();
        }*/
    public static String addBinary(String A, String B) {
        int lengthA = A.length();
        int lengthB = B.length();
        int maxBetweenAandB = Math.max(lengthA, lengthB);

        int coloumnA, coloumnB;
        StringBuilder s = new StringBuilder();
        int sumOfColoumnAB, carry = 0;

        for (int i = 1; i < maxBetweenAandB; i++) {
            coloumnA = lengthA - i >= 0 ? (int) A.charAt(lengthA - i) / 49 : 0;
            coloumnB = lengthB - i >= 0 ? (int) B.charAt(lengthB - i) / 49 : 0;

            sumOfColoumnAB = coloumnA + coloumnB;

            if (sumOfColoumnAB > 1) {
                // now check if the previous there is any carry forward or not to current sumOfColoumnAB
                if (carry == 0) {
                    carry = 1;
                    s.insert(0, 0);

                } else {
                    s.insert(0, 1);

                }
            } else {
                if (carry == 0) {
                    s.insert(0, sumOfColoumnAB);
                } else {
                    if (sumOfColoumnAB + carry > 1) {
                        s.insert(0, 0);
                    } else {
                        s.insert(0, sumOfColoumnAB + carry);
                        carry = 0;
                    }

                }
            }


        }
        if (carry > 0) {
            s.insert(0, carry);
        }
        return s.toString();

    }


    public static void main(String[] args) {
        String a = "110";
        String b = "11";
        System.out.println(addBinary(a, b));
    }
}