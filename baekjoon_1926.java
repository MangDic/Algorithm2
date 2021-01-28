package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_1926 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int result = 0;
    static int pictureCnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    pictureCnt ++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(pictureCnt);
        System.out.println(result);
    }
    public static void dfs(int x, int y) {
        Queue<picture> qu = new LinkedList<>();
        qu.add(new picture(x, y));
        visit[x][y] = true;
        int cnt = 0;
        while (!qu.isEmpty()) {
            picture p = qu.poll();
            int nx, ny;
            cnt ++;
            for(int i = 0; i < 4; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    qu.add(new picture(nx, ny));
                }
            }
        }
        result = Math.max(result, cnt);
    }
}
class picture {
    int x;
    int y;
    picture(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
