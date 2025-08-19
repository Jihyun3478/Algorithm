import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringBuilder builder = new StringBuilder();
            String line = null;

            while (!(line = reader.readLine()).equals(".")) {
                if (isBalanced(line)) {
                    builder.append("yes\n");
                } else {
                    builder.append("no\n");
                }
            }
            writer.write(builder.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isBalanced(String sentence) {
        Stack<Character> stack = new Stack<>();

        for (char c : sentence.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
