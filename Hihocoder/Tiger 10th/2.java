import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashSet<String> ret = new HashSet<String>();
        for(int t = 0; t < n; t++) {
            HashSet<String> cur = new HashSet<String>();
            int m = input.nextInt();
            if(t == 0) {
                for(int i = 0; i < m; i++) {
                    String id = input.next(), date = input.next(), price = input.next();
                    String line = id + " " + price;
                    cur.add(line);
                }
            }
            else {
                for(int i = 0; i < m; i++) {
                    String id = input.next(), date = input.next(), price = input.next();
                    String line = id + " " + price;
                    if(ret.contains(line)) {
                        cur.add(line);
                    }
                }
            }
            ret = new HashSet<String>(cur);
        }
        ArrayList<String> ids = new ArrayList<String>();
        for(String line: ret) {
            ids.add(line.split("\\s+")[0]);
        }
        Collections.sort(ids);
        for(String tmp: ids) {
            System.out.println(tmp);
        }
        
    }
    
}



