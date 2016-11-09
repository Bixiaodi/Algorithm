import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException { 
        Scanner input = new Scanner(new File("E:\\test.txt"));
        PrintWriter output = new PrintWriter(new File("E:\\output.txt"));
//        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt(), k = input.nextInt(), c = input.nextInt(), x = input.nextInt();
            long[] a = new long[n], b = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = input.nextLong();
            for(int j = 0; j < n; j++)
                b[j] = input.nextLong();
            long[][] matrix = new long[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = (a[i] * (i + 1) + b[j] * (j + 1) + c) % x;
            }
            long[][] line = new long[n][n - k + 1];
            for(int i = 0; i < n; i++) {
                Deque<Integer> q = new LinkedList<Integer>();
                for(int j = 0; j < n; j++) {
                    if(!q.isEmpty() && j - q.peekFirst() >= k)
                        q.pollFirst();
                    while(!q.isEmpty() && matrix[i][q.peekLast()] < matrix[i][j])
                        q.pollLast();
                    q.add(j);
                    if(j >= k - 1)
                        line[i][j - k + 1] = matrix[i][q.peekFirst()];

                }
            }
            long[][] maxv = new long[n - k + 1][n - k + 1];
            long ret = 0;
            for(int j = 0; j < n - k + 1; j++) {
                Deque<Integer> q = new LinkedList<Integer>();
                for(int i = 0; i < n; i++) {
                    if(!q.isEmpty() && i - q.peekFirst() >= k)
                        q.pollFirst();
                    while(!q.isEmpty() && line[q.peekLast()][j] < line[i][j])
                        q.pollLast();
                    q.add(i);
                    if(i >= k - 1) {
                        maxv[i - k + 1][j] = line[q.peekFirst()][j];
                        ret += maxv[i - k + 1][j];
                    }
                }
            }
            output.println(ret);
            System.out.println(ret);
        }

        input.close();
        output.close();
    }

}


