package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static Queue<shore> startPoint = new LinkedList<>();
    static int shoreNumber = 1;
    static int min = 100000000;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    continue;
                }
                if(!visit[i][j]) {
                    devide(i, j);
                    shoreNumber++;
                }
            }
        }
        while (!startPoint.isEmpty()) {
            visit = new boolean[N][N];
            shore s = startPoint.poll();
            bfs(s.x, s.y, map[s.x][s.y]);
        }
        System.out.println(min);

    }
    public static void bfs(int x, int y, int num) {
        Queue<shore> qu = new LinkedList<>();
        qu.add(new shore(x, y, 0));
        visit[x][y] = true;
        while (!qu.isEmpty()) {
            shore s = qu.poll();
            if(s.dist > min) {
                continue;
            }
            int nx, ny;
            for(int i = 0; i < 4; i++) {
                nx = s.x + dx[i];
                ny = s.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    qu.add(new shore(nx, ny, s.dist + 1));
                }
                else if(map[nx][ny] != num) {
                    min = Math.min(s.dist, min);
                }
            }
        }
    }
    public static void devide(int x, int y) {
        Queue<shore> qu = new LinkedList<>();
        qu.add(new shore(x, y, 0));
        visit[x][y] = true;
        map[x][y] = shoreNumber;
        while (!qu.isEmpty()) {
            shore s = qu.poll();
            int nx, ny;
            for(int i = 0; i < 4; i++) {
                nx = s.x + dx[i];
                ny = s.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 0) {
                    startPoint.add(new shore(s.x, s.y, 0));
                    continue;
                }
                visit[nx][ny] = true;
                qu.add(new shore(nx, ny, 0));
                map[nx][ny] = shoreNumber;
            }
        }
    }
}
class shore{
    int x;
    int y;
    int dist;
    shore(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
