package Baekjoon.단어의_개수;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        sentence = sentence.trim();

        String[] splitSentence = sentence.split(" ");
        if(sentence.isBlank()) {
            bw.write("0");
        } else {
            bw.write(splitSentence.length + "\n");
        }
        bw.flush();
    }
}