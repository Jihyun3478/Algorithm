package Baekjoon.숫자의_합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String numbers = sc.next();

        int sum = 0;
        for(int i = 0; i < N; i++) {
            String[] splitNumbers = numbers.split("");
            sum += Integer.parseInt(splitNumbers[i]);
        }
        System.out.println(sum);
    }
}