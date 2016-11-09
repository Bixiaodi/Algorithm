import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i + 1; j ++)
                grid[i][j] = input.nextInt();
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                grid[i][j] = Math.max(grid[i + 1][j], grid[i + 1][j + 1]) + grid[i][j];
            }
        }
        System.out.println(grid[0][0]);
    }
}