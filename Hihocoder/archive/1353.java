import java.io.*;
import java.util.*;

public class Main {

    public static  int helper(int[] price, int n, int x, int sum) {
        boolean[][] opt = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i++) {
            opt[i][0] = true;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j - price[i - 1] >= 0) {
                    opt[i][j] = opt[i - 1][j] || opt[i - 1][j - price[i - 1]];
                }
                else {
                    opt[i][j] = opt[i - 1][j];
                }
            }
        }
        for(int i = x; i <= sum; i++) {
            if(opt[n][i]) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), x = input.nextInt();
        int[] price = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            price[i] = input.nextInt();
            sum += price[i];
        }
        if(sum < x) {
            System.out.println("-1");
        }
        else {
            System.out.println(helper(price, n, x, sum));
        }
    }
}
