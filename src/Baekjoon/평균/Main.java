package Baekjoon.평균;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        double[] grades = new double[N];
        for(int i = 0; i < grades.length; i++) {
            grades[i] = Double.parseDouble(st.nextToken());
        }

        double maxGrade = grades[0];
        for(int i = 0; i < N; i++) {
            if(maxGrade < grades[i]) {
                maxGrade = grades[i];
            }
        }

        double result = 0;
        for(int i = 0; i < N; i++) {
            grades[i] = (grades[i] / maxGrade) * 100;
            result = result + (grades[i] / N);
        }
        System.out.println(result);
        br.close();
    }
}