import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Main {

    private static Stack<Integer> s = new Stack<Integer>();
    private static int maxEle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < row; i++) {
            String s = scanner.nextLine();
            if (s.equals("max")) {
                getMax();
            } else if (s.equals("pop")) {
                pop();
            } else if (s.matches("push \\d")) {
                int v = Integer.parseInt(Arrays.asList(s.split(" ")).get(1));
                push(v);
            }
        }
    }

    // Prints maximum element of MyStack
    public static void getMax() {
        if (!s.empty()) {
            System.out.println(maxEle);
        }
    }

    public void peek() {
        if (!s.empty()) {
            s.peek();
        }
    }

    public static void pop() {
        if (!s.empty()) {
            int t = s.peek();
            s.pop();
            if (t > maxEle) {
                maxEle = 2 * maxEle - t;
            }
        }
    }

    public static void push(int v) {
        // Insert new number into the stack
        if (s.empty()) {
            maxEle = v;
            s.push(v);
            return;
        }

        // If new number is less than maxEle
        if (v > maxEle) {
            s.push(2 * v - maxEle);
            maxEle = v;
        } else
            s.push(v);
    }
}