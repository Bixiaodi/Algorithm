import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(100000, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                if(n1.cnt == n2.cnt) {
                    return n1.val - n2.val;
                }
                else {
                    return n2.cnt - n1.cnt;
                }
            }
        });
        for(int i = 0; i < n; i++) {
            num[i] = input.nextInt();
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            }
            else {
                map.put(num[i], 1);
            }
        }
        for(int key: map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }
        boolean found = true;
        int id = 0;
        for(int i = 0; i < n; i++) {
            Node cur = pq.peek();
            if(cur.cnt + cur.cnt - 1 < n - id) {
                int key = map.firstKey();
                if(id == 0 || key != num[id - 1]) {
                    num[id++] = key;
                    int cnt = map.get(key);
                    Node tmp = new Node(key, cnt);
                    pq.remove(tmp);
                    if(cnt == 1) {
                        map.remove(key);
                    }
                    else {
                        map.put(key, cnt - 1);
                        pq.add(new Node(key, cnt - 1));
                    }
                }
                else {
                    Integer second = map.higherKey(key);
                    if(second == null) {
                        found = false;
                        break;
                    }
                    num[id++] = second;
                    int cnt = map.get(second);
                    pq.remove(new Node(second, cnt));
                    if(cnt == 1) {
                        map.remove(second);
                    }
                    else {
                        map.put(second, cnt - 1);
                        pq.add(new Node(second, cnt - 1));
                    }
                }
            }
            else {
                if(id > 0 && cur.val == num[id - 1]) {
                    found = false;
                    break;
                }
                else {
                    pq.poll();
                    num[id++] = cur.val;
                    int cnt = map.get(cur.val);
                    if(cnt == 1) {
                        map.remove(cur.val);
                    }
                    else {
                        map.put(cur.val, cnt - 1);
                        pq.add(new Node(cur.val, cnt - 1));
                    }
                }
            }
        }
        if(found) {
            for(int i = 0; i < n; i++) {
                System.out.print(num[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }
    }
}
class Node extends Object{
    int val, cnt;
    Node(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
    public boolean equals(Object o) {
        Node n = (Node)o;
        return n.val == this.val && n.cnt == this.cnt;
    }
}
