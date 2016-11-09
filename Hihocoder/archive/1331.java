import java.io.*;
import java.util.*;

public class Main {
	public static int ret = 0;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        dfs(29, n);
        System.out.println(ret);
    }
    public static void dfs(long power, long n) {
    	if(n < 0 || power < 0) {
    		return ;
    	}
    	if(power == 0) {
    		ret += (n <= 2 ? 1 : 0);
    		return ;
    	}
    	long remain = ((long)1 << (power + 2)) - 2;
    	if(n - remain > 0) {
    		return ;
    	}
    	for(int i = 0; i <= 2; i++) {
    		dfs(power - 1, n - i * (1 << power));
    	}
    }

}


