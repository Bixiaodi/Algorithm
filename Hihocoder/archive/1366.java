import java.io.*;
import java.util.*;

public class Main {
    public static void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0, n = word.length(); i < n; i++) {
            char c = word.charAt(i);
            if(cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur = cur.child[c - 'a'];
        }
        cur.isWord = true;
    }
    public static boolean search(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0, n = word.length(); i < n; i++) {
            char c = word.charAt(i);
            if(cur.child[c - 'a'] == null) {
                return false;
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        return cur.isWord;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] words = new String[n];
        TrieNode root = new TrieNode();
        for(int i = 0; i < n; i++) {
            words[i] = input.next();
            insert(root, words[i]);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            StringBuilder cur = new StringBuilder(words[i]);
            cur = cur.reverse();
            cnt += search(root, cur.toString()) ? 1 : 0;
        }
        cnt /= 2;
        System.out.println(cnt);
    }
}
class TrieNode {

    boolean isWord;
    TrieNode[] child;
    TrieNode() {
        isWord = false;
        child = new TrieNode[26];
    }
}

