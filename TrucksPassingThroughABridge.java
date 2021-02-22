package Programmers;

public class TrucksPassingThroughABridge {
    public static void main(String[] args) {
        int l = 100;
        int w = 100;
        int[] t = {10,10,10,10,10,10,10,10,10,10};
        solution(l, w, t);
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cnt = truck_weights.length;
        Truck[] trucks = new Truck[truck_weights.length];
        for(int i = 0; i < truck_weights.length; i++) {
            trucks[i] = new Truck(truck_weights[i], 0);
        }
        int left = 0;
        int right = 0;
        int currentWeight = 0;
        int time = 0;
        while (cnt != 0) {
            time++;
            if(right < truck_weights.length) {
                if(currentWeight + trucks[right].weight <= weight) {
                    currentWeight += trucks[right].weight;
                    right++;
                }
            }
            for(int i = left; i < right; i++) {
                trucks[i].dist++;
                if(trucks[i].dist == bridge_length) {
                    cnt--;
                    left++;
                    currentWeight -= trucks[i].weight;
                }
            }
        }
        time++;
        answer = time;
        return answer;
    }
}
class Truck {
    int weight;
    int dist;
    Truck(int weight, int dist) {
        this.weight = weight;
        this.dist = dist;
    }
}
