package Programmers;

import java.util.LinkedList;
import java.util.Queue;

class kaka {

    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] map;
    static int maxSizeOfOneArea;

    public static void main(String[] args) {
        int[][] pic = {{1, 1, 1, 1},{2, 2, 2, 2},{2, 2, 2, 2},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0} };
        solution(6,4,pic);
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;
        N = m;
        M = n;
        map = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = picture[i][j];
            }
        }

        visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    find(i, j, picture[i][j]);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
    public static void find(int x, int y, int color) {
        Queue<Dot> qu = new LinkedList();
        qu.add(new Dot(x, y));
        visit[x][y] = true;
        int cnt = 0;
        while(!qu.isEmpty()) {
            int nx, ny;
            Dot d = qu.poll();
            cnt++;
            for(int i = 0; i < 4; i++) {
                nx = d.x + dx[i];
                ny = d.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] != color) {
                    continue;
                }
                visit[nx][ny] = true;
                qu.add(new Dot(nx, ny));
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}
class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
