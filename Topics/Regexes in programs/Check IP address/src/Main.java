import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String ipAdress = scanner.nextLine();

        String regexForIp = "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\." +
                            "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\." +
                            "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\." +
                            "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";
        String output = "NO";

        boolean isCorrect = ipAdress.matches(regexForIp);
        if (isCorrect) {
            output = "YES";
        }

        System.out.print(output);


    }
}