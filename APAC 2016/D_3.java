import sun.text.normalizer.Trie;

import java.io.*;
import java.util.*;

public class Main {

    public static List<String> ret = new ArrayList<>();

    public static void insert(TrieNode root, int ip, int prefix) {
        TrieNode cur = root;
        for(int i = 31; i >= 0 && prefix > 0; i--, prefix--) {
            int id = ((ip >> i) & 0x1);
            if(cur.child[id] == null)
                cur.child[id] = new TrieNode();
            cur = cur.child[id];
        }
        cur.merge = true;
    }
    public static void checkMerge(TrieNode root) {
        if(root == null || root.merge)
            return ;
        checkMerge(root.child[0]);
        checkMerge(root.child[1]);
        if (root.child[0] != null && root.child[1] != null) {
            root.merge = root.child[0].merge && root.child[1].merge;
        }
    }

    public static String handle(int ip, int pre) {
        StringBuilder ret = new StringBuilder();
        int mask = 0xFFFFFFFF;
        mask <<= (31 - pre);
        ip &= mask;
        ret.append((ip >> 24) & 0xFF);
        ret.append(".");
        ret.append((ip >> 16) & 0xFF);
        ret.append(".");
        ret.append((ip >> 8) & 0xFF);
        ret.append(".");
        ret.append(ip & 0xFF);
        ret.append("/");
        ret.append(pre);
        return ret.toString();
    }

    public static void merge(TrieNode cur, int ip, int pre) {
        if(cur == null)
            return;
        if(cur.merge) {
            ret.add(handle(ip, pre));
            System.out.println("ret :  ip = " + ip + "pre = " + pre);
            return;
        }
        merge(cur.child[0], ip, pre + 1);
        merge(cur.child[1], ip | (1 << (31 - pre)), pre + 1);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
//        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new File("output.txt"));

        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            output.println("Case #" + t + ":");
            int n = input.nextInt();
            TrieNode root = new TrieNode();

            for(int i = 0; i < n; i++) {
                String line = input.next();
                int id = line.indexOf('/');
                String[] ips = line.substring(0, id).split("\\.");
                int ip = (Integer.parseInt(ips[0]) << 24) + (Integer.parseInt(ips[1]) << 16) + (Integer.parseInt(ips[2]) << 8) + Integer.parseInt(ips[3]);
                insert(root, ip, Integer.parseInt(line.substring(id + 1)));
            }
            checkMerge(root);
            ret.clear();
            merge(root, 0, 0);
            for(int i = 0; i < ret.size(); i++)
                output.println(ret.get(i));
        }
        input.close();
        output.close();
    }
}
class TrieNode {
    boolean merge;
    TrieNode[] child;
    TrieNode() {
        this.merge = false;
        child = new TrieNode[2];
    }
}