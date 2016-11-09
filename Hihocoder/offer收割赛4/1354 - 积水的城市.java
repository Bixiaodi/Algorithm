import java.io.*;
import java.util.*;

public class Main {
    private static int inf = (int)(2.5e6) + 1;
    public static int bfs(int i, int j, int p, int q, int[] A, int[] B, HashSet<String> water, int m, int n) {
        boolean[][] visit = new boolean[n + 1][m + 1];
        int[][] dis = new int[n + 1][m + 1];
        for(int k = 1; k <= n; k++) {
            Arrays.fill(dis[k], inf);
        }
        dis[i][j] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(250000, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.dis - n2.dis;
            }
        });
        pq.add(new Node(i, j, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, y = cur.y, d = cur.dis;
            if(visit[x][y]) {
                continue;
            }
            visit[x][y] = true;
            if(water.contains(x + " " + y)) {
                continue;
            }
            if(x == p && y == q) {
                break;
            }
            if(x > 1) {
                if(dis[x - 1][y] > dis[x][y] + B[x - 1]) {
                    dis[x - 1][y] = dis[x][y] + B[x - 1];
                    pq.add(new Node(x - 1, y, dis[x - 1][y]));
                }
            }
            if(y > 1) {
                if(dis[x][y - 1] > dis[x][y] + A[y - 1]) {
                    dis[x][y - 1] = dis[x][y] + A[y - 1];
                    pq.add(new Node(x, y - 1, dis[x][y - 1]));
                }
            }
            if(x < n) {
                if(dis[x + 1][y] > dis[x][y] + B[x]) {
                    dis[x + 1][y] = dis[x][y] + B[x];
                    pq.add(new Node(x + 1, y, dis[x + 1][y]));
                }
            }
            if(y < m) {
                if(dis[x][y + 1] > dis[x][y] + A[y]) {
                    dis[x][y + 1] = dis[x][y] + A[y];
                    pq.add(new Node(x, y + 1, dis[x][y + 1]));
                }
            }
        }
        if(dis[p][q] != inf) {
            return dis[p][q];
        }
        else {
            return -1;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] B = new int[n], A = new int[m];
        for(int i = 1; i < n; i++) {
            B[i] = input.nextInt();
        }
        for(int i = 1; i < m; i++) {
            A[i] = input.nextInt();
        }
        int k = input.nextInt();
        HashSet<String> water = new HashSet<String>();
        for(int i = 0; i < k; i++) {
            water.add(input.nextInt() + " " + input.nextInt());
        }
        int Q = input.nextInt();
        for(int i = 0; i < Q; i++) {
            int x = input.nextInt(), y = input.nextInt(), p = input.nextInt(), q = input.nextInt();
            System.out.println(bfs(x, y, p, q, A, B, water, m, n));
        }
    }
}

class Node{
    int x, y, dis;
    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
