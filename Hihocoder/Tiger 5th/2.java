import java.io.*;
import java.util.*;
public class Main {


    public static boolean isValid(int start, int len, int[] cnt) {
        int maxId = -1, maxv = -1;
        for(int i = 0; i < 26; i++) {
            if(cnt[i] > maxv) {
                maxv = cnt[i];
                maxId = i;
            }
        }
        if(maxId == start) {
            return maxv <= len / 2;
        }
        else {
            return maxv <= (len + 1) / 2;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        String s = input.next();
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int[] cnt = new int[26];
        boolean found = true;
        for(int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if((i == 0 || c != ret.charAt(i - 1)) && cnt[c - 'a'] > 0) {
                    cnt[c - 'a']--;
                    if (isValid(c - 'a', n - i - 1, cnt)) {
                        ret.append(c);
                        break;
                    }
                    else {
                        cnt[c - 'a']++;
                    }
                }
            }
            if(ret.length() != i + 1) {
                found = false;
                break;
            }

        }
        if(found)
            System.out.println(ret.toString());
        else
            System.out.println("INVALID");
    }
}