import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    private TrieNode root;

    public Main() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] s = word.toCharArray();
        TrieNode p = root;
        int n = word.length();
       for(int i = 0; i < n; i++)
       {
           TrieNode next = p.next.get(s[i]);
           if(next == null)
           {
               TrieNode node = new TrieNode();
               node.count = 1;
               p.next.put(s[i], node);
               p = node;
           }
           else
           {
               p = next;
               next.count++;
           }
       }

    }
    public int startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0, len = prefix.length(); i < len; i++)
        {
            TrieNode child = p.next.get(prefix.charAt(i));
            if(child == null)
                return 0;
            p = child;
        }
        return p.count;
    }
    public static void main(String[] args)  {
 //       Scanner scanner = new Scanner(new File("test.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main solution = new Main();
        for(int i = 0; i < n; i++)
        {
            solution.insert(scanner.next());
        }
        int m = scanner.nextInt();
        for(int i = 0; i < m; i++)
            System.out.println(solution.startsWith(scanner.next()));
    }
}

class TrieNode{
    int count;
    HashMap<Character, TrieNode> next;
    public TrieNode() {
        next = new HashMap<Character, TrieNode>();
        count = 0;
    }
}
