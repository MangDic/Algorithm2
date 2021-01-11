package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_4485 {
    static int[][] map;
    static int[][] lost;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            map = new int[N][N];
            lost = new int[N][N];
            for (int i = 0 ; i < N; i++) {
                String[] str = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    lost[i][j] = 10000000;
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
            lost[0][0] = map[0][0];
            dijkstra(0, 0);
            System.out.println("Problem " + cnt + ": " + lost[N-1][N-1]);
            cnt++;
        }
    }

    public static void dijkstra(int x, int y) {
        Queue<dot> qu = new LinkedList();
        qu.add(new dot(x, y));
        int nx, ny;
        while (!qu.isEmpty()) {
            dot d = qu.poll();
            for(int i = 0; i < 4; i++) {
                nx = d.x + dx[i];
                ny = d.y + dy[i];
                if(nx >= N || nx < 0 || ny >= N || ny < 0) {
                    continue;
                }
                if(lost[nx][ny] > lost[d.x][d.y] + map[nx][ny]) {
                    lost[nx][ny] = lost[d.x][d.y] + map[nx][ny];
                    qu.add(new dot(nx, ny));
                }
            }
        }
    }
}

class dot {
    int x;
    int y;
    dot(int x, int y) {
       this.x = x;
       this.y = y;
    }
}