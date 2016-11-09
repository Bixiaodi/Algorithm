import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by emily on 16/7/9.
 */
public class ApacTest {

    public static int dfs(int[][] grid, int[][] path, int x, int y, int s) {
        if(path[x][y] != 0)
            return path[x][y];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ret = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && ny >= 0 && nx < s && ny < s && grid[nx][ny] - grid[x][y] == 1) {
                ret = Math.max(ret, dfs(grid, path, nx, ny, s));
            }
        }
        path[x][y] = ret + 1;
        return path[x][y];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int s = input.nextInt();
            int[][] grid = new int[s][s];
            for(int i = 0; i < s; i++) {
                for(int j = 0; j < s; j++) {
                    grid[i][j] = input.nextInt();
                }
            }
            int[][] path = new int[s][s];
            int room = Integer.MAX_VALUE, ret = -1;
            for(int i = 0; i < s; i++) {
                for(int j = 0; j < s; j++) {
                    int cur = dfs(grid, path, i, j, s);
                    if(cur > ret) {
                        ret = cur;
                        room = grid[i][j];
                    }
                    else if(cur == ret) {
                        if(grid[i][j] < room) {
                            room = grid[i][j];
                        }
                    }
  //                  System.out.println("room = " + grid[i][j] + " path = " + cur);
                }
            }
            System.out.println(room + " " + ret);
            output.println(room + " " + ret);
        }

        input.close();
        output.close();
    }
}
