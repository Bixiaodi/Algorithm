import java.io.*;
import java.util.*;

public class Main {
    public static final int inf = 1000000010;
    public static boolean check(int h, int n, int m, int l, int[] a) {
        for(int start = n - l; start <= n; start++) {
            int end = start + n;
            int cnt = 0;
            for(int i = start; i < end; ) {
                if(a[i] < h) {
                    cnt++;
                    i += l;
                } else {
                    i++;
                }
            }
            if(cnt <= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), l = input.nextInt();
        int[] a = new int[n + n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for(int i = n; i < n + n; i++) {
            a[i] = a[i - n];
        }
        int low = 1, high = inf;
        int ret = 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(check(mid, n, m, l, a)) {
                ret = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(ret);
    }
}

