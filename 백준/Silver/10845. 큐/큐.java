import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private static Queue<Integer> queue = new LinkedList<>();
    public static int last;

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(reader.readLine());

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String input = reader.readLine();

                int number = 0;
                if (input.contains("push")) {
                    String[] split = input.split(" ");
                    number = Integer.parseInt(split[1]);
                    input = split[0];
                }

                switch (input) {
                    case "push":
                        push(number);
                        break;
                    case "pop":
                        builder.append(pop()).append("\n");
                        break;
                    case "size":
                        builder.append(size()).append("\n");
                        break;
                    case "empty":
                        builder.append(empty()).append("\n");
                        break;
                    case "front":
                        builder.append(front()).append("\n");
                        break;
                    case "back":
                        builder.append(back()).append("\n");
                        break;
                }
            }
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void push(int number) {
        queue.add(number);
        last = number;
    }

    private static int pop() {
        if (size() == 0) {
            return -1;
        }
        return queue.poll();
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.element();
    }

    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return last;
    }
}
