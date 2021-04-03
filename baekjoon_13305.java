package Greedy;

import java.util.Scanner;

public class baekjoon_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dists = new int[n - 1];
        int[] cities = new int[n];
        for(int i = 0; i < n - 1; i++) {
            dists[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            cities[i] = sc.nextInt();
        }
        int min = cities[0];
        int result = 0;
        for(int i = 0; i < n-1; i++) {
            min = Math.min(min, cities[i]);
            result += min*dists[i];
            System.out.println("i : " + i + " min : " + min + " result : " + result);

        }
        System.out.println(result);
    }
}
