import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
       // Scanner input = new Scanner(new File("input.txt"));
        long n = input.nextLong();
        if(n < 10) {
            System.out.println(n);
            return ;
        }
        long length = 0, start = 0, len = 1, power = 10;
        while(length + (power - start) * len <= n) {
            length += (power - start) * len;
            start = power;
            power *= 10;
            len++;
        }
        long remain = n - length;
        long pre = (remain + 1) / len, last = (remain) % len;
        long ret = (long)Math.pow(10, len - 1);
        if(pre != 0)
            ret += pre - 1;
        String val = String.valueOf(ret);
        System.out.println(val.charAt((int)last));
    }
}
