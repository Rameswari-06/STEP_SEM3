import java.util.Scanner;

public class FrequencyWithUniqueChars {

    public static char[] uniqueCharacters(String text) {
        int length = text.length();
        char[] temp = new char[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < count; j++) {
                if (temp[j] == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[count] = ch;
                count++;
            }
        }
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static String[][] charFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] frequencies = charFrequency(input);
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("---------------------");
        for (String[] row : frequencies) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
        sc.close();
    }
}

