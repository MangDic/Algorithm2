package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {

    public static void main(String[] args) {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] spped = {1, 1, 1, 1, 1, 1};
        solution(progress, spped);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<progress> progressesQueue = new LinkedList<>();
        Queue<Integer> resultQueue = new LinkedList<>();
        progress[] pr = new progress[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            pr[i] = new progress(progresses[i], speeds[i], false);
            progressesQueue.add(new progress(progresses[i], speeds[i], false));
        }
        int count = progresses.length;
        int index = 0;
        int result = 0;
        while (!progressesQueue.isEmpty()) {
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            if(progresses[index] >= 100) {
                result++;
                for(int i = index; i < progresses.length; i++) {
                    if(i - index <= 1 && progresses[i] >= 100) {
                        index++;
                        count++;
                        progressesQueue.poll();
                    }
                    else {
                        break;
                    }
                }
                resultQueue.add(count);
            }
            count = 0;

        }
        answer = new int[result];
        index = 0;
        while (!resultQueue.isEmpty()) {
            answer[index] = resultQueue.poll();
            index++;
        }
        return answer;
    }

}
class progress {
    int percent;
    int speed;
    boolean isFinish;
    progress(int percent, int speed, boolean isFinish) {
        this.percent = percent;
        this.speed = speed;
        this.isFinish = isFinish;
    }
}
