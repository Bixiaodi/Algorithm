import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
//		Scanner input = new Scanner(new File("input.txt"));
		int n = input.nextInt();
		int[] num = new int[n];
		int[] sum = new int[n + 1];
		for(int i = 0; i < n; i++) {
			num[i] = input.nextInt();
			sum[i + 1] = sum[i] + num[i];
		}
//		System.out.println(Arrays.toString(sum));
		int[][] opt = new int[n][n];
		for(int i = 0; i < n; i++) {
			opt[i][i] = num[i];
		}
		for(int len = 2; len <= n; len++) {
			for(int i = n - len; i >= 0; i--) {
				int j = i + len - 1;
//				System.out.println("i = " + i + " j = " + j);
				int left = sum[j + 1] - sum[i] - opt[i + 1][j];
				int right = sum[j + 1] - sum[i] - opt[i][j - 1];
				opt[i][j] = Math.max(left, right);
			}
		}
		
		System.out.println(opt[0][n - 1]);
	}
}