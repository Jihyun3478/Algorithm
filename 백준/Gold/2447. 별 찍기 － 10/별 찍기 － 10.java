import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Star(i, j);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void Star(int i, int j) {
        while(true) {
            if(i == 0)
                break;
            else if(i % 3 == 1 && j % 3 == 1) {
                sb.append(" ");
                return;
            }
            i /= 3;
            j /= 3;
        }
        sb.append("*");
    }
}
