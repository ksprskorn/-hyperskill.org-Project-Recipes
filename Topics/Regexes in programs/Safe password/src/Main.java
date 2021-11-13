import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String passwors = scanner.nextLine();
        String regexPatternDigits = ".*\\d.*";
        String regexPatternLetter = ".*[a-z].*";
        String regexPatternUpperLetter = ".*[A-Z].*";
        String regexPatternCorrectLenght = "\\w{12,}";

        boolean contentDigits = passwors.matches(regexPatternDigits);
        boolean contentLetter = passwors.matches(regexPatternLetter);
        boolean contentUpperLetter = passwors.matches(regexPatternUpperLetter);
        boolean correctLenght = passwors.matches(regexPatternCorrectLenght);

        System.out.print((contentDigits & contentLetter & contentUpperLetter & correctLenght) ? "YES" : "NO");
    }
}
