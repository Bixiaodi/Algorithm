import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> factors = new ArrayList<ArrayList<Integer>>();
    public static int solve( String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[i][i] = 1;
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int ret = len;
                for(int k = i; k < j; k++)
                    ret = Math.min(ret, dp[i][k] + dp[k + 1][j]);
                ArrayList<Integer> fac = factors.get(len);
                for(int f: fac) {
                    if(valid(i, j, f, s)) {
                        int count = len / f;
                        ret = Math.min(ret, String.valueOf(count).length() + 2 + dp[i][i + f - 1]);
                    }
                }
                dp[i][j] = ret;
            }

        }
        return dp[0][n - 1];

    }
    public static boolean valid(int i, int j, int f, String s) {//start, end, node
        for(int k = 0; k < f; k++) {
            int start = i + k;
            while(start <= j) {
                if(s.charAt(start) != s.charAt(i + k))
                    return false;
                start += f;
            }
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
      Scanner input = new Scanner(System.in);
        factors.add(new ArrayList<Integer>());
        for(int i = 1; i <= 100; i++) {
            factors.add(new ArrayList<Integer>());
            for(int j = 1; j * j <= i; j++) {
                if(i % j == 0) {
                    int another  = i / j;
                    factors.get(i).add(j);
                    if(another != j && another < i)
                        factors.get(i).add(another);
                }
            }
        }
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            String s = input.next();
            System.out.println(solve(s));
        }


    }

}


