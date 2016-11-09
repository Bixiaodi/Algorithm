import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by emily on 16/7/9.
 */
public class ApacTest {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
        //        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = Integer.parseInt(input.nextLine());
            String[] name = new String[n];
            for(int i = 0; i < n; i++) {
                name[i] = input.nextLine();
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for(int i = 0; i < n; i++) {
                HashSet<Character> set = new HashSet<Character>();
                String cur = name[i];
                for(int j = 0; j < cur.length(); j++) {
                    set.add(cur.charAt(j));
                }
                map.put(cur, set.size());
            }
            String ret = "";
            int cnt = 0;
            for(String key: map.keySet()) {
                int val = map.get(key);
                if(val > cnt) {
                    cnt = val;
                    ret = key;
                }
                else if(val == cnt) {
                    if(key.compareTo(ret) < 0) {
                        ret = key;
                    }
                }
            }
            System.out.println(ret);
            output.println(ret);
        }
        
        input.close();
        output.close();
    }
}
