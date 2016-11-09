import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public ArrayList<Integer> helper(int n)
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
                ret.add(i);
        }
        return ret;
    }
    public static void main(String[] args) {
        
        Main solution = new Main();
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        int q = input.nextInt();
        ArrayList<Integer> pval = solution.helper(p), qval = solution.helper(q);
        for(int i = 0, n1 = pval.size(); i < n1; i++)
        {
            for(int j = 0, n2 = qval.size(); j < n2; j++)
                System.out.println(pval.get(i) + " " + qval.get(j));
        }
    }
}