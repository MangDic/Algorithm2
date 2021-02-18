package Programmers;

import java.util.HashMap;

public class FindDecimalNumber {
    static int baseDist = 0;
    static int numberCount;
    static String baseNumber = "";
    static boolean[] visit;
    static HashMap<Integer, Boolean> checkNumbers = new HashMap<>();
    static int result = 0;
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));

    }
    public static int solution(String numbers) {
        int answer = 0;
        baseNumber = numbers;
        numberCount = numbers.length();
        for(int i = 1; i <= numbers.length(); i++) {
            baseDist = i;
            visit = new boolean[numbers.length()];
            dfs(0, 0, "");
        }
        answer = result;
        return answer;
    }
    public static void dfs(int a, int dist, String str) {
        if(dist == baseDist) {
            check(str);
        }
        else {
            for(int i = 0; i < numberCount; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    dfs(i, dist + 1, baseNumber.substring(i, i+1) + "" + str);
                    visit[i] = false;
                }
            }
        }
    }

    public static boolean check(String number) {
        int numberDist = 1;
        double num = 0;
        for(int i = number.length()-1; i >= 0; i--) {
            num = num + Integer.parseInt(number.substring(i, i+1))*Math.pow(10, numberDist-1);
            numberDist++;
        }
        int numValue = Integer.parseInt(String.valueOf(Math.round(num)));
        if(checkNumbers.containsKey(numValue)) {
            return false;
        }
        checkNumbers.put(numValue, true);
        int cnt = 0;
        for(int i = 1; i <= numValue; i++) {
            if(numValue%i == 0) {
                cnt ++;
            }
            if(cnt > 2) {
                break;
            }
        }
        if(cnt == 2) {
            result++;
            return true;
        }
        return false;
    }
}
