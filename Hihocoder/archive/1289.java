import java.io.*;
import java.util.*;
public class Main {
    public int handleIP(String s) {
        String[] num = s.split(".");
        int ret = (Integer.parseInt(num[0]) << 24) + (Integer.parseInt(num[1]) << 16) + (Integer.parseInt(num[2]) << 8) + Integer.parseInt(num[3]);
        return ret;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
//        Scanner input = new Scanner(new File("test.txt"));
        int n = input.nextInt(), m = input.nextInt();
        Main solution = new Main();
        Trie trie = new Trie();
        boolean[] allow = new boolean[n];
        for(int i = 0; i < n; i++) {
            String flag = input.next();
            String ip = input.next();
            int index = ip.indexOf('/');
            int ipInteger = 0, mask = 32;
            if(index == -1)
                ipInteger = solution.handleIP(ip);
            else {
                ipInteger = solution.handleIP(ip.substring(0, index));
                mask = Integer.parseInt(ip.substring(index + 1));
            }
            if(flag.equals("allow")) {
                allow[i] = true;
            }
            trie.insert(ipInteger, mask, i);
        }
        for(int i = 0; i < m; i++) {
            String ip = input.next();
            boolean ret = true;
            int ipInteger = solution.handleIP(ip);
            int index = trie.search(ipInteger);
            if(index != Integer.MAX_VALUE && !allow[index])
                ret = false;
            if(ret) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
class TrieNode {
    int index = -1;
    TrieNode[] child = new TrieNode[2];
    TrieNode() {

    }
}
class Trie {
    TrieNode root = new TrieNode();
    Trie() {

    }
    public void insert(int ip, int mask, int index) {//从高位开始,到mask截止
        TrieNode cur = root;
        for(int j = 0, i = 31; j < mask && i >= 0; j++, i--) {
            int flag = ((ip >> i) & 1);
            if(cur.child[flag] == null) {
                TrieNode tmp = new TrieNode();
                cur.child[flag] = tmp;
            }
            cur = cur.child[flag];
        }
        if(cur.index == -1)//保证按照规则的顺序来
            cur.index = index;
    }
    public int search(int ip) {
        TrieNode cur = root;
        int index = Integer.MAX_VALUE;
        for(int i = 31; i >= 0; i--) {
            int flag = ((ip >> i) & 1);
            if(cur.index != -1)
                index = Math.min(index, cur.index);
            if(cur.child[flag] == null) {
                break;
            }
            cur = cur.child[flag];


        }
        return index;
    }
}