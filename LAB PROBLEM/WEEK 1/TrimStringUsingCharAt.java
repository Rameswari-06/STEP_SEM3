import java.util.Scanner;

public class TrimStringUsingCharAt {

    // a. Method to find start and end index without spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find first non-space from start
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space from end
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        // If the string is all spaces
        if (start > end) {
            return new int[]{0, -1}; // Represents an empty string
        }

        return new int[]{start, end};
    }

    // b. Method to create a substring using charAt()
    public static String manualSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // c. Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Step 1: Find start & end indexes
        int[] indexes = findTrimIndexes(input);

        // Step 2: Create manually trimmed string
        String manuallyTrimmed = (indexes[1] == -1) ? "" : manualSubstring(input, indexes[0], indexes[1]);

        // Step 3: Use built-in trim()
        String builtInTrimmed = input.trim();

        // Step 4: Compare
        boolean areEqual = compareStrings(manuallyTrimmed, builtInTrimmed);

        // Step 5: Display results
        System.out.println("\nOriginal String: \"" + input + "\"");
        System.out.println("Manually Trimmed: \"" + manuallyTrimmed + "\"");
        System.out.println("Built-in Trimmed: \"" + builtInTrimmed + "\"");
        System.out.println("Are both equal? " + areEqual);

        sc.close();
    }
}

