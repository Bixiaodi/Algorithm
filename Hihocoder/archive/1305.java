import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        Node[] nodes = new Node[2 * n + 2 * m];
        for(int i = 0; i < 2 * n; i += 2) {
            nodes[i] = new Node(true, true, input.nextInt());
            nodes[i + 1] = new Node(false, true, input.nextInt());
        }
        for(int i = 2 * n; i < 2 * n + 2 * m; i += 2) {
            nodes[i] = new Node(true, false, input.nextInt());
            nodes[i + 1] = new Node(false, false, input.nextInt());
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                if(n1.id != n2.id)
                    return n1.id - n2.id;
                else {
                    if(n1.a == n2.a) {
                        return n1.begin ? -1 : 1;
                    }
                    else
                        return n1.a ? -1 : 1;
                }
            }
        });
//        for(int i = 0; i < nodes.length; i++) {
//            System.out.println(nodes[i].id + " " + nodes[i].begin + " " + nodes[i].a);
//        }
        int ret = 0, sa = 0, sb = 0;
        int start = -1;
        for(int i = 0; i < 2 * n + 2 * m; i++) {
            if(nodes[i].a) {
                if(nodes[i].begin) {
                    sa++;
                    if(start == -1 && sb == 0)
                        start = nodes[i].id;
                }
                else {
                    sa--;
                    if(start != -1 && sb == 0 && sa == 0) {
                        ret += nodes[i].id - start;//[a, b]
//                        System.out.println(start + " " + nodes[i].id);
                        start = -1;
                    }

                }
            }
            else {
                if(nodes[i].begin) {
                    sb++;
                    if(start != -1 && sa > 0) {
                        ret += nodes[i].id - start;//[a, b)
//                        System.out.println(start + " " + nodes[i].id);
                        start = -1;
                    }
                }
                else {
                    sb--;
                    if(sa > 0  && sb == 0 && start == -1) {
                        start = nodes[i].id;//(a, b]
                    }
                }
            }
        }
        System.out.println(ret);

    }
}
class Node{
    boolean begin, a;
    int id;
    Node(boolean begin, boolean a, int id) {
        this.begin = begin;
        this.a = a;
        this.id = id;
    }
}