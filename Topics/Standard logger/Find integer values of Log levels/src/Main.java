import java.util.*;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> level = Arrays.asList(scanner.nextLine().toUpperCase(Locale.ROOT).split(" "));
        int sum = 0;

        for (String lvl : level) {
            sum += Level.parse(lvl).intValue();
        }
        System.out.println(sum);
    }
}