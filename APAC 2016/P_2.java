
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
	public static final int P = 100000000;
	public static boolean helper(double r, double target) {
		return Math.sin(r) * Math.cos(r) < target;
	}
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int v = input.nextInt(), d = input.nextInt();
            double target = d * 9.8 / (2 * v * v);
            //left part
            int low = 1, high = 45 * P;
            while(low < high) {
            	int mid = low + (high - low) / 2;
            	double r = (mid * 1.0 / P) * Math.PI / 180;
            	if(helper(r, target)) {
            		low = mid + 1;
            	} else {
            		high = mid;
            	}

            }
            double ret = low * 1.0 / P;
            System.out.println(ret);
            output.println(ret);

        }

        input.close();
        output.close();
    }
}
class Node {
	int x, y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}