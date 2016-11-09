import java.io.*;
import java.util.*;

public class Main {

    public static final long MAX_VALUE = (long)1e15;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
//       Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            output.print("Case #" + t + ": ");
            boolean flag = true;
            int n = input.nextInt();
            long[] p = new long[n], k = new long[n];
            for(int i = 0; i < n; i++) {
                p[i] = input.nextLong();
                k[i] = input.nextLong();
            }
            long start = 0, end = MAX_VALUE;
            for(int i = 0; i < n; i++) {
                long large = MAX_VALUE, small = 0;
                if(p[i] == 0) {
                    small = (k[i] * 100 / (p[i] + 1)) + 1;
                }
                else if(p[i] == 100) {
                    small = k[i];
                    end = k[i];
                }
                else {
                    small = (k[i] * 100 / (p[i] + 1)) + 1;
                    large = k[i] * 100 / p[i];
                }
                start = Math.max(start, small);
                end = Math.min(end, large);
                if(start > end) {
                    flag = false;
                    break;
                }
            }
            System.out.println("start = " + start + " end = " + end);
            if(!flag || start != end)
                output.println("-1");
            else {
                output.println(start);
            }
        }
        input.close();
        output.close();
    }
}
