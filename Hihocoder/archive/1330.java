import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int gcd(int a, int b) {
        if(a < b)
            return gcd(b, a);
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = input.nextInt();
        }
        HashSet<Integer> cnt = new HashSet<Integer>();
        for(int i = 1; i <= n; i++) {
            int count = 1, id = num[i];
            while(id != i) {
                id = num[id];
                count++;
            }
//            System.out.println(i + " " + count);
            if(count != 0)
                cnt.add(count);
        }
        if(cnt.size() == 0)
            System.out.println("0");
        else {
            ArrayList<Integer> count = new ArrayList<Integer>(cnt);
            int ret = count.get(0);
            for(int i = 1; i < count.size(); i++) {
                int g = gcd(ret, count.get(i));
                ret = ret * count.get(i) / g;
            }
            System.out.println(ret);
        }
    }

}


