package Programmers;

import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 5, 10, 15, 20};
        solution(numbers);
    }
    public static String solution(int[] numbers) {
        String answer = "";
        int maxDist = 0;
        List<number> list = new ArrayList<>();
        number[] getNumber = new number[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            int dist = 0;
            int temp = numbers[i];
            while (temp > 0) {
                temp = temp / 10;
                dist++;
            }
            getNumber[i] = new number(numbers[i], dist, 0);
            maxDist = Math.max(maxDist, dist);
        }
        for(int i = 0; i < numbers.length; i++) {
            long distValue = numbers[i];
            if(getNumber[i].dist < maxDist) {
                for (int j = 0; j < maxDist - getNumber[i].dist; j++) {
                    distValue = distValue * 10;
                }
            }
            list.add(new number(numbers[i], getNumber[i].dist, distValue));
        }
        Collections.sort(list, new Comparator<number>() {
            public int compare(number o1, number o2) {
                String t1 = String.valueOf(o1.value);
                String t2 = String.valueOf(o2.value);
                // 케이스를 3개로 분리하지 않으면 에러 발생... ㅠㅠ
                if(Long.parseLong(t1 + t2) > Long.parseLong(t2 + t1)) {
                    return -1;
                }
                else if(Long.parseLong(t1 + t2) < Long.parseLong(t2 + t1)) {
                    return 1;
                }
                return 0;
            }
        });
        String result = "";
        for(int i = 0; i < numbers.length; i++) {
            result += list.get(i).value + "";
        }
        answer = result;
        if(answer.substring(0, 1).equals("0")) {
            answer = "0";
        }
        System.out.println(answer);
        return answer;
    }
}
class number {
    int value;
    int dist;
    long strValue;
    number(int value, int dist, long strValue) {
        this.value = value;
        this.dist = dist;
        this.strValue = strValue;
    }
}
