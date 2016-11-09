import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by emily on 16/7/9.
 */
public class A_2 {

    public static int bfs(int[][] grid, int r, int c, int rain, int n, int m) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean fill = true;
        int index = 0, ret = 0, high = Integer.MAX_VALUE;
        ArrayList<Node> list = new ArrayList<Node>();
        boolean[][] visit = new boolean[n][m];
        visit[r][c] = true;
        list.add(new Node(r, c, rain));
        while(index < list.size()) {
            Node front = list.get(index++);
            int rr = front.r;
            int cc = front.c;
            for(int i = 0; i < 4; i++) {
                int nr = rr + dir[i][0];
                int nc = cc + dir[i][1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    fill = false;
                    continue;
                }
                if(grid[nr][nc] <= rain) {
                    if(!visit[nr][nc]) {
                        visit[nr][nc] = true;
                        list.add(new Node(nr, nc, grid[nr][nc]));
                    }
                }
                else {
                    high = Math.min(high, grid[nr][nc]);
                }
            }
        }
        if(fill) {
            for(int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                int x = node.r;
                int y = node.c;
                int z = node.rain;
                ret += high - z;
                grid[x][y] = high;
            }
        }
        return ret;

    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt(), m = input.nextInt();
            int[][] grid = new int[n][m];
            PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.rain - o2.rain;
                }
            });
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    grid[i][j] = input.nextInt();
                    pq.add(new Node(i, j, grid[i][j]));
                }
            }
            int ret = 0;

            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int r = node.r;
                int c = node.c;
                int rain = node.rain;
                if(grid[r][c] <= rain) {
                    int tmp = bfs(grid, r, c, rain, n, m);
                    ret += tmp;
                }

            }
            System.out.println(ret);
            output.println(ret);
        }

        input.close();
        output.close();
    }
}
class Node {
    int r, c, rain;
    Node(int r, int c, int rain) {
        this.r = r;
        this.c = c;
        this.rain = rain;
    }
}
