import java.io.*;
import java.util.*;

public class Main {

    public static int ret = 0;
    public static void dfs(int[] num, int n, int cur, int id, int len) {
        if(id == n) {
            ret = Math.max(ret, len);
            return;
        }
        if(len + n - id < ret)
            return ;
        dfs(num, n, cur, id + 1, len);
        if((num[id] & cur) == 0) {
            int tmp = num[id] | cur;
            dfs(num, n, tmp, id + 1, len + 1);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
       Scanner input = new Scanner(System.in);
//        PrintWriter output = new PrintWriter(new File("output.txt"));
        int n = input.nextInt();
        String[] word = new String[n];
        for(int i = 0; i < n; i++) {
            word[i] = input.next();
        }
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            String cur = word[i];
            for(int j = 0; j < cur.length(); j++) {
                num[i] |= (1 << (cur.charAt(j) - 'a'));
            }
        }
        dfs(num, n, 0, 0, 0);
        System.out.println(ret);
        input.close();
//        output.close();
    }
}
