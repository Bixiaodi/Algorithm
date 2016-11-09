import java.io.*;
import java.util.*;

public class Main {
    public static long helper(int k, int m, long[] a, int[] b) {
        long[][] opt = new long[m + 1][k + 1];
        Arrays.fill(opt[0], Integer.MAX_VALUE);
        opt[0][0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= k; j++) {
                long last = opt[i - 1][j];
                if(b[i - 1] > 0) {
                    int id = Math.max(j - b[i - 1], 0);
                    opt[i][j] = Math.min(last, opt[i][id] + a[i - 1]);
                }
                else {
                    opt[i][j] = last;
                }
                
            }
        }
        return opt[m][k];
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int Q = input.nextInt();
        for (int q = 0; q < Q; q++) {
            int n = input.nextInt(), m = input.nextInt(), k = input.nextInt(), t = input.nextInt();
            long[] a = new long[m];
            int[] b = new int[m];
            for(int i = 0; i < m; i++) {
                a[i] = input.nextLong();
            }
            for(int i = 0; i < m; i++) {
                b[i] = input.nextInt();
            }
            long ret = 0;
            boolean finish = true;
            for(int i = 0; i < n; i++) {
                ret += helper(k, m, a, b);
                boolean zero = true;
                for(int j = 0; j < m; j++) {
                    b[j] /= t;
                    if(b[j] > 0) {
                        zero = false;
                    }
                }
                if(i < n - 1 && zero) {
                    finish = false;
                    break;
                }
            }
            if(finish) {
                System.out.println(ret);
            }
            else {
                System.out.println("No Answer");
            }

        }
    }
}
