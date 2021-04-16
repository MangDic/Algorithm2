package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2210 {
    static int[][] map = new int[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static HashMap<String, String> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }
        System.out.println(hashMap.size());
    }

    public static void bfs(int x, int y) {
        Queue<Jump> qu = new LinkedList();
        qu.add(new Jump(x, y, 1, map[x][y] + ""));
        while (!qu.isEmpty()) {
            int nx, ny;
            Jump j = qu.poll();
            if(j.dist == 6) {
                hashMap.put(j.str, j.str);
                continue;
            }
            for(int i = 0; i < 4; i++) {
                nx = j.x + dx[i];
                ny = j.y + dy[i];
                if(nx >= 5 || nx < 0 || ny >= 5 || ny < 0) {
                    continue;
                }
                qu.add(new Jump(nx, ny, j.dist + 1, j.str + map[nx][ny]));
            }
        }
    }
}
class Jump {
    int x;
    int y;
    int dist;
    String str;
    Jump(int x, int y, int dist, String str) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.str = str;
    }
}