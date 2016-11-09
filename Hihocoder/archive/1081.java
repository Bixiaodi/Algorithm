import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), s = input.nextInt(), t = input.nextInt();
        int[] dis = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        int[][] length = new int[n + 1][n + 1];
        HashMap<Integer, HashSet<Integer>> path = new HashMap<Integer, HashSet<Integer>>();
        Arrays.fill(dis, 1000000);
        for (int i = 0; i < m; i++) {
            int x = input.nextInt(), y = input.nextInt(), l = input.nextInt();
            if (!path.containsKey(x)) {
                path.put(x, new HashSet<Integer>());
            }
            if (!path.containsKey(y)) {
                path.put(y, new HashSet<Integer>());
            }
            path.get(x).add(y);
            path.get(y).add(x);
            if (length[x][y] == 0) {
                length[x][y] = l;
                length[y][x] = l;
            } else {
                length[x][y] = Math.min(length[x][y], l);
                length[y][x] = length[x][y];
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(1000, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.dis - n2.dis;
            }
        });
        pq.add(new Node(s, 0));
        dis[s] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            // System.out.println("id = " + cur.id + " dis = " + cur.dis);
            if (visit[cur.id]) {
                continue;
            }
            visit[cur.id] = true;
            if (cur.id == t) {
                break;
            } 
            if (path.containsKey(cur.id)) {
                for (int tmp: path.get(cur.id)) {
                    dis[tmp] = Math.min(dis[tmp], dis[cur.id] + length[cur.id][tmp]);    
                    // System.out.println("next = " + tmp + " dis = " + dis[tmp]);             
                    pq.add(new Node(tmp, dis[tmp]));
                }
            }
        }
        System.out.println(dis[t]);
    }
}
class Node {
    int id, dis;
    Node(int id, int dis) {
        this.id = id;
        this.dis = dis;
    }
}
