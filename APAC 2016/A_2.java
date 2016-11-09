
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
    public static double helper(int start, int end, int[] a) {
        double ret = 1.0;
        int len = end - start + 1;
        for(int i = start; i <= end; i++) {
            ret *= root(a[i], len);
        }
        return ret;        

    }
    public static double root(int n, int len) {
        if(n == 1)
            return (double)n;
        double ret = Math.log10(n) / len;
        ret = Math.pow(10, ret);
        return ret;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            // System.out.print("Case #" + t + ": ");
            // output.print("Case #" + t + ": ");
            System.out.println("Case #" + t + ": ");
            output.println("Case #" + t + ": ");
            int n = input.nextInt(), m = input.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }
            for(int i = 0; i < m; i++) {
                int start = input.nextInt(), end = input.nextInt();
                double ret = helper(start, end, a);
                System.out.println(ret);
                output.println(ret);
            }

        }

        input.close();
        output.close();
    }
}