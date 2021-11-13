import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.asList(scanner.nextLine().split(" "));
        int swapsCount = Integer.parseInt(scanner.nextLine());

        for (int a = 0; a < swapsCount; a++) {
            List<String> position = Arrays.asList(scanner.nextLine().split(" "));
            int i = Integer.parseInt(position.get(0));
            int j = Integer.parseInt(position.get(1));
            Collections.swap(list, i, j);
        }

        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}