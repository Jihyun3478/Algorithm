import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> palindrome = new ArrayList<>();
        String last = "";

        while (!last.equals("0")) {
            palindrome.add(br.readLine());
            last = palindrome.get(palindrome.size() - 1);
        }

        for (int i = 0; i < palindrome.size() - 1; i++) {
            int length = palindrome.get(i).length();
            String temp1 = palindrome.get(i).substring(0, length / 2);
            String temp2 = "";

            if (length % 2 == 0) {
                temp2 = palindrome.get(i).substring(length / 2);
                StringBuilder sb = new StringBuilder(temp2);
                temp2 = sb.reverse().toString();
            } else {
                temp2 = palindrome.get(i).substring(length / 2 + 1);
                StringBuilder sb = new StringBuilder(temp2);
                temp2 = sb.reverse().toString();
            }

            if (temp1.equals(temp2)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        br.close();
        bw.close();
    }
}
