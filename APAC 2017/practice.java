import java.io.*;
import java.util.*;

public class Main {

    public static final int MOD = 1000000007;

    public static long helper(String s) {//(a * b) % p = (a % p * b % p) % p
        int n = s.length();
        if(n < 2)
            return n;
        long ret = 1;
        if(s.charAt(0) != s.charAt(1))
            ret = 2;
        if(s.charAt(n - 1) != s.charAt(n - 2))
            ret *= 2;
        for(int i = 1; i < n - 1; i++) {
            int cnt = judge(s.charAt(i - 1), s.charAt(i), s.charAt(i + 1));
            ret = (ret % MOD * cnt % MOD) % MOD;
        }
        return ret;
    }

    public static int judge(char a, char b, char c) {
        int ret = 3;
        char[] num = {a, b, c};
        Arrays.sort(num);
        if(num[1] == num[0])
            ret--;
        if(num[2] == num[1])
            ret--;
        return ret;
    }

    public static long helper(int[][] num, int n, int k) {
        HashMap<Integer, Long> first = new HashMap<Integer, Long>();
        HashMap<Integer, Long> second = new HashMap<Integer, Long>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int p = num[0][i] ^ num[1][j], q = num[2][i] ^ num[3][j];
                first.putIfAbsent(p, (long)0);
                first.putIfAbsent(q, (long)0);
                second.putIfAbsent(p, (long)0);
                second.putIfAbsent(q, (long)0);
                first.put(p, first.get(p) + 1);
                second.put(q, second.get(q) + 1);
            }
            System.out.println("finish: " + i);
        }
        long ret = 0, cnt = 0;
        for(int pre: first.keySet()) {
            if(second.containsKey(pre ^ k)) {
                ret += first.get(pre) * second.get(pre ^ k);
            }
            System.out.println("finish: " + (cnt++));
        }
        return ret;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
        PrintWriter output = new PrintWriter(new File("ret.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.println("-----------------" + t + "-------------------------");
            int n = input.nextInt(), x = input.nextInt(), k = input.nextInt(), a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
            double da = a / 100.0, db = b / 100.0, dc = c / 100.0;
            HashMap<Integer, Double> map = new HashMap<Integer, Double>();
            map.put(x, 1.0);
            for(int i = 0; i < n; i++) {
                HashMap<Integer, Double> cur = new HashMap<Integer, Double>();
                for(int old: map.keySet()) {
                    cur.putIfAbsent(old & k, 0.0);
                    cur.put(old & k, cur.get(old & k) + map.get(old) * da);
                    cur.putIfAbsent(old | k, 0.0);
                    cur.put(old | k, cur.get(old | k) + map.get(old) * db);
                    cur.putIfAbsent(old ^ k, 0.0);
                    cur.put(old ^ k, cur.get(old ^ k) + map.get(old) * dc);
                }
                System.out.println(cur);
                map = new HashMap<Integer, Double>(cur);
            }
            double ret = 0;
            for(int key: map.keySet()) {
                ret += key * map.get(key);
            }
            output.println("Case #" + t + ": " + ret);
        }

        input.close();
        output.close();
    }
}


