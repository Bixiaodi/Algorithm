
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Main {
    public static final int N = 8;
    public static int search(boolean[][] grid, Node node) {
        HashMap<Character, int[][]> map = new HashMap<Character, int[][]>();
        int[][] dirK = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] dirQ = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] dirR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] dirB = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] dirN = {{-1,-2},{-1,2},{1,-2},{1,2},{-2,-1},{-2,1},{2,-1},{2,1}};
        int[][] dirP = {{1, -1}, {1, 1}};
        map.put('K', dirK);
        map.put('Q', dirQ);
        map.put('R', dirR);
        map.put('B', dirB);
        map.put('N', dirN);
        map.put('P', dirP);
        int ret = 0;
        int[][] dir = map.get(node.c);
        if(node.c == 'K' || node.c == 'P' || node.c == 'N') {
            for(int i = 0; i < dir.length; i++) {
                int nx = node.x + dir[i][0], ny = node.y + dir[i][1];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny]) {
                    ret++;
                } 
            }
            return ret;
        }
        for(int i = 0; i < dir.length; i++) {
            for(int l = 1; l < 8; l++) {
                int nx = node.x + dir[i][0] * l;
                int ny = node.y + dir[i][1] * l;
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny]) {
                    ret++;
                    break;
                } 
            }          
        }
        return ret;

    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt();
            boolean[][] grid = new boolean[N][N];
            ArrayList<Node> list = new ArrayList<Node>();
            for(int i = 0; i < n; i++) {
                String line = input.next();
                int x = (line.charAt(0) - 'A');
                int y = (line.charAt(1) - '1');
                char c = line.charAt(3);
                list.add(new Node(x, y, c));
                grid[x][y] = true;
            }
            int ret = 0;
            for(int i = 0; i < list.size(); i++) {
                ret += search(grid, list.get(i));
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
    char c;
    Node(int x, int y, char c) {
        this.x = x; 
        this.y = y;
        this.c = c;
    }
}