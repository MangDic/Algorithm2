package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_3184 {
    static int N, M;
    static int cntO = 0;
    static int cntV = 0;
    static int tempO = 0;
    static int tempV = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static String[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new String[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] str2 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = str2[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("#")) {
                    continue;
                }
                if (!visit[i][j]) {
                    bfs(i, j);
                    if (tempO > tempV) {
                        cntO += tempO;
                    } else {
                        cntV += tempV;
                    }
                    tempO = 0;
                    tempV = 0;
                }
            }
        }
        System.out.println(cntO + " " + cntV);

    }

    static public void bfs(int x, int y) {
        Queue<dot> qu = new LinkedList();
        qu.add(new dot(x, y));
        visit[x][y] = true;
        int nx, ny;
        while (!qu.isEmpty()) {
            dot d = qu.poll();
            if(map[d.x][d.y].equals("o")) {
                tempO ++;
            }
            else if(map[d.x][d.y].equals("v")) {
                tempV ++;
            }
            for(int i = 0; i < 4; i++) {
                nx = d.x + dx[i];
                ny = d.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny].equals("#")) {
                    continue;
                }

                visit[nx][ny] = true;
                qu.add(new dot(nx, ny));
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
