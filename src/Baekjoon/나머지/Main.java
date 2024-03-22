package Baekjoon.나머지;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = new String[10];
        int[] remain = new int[10];

        for(int i = 0; i < 10; i++) {
            numbers[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 10; i++) {
            remain[i] = Integer.parseInt(numbers[i]) % 42;

        }

        remain = Arrays.stream(remain).distinct().toArray();
        bw.write(remain.length + "\n");
        bw.flush();
    }
}