package Baekjoon.별_찍기2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = N-1; j > i; j--) {
                System.out.print(" ");
            }
            for(int k = 1; k <= i+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}