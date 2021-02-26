package Programmers;

import java.util.*;

public class TripRoute {
    static Queue<Trip> ticket = new LinkedList<>();
    static int totalCount;
    static boolean[] visit;
    static ArrayList<String> list = new ArrayList<>();
    static String[][] copyTickets;
    public static void main(String[] args) {
        // {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        totalCount = tickets.length;
        answer = new String[totalCount + 1];
        copyTickets = new String[totalCount][2];

        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                ticket.add(new Trip(tickets[i][0],tickets[i][1], i));
            }
            copyTickets[i][0] = tickets[i][0];
            copyTickets[i][1] = tickets[i][1];
        }
        while (!ticket.isEmpty()) {
            visit = new boolean[totalCount];
            Trip t = ticket.poll();
            visit[t.index] = true;
            dfs(1, t.index, t.end, "ICN");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] temp = list.get(0).split(" ");
        for(int i = 0; i <= totalCount; i++) {
            answer[i] = temp[i];
        }
        return answer;
    }
    public static void dfs(int dist, int current, String end, String str) {
       if(dist == totalCount) {
           for(int i = 0; i < totalCount; i++) {
               if(!visit[i]) {
                   return;
               }
           }
           list.add(str);
       }
       else {
           for(int i = 0; i < totalCount; i++) {
               if(i == current) {
                   continue;
               }
               if(!visit[i]) {
                   if(copyTickets[i][0].equals(end)) {
                       visit[i] = true;
                       if(dist == totalCount - 1) {
                           dfs(dist + 1, i, copyTickets[i][1], str + " " + end + " " + copyTickets[i][1]);
                       }
                       else {
                           dfs(dist + 1, i, copyTickets[i][1], str + " " + end);
                       }
                       visit[i] = false;
                   }
               }
           }
       }
    }
}
class Trip{
    String start;
    String end;
    int index;
    Trip(String start, String end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}