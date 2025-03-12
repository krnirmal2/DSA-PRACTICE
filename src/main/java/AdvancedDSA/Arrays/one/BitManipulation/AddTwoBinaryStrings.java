package AdvancedDSA.Arrays.one.BitManipulation;

public class AddTwoBinaryStrings {

    private static String addTwoBinaryString(String num1, String num2) {
        // find the max of the length of two string
        int num1Length = num1.length();
        int num2Length = num2.length();

        int maxlengthString = Math.max(num1Length, num2Length);
        // create results array one character extra
        char[] res = new char[maxlengthString + 1];


        // now iterate over the binary from last and then add
//        start from end

        int i = num1Length - 1;
        int j = num2Length - 1;

        // initial sum and carray is 0
        int sum = 0, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            sum = carry; //before sum take the previous carry value in sum
            if (i >= 0) {
                sum += (num1.charAt(i) - '0');
            }
            if (j >= 0) {
                sum += (num2.charAt(i) - '0');
            }
            res[maxlengthString] = (char) ((sum % 2) + '0'); // add result 0 or 1
            carry = sum / 2; // now check if the carry is 1 or 0
            i--;
            j--;
            maxlengthString--;
        }

        //now check if the leadding carry is 1 trhen
        if (res[0] == '1') {
            return new String(res);

        }
        int len = Math.max(num1Length, num2Length);
        return new String(res, 1, len);
    }

    public static void main(String[] args) {
        String num1 = "10110";
        String num2 = "10110";
        System.out.println(addTwoBinaryString(num1, num2));
    }
}
