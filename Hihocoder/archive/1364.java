import java.io.*;
import java.util.*;

public class Main {
    public static int MAXN = 100010;
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[][] pack = new int[110][110];
        int[] value = new int[MAXN], size = new int[MAXN], opt = new int[MAXN];
        for(int i = 0; i < n; i++) {
            int w = input.nextInt(), p = input.nextInt();
            pack[w][p]++;
        }
        for(int i = 1; i <= 100; i++) {
            int w = (i - 1) / 10 + 1;
            int p = (i - 1) % 10 + 1;
            if(pack[w][p] == 0) {
                continue;
            }
            int count = 0;
            int c = pack[w][p];
            for(int k = 1; k <= c; k <<= 1) {
                value[count] = k * p;
                size[count++] = k * w;
                c -= k;
            }
            if(c > 0) {
                value[count] = c * p;
                size[count++] = c * w;
            }
            for(int k = 0; k < count; k++) {
                for(int j = m; j >= 1; j--) {
                    if(j >= size[k]) {
                        opt[j] = Math.max(opt[j], opt[j - size[k]] + value[k]);
                    }
                }
            }
        }
        System.out.println(opt[m]);
    }
}

