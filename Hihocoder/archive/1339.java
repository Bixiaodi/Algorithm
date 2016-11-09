import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
//		Scanner input = new Scanner(new File("input.txt"));
		int n = input.nextInt(), m = input.nextInt();
		double p = 1.0 / 6;
		double[][] opt = new double[n][Math.max(7, m + 1)];
		for(int i = 1; i <= 6; i++) {
			opt[0][i] = p;
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= m; j++) {
				for(int k = 1; k <= 6; k++) {
					if(j - k >= 0 && j - k <= m) {
						opt[i][j] += opt[i - 1][j - k] * p;
					}
				}
			}
		}
		double ret = opt[n - 1][m] * 100;
		System.out.println(String.format("%.2f", ret));		
	}
}