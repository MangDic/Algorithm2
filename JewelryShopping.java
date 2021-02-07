package Programmers;

import java.util.HashMap;

public class JewelryShopping {
    public static void main(String[] args) {
        String[] j = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE"};
        int[] result = new int[2];
        result = solution(j);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
    public static int[] solution(String[] gems) {
        int[] answer = {};
        answer = new int[2];
        HashMap<String, String> jewelry = new HashMap<>();
        for(String i : gems) {
            jewelry.put(i, i);
        }
        int jewelryCount = 0;
        for(String i : jewelry.keySet()) {
            jewelryCount ++;
        }
        int left = 0;
        int cnt = 1;
        int right = 0;
        int min = 100001;

        while (true) {
            if(right >= gems.length) {
                if(left == gems.length - 1) {
                    break;
                }
                left++;
                right = left + 1;
                cnt = 1;
            }
            if(left == gems.length-1) {
                break;
            }
            System.out.println("left : " + (left + 1) + " right : " + (right + 1) + " cnt : " + cnt);
            if(cnt == jewelryCount) {
                System.out.println("dist : " + Math.abs(right-left));
                if(min > Math.abs(right-left)) {
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                    min = Math.abs(right-left);
                    System.out.println("l : " + answer[0] + " r : " + answer[1]);
                }
                left++;
                right = left + 1;
                cnt = 1;
                continue;
            }
            String startJewelry = gems[left];
            if(!startJewelry.equals(gems[right])) {
                cnt++;
            }
            right++;

        }
        return answer;
    }
}
