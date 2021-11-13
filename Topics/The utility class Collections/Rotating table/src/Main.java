import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tableDim = Arrays.asList(scanner.nextLine().split(" "));
        int row = Integer.parseInt(tableDim.get(0));
        int col = Integer.parseInt(tableDim.get(1));

        List<List<String>> table = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<String> tableRow = Arrays.asList(scanner.nextLine().split(" "));
            table.add(tableRow);
        }

        int distance = scanner.nextInt();

        Collections.rotate(table, distance);

        for (List<String> list: table) {
            for (String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}