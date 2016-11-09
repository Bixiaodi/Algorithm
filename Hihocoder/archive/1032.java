import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.next());
        for(int k = 0; k < N; k++)
        {
            String str = input.next();
            StringBuilder s = new StringBuilder("&#");
            for(int j = 0, n = str.length(); j < n; j++)
            {
                s.append(str.charAt(j));
                s.append("#");
            }
            int len = s.length();
            int[] p = new int[len];//p[i]是以i为起点，向右延伸p[i]个长度的回文串
            int cur= 0, center = 0;
            for(int i = 1, idx = 0, maxRight = 0; i < len; i++)
            {
                p[i] = i < maxRight ? Math.min(p[2 * idx - i], maxRight - i) : 1;
                while(i + p[i] < len && i - p[i] >= 0 && s.charAt(i - p[i]) == s.charAt(i + p[i]))
                    p[i]++;
                if(i + p[i] > maxRight)
                {
                    maxRight = i + p[i];
                    idx = i;
                }
                if(p[i] > cur)
                {
                    cur = p[i];
                    center = i;
                }
            }
            System.out.println(cur - 1);

        }
        
    }
    
}