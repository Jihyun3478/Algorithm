import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int T = Integer.parseInt(reader.readLine());

            for (int i = 0; i < T; i++) {
                Queue<Integer> queues = new LinkedList<>();
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int N = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());

                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    queues.add(Integer.parseInt(tokenizer.nextToken()));
                }

                int printCount = 0;
                while (true) {
                    int front = queues.peek();
                    boolean flag = false;

                    for (Integer queue : queues) {
                        if (queue > front) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        int poll = queues.poll();
                        queues.add(poll);
                        if (M == 0) {
                            M = queues.size() - 1;
                        } else {
                            M -= 1;
                        }
                    } else {
                        queues.poll();
                        printCount++;

                        if (M == 0) {
                            writer.write(printCount + "\n");
                            break;
                        } else {
                            M -= 1;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
