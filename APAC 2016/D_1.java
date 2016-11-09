
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
	public static int helper(char[][] grid, int r, int c) {
		int ret = 0;
		boolean[][] visit = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == '1' && !visit[i][j]) {
					ret++;
					bfs(grid, r, c, i, j, visit);
				}
			}
		}
		return ret;
	}
	public static void bfs(char[][] grid, int r, int c, int x, int y, boolean[][] visit) {
		int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dir[i][0], ny = cur.y + dir[i][1];
				if(nx >= 0 && ny >= 0 && nx < r && ny < c && grid[nx][ny] == '1' && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		
	}
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            // System.out.print("Case #" + t + ": ");
            // output.print("Case #" + t + ": ");
            System.out.println("Case #" + t + ": ");
            output.println("Case #" + t + ": ");
            int r = input.nextInt(), c = input.nextInt();
            char[][] grid = new char[r][c];
            for(int i = 0; i < r; i++) {
            	String line = input.next();
            	grid[i] = line.toCharArray();
            }
            int n = input.nextInt();
            for(int i = 0; i < n; i++) {
            	String op = input.next();
            	if(op.equals("Q")) {
            		int ret = helper(grid, r, c);
            		System.out.println(ret);
            		output.println(ret);
            	}
            	else {
            		int x = input.nextInt(), y = input.nextInt(), val = input.nextInt();
            		grid[x][y] = (char)('0' + val);
            	}
            }
            

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