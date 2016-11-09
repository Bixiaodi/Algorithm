import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int Q = input.nextInt();
        for (int q = 0; q < Q; q++) {
            int n = input.nextInt();
            double[] price = new double[n];
            int[] eager = new int[n];
            int ret = 0;
            for(int i = 0; i < n; i++) {
                price[i] = input.nextDouble();
                eager[i] = input.nextInt();
                if(price[i] % 5 == 0) {
                    ret = Math.max(ret, eager[i]);
                }
            }
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if((price[i] + price[j]) % 5 == 0) {
                        ret = Math.max(ret, eager[i] + eager[j]);
                    }
                }
            }
            for(int i = 0; i < n - 2; i++) {
                for(int j = i + 1; j < n - 1; j++) {
                    for(int k = j + 1; k < n; k++) {
                        double sum = price[i] + price[j] + price[k];
                        int total = eager[i] + eager[j] + eager[k];
                        if(sum / 5 == ((int)sum) / 5) {
                            ret = Math.max(ret, total);
                        }
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
