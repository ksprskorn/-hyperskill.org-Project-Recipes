import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        Queue<Integer> firstQueue = new ArrayDeque<>();
        Queue<Integer> secondQueue = new ArrayDeque<>();

        int firstQueueTotalLoad = 0;
        int secondQueueTotalLoad = 0;

        for (int i = 0; i < row; i++) {
            int[] readRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (firstQueueTotalLoad <= secondQueueTotalLoad) {
                firstQueueTotalLoad += readRow[1];
                firstQueue.offer(readRow[0]);
            } else {
                secondQueueTotalLoad += readRow[1];
                secondQueue.offer(readRow[0]);
            }
        }
        firstQueue.stream().forEach(num -> System.out.print(num + " "));
        System.out.println();
        secondQueue.stream().forEach(num -> System.out.print(num + " "));
    }
}