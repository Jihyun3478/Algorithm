package Baekjoon.알람_시계;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M >= 45) {
            System.out.println(H + " " + (M-45));
        }
        if(H > 0 && M < 45) {
            System.out.println((H-1) + " " + (60-45+M));
        }
        if(H == 0 && M < 45) {
            System.out.println((23-H) + " " + (60-45+M));
        }
    }
}