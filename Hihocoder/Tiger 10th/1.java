import java.io.*;
import java.util.*;

public class Main {
    public static HashMap<Integer, ArrayList<Integer>> num = new HashMap<Integer, ArrayList<Integer>>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
//        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        dfs(6, 0, 0, 0);
        TreeSet<String> set = new TreeSet<String>();
        for(int i = 0; i <= Math.min(n, 4); i++) {
            int j = n - i;
            if(j >= 6) {
                continue;
            }
 //           System.out.println("i = " + i + " j = " + j);
            ArrayList<Integer> hour = num.get(i), minute = num.get(j);
            for(int h: hour) {
                if(h > 23) {
                    continue;
                }
                for(int m: minute) {
                    StringBuilder cur = new StringBuilder();
                    if(h < 10) {
                        cur.append(0);
                    }
                    cur.append(h);
                    cur.append(":");
                    if(m < 10) {
                        cur.append(0);
                    }
                    cur.append(m);
                    set.add(cur.toString());
                }
            }
        }
        for(String val: set) {
            System.out.println(val);
        }
    }
    public static void dfs(int n, int cur, int start, int val) {
        if(start > n) {
            return ;
        }
        if(val < 60) {
//            set.add(val);
//            num.putIfAbsent(cur, new ArrayList<Integer>());
            if(!num.containsKey(cur)) {
                num.put(cur, new ArrayList<Integer>());
            }
            num.get(cur).add(val);
        }
        for(int i = start; i <= n; i++) {
            if(((val >> i) & 1) == 1) {
                continue;
            }
            int tmp = val;
            dfs(n, cur + 1, i + 1, val | (1 << i));
            val = tmp;
        }
    }
}



