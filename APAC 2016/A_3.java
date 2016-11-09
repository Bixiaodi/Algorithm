
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
            // System.out.print("Case #" + t + ": ");
            // output.print("Case #" + t + ": ");
            System.out.println("Case #" + t + ": ");
            output.println("Case #" + t + ": ");
            int n = input.nextInt(), m = input.nextInt();
            Edge[] edge = new Edge[m];
            long[][] path = new long[n][n];
            for(int i = 0; i < n; i++) {
                Arrays.fill(path[i], Integer.MAX_VALUE);
                path[i][i] = 0;
            }
            for(int i = 0; i < m; i++) {
                int start = input.nextInt(), end = input.nextInt(), weight = input.nextInt();
                edge[i] = new Edge(start, end, weight);
                path[start][end] = Math.min(path[start][end], weight);
                path[end][start] = Math.min(path[end][start], weight);
            }
            for(int k = 0; k < n; k++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(path[i][k] == Long.MAX_VALUE || path[k][j] == Long.MAX_VALUE) {
                            continue;
                        }
                        else {
                            path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                        }
                    }
                }
            }
            // for(int i = 0; i < n; i++) {
            //     for(int j = 0; j < n; j++) {
            //         System.out.print(path[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            for(int i = 0; i < m; i++) {
                if(edge[i].w > path[edge[i].s][edge[i].e]) {
                    System.out.println(i);
                    output.println(i);
                }
            }

        }

        input.close();
        output.close();
    }
}
class Edge {
    int s, e;
    long w;
    Edge(int s, int e, long w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}