package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        solution(numbers, target);
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Nums> qu = new LinkedList<>();
        qu.add(new Nums(numbers[0], 1));
        qu.add(new Nums(-numbers[0], 1));
        while (!qu.isEmpty()) {
            Nums n = qu.poll();
            if(n.dist == numbers.length) {
                if(n.sum == target) {
                    answer++;
                }
            }
            else {
                qu.add(new Nums(n.sum + numbers[n.dist], n.dist+1));
                qu.add(new Nums(n.sum - numbers[n.dist], n.dist+1));
            }
        }
        return answer;
    }
}
class Nums {
    int sum;
    int dist;
    Nums(int sum, int dist) {
        this.sum = sum;
        this.dist = dist;
    }
}