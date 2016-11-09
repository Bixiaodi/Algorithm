import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
 //       Scanner scanner = new Scanner(new File("test.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++)
        {
            int num = scanner.nextInt();
            double[] price = new double[num];
            int[] eager = new int[num];
            int ret = 0;
            double sum = 0;
            for(int j = 0; j < num; j++)
            {
                price[j] = scanner.nextDouble();
                eager[j] = scanner.nextInt();
                if(price[j] % 5 == 0)
                    ret = Math.max(ret, eager[j]);
            }
            for(int j = 0; j < num - 1; j++)
            {
                for(int k = j + 1; k < num; k++)
                {
                    if((price[j] + price[k]) % 5 == 0)
                    {
                        ret = Math.max(eager[j] + eager[k], ret);
                    }
                }
            }
            for(int j = 0; j < num - 2; j++)
            {
                for(int k = j + 1; k < num - 1; k++)
                {
                    for(int p = k + 1; p < num; p++)
                    {
                        if((price[j] + price[k] + price[p]) % 5 == 0)
                            ret = Math.max(eager[j] + eager[k] + eager[p], ret);
                    }
                }
            }
            System.out.println(ret);
        }
    }
}