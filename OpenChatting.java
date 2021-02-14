package Programmers;

import java.util.HashMap;

public class OpenChatting {
    public static void main(String[] args) {
        String[] log = {"Enter uid0606 Gimoi", "Enter uid4567 Prodo", "Leave uid0606", "Enter uid1234 Prodo", "Change uid1234 OhYeah"};
        String[] answer = Solution(log);
        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static String[] Solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> userCheck = new HashMap<>();
        int index = record.length;

        for(String s : record) {
            String[] temp = s.split(" ");
            if (temp[0].equals("Enter")) {
                userCheck.put(temp[1], temp[2]);
            }
            else if (temp[0].equals("Change")) {
                userCheck.put(temp[1], temp[2]);
                index--;
            }
        }
        answer = new String[index];
        int cnt = 0;
        for(String user : record) {
            String[] temp = user.split(" ");
            if(temp[0].equals("Enter")) {
                answer[cnt] = userCheck.get(temp[1]) + "님이 들어왔습니다.";
            }
            else if(temp[0].equals("Leave")) {
                answer[cnt] = userCheck.get(temp[1]) + "님이 나갔습니다.";
            }
            cnt++;
        }
        return answer;
    }
}
