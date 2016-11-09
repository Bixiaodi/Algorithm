import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
      //  Scanner input = new Scanner(new File("input.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        while(input.hasNext()) {
            String s = input.nextLine();
 //          System.out.println(s);
            s = s.trim();
            s = s.toLowerCase();
            String[] words = s.split("s+");
            boolean dot = false;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(".")) {
                    if(sb.charAt(sb.length() - 1) == ' ')
                        sb.deleteCharAt(sb.length() - 1);
                    sb.append(words[i]);
                    sb.append(" ");
                    dot = true;
                }
                else if(words[i].equals(",")) {
                    if(sb.charAt(sb.length() - 1) == ' ')
                        sb.deleteCharAt(sb.length() - 1);
                    sb.append(words[i]);
                    sb.append(" ");
                }
                else {
                    if (dot || i == 0) {
                        char c = Character.toUpperCase(words[i].charAt(0));
                        sb.append(c);
                        if (words[i].length() > 1)
                            sb.append(words[i].substring(1));
                        dot = false;
                    }
                    else {
                        sb.append(words[i]);
                    }
                    if(words[i].charAt(words[i].length() - 1) == '.')
                        dot = true;
                    sb.append(" ");
                }
            }
            lines.add(sb.toString());
        }
        for(int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
