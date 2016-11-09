import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    
    public boolean check(int[][] square)
    {
        int line1 = 0, line2 = 0;
        for(int i = 0; i < 3; i++)
        {
            line1 += square[i][i];
            line2 += square[i][2 - i];
        }
        if(line1 != line2)
            return false;
        for(int i = 0; i < 3; i++)
        {
            int sumRow = 0, sumCol = 0;
            for(int j = 0; j < 3; j++)
            {
                sumRow += square[i][j];
                sumCol += square[j][i];
            }
            if(sumRow != line1 || sumCol != line1)
                return false;
        }
        return true;
    }

    public void dfs(int[][] square, int[] num, int x, int y, int[][] ret, int[] count)
    {
        if(count[0] > 1)
            return ;
        if(y >= 3)
        {
            y = 0;
            x++;
        }
        if(x >= 3)
        {
            if(check(square))
            {
                count[0]++;
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                        ret[i][j] = square[i][j];
                }
            }
            return ;
        }
        if(square[x][y] == 0)
        {
            for(int i = 1; i < 10; i++)
            {
                if(num[i] >= 1)
                    continue;
                square[x][y] = i;
                num[i]++;
                dfs(square, num, x, y + 1, ret, count);
                num[i]--;
                square[x][y] = 0;
            }
        }
        else
            dfs(square, num, x, y + 1, ret, count);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] square = new int[3][3];
        int[][] ret = new int[3][3];
        int[] num = new int[10];//候选答案
        int[] count = new int[1];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                square[i][j] = input.nextInt();
                num[square[i][j]]++;
            }
        }
        Main solution = new Main();
        solution.dfs(square, num, 0, 0, ret, count);
        if(count[0] == 1)
        {
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                    System.out.print(ret[i][j] + " ");
                System.out.println();
            }
        }
        else
            System.out.println("Too Many");
    }
    
    
}