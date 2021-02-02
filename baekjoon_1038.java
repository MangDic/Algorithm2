package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1038 {
    static int N;
    static int count = -1;
    static int baseDist = 0;
    static int[] used;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        used = new int[10];
        if(N > 1022) {
            System.out.println(-1);
        }
        else {
            for(int i = 0; i < 10; i++) {
                baseDist = i + 1;
                chk(10, 0, "");
            }
        }
    }

    static void chk(int crt, int dist, String str) {
        if(isFind) {
            return;
        }
        if(dist == baseDist) {
            count++;
            if(count == N) {
                System.out.println(str);
                isFind = true;
                return;
            }
            //System.out.println(str + " count : " + count);
            return;
        }
        else {
            for (int i = 0; i <= 9; i++){
                if(used[i] == 0 && i < crt) {
                    used[i] = 1;
                    chk(i, dist + 1, str + "" + i);
                    used[i] = 0;
                }
            }
        }

    }
}

