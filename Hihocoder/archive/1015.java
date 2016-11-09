import java.util.Scanner;
	
public class Main {
    public int match(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        int ret = 0;
        int[] next = getNext(t);
        while (i < m) {
            if(j == -1 || s.charAt(i) == t.charAt(j))
            {
                i++;
                j++;
            }
            else
                j = next[j];
            if(j == n)
            {
                j = next[j];
                ret++;
            }
        }
        return ret;

    }
    public int[] getNext(String t){
        int n = t.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        int k = -1, j = 0;
        while(j < n)
        {
            if(k == -1 || t.charAt(k) == t.charAt(j))
            {
                k++;
                j++;
                next[j] = k;
            }
            else
                k = next[k];
        }
        return next;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main solution = new Main();
        for(int i = 0; i < n; i++)
        {
            String t = in.next();
            String s = in.next();
            System.out.println(solution.match(s, t));
        }
    }
}