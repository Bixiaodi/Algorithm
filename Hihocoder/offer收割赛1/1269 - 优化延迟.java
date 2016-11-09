import java.io.*;
import java.util.*;

public class Main {
    public static boolean valid(int[] num, long k, long q) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((int)k, Collections.reverseOrder());
        long cost = 0;
        int id = 1;
        for(int i = 0, n = num.length; i < n; i++) {
            if(pq.size() < k) {
                pq.add(num[i]);
            } else {
                cost += pq.poll() * id++;
                pq.add(num[i]);
            }
        }
        while(!pq.isEmpty()) {
            cost += pq.poll() * id++;
        }
//        System.out.println("k = " + k + " cost = " + cost);
        return cost <= q;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long q = input.nextLong();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        long low = 1, high = n + 1;
        while(low < high) {
            long mid = low + (high - low) / 2;
            if(valid(num, mid, q)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        if(low == n + 1) {
            System.out.println("-1");
        }
        else {
            System.out.println(low);
        }
    }
}
