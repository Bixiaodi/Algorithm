import java.io.*;
import java.util.*;

public class Main {

    public static int findset(int x, int[] father) {
        return x == father[x] ? x : (father[x] = findset(father[x], father));
    }
    public static void unionset(int x, int y, int[] father) {
        int fx = findset(x, father);
        int fy = findset(y, father);
        if(fx != fy) {
            father[fx] = fy;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int N = 1000;
        int[] father = new int[N * N];
        int[][] grid = new int[N][N];
        for(int i = 0; i < N * N; i++) {
            father[i] = i;
        }
        int n = input.nextInt();
        int ret = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int t = 0; t < n; t++) {
            int x = input.nextInt(), y = input.nextInt();
            grid[x][y] = 1;
            if(t == 0) {
                ret++;
                System.out.println(ret);
                continue;
            }
            ret++;
            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny] == 1) {
                    if(findset(x * N + y, father) != findset(nx * N + ny, father)) {
                        unionset(x * N + y, nx * N + ny, father);
                        ret--;
                    }
                }
            }
            System.out.println(ret);

        }
    }
}



