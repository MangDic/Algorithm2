package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_4964 {
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[][] map;
    static int[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        while (true) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            if(N == 0 && M == 0) {
                break;
            }
            map = new int[N][M];
            visit = new int[N][M];
            for(int i = 0; i < N; i ++) {
                String[] temp = br.readLine().split(" ");
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }

            cnt = 0;

            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && visit[i][j] == 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }
    public static void bfs(int x, int y) {
        int nx;
        int ny;
        visit[x][y] = 1;

        for(int i = 0; i < 8; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if(visit[nx][ny] == 1) {
                continue;
            }
            if(map[nx][ny] == 0) {
                continue;
            }
            visit[x][y] = 1;
            bfs(nx, ny);
        }
    }
}
