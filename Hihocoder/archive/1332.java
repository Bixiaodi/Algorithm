import java.io.*;
import java.util.*;

public class Main {
    public static int calculate(String s) {
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                int cur = 0;
                while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cur = cur * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                num.push(cur);
            }
            else if(c == '(') {
                op.push(c);
            }
            else if(c == '*' || c == '/') {
                while(!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    num.push(helper(num.pop(), num.pop(), op.pop()));
                }
                op.push(c);
            }
            else {
                while(!op.isEmpty() && op.peek() != '(') {
                    num.push(helper(num.pop(), num.pop(), op.pop()));
                }
                if(c == ')') {
                    op.pop();
                }
                else {
                    op.push(c);
                }
            }
        }
        while(!op.isEmpty()) {
            num.push(helper(num.pop(), num.pop(), op.pop()));
        }
        return num.peek();
    }
    public static int helper(int num1, int num2, char op) {
        int ret = 0;
        switch(op) {
            case '+': ret = num2 + num1; break;
            case '-': ret = num2 - num1; break;
            case '*': ret = num2 * num1; break;
            case '/': ret = num2 / num1; break;
        }
        return ret;
    }
	
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("input.txt"));
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(calculate(s));
        
    }
    
}



