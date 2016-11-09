import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int findset(int x, int[] fa) {
        return x == fa[x] ? x : (fa[x] = findset(fa[x], fa));
    }
    public static void unionset(int x, int y, int[] fa) {
        int fx = findset(x, fa);
        int fy = findset(y, fa);
        if(fx != fy)
            fa[fx] = fy;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
       Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            int n = input.nextInt(), m = input.nextInt();
            int[] fa = new int[n + 1];
            for(int i = 1; i <= n; i++)
                fa[i] = i;
            for(int i = 0; i < m; i++) {
                int from = input.nextInt(), to = input.nextInt();
                unionset(from, to, fa);
            }
            if(n != m + 1)
                System.out.println("NO");
            else {
                int root = findset(1, fa);
                for(int i = 2; i <= n; i++) {
                    if(findset(i, fa) != root) {
                        root = Integer.MIN_VALUE;
                        break;
                    }
                }
                if(root == Integer.MIN_VALUE)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
        }
    }
}