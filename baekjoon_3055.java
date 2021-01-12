package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_3055 {

    static final int MAX = 100000000;
    static Queue<dot> water = new LinkedList<>();
    static Queue<dot> dochi = new LinkedList<>();
    static int n,m;
    static dot start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        String[][] map = new String[n][m];

        boolean[][] dVisit = new boolean[n][m];
        boolean[][] wVisit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String[] str2 = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = str2[j];
                if(map[i][j].equals("*")) {
                    water.add(new dot(i, j, 0));
                }
                if(map[i][j].equals("S")) {
                    start = new dot(i, j, 0);
                    dochi.add(start);
                }
                if(map[i][j].equals("D")) {
                    end = new dot(i, j, MAX);
                }
            }
        }

        while (!water.isEmpty() || !dochi.isEmpty()) {
            int wSize = water.size();
            int nx, ny;
            for(int j = 0; j < wSize; j++) {
                dot w = water.poll();
                for(int i = 0; i < 4; i++) {
                    nx = w.x + dx[i];
                    ny = w.y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if(wVisit[nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny].equals("*") || map[nx][ny].equals("X")) {
                        continue;
                    }
                    if(map[nx][ny].equals(".")) {
                        wVisit[nx][ny] = true;
                        map[nx][ny] = "*";
                        water.add(new dot(nx, ny, 0));
                    }
                }
            }
            int dSize = dochi.size();
            for(int j = 0; j < dSize; j++) {
                dot d = dochi.poll();
                for(int i = 0; i < 4; i++) {
                    nx = d.x + dx[i];
                    ny = d.y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if(dVisit[nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny].equals("*") || map[nx][ny].equals("X")) {
                        continue;
                    }
                    if(map[nx][ny].equals("D")) {
                        end.dist = Math.min(end.dist, d.dist + 1);
                        continue;
                    }
                    if(map[nx][ny].equals(".")) {
                        dVisit[nx][ny] = true;
                        dochi.add(new dot(nx, ny, d.dist + 1));
                    }
                }
            }

        }
        if(end.dist == MAX) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(end.dist);
        }
    }
}
class dot{
    int x, y, dist;
    dot(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
