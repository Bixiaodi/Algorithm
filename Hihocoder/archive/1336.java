import java.io.*;
import java.util.*;

public class Main {
   
    public static final int MOD = 1000000000 + 7;
    
    public static long sum(long[][] c, int row, int col) {
    	long sum = 0;
    	for(int i = row; i > 0; i -= lowbit(i)) {
    		for(int j = col; j > 0; j -= lowbit(j)) {
    			sum += c[i][j];
    		}
    	}
    	return sum;
    }
    public static void add(long[][] c, int row, int col, int val, int n) {
    	for(int i = row; i <= n; i += lowbit(i)) {
    		for(int j = col; j <= n; j += lowbit(j)) {
    			c[i][j] += val;
    		}
    	}
    }
    public static int lowbit(int x) {
    	return (x & -x);
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("E:test.txt"));
      Scanner input = new Scanner(System.in);
//        System.out.println((-1000000008 % MOD));
        int n = input.nextInt(), m = input.nextInt();
        long[][] c = new long[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
        	String op = input.next();
        	if(op.equals("Add")) {
        		int x = input.nextInt(), y = input.nextInt(), val = input.nextInt();
        		add(c, x + 1, y + 1, val, n);
        	}
        	else {
        		int x1 = input.nextInt() + 1, y1 = input.nextInt() + 1, x2 = input.nextInt() + 1, y2 = input.nextInt() + 1;
        		long cur = sum(c, x2, y2) - sum(c, x2, y1 - 1) - sum(c, x1 - 1, y2) + sum(c, x1 - 1, y1 - 1);
        		cur %= MOD;
        		if(cur < 0)
        			cur += MOD;
        		System.out.println(cur);
        	}
        }
        
        input.close();
    }

}


