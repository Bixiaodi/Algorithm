import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by emily on 16/7/9.
 */
public class ApacTest {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt();
            int[] a = new int[n], b = new int[n];
            int maxv = 50001;
            for(int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                b[i] = input.nextInt();
           //     maxv = Math.max(maxv, b[i]);
            }
            int p = input.nextInt();
            int[] num = new int[p];
            for(int i = 0; i < p; i++) {
                num[i] = input.nextInt();
            }
            int[] cnt = new int[maxv + 2];
            for(int i = 0; i < n; i++) {
                cnt[a[i]]++;
                cnt[b[i] + 1]--;
            }
//            for(int i = 0; i <= 50; i++) {
//                System.out.println("cnt[" + i + "] = " + cnt[i]);
//            }
            int[] ret = new int[maxv + 1];
            for(int i = 1; i <= maxv; i++) {
                ret[i] = ret[i - 1] + cnt[i];
            }
            for(int i = 0; i < p; i++) {
                System.out.print(ret[num[i]] + " ");
                output.print(ret[num[i]] + " ");
            }
            System.out.println();
            output.println();
        }

        input.close();
        output.close();
    }
}
