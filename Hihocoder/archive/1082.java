import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("test.txt"));
        Scanner input = new Scanner(System.in);
        String target = "fjxmlhx", place = "(?i)marshtomp";
        while(input.hasNext()) {
            String s = input.nextLine();
            System.out.println(s.replaceAll(place, target));
        }
    }
}