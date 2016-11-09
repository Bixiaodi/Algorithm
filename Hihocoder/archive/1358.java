import java.io.*;
import java.util.*;

public class Main {
    public static int getIndex(int[] a, double[] exp, int k, double last) {
        double maxv = 0;
        int maxId = -1;
        double cur = 1.0;
        for(int i = 0; i < k; i++) {
            cur *= Math.pow(a[i], exp[i]);
        }
        for(int i = 0; i < k; i++) {
            double next = cur / Math.pow(a[i], exp[i]) * Math.pow(a[i] + 1, exp[i]);
            if(next > maxv) {
                maxv = next;
                maxId = i;
            }
        }
        return maxId;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] a = new int[k], b = new int[k];
        double[] exp = new double[k];
        double last = 1;
        for(int i = 0; i < k; i++) {
            a[i] = input.nextInt();
        }
        for(int i = 0; i < k; i++) {
            b[i] = input.nextInt();
            exp[i] = 1.0 / b[i];
            last = Math.pow(a[i], exp[i]);
        }
        for(int i = 0; i < n; i++) {
            int id = getIndex(a, exp, k, last);
            a[id]++;
        }
        double ret = 1.0;
        for(int i = 0; i < k; i++) {
            ret *= Math.pow(a[i], exp[i]);
        }
        System.out.println(ret);
    }
}