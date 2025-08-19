import java.util.*;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder properCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                properCase.append(Character.toUpperCase(word.charAt(0)))
                          .append(word.substring(1).toLowerCase())
                          .append(" ");
            }
        }
        return properCase.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        String longestWord = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("\n--- Text Analysis ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (excluding spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    public static String[] getWordsSorted(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = cleanText.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Text: " + cleaned);

        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n--- Words in Alphabetical Order ---");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        if (found) {
            System.out.println("The word '" + searchWord + "' is present in the text.");
        } else {
            System.out.println("The word '" + searchWord + "' is NOT present in the text.");
        }

        scanner.close();
    }
}
