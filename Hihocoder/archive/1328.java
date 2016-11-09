import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int bfs(char[][] grid, int[] keyx, int[] keyy, int a, int b, int c, int d, int k, int n, int m) {
        boolean[][][] visit = new boolean[n][m][1 << k];
        Queue<Node> q = new LinkedList<Node>();
        int s = 0;
        for(int i = 0; i < k; i++) {
            if(a == keyx[i] && b == keyy[i]) {
                s |= (1 << i);
                break;
            }
        }
        visit[a][b][s] = true;
        q.add(new Node(a, b, s));
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ret = 0;
        while(!q.isEmpty()) {
            for(int t = q.size(); t > 0; t--) {
                Node cur = q.poll();
                if(cur.x == c && cur.y == d) {
                    return ret;
                }
//                System.out.println("cur: " + cur.x + " " + cur.y + " " + cur.status);
                for(int i = 0; i < 4; i++) {
                    int nx = cur.x + dir[i][0];
                    int ny = cur.y + dir[i][1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] != '#') {
                        int status = cur.status;
                        for(int j = 0; j < k; j++) {
                            if(nx == keyx[j] && ny == keyy[j]) {
                                status |= (1 << j);
                                break;
                            }
                        }
//                        if(nx == 0 && ny == 3)
//                            System.out.println("tag");
                        int tmp = (1 << (grid[nx][ny] - 'A'));
                        if(grid[nx][ny] == '.' || (status & tmp) != 0) {
                            if(!visit[nx][ny][status]) {
//                                System.out.println("new : x = " + nx + " y = " + ny + " s = " + status);
                                visit[nx][ny][status] = true;
                                q.add(new Node(nx, ny, status));
                            }
                        }
                    }
                }
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), k = input.nextInt(), a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), d = input.nextInt();
        char[][] grid = new char[n][m];
        int[] keyx = new int[k], keyy = new int[k], lockx = new int[k], locky = new int[k];
        for(int i = 0; i < n; i++) {
            String line = input.next();
            for(int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if(grid[i][j] != '.' && grid[i][j] != '#') {
                    lockx[grid[i][j] - 'A'] = i;
                    locky[grid[i][j] - 'A'] = j;
                }
            }
        }
        for(int i = 0; i < k; i++) {
            keyx[i] = input.nextInt();
            keyy[i] = input.nextInt();
        }
        int ret = bfs(grid, keyx, keyy, a, b, c, d, k, n, m);
        System.out.println(ret);
    }

}
class Node {
    int x, y, status;
    Node(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }
}


