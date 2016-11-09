
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
    public static int helper(long k, long len) {
        if(k == (len - 1) / 2)
            return 0;
        else if(k < (len - 1) / 2) {
            return helper(k, (len - 1) / 2);
        }
        else {
            return 1 - helper(len - 1 - k, (len - 1) / 2);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            long k = input.nextLong();
            long len =((long)1 << 63) - 1;
 //           System.out.println(Long.toBinaryString(len) + " " + len);
            int ret = helper(k - 1, len);//k start with 0
            System.out.println(ret);
            output.println(ret);

        }

        input.close();
        output.close();
    }
}