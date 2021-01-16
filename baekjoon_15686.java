package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon_15686 {
    static int N, M;
    static boolean[] visit;
    static final int MIN = 100000000;
    static int result = MIN;
    static ArrayList<dot> chicken = new ArrayList<>();
    static ArrayList<dot> house = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int t = Integer.parseInt(str[j]);
                if(t == 2) {
                    chicken.add(new dot(i, j));
                }
                if(t == 1) {
                    house.add(new dot(i, j));
                }
            }
        }

        visit = new boolean[chicken.size()];
        for(int i = 0; i < chicken.size(); i++) {
            visit[i] = true;
            select(i, 0);
            visit[i] = false;
        }
        System.out.println(result);
    }

    public static void select(int start, int dist) {
        if(dist == M - 1) {
            int hap = 0;
            for(int i = 0; i < house.size(); i++) {
                int minDis = MIN;
                for(int j = 0; j < chicken.size(); j++) {
                    if(visit[j]) {
                        int t = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        minDis = Math.min(minDis, t);

                    }
                }
                hap += minDis;
                if(hap >= result) {
                    return;
                }
            }
            result = Math.min(result, hap);
        }
        else {
            for(int i = start; i < chicken.size(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    select(i + 1, dist + 1);
                    visit[i] = false;
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
