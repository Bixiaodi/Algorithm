import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
//        Scanner input = new Scanner(new File("input.txt"));
        int n = input.nextInt(), m = input.nextInt();
        double p = 1.0 / 6;
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        for(int i = 1; i <= 6; i++) {
            map.put(i, p);
        }
 //       System.out.println(map);
        for(int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>(map.keySet());
            HashMap<Integer, Double> cur = new HashMap<Integer, Double>();
            for(int j = 0; j < list.size(); j++) {
                int tmp = list.get(j);
                for(int k = 1; k <= 6; k++) {
                    int sum = tmp + k;
                    double curp = map.get(tmp) * p;
                    if(cur.containsKey(sum)) {
                        cur.put(sum, cur.get(sum) + curp);
                    }
                    else {
                        cur.put(sum, curp);
                    }
                }
            }
            map = new HashMap<Integer, Double>(cur);
        }
        double ret = 0;
        if(map.containsKey(m)) {
            ret = map.get(m);
            ret *= 100;
        }
        System.out.println(String.format("%.2f", ret));
    }
}