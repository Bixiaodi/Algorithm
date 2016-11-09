import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(int t, int n, int m, int k, int[] a) {
        int last = m, cost = 0;
        for(int i = 0; i < n; i++) {
            last = Math.min(last + t, m);
            if(a[i] >= last) {
                cost++;
                last = m;
            }
            else {
                last -= a[i];
            }
        }
        return cost < k;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int low = 1, high = 100001;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(check(mid, n, m, k, a)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        if(low == 100001) {
            System.out.println("-1");
        }
        else {
            System.out.println(low);
        }
    }
}