package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2217 {
    static int[] lopes;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lopes = new int[n];
        for(int i = 0; i < n; i++) {
            lopes[i] = sc.nextInt();
        }
        Arrays.sort(lopes);

        int weight = 100001;
        int cnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            cnt++;
            weight = Math.min(lopes[i], weight);
            result = Math.max(result, weight*cnt);

        }
        System.out.println(result);
    }
}

