import java.util.*;


class MapFunctions {

    public static void printWithSameLetter(Map<String, String> map) {
        map.entrySet().stream()
                .filter(e -> e.getKey().startsWith(String.valueOf(e.getValue().charAt(0))))
                .forEach(e -> System.out.printf("%s %s%n", e.getKey(), e.getValue()));
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.printWithSameLetter(map);
    }
}