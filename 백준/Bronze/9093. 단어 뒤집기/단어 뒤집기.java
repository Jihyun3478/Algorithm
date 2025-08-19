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
            int T = Integer.parseInt(reader.readLine());

            for (int i = 0; i < T; i++) {
                String sentence = reader.readLine();
                String[] split = sentence.split(" ");
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < split.length; j++) {
                    StringBuilder builder = new StringBuilder(split[j]);
                    split[j] = builder.reverse().toString();
                    result.append(split[j]).append(" ");
                }
                result.append("\n");
                writer.write(result.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
