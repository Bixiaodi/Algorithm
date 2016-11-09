import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public long part(long n)
    {
        long m = 1, ret = 0;
        for(m = 1; m * m <= n; m++)
        {
            if(n % m == 0)
                ret++;
        }
        ret *= 2;
        m--;
        if(m * m == n)
            ret--;
        return ret;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //       Scanner scanner = new Scanner(new File("test.txt"));
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        if(m > n)
        {
            long tmp = m;
            m = n;
            n = tmp;
        }
        long lenm = solution.part(m), lenn = solution.part(n);
        long same = 0;
        for(long i = 1; i * i < m; i++)
        {
            if(m % i  == 0)
            {
                if(n % i == 0)
                    same++;
                long mdei = m / i;
                if(mdei != i && n % mdei == 0)
                    same++;
            }

        }
        long ret = lenm * lenn / same;
        System.out.println(ret + " " + 1);

    }

}