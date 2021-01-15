package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1182 {
    static int N, S;
    static int[] num;
    static boolean[] visit;
    static int baseNum;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        num = new int[N];
        str = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        for (int i = 1; i < N + 1; i++) {
            baseNum = i;
            visit = new boolean[N];
            back(0, 0, 0);
        }
        System.out.println(result);
    }

    public static void back(int dist, int a, int hap) {
        if(dist == baseNum) {
            if(hap == S) {
                result++;
            }
        }
        else {
            for(int i = a; i < N; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    back(dist + 1, i, num[i] + hap);
                    visit[i] = false;
                }
            }
        }

    }
}
