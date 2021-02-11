package Programmers;

import java.util.HashMap;

public class NumberList {
    static HashMap<String, Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        String[] n1 = {"119", "97674223", "1195524421"};
        String[] n2 = {"123", "456", "789"};
        String[] n3 = {"12", "123", "1235", "567", "88"};

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));


    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], true);
        }
        for(int i = 0; i < phone_book.length; i++) {
            if(!checkNumber(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
    public static boolean checkNumber(String number) {
        for(String i : map.keySet()) {
            int size = 0;
            if(number.length() >= i.length()) {
                size = i.length();
            }
            else {
                size = number.length();
            }
            int cnt = 0;
            for(int j = 0; j < size; j++) {
                if(i.equals(number)) {
                    continue;
                }
                if(i.substring(j, j+1).equals(number.substring(j, j + 1))) {
                    cnt++;
                }
            }
            if(cnt == size) {
                return false;
            }
        }
        return true;
    }
}
