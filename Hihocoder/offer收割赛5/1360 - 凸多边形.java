import java.io.*;
import java.util.*;

public class Main {
    //s = sqrt(p(p-a)(p-b)(p-c))
    public static double helen(int[] x, int[] y, int i, int j, int k) {
        double a = dis(x, y, i, j), b = dis(x, y, i, k), c = dis(x, y, j, k);
        double p = (a + b + c) / 2;
        double ret = Math.sqrt(p * (p-a) * (p-b) * (p-c));
        return ret;
    }
    public static double dis(int[] x, int[] y, int i, int j) {
        double ret = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
        return Math.sqrt(ret);
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] x = new int[n], y = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
        }
        double[][][] area = new double[n][n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    area[i][j][k] = helen(x, y, i, j, k);
                }
            }
        }
        double ret = 0.0;
        double[][][] opt = new double[m + 1][n][n];
        for(int k = 3; k <= m; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = i + 2; j < n; j++) {
                    for(int t = i + 1; t < j; t++) {
                        opt[k][i][j] = Math.max(opt[k][i][j], area[i][t][j] + opt[k - 1][t][j]);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                ret = Math.max(ret, opt[m][i][j]);
            }
        }
        System.out.println(String.format("%.2f", ret));
    }
}