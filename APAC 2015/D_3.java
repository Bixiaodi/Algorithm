
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt();
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            HashMap<String, Integer> indegree = new HashMap<String, Integer>();
            for(int i = 0; i < n; i++) {
                String from = input.next();
                String to = input.next();
                indegree.putIfAbsent(from, 0);
                indegree.putIfAbsent(to, 0);
                indegree.put(to, indegree.get(to) + 1);
                map.putIfAbsent(from, new ArrayList<String>());
                map.get(from).add(to);
            }
            Queue<String> q = new LinkedList<String>();
            for(String key: indegree.keySet()) {
                if(indegree.get(key) == 0) {
                    q.add(key);
                }
            }
            ArrayList<String> list = new ArrayList<String>();
            while(!q.isEmpty()) {
                String cur = q.poll();
                list.add(cur);
                if(map.containsKey(cur)) {
                    for(String tmp: map.get(cur)) {
                        int val = indegree.get(tmp);
                        if(val == 1)
                            q.add(tmp);
                        indegree.put(tmp, val - 1);
                    }
                }
            }
            String last = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                System.out.print(last + "-" + list.get(i) + " ");
                output.print(last + "-" + list.get(i) + " ");
                last = list.get(i);
            }
            System.out.println();
        }

        input.close();
        output.close();
    }
}