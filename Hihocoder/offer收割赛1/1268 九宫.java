import java.io.*;
import java.util.*;

public class Main {
    public static int[][] ret = new int[3][3];
    public static int cnt = 0;
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = 3;
        boolean[] used = new boolean[10];
        int[][] matrix = new int[3][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
                used[matrix[i][j]] = true;
            }
        }
        dfs(0, 0, matrix, used);
        if(cnt == 1) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(ret[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Too Many");
        }
    }
    public static boolean check(int[][] matrix) {
        int[] row = new int[3], col = new int[3];
        int left = 0, right = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                row[i] += matrix[i][j];
                col[j] += matrix[i][j];
            }
        }
        for(int i = 0; i < 3; i++) {
            left += matrix[i][i];
            right += matrix[i][2 - i];
        }
        for(int i = 0; i < 3; i++) {
            if(row[i] != 15 || col[i] != 15) {
                return false;
            }
        }
        return left == 15 && right == 15;
    }
    public static void dfs(int x, int y, int[][] matrix, boolean[] used) {
        if(cnt > 1) {
            return ;
        }
        if(y == 3) {
            y = 0;
            x++;
        }
        if(x == 3) {
            if(check(matrix)) {
                cnt++;
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        ret[i][j] = matrix[i][j];
                    }
                }
            }
            return ;
        }
        if(matrix[x][y] == 0) {
            for(int i = 1; i < 10; i++) {
                if(used[i]) {
                    continue;
                }
                matrix[x][y] = i;
                used[i] = true;
                dfs(x, y + 1, matrix, used);
                used[i] = false;
                matrix[x][y] = 0;
            }
        }
        else {
            dfs(x, y + 1, matrix, used);
        }
        
    }
}
