package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class WordChange {
    static boolean[] visit;
    static String[] copyWord;
    static int dist;
    static int wordSize;
    static int result = 0;
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        String begin = "hit";
        String target = "cog";
        System.out.println(solution(begin, target, words));
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        wordSize = begin.length();
        dist = words.length;
        visit = new boolean[dist];
        copyWord = new String[dist];
        for(int i = 0; i < dist; i++) {
            copyWord[i] = words[i];
        }
        bfs(begin, target);
        answer = result;
        return answer;
    }
    public static void bfs(String begin, String target) {
        Queue<Word> qu = new LinkedList<>();
        qu.add(new Word(begin, 0));
        while (!qu.isEmpty()) {
            Word temp = qu.poll();
            if(temp.str.equals(target)) {
                if(result == 0) {
                    result = temp.count;
                }
                else {
                    result = Math.min(result, temp.count);
                }
                break;
            }
            for(int i = 0; i < dist; i++) {
                if(!visit[i] && check(temp.str, copyWord[i])) {
                    visit[i] = true;
                    qu.add(new Word(copyWord[i], temp.count + 1));
                }
            }
        }
    }
    public static boolean check(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < wordSize; i++) {
            if (a.substring(i, i+1).equals(b.substring(i, i+1))) {
                cnt++;
            }
        }
        if(cnt == wordSize - 1) {
            return true;
        }
        return false;
    }
}
class Word {
    String str;
    int count;
    Word(String str, int count) {
        this.str = str;
        this.count = count;
    }
}
