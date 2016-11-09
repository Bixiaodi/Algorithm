import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long ret = dfs(29, n);
        System.out.println(ret);
    }
    public static long dfs(long power, long n) {
    	long ret = 0;
    	if(n == 0) {
    		return 1;
    	}
    	if(n < 0 || power < 0) {
    		return 0;
    	}
    	long remain = ((long)1 << (power + 2)) - 2;
    	if(n - remain > 0) {
    		return 0;
    	}
    	for(int i = 0; i <= 2; i++) {
    		ret += dfs(power - 1, n - i * (1 << power));
    	}
    	return ret;
    }

}


