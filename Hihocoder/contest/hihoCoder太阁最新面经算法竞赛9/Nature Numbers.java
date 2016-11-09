import java.util.*;
import java.io.*;

public class Main {
//    public static char check(int n, int id) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i <= n; i++) {
//            sb.append(i);
//        }
//        return sb.charAt(id);
//    }

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
//            System.out.println("length = " + length + " start = " + start + " power = " + power + " len = " + len);
            start = power;
            power *= 10;
            len++;
        }
//        System.out.println("after : " + "length = " + length + " start = " + start + " power = " + power + " len = " + len);
        long remain = n - length;
//        System.out.println("remain = " + remain);
        long pre = (remain + 1) / len, last = (remain) % len;
//        System.out.println("pre = " + pre + " last = " + last);
        long ret = (long)Math.pow(10, len - 1);
        if(pre != 0)
            ret += pre - 1;
//        System.out.println(ret);
        String val = String.valueOf(ret);
        System.out.println(val.charAt((int)last));
//        System.out.println("right = " + check(3000, (int)n));
    }
}
