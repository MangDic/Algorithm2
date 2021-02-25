package Programmers;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        solution(citations);
    }
    // n편 중 h번 이상 인용된 논문이 h편 이상 / 나머지 논문이 h번 이하 인용 / 22 24
    public static int solution(int[] citations) {
        int answer = 0;
        int index = 0;
        while (index <= citations.length) {
            int count = 0;
            boolean[] isCheck = new boolean[citations.length];
            for(int i = 0; i < citations.length; i++) {
                if(citations[i] >= index) {
                    count++;
                    isCheck[i] = true;
                }
            }
            int elseCount = 0;
            for(int i = 0; i < citations.length; i++) {
                if(!isCheck[i] && citations[i] <= index) {
                    elseCount++;
                }
            }
            if(index <= count && elseCount == citations.length - count) {
                answer = Math.max(answer, index);
            }
            index++;
        }
        System.out.println(answer);
        return answer;
    }
}
