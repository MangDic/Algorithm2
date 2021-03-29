package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_1931 {
    static int[][] times;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(str[0]);
            times[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int endTemp = 0;
        for(int i = 0; i < n; i++) {
            if(times[i][0] >= endTemp) {
                //System.out.println(times[i][0] + " " + times[i][1]);
                endTemp = times[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
