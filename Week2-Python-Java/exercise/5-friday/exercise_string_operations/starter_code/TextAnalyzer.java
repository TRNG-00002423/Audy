import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Week 2 Exercise — String analysis (implement TODO methods).
 *
 * Compile: javac TextAnalyzer.java
 * Run:     java TextAnalyzer
 */
public class TextAnalyzer {

    public static int wordCount(String text) {
        if (text == null || text.isBlank()){
            return 0;
        }
        String[] words = text.trim().split("\\s");
        return words.length;
    }

    public static boolean isPalindrome(String token) {
        if (token == null) {
            return false;
        }

        token = token.toLowerCase().trim();

        int left = 0;
        int right = token.length() - 1;

        // two pointer approach 
        while (left < right) {
            if (token.charAt(left) != token.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int countOccurrences(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0){
            return 0;
        }

        int count = 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            String part = haystack.substring(i, i + needle.length());

            if(part.equals(needle)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("sample.txt");
        String body = Files.readString(p);
        System.out.println("words=" + wordCount(body));
        System.out.println("palindrome(Radar)=" + isPalindrome("Radar"));
        System.out.println("occurrences of 'QA'=" + countOccurrences(body, "QA"));
    }
}
