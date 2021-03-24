package DP;

import java.util.Scanner;

public class Add123 {
    static int[] targets;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        targets = new int[n];
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < n; i++) {
            targets[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[targets[i]]);
        }

    }
}
