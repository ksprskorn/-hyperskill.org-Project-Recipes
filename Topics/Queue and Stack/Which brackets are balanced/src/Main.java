import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> openTagsStack = new ArrayDeque<>();
        Deque<Character> closeTagsStack = new ArrayDeque<>();
        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);

            if ("[{(".contains(String.valueOf(value))) {
                openTagsStack.addFirst(value);
            } else {
                closeTagsStack.addFirst(value);
            }
            if (i == 0 & openTagsStack.isEmpty()) {
                break;
            }

            if (!openTagsStack.isEmpty() & !closeTagsStack.isEmpty()) {
                char convertedOpenTag = (String.valueOf(openTagsStack.getFirst()).equals("(") ? ")" :
                        String.valueOf(openTagsStack.getFirst()).equals("[") ? "]" : "}").charAt(0);
                char closeTag = closeTagsStack.getFirst();

                if (String.valueOf(convertedOpenTag).equals(String.valueOf(closeTag))) {
                    openTagsStack.removeFirst();
                    closeTagsStack.removeFirst();
                }
            }
        }
        if (openTagsStack.isEmpty() & closeTagsStack.isEmpty()) {
            isBalanced = true;
        }

        System.out.println(isBalanced);
    }
}