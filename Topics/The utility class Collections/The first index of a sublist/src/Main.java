import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstArray = Arrays.asList(scanner.nextLine().split(" "));
        List<String> secondArray = Arrays.asList(scanner.nextLine().split(" "));

        int start = Collections.indexOfSubList(firstArray, secondArray);
        int end = Collections.lastIndexOfSubList(firstArray, secondArray);

        System.out.println(start + " " + end);
    }
}