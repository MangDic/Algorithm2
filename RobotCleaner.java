package Programmers;

public class RobotCleaner {

    static int cuerrentDirection = 0;
    static int currentX = 0;
    static int currentY = 0;
    static int maxR = 0;
    static int maxC = 0;
    static int result = 0;
    static int[][] map;

    public static void main(String[] args) {
        int[][] office = {{5, -1, 4},
                {6, 3, -1},
                {2, -1, 1}};
        int r = 1;
        int c = 0;
        currentX = r;
        currentY = c;
        maxR = maxC = office.length;

        String[] move = {"go", "go", "right", "go", "right", "go", "left", "go"};
        System.out.println(solution(office, r, c, move));
    }

    public static int solution(int[][] office, int r, int c, String[] move) {

        int index = 0;

        map = new int[maxR][maxC];

        for(int i = 0; i < maxR; i++) {
            for(int j = 0; j < maxC; j++) {
                map[i][j] = office[i][j];
            }
        }

        for(int i = 0; i <= move.length; i++) {
            result += map[currentX][currentY];
            map[currentX][currentY] = 0;

            if(i== move.length) {
                break;
            }

            switch (move[i]) {
                case "go" :
                    setDirection();
                    break;
                case "right" :
                    cuerrentDirection += 1;
                    if(cuerrentDirection == 4) {
                        cuerrentDirection = 0;
                    }
                    break;
                case "left" :
                    cuerrentDirection -= 1;
                    if(cuerrentDirection == -1) {
                        cuerrentDirection = 3;
                    }
                    break;
            }

        }
        return result;
    }

    public static void setDirection() {
        switch (cuerrentDirection) {
            case 0:
                move(-1, 0);
                break;
            case 1:
                move(0, 1);
                break;
            case 2:
                move(1, 0);
                break;
            case 3:
                move(0 , -1);
                break;
        }
    }

    public static void move(int dx, int dy) {
        int nx = currentX + dx;
        int ny = currentY + dy;
        if(nx < 0 || nx >= maxR || ny < 0 || ny >= maxC) {
            return;
        }
        if(map[nx][ny] == -1) {
            return;
        }
        currentX = nx;
        currentY = ny;
    }
}
