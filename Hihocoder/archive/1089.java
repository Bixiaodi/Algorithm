import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[][] opt = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(opt[i], 100000);
            opt[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int x = input.nextInt(), y = input.nextInt(), l = input.nextInt();
            opt[x][y] = Math.min(opt[x][y], l);
            opt[y][x] = Math.min(opt[y][x], l);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    opt[i][j] = Math.min(opt[i][j], opt[i][k] + opt[k][j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(opt[i][j] + " ");
            }
            System.out.println();
        }
    }
}