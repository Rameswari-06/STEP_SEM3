import java.util.Scanner;

public class CharFrequencyFinder {

    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        boolean[] added = new boolean[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                added[ch] = true;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] frequencies = findCharFrequency(input);
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("---------------------");
        for (String[] row : frequencies) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
        sc.close();
    }
}
