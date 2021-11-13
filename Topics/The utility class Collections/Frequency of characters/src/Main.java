import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> array = Arrays.asList(scanner.nextLine().split(" "));
        String findElem = scanner.nextLine();

        System.out.println(Collections.frequency(array, findElem));
    }
}