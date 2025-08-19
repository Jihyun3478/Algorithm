import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String word = reader.readLine();
            int mid = word.length() / 2;
            
            String front = word.substring(0, mid);
            String back = null;
            if (word.length() % 2 == 0) {
                back = word.substring(mid);
            }
            else {
                back = word.substring(mid + 1);
            }

            back = new StringBuilder(back).reverse().toString();

            if (front.equals(back)) {
                writer.write("1");
            } else {
                writer.write("0");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
