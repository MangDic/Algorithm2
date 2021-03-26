package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int baseNumbers[] = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            baseNumbers[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(baseNumbers);
        int m = Integer.parseInt(br.readLine());
        int targetNumbers[] = new int[m];
        str = br.readLine().split(" ");
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            targetNumbers[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if(targetNumbers[i] < baseNumbers[mid]) {
                    right = mid - 1;

                }
                else if(targetNumbers[i] > baseNumbers[mid]){
                    left = mid + 1;
                }
                else {
                    result[i] = 1;
                    break;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }
    }
}
