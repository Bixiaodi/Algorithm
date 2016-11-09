import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //       Scanner scanner = new Scanner(new File("test.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = scanner.nextInt();
        int end = n - 1;
        while(end > 0)
        {
            if(num[end - 1] < num[end])
                end--;
            else
                break;
        }
        if(end == 0)
            System.out.println(num[0]);
        else
        {
            for(int i = 0; i < end; i++)
                System.out.print(num[i] + " ");
        }
    }
}