package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_16234 {
    static int N, L, R;
    static int[][] map;
    static int set = -1;
    static int result = 0;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        R = Integer.parseInt(str[2]);
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        while (set != N*N) {
            visit = new boolean[N][N];
            set = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visit[i][j]) {
                        bfs(i, j);
                        set++;
                    }
                }
            }
            result++;
        }
        System.out.println(result - 1);
    }

    public static void bfs(int x, int y) {
        Queue<dot3> qu = new LinkedList<>();
        Queue<dot3> temp = new LinkedList<>();
        qu.add(new dot3(x, y));
        int hap = 0;
        int cnt = 0;
        int nx, ny;
        while (!qu.isEmpty()) {
            dot3 d = qu.poll();
            for(int i = 0; i < 4; i++) {
                nx = d.x + dx[i];
                ny = d.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(Math.abs(map[nx][ny] - map[d.x][d.y]) < L || Math.abs(map[nx][ny] - map[d.x][d.y]) > R) {
                    continue;
                }
                visit[nx][ny] = true;
                cnt++;
                hap += map[nx][ny];
                qu.add(new dot3(nx, ny));
                temp.add(new dot3(nx, ny));
            }
        }
        if(cnt > 1) {
            while (!temp.isEmpty()) {
                dot3 d = temp.poll();
                map[d.x][d.y] = hap/cnt;
            }
        }
    }
}
class dot3 {
    int x;
    int y;
    dot3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
