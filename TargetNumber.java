package Programmers;

public class TargetNumber {

    static boolean[] visit;
    static int[] numberClone;
    static int baseDist;
    static int baseSum;
    static int result = 0;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        baseDist = numbers.length;
        visit = new boolean[baseDist];
        numberClone = new int[baseDist];
        baseSum = target;
        numberClone = numbers;
        dfs(0, 0, 0);
        answer = result;
        return answer;
    }

    public static void dfs(int dist, int cur, int sum) {
        if(dist == baseDist) {
            if(sum == baseSum) {
                result++;
            }
        }
        else {
            for(int i = cur; i < baseDist; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    for(int j = 0; j < 2; j++) {
                        int signTemp = numberClone[i];
                        if(j == 1) {
                            signTemp = -numberClone[i];
                        }
                        dfs(dist + 1, i, sum + signTemp);
                    }
                    visit[i] = false;
                }
            }
        }
    }
}
