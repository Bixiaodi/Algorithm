import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int mod = 1000000007;
        int n = input.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        long power = 1, cnt = 1;
        while (cnt <= n) {
            power = (power % mod * 2 % mod) % mod;
            cnt++;
        }
        long ret = (power - dp[n]) % mod;
        if(ret >= 0)
            System.out.println(ret);
        else
            System.out.println(ret + mod);

    }
}