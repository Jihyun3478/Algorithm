import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int sum = 0, avg = 0;
        for (int i : arr) {
            sum += i;
        }
        avg = sum / 5;
        int mid = arr[2];
        System.out.println(avg);
        System.out.println(mid);
    }
}
