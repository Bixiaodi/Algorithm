import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static boolean reach(int n, int m, int q, int[] v, int[] p, int[] h, int time) {
        for(int i = 0; i < n; i++) {
            if(p[i] == 0)
                continue;
            int minv = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                if(v[j] == 0)
                    continue;
                else if(p[i] * v[j] < 0) {
                    int tmp = (int)Math.ceil(Math.abs(p[i] * 1.0/ v[j]));
                    if(tmp <= time) {
                   //     System.out.println("i = " + i + " j = " + j);
                        minv = Math.min(Math.abs(h[i] - j), minv);
                    }
                }
            }
            if(q - minv >= 0)
                q -= minv;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
//        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            output.print("Case #" + t + ": ");
            boolean flag = true;
            int n = input.nextInt(), m = input.nextInt(), q = input.nextInt();
            int[] v = new int[m];
            int[] p = new int[n], h = new int[n];
            for(int i = 0; i < m; i++) {
                v[i] = input.nextInt();
            }
            for(int i = 0; i < n; i++) {
                p[i] = input.nextInt();
                h[i] = input.nextInt();
            }
            int low = 0, high = 10001;
            while(low < high) {
                int mid = low + (high - low) / 2;
                if(reach(n, m, q, v, p, h, mid))
                    high = mid;
                else
                    low = mid + 1;
            }
            if(low == 10001)
                output.println("IMPOSSIBLE");
            else
                output.println(low);

        }
        input.close();
        output.close();
    }
}
