package Baekjoon.빠른_A_더하기_B;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        String[] testCases = new String[T];
        for(int i = 0; i < T; i++) {
            testCases[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < T; i++) {
            String[] splitTestCase = testCases[i].split(" ");
            int sum = Integer.parseInt(splitTestCase[0]) + Integer.parseInt(splitTestCase[1]);
            bw.write(sum + "\n");
        }
        bw.flush();
    }
}