import java.util.Scanner;

public class VowelConsonantTable {

    // Method to check if a character is a vowel, consonant, or not a letter
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // 'A' -> 'a'
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to find vowels and consonants in a string and return as 2D array
    public static String[][] findVowelsConsonants(String str) {
        String[][] result = new String[str.length()][2]; // [char, type]

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);        // Character
            result[i][1] = checkCharType(ch);         // Type
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-15s\n", "Character", "Type");
        System.out.println("-------------------------");
        for (String[] row : table) {
            System.out.printf("%-10s %-15s\n", row[0], row[1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] table = findVowelsConsonants(input);
        displayTable(table);

        sc.close();
    }
}

