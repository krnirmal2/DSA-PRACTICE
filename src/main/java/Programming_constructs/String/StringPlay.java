package Programming_constructs.String;

public class StringPlay {
    public static String solve(String A) {

        // concatenate the given string with it self
        String S = A.concat(A);
        // convert the string to toCharArray
        char[] stringToArray = S.toCharArray();

        // delete all the uppercase letters

        for (int i = 1; i < stringToArray.length; i++) {
            if (stringToArray[i - 1] >= 65 && stringToArray[i - 1] <= 90) {
                stringToArray[i - 1] = ' ';
            }
        }
        for (int i = 0; i < stringToArray.length; i++) {
            if (stringToArray[i] == 'a' || stringToArray[i] == 'e' || stringToArray[i] == 'i' || stringToArray[i] == 'o' || stringToArray[i] == 'u') {
                stringToArray[i] = '#';

            }
        }
        A = stringToArray.toString();
        return A;
    }

    public static void main(String[] args) {

        System.out.println(solve("hgUe"));
    }
}


