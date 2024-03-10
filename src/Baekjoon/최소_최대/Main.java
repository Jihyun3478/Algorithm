package Baekjoon.최소_최대;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] number = new int[N];
        for(int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(max < number[i]) {
                max = number[i];
            }
            if(min > number[i]) {
                min = number[i];
            }
        }
        System.out.println(min + " " + max);
    }
}