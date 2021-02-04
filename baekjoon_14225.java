package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_14225 {
    static int N;
    static int[] num;
    static int max = 0;
    static boolean[] checkNum = new boolean[1000000000];
    static boolean[] visit;
    static int baseDist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(num);
        for(int i = 1; i <= N; i++) {
            visit = new boolean[N];
            baseDist = i;
            addNum(0, 0, 0);
        }
        for(int i = 1; i <= max + 1; i++) {
            if(!checkNum[i]) {
                System.out.println(i);
                break;
            }
        }
    }
    public static void addNum(int a, int dist, int hap) {
        if(dist == baseDist) {
            max = Math.max(max, hap);
            checkNum[hap] = true;
        }
        else {
            for(int i = a; i < N; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    addNum(i, dist + 1,hap + num[i]);
                    visit[i] = false;
                }
            }
        }
    }
}
