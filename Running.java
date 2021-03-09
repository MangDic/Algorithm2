package Programmers;

import java.util.HashMap;

public class Running {

    public static void main(String[] args) {
        String[] participant = {"a", "a", "a", "b", "b", "b", "c"};
        String[] completion = {"a", "a", "b", "b", "a", "b"};
        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> players = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            int cnt = 1;
            if(players.containsKey(participant[i])) {
                cnt = players.get(participant[i]) + 1;
            }
            players.put(participant[i], cnt);
        }


        for(int i = 0; i < completion.length; i++) {
            int cnt = 0;
            if(players.get(completion[i]) != 1) {
                cnt = players.get(completion[i]) - 1;
                players.put(completion[i], cnt);
            }
            else {
                players.remove(completion[i]);
            }
        }

        for(String a : players.keySet()) {
            answer = a;
        }
        return answer;
    }
}
