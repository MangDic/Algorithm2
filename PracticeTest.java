package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PracticeTest {
    static int[] student1 = {1,2,3,4,5};
    static int[] student2 = {2,1,2,3,2,4,2,5};
    static int[] student3 = {3,3,1,1,2,2,4,4,5,5};
    static int[] copyAnswer;
    static int max = -1;
    static HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        solution(answer);
    }
    public static int[] solution(int[] answers) {
        int[] answer = {};
        copyAnswer = new int[answers.length];
        for(int i = 0; i < answers.length; i++) {
            copyAnswer[i] = answers[i];
        }
        checkAnswer(student1, 1);
        checkAnswer(student2, 2);
        checkAnswer(student3, 3);
        int count = hashMap.get(max).size();
        answer = new int[count];
        for(int i = 0 ; i < count; i++) {
            answer[i] = hashMap.get(max).get(i);
        }
        return answer;
    }
    public static void checkAnswer(int[] student, int index) {
        int cnt = 0;
        for(int i = 0; i < copyAnswer.length; i++) {
            if(copyAnswer[i] == student[i% student.length]) {
                cnt++;
            }
        }
        max = Math.max(max, cnt);
        if(hashMap.containsKey(cnt)) {
            hashMap.get(cnt).add(index);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(index);
            hashMap.put(cnt, list);
        }
    }
}
