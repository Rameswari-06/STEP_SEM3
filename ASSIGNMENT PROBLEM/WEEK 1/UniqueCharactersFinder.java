import java.util.Scanner;

public class UniqueCharactersFinder {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static char[] findUniqueCharacters(String text) {
        int length = getLength(text);
        char[] uniqueTemp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueTemp[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueTemp[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueTemp[i];
        }
        return uniqueChars;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] uniqueChars = findUniqueCharacters(input);
        System.out.print("Unique characters: ");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }
        sc.close();
    }
}
