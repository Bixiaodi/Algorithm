import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
    //    Scanner input = new Scanner(new File("input.txt"));
        int n = input.nextInt(), m = input.nextInt();
        LinkedList<String> list = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < n; i++) {
            String cur = input.next();
            if(set.contains(cur)) {
                System.out.println("Cache");
                list.remove(cur);
                list.add(cur);
            }
            else {
                System.out.println("Internet");
                if(list.size() >= m) {
                    set.remove(list.pollFirst());
                }
                set.add(cur);
                list.add(cur);
            }
        }
    }
}
