public class StringManipulation {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = new String("Java Programming");
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String str3 = new String(charArray);

        System.out.println("Comparing str1 and str2 with == : " + (str1 == str2));
        System.out.println("Comparing str1 and str2 with .equals() : " + str1.equals(str2));

        System.out.println("Comparing str1 and str3 with == : " + (str1 == str3));
        System.out.println("Comparing str1 and str3 with .equals() : " + str1.equals(str3));

        System.out.println("\nExplanation:");
        System.out.println("'==' checks if both references point to the same object in memory.");
        System.out.println("'.equals()' checks if the content of the strings is the same.");
        System.out.println("String literals are stored in the String pool, while 'new String()' creates a new object in heap memory.");

        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}
