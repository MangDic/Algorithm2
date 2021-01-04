package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class baekjoon_1987 {
    static int N, M;
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new char[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j-1);
            }
        }

        bfs(1, 1, 1);

        System.out.println(cnt);


    }

    public static void bfs(int x, int y, int count) {
        int nx, ny;

        visit[map[x][y] - 'A'] = true;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx <= 0 || nx > N || ny <= 0 || ny > M) {
                continue;
            }
            if(!visit[map[nx][ny] - 'A']) {
                bfs(nx, ny, count + 1);
            }

        }
        visit[map[x][y] - 'A'] = false;
        cnt = max(cnt,count);
    }
}
