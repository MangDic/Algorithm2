package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_5427 {
    static int N, M;
    static String[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<dot2> person;
    static Queue<dot2> fire;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);

            cnt = 100000000;
            person = new LinkedList<>();
            fire = new LinkedList<>();
            map = new String[N][M];
            visit = new boolean[N][M];

            for(int j = 0; j < N; j++) {
                String[] str2 = br.readLine().split("");
                for(int k = 0; k < M; k++) {
                    if(str2[k].equals("@")) {
                        person.add(new dot2(j, k, 0));
                    }
                    else if (str2[k].equals("*")) {
                        fire.add(new dot2(j, k, 0));
                    }
                    map[j][k] = str2[k];
                }
            }

            dot2 d = person.peek();
            bfs(d.x, d.y);
            if(cnt == 100000000) {
                System.out.println("IMPOSSIBLE");
            }
            else {
                System.out.println(cnt);
            }

        }
    }

    public static void bfs(int x, int y) {
        int nx, ny;
        visit[x][y] = true;
        while (!person.isEmpty() || !fire.isEmpty()) {
            int fSize = fire.size();
            for(int j = 0; j < fSize; j++) {
                dot2 f = fire.poll();
                for(int i = 0; i < 4; i++) {
                    nx = f.x + dx[i];
                    ny = f.y + dy[i];
                    if(nx >= N || nx < 0 || ny >= M || ny < 0) {
                        continue;
                    }
                    if(map[nx][ny].equals(".")) {
                        map[nx][ny] = "*";
                        fire.add(new dot2(nx, ny, 0));
                    }
                }
            }
            int pSize = person.size();
            for (int j = 0; j < pSize; j++) {
                dot2 p = person.poll();
                for(int i = 0; i < 4; i ++) {
                    if(p.x == 0 || p.x == N-1 || p.y == 0 || p.y == M-1) {
                        cnt = Math.min(cnt, p.cnt + 1);
                    }
                    nx = p.x + dx[i];
                    ny = p.y + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >=M) {
                        continue;
                    }
                    if(visit[nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny].equals(".")) {
                        visit[nx][ny] = true;
                        map[p.x][p.y] = ".";
                        map[nx][ny] = "@";
                        person.add(new dot2(nx, ny, p.cnt + 1));

                    }
                }

            }

        }
    }



}

class dot2 {
    int x;
    int y;
    int cnt;
    dot2(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
