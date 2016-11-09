import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
      Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            String s = input.next();
            int n = s.length();
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                dp[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(s.charAt(j) <= s.charAt(i))
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(n - max);

        }
    }

}


