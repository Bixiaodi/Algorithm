import java.util.*;
import java.io.*;

public class Main {
    public static long ret = 1, maxCnt = 1;
    public static void dfs(int[] prime, int id, long cur, long cnt, long val, long last) {
        if(id >= prime.length || prime[id] > val)
            return ;
        if(cnt > maxCnt || (cnt == maxCnt && cur < ret)) {
            maxCnt = cnt;
            ret = cur;
        }
        int power = 1;
        while(cur * (long)Math.pow(prime[id], power) <= val && power <= last) {
            dfs(prime, id + 1, cur * (long)Math.pow(prime[id], power), cnt * (power + 1), val, power);
            power++;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
      //  Scanner input = new Scanner(new File("input.txt"));
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43};
        long n = input.nextLong();
//        long ret = 1;
//        for(long tmp: prime) {
//            ret *= tmp;
//        }
//        System.out.println(ret);
        dfs(prime, 0, 1, 1, n, Integer.MAX_VALUE);
        System.out.println(ret);
    }
}
