import java.math.BigInteger;
import java.util.*;
import java.io.*;
/**
 * Created by emily on 16/7/8.
 */
public class Main {
    public static int MOD = (int)(1e9 + 7);
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int m = input.nextInt(), n = input.nextInt();
            long ret = 0;
            long[][] opt = new long[m + 1][n + 1];
            opt[0][0] = 1;
            for(int i = 1; i <= m; i++) {
                for(int j = i; j <= n; j++) {
                    opt[i][j] = (opt[i - 1][j - 1] * (m - i + 1) + opt[i][j - 1] * i) % MOD;
//                    System.out.println("opt[" + i + "][" + j + "] = " + opt[i][j]);
                }
            }
            ret = opt[m][n];
            System.out.println(ret);
            output.println(ret);
        }

        input.close();
        output.close();
    }
}
