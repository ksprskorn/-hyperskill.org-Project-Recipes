import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        Deque<Integer> array = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            array.addFirst(value);
        }
        array.stream().forEach(n -> System.out.println(n));
    }
}