import java.io.*;
import java.util.*;
public class Main {

    public static long pages(int[] para, int w, int h) {
        long ret = 0, rows = 0;
        for(int i = 0, n = para.length; i < n; i++) {
            int chars = para[i];
            rows += (long)Math.ceil(chars * 1.0 / w);
        }
        return (long)Math.ceil(rows * 1.0/ h);
    }
    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            int n = input.nextInt(), p = input.nextInt(), w = input.nextInt(), h = input.nextInt();
            int[] para = new int[n];
            for(int i = 0; i < n; i++)
                para[i] = input.nextInt();
            int low = 1, high = Math.min(w, h), last = -1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                long cur = pages(para, w / mid, h / mid);
                if(cur <= p) {
                    last = mid;
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
            System.out.println(last);
        }
    }

}