
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            // System.out.println("Case #" + t + ": ");
            // output.println("Case #" + t + ": ");
            int n = Integer.parseInt(input.nextLine());
            String[] s = new String[n];
            for(int i = 0; i < n; i++)
            	s[i] = input.nextLine();
            int ret = 0;
 //           System.out.println();
            for(int i = 1; i < n; i++) {
 //           	System.out.println("pre = " + s[i - 1] + " cur = " + s[i]);
            	if(s[i].compareTo(s[i - 1]) < 0) {
  //          		System.out.println(s[i]);
            		String tmp = s[i];
            		int j = i;
            		while(j > 0 && s[j - 1].compareTo(tmp) > 0) {
            			s[j] = s[j - 1];
            			j--;
            		}
            		s[j] = tmp;
            		ret++;
            	}
            }
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