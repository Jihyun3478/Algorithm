import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int size = 0;
    private static int front = 0;
    private static int back = 0;
    private static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push(int item) {
        queue[back] = item;
        size++;
        back++;
    }

    static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int temp = queue[front];
            size--;
            front++;

            return temp;
        }
    }

    static int size() {
        return size;
    }

    static int empty() {
        if(size == 0) return 1;
        else return 0;
    }

    static int front() {
        if(size == 0) return -1;
        return queue[front];
    }

    static int back() {
        if(size == 0) return -1;
        return queue[back-1];
    }
}
