package Programmers;

import java.util.Arrays;

public class KNumber {
    static int[] mainArray;
    static int[] result;
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);

    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        mainArray = new int[array.length];
        result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            mainArray[i] = array[i];
        }
        for(int i = 0; i < commands.length; i++) {
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];
            int cnt = 0;
            System.out.println(commands[i][0] + " " + commands[i][1] + " " + commands[i][2]);
            for(int j = commands[i][0] -1 ; j < commands[i][1]; j++) {
                temp[cnt] = array[j];
                cnt++;
            }
            findKNumber(temp, commands[i][2], i);
        }
        for(int i = 0; i < commands.length; i++) {
            answer[i] = result[i];
        }

        return answer;
    }
    public static void findKNumber(int[] array, int cnt, int index) {
        Arrays.sort(array);
        result[index] = array[cnt-1];

    }
}
