package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1051 {
    static int N, M;
    static int[][] map;
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        int dist = Math.min(N, M) - 1;
        boolean isFind = false;
        while (!isFind) {
            for(int i = 0; i < N - dist; i++) {
                for(int j = 0; j < M - dist; j++) {
                    if (find(i, j, dist)) {
                        isFind = true;
                        max = dist + 1;
                    }
                }
            }
            dist--;
        }
        if(N == 1 && M == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(max * max);
        }
    }

    public static boolean find(int x, int y, int dist) {
        if(map[x][y] == map[x + dist][y] && map[x][y] == map[x][y + dist] && map[x][y] == map[x + dist][y + dist]) {
            max = Math.max(max, dist);
            return true;
        }
        return false;
    }
}
