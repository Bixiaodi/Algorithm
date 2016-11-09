import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = s.length();
        HashSet<Character> set = new HashSet<Character>();
        char[][] grid = new char[5][5];
        int x = 0, y = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'J') {
                c = 'I';
            }
            if(set.contains(c)) {
                continue;
            } else {
                grid[x][y++] = c;
                set.add(c);
                if(y == 5) {
                    x++;
                    y = 0;
                }
            }
        }
        for(char c = 'A'; c <= 'Z'; c++) {
            if(c == 'J') {
                continue;
            }
            if(!set.contains(c)) {
                grid[x][y++] = c;
                set.add(c);
                if(y == 5) {
                    x++;
                    y = 0;
                }
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}

