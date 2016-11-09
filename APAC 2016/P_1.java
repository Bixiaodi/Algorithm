import java.io.*;
import java.util.*;

public class Main {
    public static boolean bfs(HashMap<Integer, ArrayList<Integer>> edge, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1);
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < n; i++)
            set.add(i);
        Queue<Integer> q = new LinkedList<Integer>();
        while(!set.isEmpty()) {
            q.add(set.first());
            color[set.first()] = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();
                set.remove(cur);
                if(edge.containsKey(cur)) {
                    for(int id: edge.get(cur)) {
                        if(color[id] == -1) {
                            color[id] = 1 - color[cur];
                            q.add(id);
                        }
                        else {
                            if(color[id] == color[cur])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException { 
        Scanner input = new Scanner(new File("E:\\test.txt"));
        PrintWriter output = new PrintWriter(new File("E:\\output.txt"));
//        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            int n = input.nextInt();
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            HashMap<Integer, ArrayList<Integer>> edge = new HashMap<Integer, ArrayList<Integer>>();
            int len = 0;
            for(int i = 0; i < n; i++) {
                String s1 = input.next(), s2 = input.next();
                int id1 = -1, id2 = -1;
                if(!map.containsKey(s1))
                    map.put(s1, len++);
                if(!map.containsKey(s2))
                    map.put(s2, len++);
                id1 = map.get(s1);
                id2 = map.get(s2);
                edge.putIfAbsent(id1, new ArrayList<Integer>());
                edge.putIfAbsent(id2, new ArrayList<Integer>());
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
            }
            boolean part = bfs(edge, len);
            
            System.out.println(part);
            if(part)
                output.println("Yes");
            else
                output.println("No");

        }

        input.close();
        output.close();
    }

}


