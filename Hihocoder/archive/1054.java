import java.util.*;
import java.io.*;

public class Main {
    public static int ret = 0;
    public static int[][] jump = new int[10][10];

    public static void init() {
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = jump[2][8] = jump[8][2] = jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        ret = 0;
    }
    public static void dfs(String[][] rules, int begin, int last, int len, String path, boolean[] visit) {
    	if(len > 3) {
    		if(check(rules, path)) {
    			ret++;
    		}
    		if(len == 9)
    			return ;
    	}
    	for(int i = 1; i <= 9; i++) {
    		if(!visit[i] && (last == -1 || jump[begin][i] == 0 || visit[jump[begin][i]])) {
    			visit[i] = true;
    			dfs(rules, i, begin, len + 1, path + i, visit);
    			visit[i] = false;
    		}
    	}
    }

    public static boolean check(String[][] rules, String path) {
    	int n = rules.length;
    	for(int i = 0; i < n; i++) {
    		if(path.indexOf(rules[i][0]) == -1 && path.indexOf(rules[i][1]) == -1) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
      //  Scanner input = new Scanner(new File("input.txt"));
        int T = input.nextInt();
        for(int t = 0; t < T; t++) {
            int n = input.nextInt();
            if(n == 0) {
                System.out.println(389112);
                continue;
            }
            init();
            String[][] rules = new String[n][2];
            for(int i = 0; i < n; i++) {
            	String x = input.next(), y = input.next();
            	rules[i][0] = x + y;
            	rules[i][1] = y + x;
            }
            boolean[] visit = new boolean[10];
            dfs(rules, 0, -1, 0, "", visit);
            System.out.println(ret);
        }
    }
}
