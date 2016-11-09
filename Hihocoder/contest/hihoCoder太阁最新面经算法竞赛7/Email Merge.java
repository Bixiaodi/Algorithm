import java.io.*;
import java.util.*;

public class Main {

    public static int findset(int x, int[] fa) {
        return (x == fa[x] ? x : (fa[x] = findset(fa[x], fa)));
    }
    public static void unionset(int x, int y, int[] fa) {
        int fx = findset(x, fa), fy = findset(y, fa);
        if(fx != fy)
            fa[fx] = fy;
    }

    public static void main(String[] args) throws FileNotFoundException {
  //      File inputFile = 
 //       Scanner input = new Scanner(new File("E: est.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] name = new String[n];
        int[] fa = new int[n];
        for(int i = 0; i < n; i++)
            fa[i] = i;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++) {
            name[i] = input.next();
            int num = input.nextInt();
            for(int j = 0; j < num; j++) {
                String email = input.next();
                if(map.containsKey(email)) {
                	unionset(i, map.get(email), fa);
                }
                else {
                    map.put(email, i);
                }
            }
        }
//        System.out.println(map);
//        for(int i = 0; i < n; i++) {
//            System.out.println("i = " + i + " fa[i] = " + findset(i, fa));
//        }
        HashMap<Integer, ArrayList<Integer>> order = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> group = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
        	int root = findset(i, fa);
        	if(!order.containsKey(root)) {
        		order.put(root, new ArrayList<Integer>());
        		group.add(root);
        	}
        	order.get(root).add(i);
        }
        for(int id: group) {
        	for(int cur: order.get(id)) {
        		System.out.print(name[cur] + " ");
        	}
        	System.out.println();
        }
        
        input.close();
    }

}


