/*
 * 2023.05.16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }

        int sum = 0;
        for(int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}

/*
 * 2023.05.21
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) stack.push(num);
            else stack.pop();
        }

        int sum = 0;
        for(int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}
