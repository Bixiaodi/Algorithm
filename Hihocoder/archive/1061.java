import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            int n = input.nextInt();
            String s = input.next();
            if(n < 3) {
                System.out.println("NO");
                continue;
            }
                
            ArrayList<Node> info = new ArrayList<Node>();
            char last = s.charAt(0);
            int count = 1;
            for(int i = 1; i < n; i++) {
                if(s.charAt(i) == s.charAt(i - 1))
                    count++;
                else {
                    info.add(new Node(last, count));
                    last = s.charAt(i);
                    count = 1;
                }
            }
            info.add(new Node(last, count));
            boolean beautiful = false;
            for(int i = 0, end = info.size(); i < end - 2; i++) {
                if(info.get(i + 1).c - info.get(i).c == 1 && info.get(i + 2).c - info.get(i + 1).c == 1 && info.get(i).cnt >= info.get(i + 1).cnt && info.get(i + 2).cnt >= info.get(i + 1).cnt) {
                    beautiful = true;
                    break;
                }
            }
            if(beautiful)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
class Node{
    char c;
    int cnt;
    Node(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }
}