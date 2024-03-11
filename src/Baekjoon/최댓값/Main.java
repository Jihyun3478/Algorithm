package Baekjoon.최댓값;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] number = new int[9];
        for(int i = 0; i < 9; i++) {
            number[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0; i < 9; i++) {
            if(max < number[i]) {
                max = number[i];
                maxIndex = i+1;
            }
        }
        System.out.println(max + "\n" + maxIndex);
    }
}