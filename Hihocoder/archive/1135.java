import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int[] diff = new int[3];
        for(int i = 0; i < 3; i++)
            diff[i] = input.nextInt();
        String s = input.next();
        Arrays.sort(diff);
        int n = s.length();
        int[] cur = new int[3];
        int cr = 0, cy = 0, cb = 0;
        int ret = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'R')
                cr++;
            else if(s.charAt(i) == 'Y')
                cy++;
            else
                cb++;
            ret = Math.max(ret, cr + cy + cb);
            cur[0] = Math.abs(cr - cy);
            cur[1] = Math.abs(cy - cb);
            cur[2] = Math.abs(cr - cb);
            Arrays.sort(cur);
            if(diff[0] == cur[0] && diff[1] == cur[1] && diff[2] == cur[2]) {
                cr = 0;
                cy = 0;
                cb = 0;
            }
        }
        System.out.println(ret);
        
    }
}

