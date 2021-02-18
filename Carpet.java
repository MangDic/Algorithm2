package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Carpet {
    static Queue<size> dividedYellow = new LinkedList<>();
    static int yellowCount;
    static int brownCount;
    static size result;
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.print(solution(brown, yellow)[0] + " ");
        System.out.println(solution(brown, yellow)[1]);
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        yellowCount = yellow;
        brownCount = brown;
        divideYellow();
        while (!dividedYellow.isEmpty()) {
            matchBrown(dividedYellow.poll());
        }
        answer[0] = result.x;
        answer[1] = result.y;
        return answer;
    }
    public static void divideYellow() {
        for(int i = 1; i <= yellowCount; i++) {
            if(yellowCount%i == 0) {
                if(yellowCount/i >= i) {
                    dividedYellow.add(new size(yellowCount / i, i));
                }
            }
        }
    }
    public static void matchBrown(size s) {
        int x = s.x + 2;
        int y = s.y + 2;
        if(x*y == yellowCount + brownCount) {
            result = new size(x, y);
        }
    }
}
class size {
    int x;
    int y;
    size(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
