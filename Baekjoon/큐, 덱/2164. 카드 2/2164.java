import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        while(N-- > 1) {
            deque.pollFirst();
            deque.offerLast(deque.peekFirst());
            deque.pollFirst();
        }

        Iterator<Integer> iter = deque.iterator();
        System.out.println(iter.next());
    }
}
