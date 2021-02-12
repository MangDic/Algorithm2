package Programmers;

import java.util.*;

public class BestAlbum {
    static HashMap<String, Music> map = new HashMap<>();
    public static void main(String[] args) {
        String[] genres = {"classic", "classic", "classic", "pop"};
        int[] plays = {500, 150, 800, 2500};
        int[] a = solution(genres, plays);
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int cnt = 0;
        for(int i = 0; i < genres.length; i++) {
            if(map.containsKey(genres[i])) {
                int firstTemp = map.get(genres[i]).first.value;
                int secondTemp = map.get(genres[i]).second.value;
                int firstIndex = map.get(genres[i]).first.index;
                int secondIndex = map.get(genres[i]).second.index;
                if(firstTemp < plays[i]) {
                    int temp = firstTemp;
                    firstTemp = plays[i];
                    secondTemp = temp;

                    int temp2 = firstIndex;
                    firstIndex = i;
                    secondIndex = temp2;
                }
                else if(secondTemp < plays[i]) {
                    secondTemp = plays[i];
                    secondIndex = i;
                }
                map.put(genres[i], new Music(new Sub(firstIndex, firstTemp), new Sub(secondIndex, secondTemp), map.get(genres[i]).sum + plays[i]));
            }
            else {
                map.put(genres[i], new Music(new Sub(i, plays[i]), new Sub(-1, -1), plays[i]));
                cnt++;
            }
        }
        int[][] list = new int[cnt][5];
        int index = 0;
        int cnt1 = 0;
        for(String i : map.keySet()) {
            list[index][0] = map.get(i).sum;
            list[index][1] = map.get(i).first.value;
            list[index][2] = map.get(i).second.value;
            list[index][3] = map.get(i).first.index;
            list[index][4] = map.get(i).second.index;
            if(list[index][2] == -1) {
                cnt1++;
            }
            else {
                cnt1 += 2;
            }
            index++;
        }
        answer = new int[cnt1];
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        index = 0;
        for(int i = 0; i < cnt; i++) {
            System.out.println(list[i][3]);
            answer[index] = list[i][3];
            index++;
            if(list[i][2] == -1) {
                continue;
            }
            answer[index] = list[i][4];
            System.out.println(list[i][4]);
            index++;
        }
        return answer;
    }
}
class Music {
    Sub first;
    Sub second;
    int sum;
    Music(Sub first, Sub second, int sum) {
        this.first = first;
        this.second = second;
        this.sum = sum;
    }
}
class Sub {
    int index;
    int value;
    Sub(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
