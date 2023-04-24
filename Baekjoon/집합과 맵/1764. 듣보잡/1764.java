/* 리팩토링 전 : 시간 초과 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] nArr = new String[N];
        String[] mArr = new String[M];
        int cnt = 0;
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            nArr[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            mArr[i] = br.readLine();
        }

        for(int i = 0; i < nArr.length; i++) {
            for(int j = 0; j < mArr.length; j++) {
                if(nArr[i].contains(mArr[j])) {
                    cnt++;
                    map.put(mArr[j], 0);
                }
            }
        }

        for(String s : map.keySet()) {
            sb.append(s).append('\n');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}

/* 리팩토링 후 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        int cnt = 0;


        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(set.contains(s)) {
                cnt++;
                list.add(s);
            }
        }
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}