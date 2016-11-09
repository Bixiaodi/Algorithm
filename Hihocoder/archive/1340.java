import java.io.*;
import java.util.*;
public class Main {
	public static boolean check(int i, int j, int k) {
		int valid = (i + j + k) / 2;
		return i <= valid && j <= valid && k <= valid;
	}
	public static boolean valid(int i, int j, int k) {
		int sum = i + j + k;
		return sum <= 15 || check(i, j, k);
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
//		Scanner input = new Scanner(new File("input.txt"));
		int[] robot = new int[3];
		for(int i = 0; i < 3; i++) {
			robot[i] = input.nextInt();
		}	
		Arrays.sort(robot);
//		System.out.println(Arrays.toString(robot));
		int round = 0;
		while(robot[2] > 0) {
			int maxv = 0;
			int[] cur = new int[3];
			for(int i = robot[2]; i >= 0; i--) {
				if(i > 15)
					continue;
				for(int j = robot[1]; j >= 0; j--) {
					if(i + j > 20 || !valid(i, j, 0))
						continue;
					for(int k = robot[0]; k >= 0; k--) {
						if(i + j + k > 20 || !valid(i, j, k)) 
							continue;
						int total = i + j + k;
						if(total > maxv) {
							maxv = total;
							cur[0] = k;
							cur[1] = j;
							cur[2] = i;
						}
								
					}
				}

			}
			// System.out.println("round = " + round);
			// for(int i = 0; i < 3; i++) {
			// 	System.out.println("total" + i + " = " + robot[i] + " move" + i + " = " + cur[i]);
			// }
			for(int i = 0; i < 3; i++) {
				robot[i] -= cur[i];
			}
			Arrays.sort(robot);
			round++;
		}
		int ret = round * 6;
		System.out.println(ret);
	}
}