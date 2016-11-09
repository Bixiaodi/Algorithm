import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), x = input.nextInt(), y = input.nextInt();
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = input.nextInt();
            }
        }
        boolean[][] visit = new boolean[n][m];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        int cnt = 1;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == map[x][y] && !visit[nx][ny]) {
                    cnt++;
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        int repeat = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m - 1; j++) {
                if(visit[i][j] && visit[i][j + 1])
                    repeat++;
            }
        }
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n - 1; i++) {
                if(visit[i][j] && visit[i + 1][j])
                    repeat++;
            }
        }
        System.out.println(cnt * 4 - repeat * 2);
    }
}
class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}