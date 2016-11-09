import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
//        Scanner input = new Scanner(System.in);
        String s = input.next();
        Stack<Character> op = new Stack<Character>();
        Stack<Integer> num = new Stack<Integer>();
        int i = 0, n = s.length();
        while(i < n) {
        	char c = s.charAt(i);
        	if(c >= '0' && c <= '9') {
        		int tmp = 0;
        		while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        			tmp = tmp * 10 + (s.charAt(i) - '0');
        			i++;
        		}
        		num.push(tmp);
 //       		System.out.println(tmp);
        	}
        	else {
        		if(c == '(') {
        			op.push(c);
        		}
        		else if(c == '*' || c == '/') {
        			while(!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
        				num.push(helper(num.pop(), num.pop(), op.pop()));
        			}
        			op.push(c);
        		}
        		else if(c == '+' || c == '-' || c == ')') {
        			while(!op.isEmpty() && op.peek() != '(') {
        				num.push(helper(num.pop(), num.pop(), op.pop()));
        			}
        			if(!op.isEmpty() && op.peek() == '(' && c == ')') {
        				op.pop();
        			}
        			else {
        				op.push(c);
        			}
        		}
        		i++;
        	}
        }
        while(!op.isEmpty()) {
        	num.push(helper(num.pop(), num.pop(), op.pop()));
        }
        System.out.println(num.pop());
    }
    public static  int helper(int num1, int num2, char op) {
        int ret = 0;
        switch(op) {
            case '+' :
                ret = num2 + num1;
                break;
            case '-' :
                ret = num2 - num1;
                break;
            case '*' :
                ret = num2 * num1;
                break;
            case '/' :
                ret = num2 / num1;
                break;
            default:
                ret = -1;
        }
        return ret;
    }

}


