import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt())
        {
            int a = input.nextInt(), b = input.nextInt();
            System.out.println(a + b);
        }
    }
}