import java.io.*;
import java.util.*;

public class Main {
    
    public static void corner(Node[] node, int i, int j) {
        int x1 = node[j].x1, y1 = node[j].y1, x2 = node[j].x2, y2 = node[j].y2;
        if(!node[i].cover[0]) {
            int x = node[i].x1, y = node[i].y1;
            node[i].cover[0] = x > x1 && x < x2 && y > y1 && y < y2;
        }
        if(!node[i].cover[1]) {
            int x = node[i].x1, y = node[i].y2;
            node[i].cover[1] = x > x1 && x < x2 && y > y1 && y < y2;
        }
        if(!node[i].cover[2]) {
            int x = node[i].x2, y = node[i].y2;
            node[i].cover[2] = x > x1 && x < x2 && y > y1 && y < y2;
        }
        if(!node[i].cover[3]) {
            int x = node[i].x2, y = node[i].y1;
            node[i].cover[3] = x > x1 && x < x2 && y > y1 && y < y2;
        }
    }
    public static boolean removeable(Node node) {
        return !node.cover[0] || !node.cover[1] || !node.cover[2] || !node.cover[3];
    }
    public static boolean cover(Node n1, Node n2) {
        int maxx = Math.max(n1.x1, n2.x1);
        int minx = Math.min(n1.x2, n2.x2);
        int maxy = Math.max(n1.y1, n2.y1);
        int miny = Math.min(n1.y2, n2.y2);
        return maxx < minx && maxy < miny;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int w = input.nextInt(), h = input.nextInt(), n = input.nextInt();
//        System.out.println(w + " " + h + " " + n);
        Node[] node = new Node[n];
        for (int i = 0; i < n; i++) {
            node[i] = new Node(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
            for(int j = 0; j < i; j++) {
                corner(node, j, i);
            }
        }
        // for(int i = 0; i < n; i++) {
        //     System.out.println(node[i].x1 + " " + node[i].y1 + " " + node[i].x2 + " " + node[i].y2);
        // }
        int ret = 0, start = 0;
        for(int i = 0; i < n; i++) {
            if(removeable(node[i])) {
                int cur = 1;
                ArrayList<Node> papers = new ArrayList<Node>();
                papers.add(node[i]);
                for(int j = i + 1; j < n; j++) {
                    for(int k = 0; k < papers.size(); k++) {
                        if(cover(node[j], papers.get(k))) {
                            papers.add(node[j]);
                            cur++;
                            break;
                        }
                    }
                }
                if(ret < cur) {
                    ret = cur;
                    start = i + 1;
                }
            }
        }
        System.out.println(ret + " " + start);
        
    }
}
class Node {
    int x1, y1, x2, y2;
    boolean[] cover;
    Node(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        cover = new boolean[4];
    }
}

