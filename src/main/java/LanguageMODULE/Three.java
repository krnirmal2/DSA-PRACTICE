package LanguageMODULE;

public class Three {

    public static void main(String[] args) {
        // Getting an integer value

        Integer i = Integer.valueOf(12);

        // Printing the same integer value

        System.out.print(i + " ");

        // Calling method 2

        modify(i);

        // Now printing the value stored in above integer

        System.out.print(i);
    }

    // Method 2

    // To modify integer value

    private static void modify(Integer i) {
        i = i + 1;
    }
}
