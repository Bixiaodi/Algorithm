import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = scanner.nextInt();
        int end = 0;
        for(end = 0; end < n; end++)
        {
            boolean des = true;
            for(int i = end + 1; i < n - 1; i++){
                if(num[i] > num[i + 1])
                {
                    des = false;
                    break;
                }
            }
            if(des)
                break;
        }
        for(int i = 0; i <= end; i++)
            System.out.print(num[i] + " ");
    }
}