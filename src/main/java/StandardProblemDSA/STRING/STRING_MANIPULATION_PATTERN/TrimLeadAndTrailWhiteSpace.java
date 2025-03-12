package StandardProblemDSA.STRING.STRING_MANIPULATION_PATTERN;

public class TrimLeadAndTrailWhiteSpace {
    public static String trimSpaces(String str) {
        if (str == null || str.isEmpty()) {
            return ""; // Handle null or empty strings
        }

        int start = 0;
        int end = str.length() - 1;

        //Two poiner Approach
        // Skip leading whitespaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Skip trailing whitespaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        // Manually build the trimmed string using a StringBuilder
        StringBuilder trimmed = new StringBuilder();
        for (int i = start; i <= end; i++) {
            trimmed.append(str.charAt(i));
        }

        return trimmed.toString();
    }

    public static void main(String[] args) {
        String input = "   Hello World!   ";
        String trimmed = trimSpaces(input);
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Trimmed: \"" + trimmed + "\"");
    }
}