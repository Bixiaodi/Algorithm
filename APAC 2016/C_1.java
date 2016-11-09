import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test.txt"));
//       Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++) {
            output.println("Case #" + t + ":");
            int p = input.nextInt();
            int[] ps = new int[p];
            for(int i = 0; i < p; i++) {
                ps[i] = input.nextInt();
            }
            int n = input.nextInt();
            Competition[] competition = new Competition[n];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            HashMap<String, Integer> score = new HashMap<String, Integer>();
            for(int i = 0; i < n; i++) {
                competition[i] = new Competition();
                competition[i].weight = input.nextInt();
                for(int j = 0; j < p; j++)
                    competition[i].althlete.add(input.next());
            }
            int top = input.nextInt();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < competition[i].althlete.size(); j++) {
                    String name = competition[i].althlete.get(j);
                    map.putIfAbsent(name, 0);
                    score.putIfAbsent(name, 0);
                    if(map.get(name) < top) {
                        map.put(name, map.get(name) + 1);
                        score.put(name, score.get(name) + competition[i].weight * ps[j]);
                    }
                }
            }
            PriorityQueue<Rank> q = new PriorityQueue<Rank>(new Comparator<Rank>() {
                @Override
                public int compare(Rank r1, Rank r2) {
                    if(r1.score == r2.score) {
                        return r1.name.compareTo(r2.name);
                    }
                    else {
                        return r2.score - r1.score;
                    }
                }
            });
            for(String name: score.keySet()) {
                q.add(new Rank(name, score.get(name)));
            }
            int rank = 0, cnt = 1, pre = Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                Rank cur = q.poll();
 //               System.out.println(" cur = " + cur.score + " pre = " + pre);
                if(cur.score < pre)  {
                    output.println(cnt + ": " + cur.name);
                    rank = cnt;
                    cnt++;
                }
                else {
                    cnt++;
                    output.println(rank + ": " + cur.name);
                }
                pre = cur.score;
            }
        }
        input.close();
        output.close();
    }
}
class Competition {
    int weight;
    ArrayList<String> althlete;
    Competition() {
        weight = 0;
        althlete = new ArrayList<String>();
    }
}
class Rank {
    String name;
    int score;
    Rank(String name, int score) {
        this.name = name;
        this.score = score;
    }
}