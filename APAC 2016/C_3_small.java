
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter.*;

/**
 * Created by emily on 16/7/9.
 */
public class Test {
	public static boolean check(int[] num, int n, Node[] node) {
//		System.out.println(Arrays.toString(num));
		boolean flag = true;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++)
			map.put(num[i], i);
		for(int i = 0, end = node.length; i < end; i++) {
			int k = node[i].k, order = map.get(node[i].e);
			int mask = (1 << k);
//			System.out.println("mask = " + mask);
			for(int id: node[i].friend) {
				int tmp = map.get(id);
				if(Integer.highestOneBit(tmp ^ order) < mask) {
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
		}
		return flag;
	}
	public static int nextPermutation(int[] num, int n) {
//		System.out.println("old : " + Arrays.toString(num));
		int pivot = n - 2;
		while(pivot >= 0 && num[pivot] > num[pivot + 1])
			pivot--;
//		System.out.println("pivot = " + pivot);
		if(pivot < 0) {
//			reverse(num, 0, n - 1);
			return -1;
		}
		int right = pivot + 1;
		while(right < n && num[right] > num[pivot])
			right++;
		swap(num, pivot, right - 1);
		reverse(num, pivot + 1, n - 1);
		return 1;
//		System.out.println("new : " + Arrays.toString(num));
	}
	public static void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	public static void reverse(int[] num, int i, int j) {
		while(i < j) {
			swap(num, i, j);
			i++;
			j--;
		}
	}
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int T = Integer.parseInt(input.nextLine());
//        System.out.println("T = " + T);
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            output.print("Case #" + t + ": ");
            // System.out.println("Case #" + t + ": ");
            // output.println("Case #" + t + ": ");
            int n = input.nextInt(), m = input.nextInt();
            Node[] node = new Node[m];
            for(int i = 0; i < m; i++) {
            	int e = input.nextInt(), k = input.nextInt(), b = input.nextInt();
            	node[i] = new Node(e - 1, k);
            	for(int j = 0; j < b; j++) {
            		node[i].friend.add(input.nextInt() - 1);
            	}
            }
            int total = (1 << n);
            int[] num = new int[total];
            for(int i = 0; i < total; i++) {
            	num[i] = i;
            }
            boolean flag = false;
            while(true) {
            	flag = check(num, total, node);
            	if(flag)
            		break;
            	int val = nextPermutation(num, total);
            	if(val < 0)
            		break;
            }
            // if(n == 1 && m != 0)
            // 	flag = false;
            if(flag) {
            	System.out.println("Yes");
            	output.println("Yes");
            }
            else {
            	System.out.println("No");
            	output.println("No");
            }

            // System.out.println(ret);
            // output.println(ret);

        }

        input.close();
        output.close();
    }
}
class Node {
	int e, k;//id start from 0
	ArrayList<Integer> friend;
	Node(int e, int k) {
		this.e = e;
		this.k = k;
		friend = new ArrayList<Integer>();
	}
}