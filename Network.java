package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    static int[][] network;
    static boolean[] visit;
    static int dist = 0;
    static int result = 0;
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n = 3;
        System.out.println(solution(n, a));

    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        dist = computers.length;
        visit = new boolean[computers.length];
        network = new int[dist][dist];
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers.length; j++) {
                network[i][j] = computers[i][j];
            }
        }
        for(int i = 0; i < dist; i++) {
            if(!visit[i]) {
                bfs(i);
                result++;
            }
        }
        answer = result;
        return answer;
    }
    public static void bfs(int x) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(x);
        visit[x] = true;
        while (!qu.isEmpty()) {
            int c = qu.poll();
            for(int i = 0; i < dist; i++) {
                if(i == c) {
                    continue;
                }
                if(network[c][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    qu.add(i);
                }
            }
        }

    }
}
